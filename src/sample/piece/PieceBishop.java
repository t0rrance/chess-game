package sample.piece;

import javafx.scene.image.Image;
import sample.ChessBoard;

public class PieceBishop extends Piece {

    private Image image;

    public PieceBishop(int pieceType, int positionX, int positionY, ChessBoard chessBoard) {
        super(pieceType, positionX, positionY, "bishop", 8, chessBoard);
        setImage(pieceType);
    }

    @Override
    void setImage(int pieceType) {
        if (pieceType == 1) image = new Image("resource/ChessPieces/bBishop.png");
        else if (pieceType == 2) image = new Image("resource/ChessPieces/wBishop.png");
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
        while (x < 8 && y < 8) {
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
            y++;
        }

        x = i;
        y = j;
        while (x >= 0 && y >= 0) {
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
            y--;
        }

        x = i;
        y = j;
        while (x < 8 && y >= 0) {
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
            y--;
        }

        x = i;
        y = j;
        while (x >= 0 && y < 8) {
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
            y++;
        }
    }

    @Override
    public void removePieceSizeRangeHighlight() {
        int i = getPositionX();
        int j = getPositionY();
        int emptySquare = 0;
        int x = i;
        int y = j;
        while (x < 8 && y < 8) {
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
            y++;
        }

        x = i;
        y = j;
        while (x >= 0 && y >= 0) {
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
            y--;
        }

        x = i;
        y = j;
        while (x < 8 && y >= 0) {
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
            y--;
        }

        x = i;
        y = j;
        while (x >= 0 && y < 8) {
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
            y++;
        }
    }

}
