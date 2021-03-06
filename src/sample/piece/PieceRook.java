package sample.piece;

import javafx.scene.image.Image;
import sample.ChessBoard;

public class PieceRook extends Piece {

    private Image image;

    public PieceRook(int pieceType, int positionX, int positionY, ChessBoard chessBoard) {
        super(pieceType, positionX, positionY, "rook", 8, chessBoard);
        setImage(pieceType);
    }

    @Override
    void setImage(int pieceType) {
        if (pieceType == 1) image = new Image("resource/ChessPieces/bRook.png");
        else if (pieceType == 2) image = new Image("resource/ChessPieces/wRook.png");
        imageView.setImage(image);
        imageView.fitHeightProperty();
        imageView.fitWidthProperty();
        imageView.setPreserveRatio(true);
        imageView.setSmooth(true);
        imageView.setCache(true);
        imageView.setManaged(false);
    }

    @Override
    public void pieceSizeRangeHighlight() {
        int i = getPositionX();
        int j = getPositionY();
        int emptySquare = 0;

        int x = i;
        int y = j;
        while (y < 8) {
            if (x == i && y == j) {
                windows[x][y].hightlightChoosenPiece();
            } else {
                if (board[x][y] == getPieceType())
                    break;
                else if (board[x][y] != emptySquare) {
                    windows[x][y].hightlightChoosenPiece();
                    break;
                } else windows[x][y].hightlightChoosenPiece();
            }
            y++;
        }
        x = i;
        y = j;
        while (y >= 0) {
            if (x == i && y == j) {
                windows[x][y].hightlightChoosenPiece();
            } else {
                if (board[x][y] == getPieceType())
                    break;
                else if (board[x][y] != emptySquare) {
                    windows[x][y].hightlightChoosenPiece();
                    break;
                } else windows[x][y].hightlightChoosenPiece();
            }
            y--;
        }

        x = i;
        y = j;
        while (x < 8) {
            if (x == i && y == j) {
                windows[x][y].hightlightChoosenPiece();
            } else {
                if (board[x][y] == getPieceType())
                    break;
                else if (board[x][y] != emptySquare) {
                    windows[x][y].hightlightChoosenPiece();
                    break;
                } else windows[x][y].hightlightChoosenPiece();
            }
            x++;
        }

        x = i;
        y = j;
        while (x >= 0) {
            if (x == i && y == j) {
                windows[x][y].hightlightChoosenPiece();
            } else {
                if (board[x][y] == getPieceType())
                    break;
                else if (board[x][y] != emptySquare) {
                    windows[x][y].hightlightChoosenPiece();
                    break;
                } else windows[x][y].hightlightChoosenPiece();
            }
            x--;
        }
    }

    @Override
    public void removePieceSizeRangeHighlight() {
        int i = getPositionX();
        int j = getPositionY();
        int emptySquare = 0;

        int x = i;
        int y = j;
        while (y < 8) {
            if (x == i && y == j) {
                windows[x][y].removeHighlightChoosenPiece();
            } else {
                if (board[x][y] == getPieceType())
                    break;
                else if (board[x][y] != emptySquare) {
                    windows[x][y].removeHighlightChoosenPiece();
                    break;
                } else windows[x][y].removeHighlightChoosenPiece();
            }
            y++;
        }
        x = i;
        y = j;
        while (y >= 0) {
            if (x == i && y == j) {
                windows[x][y].removeHighlightChoosenPiece();
            } else {
                if (board[x][y] == getPieceType())
                    break;
                else if (board[x][y] != emptySquare) {
                    windows[x][y].removeHighlightChoosenPiece();
                    break;
                } else windows[x][y].removeHighlightChoosenPiece();
            }
            y--;
        }

        x = i;
        y = j;
        while (x < 8) {
            if (x == i && y == j) {
                windows[x][y].removeHighlightChoosenPiece();
            } else {
                if (board[x][y] == getPieceType())
                    break;
                else if (board[x][y] != emptySquare) {
                    windows[x][y].removeHighlightChoosenPiece();
                    break;
                } else windows[x][y].removeHighlightChoosenPiece();
            }
            x++;
        }

        x = i;
        y = j;
        while (x >= 0) {
            if (x == i && y == j) {
                windows[x][y].removeHighlightChoosenPiece();
            } else {
                if (board[x][y] == getPieceType())
                    break;
                else if (board[x][y] != emptySquare) {
                    windows[x][y].removeHighlightChoosenPiece();
                    break;
                } else windows[x][y].removeHighlightChoosenPiece();
            }
            x--;
        }
    }

}
