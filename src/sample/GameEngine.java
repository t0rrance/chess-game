package sample;

import sample.piece.Piece;

public class GameEngine {

    private ChessBoard chessBoard;
    private int[][] board;
    private Piece[][] pieces;
    private Window[][] windows;
    private double cell_width;
    private double cell_height;

    public GameEngine(ChessBoard chessBoard) {
        this.chessBoard = chessBoard;
        this.windows = chessBoard.getWindows();
        this.pieces = chessBoard.getPieces();
        this.board = chessBoard.getBoard();
        this.cell_height = chessBoard.getCell_height();
        this.cell_width = chessBoard.getCell_width();
    }

    private boolean checkPossibleMove(int selectedPieceIndexX, int selectedPieceIndexY, int destinationX, int destinationY) {
        boolean canMoveOnThisWindow = windows[destinationX][destinationY].isCanMoveOnThisWindow();
        if (canMoveOnThisWindow) {
            int[] indexTmp = findPieceIndex(selectedPieceIndexX, selectedPieceIndexY);
            if (indexTmp != null) {
                int i = indexTmp[0];
                int j = indexTmp[1];
                int rangeSize = pieces[i][j].getMoveRange();
                double presentPositionX = pieces[i][j].getImageView().getX();
                double presentPositionY = pieces[i][j].getImageView().getY();
                double differencePositionX = Math.abs(presentPositionX - destinationX * this.cell_height);
                double differencePositionY = Math.abs(presentPositionY - destinationY * this.cell_width);
                return (differencePositionX <= rangeSize * cell_width && differencePositionY <= rangeSize * cell_height);
            }
        }
        return false;
    }

    private boolean isThereEnemyOrFriend(int destinationX, int destinationY, int pieceType) {
        int[] indexEnemy = findPieceIndex(destinationX, destinationY);
        if (indexEnemy != null) {
            int i = indexEnemy[0];
            int j = indexEnemy[1];
            if (this.pieces[i][j].getPieceType() != pieceType) {
                this.pieces[i][j].setPiecePositionIndex(-1, -1);
                this.chessBoard.getChildren().remove(this.pieces[i][j].getImageView());
                return true;
            } else if (this.pieces[i][j].getPieceType() == pieceType)
                return false;
        }
        return false;
    }

    public boolean checkIfClickTheSamePiece(int x, int y, int X, int Y) {
        return x != X || y != Y;
    }

    public boolean checkTurn(int i, int j) {
        boolean turnToMove = CustomControl.turnToMove;
        if (board[i][j] != 0) {
            int[] pieceIndex = findPieceIndex(i, j);
            if (pieceIndex != null) {
                if ((this.pieces[pieceIndex[0]][pieceIndex[1]].getPieceType() == 2 && !turnToMove) || (this.pieces[pieceIndex[0]][pieceIndex[1]].getPieceType() == 1 && turnToMove)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean pieceMove(int selectedPieceIndexX, int selectedPieceIndexY, int destinationX, int destinationY) {
        if (checkPossibleMove(selectedPieceIndexX, selectedPieceIndexY, destinationX, destinationY)) {
            removeSizeRangeHighlight(selectedPieceIndexX, selectedPieceIndexY);
            int[] indexTmp = findPieceIndex(selectedPieceIndexX, selectedPieceIndexY);
            if (indexTmp != null) {
                int i = indexTmp[0];
                int j = indexTmp[1];
                if (isItEmptySquare(destinationX, destinationY) || isThereEnemyOrFriend(destinationX, destinationY, pieces[i][j].getPieceType())) {
                    pieces[i][j].relocate(destinationX * cell_width, destinationY * cell_height);
                    pieces[i][j].setPiecePositionIndex(destinationX, destinationY);
                    this.board[selectedPieceIndexX][selectedPieceIndexY] = 0;
                    this.board[destinationX][destinationY] = pieces[i][j].getPieceType();
                    return true;
                }
            }
        }
        return false;
    }

    public void sizeRangeHightlight(int selectedIndexX, int selectedIndexY) {
        int[] indexTmp = findPieceIndex(selectedIndexX, selectedIndexY);
        if (indexTmp != null) this.pieces[indexTmp[0]][indexTmp[1]].pieceSizeRangeHighlight();
    }

    public void removeSizeRangeHighlight(int selectedIndexX, int selectedIndexY) {
        int[] indexTmp = findPieceIndex(selectedIndexX, selectedIndexY);
        if (indexTmp != null) this.pieces[indexTmp[0]][indexTmp[1]].removePieceSizeRangeHighlight();
    }

    private boolean isItEmptySquare(int indexX, int indexY) {
        if (this.board[indexX][indexY] == 0) return true;
        return false;
    }

    private int[] findPieceIndex(int indexX, int indexY) {
        boolean found = false;
        int[] temp = new int[2];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 4; j++) {
                if (this.pieces[i][j].getPositionX() == indexX && this.pieces[i][j].getPositionY() == indexY) {
                    temp[0] = i;
                    temp[1] = j;
                    if (temp[1] == 6) temp[1] = 2;
                    if (temp[1] == 7) temp[1] = 3;
                    found = true;
                    return temp;
                }
            }
        }
        return found ? temp : null;
    }

    public boolean clickAnotherMyPiece(int selectedIndexX, int selectedIndexY, int turnToMove) {
        int[] indexTmp = findPieceIndex(selectedIndexX, selectedIndexY);
        if (indexTmp != null) {
            if (turnToMove == this.pieces[indexTmp[0]][indexTmp[1]].getPieceType()) {
                return false;
            }
        }
        return true;
    }

}
