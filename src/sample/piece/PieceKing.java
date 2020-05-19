package sample.piece;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import sample.ChessBoard;

public class PieceKing extends Piece {

    private Image image;

    public PieceKing(int pieceType, int positionX, int positionY, ChessBoard chessBoard) {
        super(pieceType, positionX, positionY, "king", 1, chessBoard);
        setImage(pieceType);
    }

    @Override
    protected void setImage(int pieceType) {
        if (pieceType == 1) image = new Image("resource/ChessPieces/bKing.png");
        else if (pieceType == 2) image = new Image("resource/ChessPieces/wKing.png");
        imageView.setImage(image);
        imageView.fitHeightProperty();
        imageView.fitWidthProperty();
        imageView.setPreserveRatio(true);
        imageView.setSmooth(true);
        imageView.setCache(true);
        imageView.setManaged(false);
    }

    @Override
    public ImageView getImageView() {
        return imageView;
    }

    @Override
    public void pieceSizeRangeHighlight() {
        int i = getPositionX();
        int j = getPositionY();
        if (j == 0) {
            if (i == 0) {
                windows[i + 1][j].hightlightChoosenPiece();
                windows[i + 1][j + 1].hightlightChoosenPiece();
            } else if (i == 7) {
                windows[i][j].hightlightChoosenPiece();
                windows[i - 1][j].hightlightChoosenPiece();
                windows[i - 1][j + 1].hightlightChoosenPiece();
            } else {
                windows[i + 1][j].hightlightChoosenPiece();
                windows[i + 1][j + 1].hightlightChoosenPiece();
                windows[i - 1][j].hightlightChoosenPiece();
                windows[i - 1][j + 1].hightlightChoosenPiece();
            }
            windows[i][j + 1].hightlightChoosenPiece();
        } else if (j == 7) {
            if (i == 0) {
                windows[i + 1][j].hightlightChoosenPiece();
                windows[i + 1][j - 1].hightlightChoosenPiece();
            } else if (i == 7) {
                windows[i][j].hightlightChoosenPiece();
                windows[i - 1][j].hightlightChoosenPiece();
                windows[i - 1][j - 1].hightlightChoosenPiece();
            } else {
                windows[i + 1][j].hightlightChoosenPiece();
                windows[i + 1][j - 1].hightlightChoosenPiece();
                windows[i - 1][j].hightlightChoosenPiece();
                windows[i - 1][j - 1].hightlightChoosenPiece();
            }
            windows[i][j - 1].hightlightChoosenPiece();
        } else if (i == 0 && j > 0 && j < 7) {
            windows[i + 1][j + 1].hightlightChoosenPiece();
            windows[i + 1][j].hightlightChoosenPiece();
            windows[i + 1][j - 1].hightlightChoosenPiece();
            windows[i][j - 1].hightlightChoosenPiece();
            windows[i][j + 1].hightlightChoosenPiece();
        } else if (i == 7 && j > 0 && j < 7) {
            windows[i - 1][j + 1].hightlightChoosenPiece();
            windows[i - 1][j].hightlightChoosenPiece();
            windows[i - 1][j - 1].hightlightChoosenPiece();
            windows[i][j - 1].hightlightChoosenPiece();
            windows[i][j + 1].hightlightChoosenPiece();
        } else if (j > 0 && j < 7 && i > 0 && i < 7) {
            windows[i - 1][j + 1].hightlightChoosenPiece();
            windows[i - 1][j].hightlightChoosenPiece();
            windows[i - 1][j - 1].hightlightChoosenPiece();
            windows[i + 1][j + 1].hightlightChoosenPiece();
            windows[i + 1][j].hightlightChoosenPiece();
            windows[i + 1][j - 1].hightlightChoosenPiece();
            windows[i][j - 1].hightlightChoosenPiece();
            windows[i][j + 1].hightlightChoosenPiece();
        }
        windows[i][j].hightlightChoosenPiece();
    }

    @Override
    public void removePieceSizeRangeHighlight() {
        int i = getPositionX();
        int j = getPositionY();
        if (j == 0) {
            if (i == 0) {
                windows[i + 1][j].removeHighlightChoosenPiece();
                windows[i + 1][j + 1].removeHighlightChoosenPiece();
            } else if (i == 7) {
                windows[i][j].removeHighlightChoosenPiece();
                windows[i - 1][j].removeHighlightChoosenPiece();
                windows[i - 1][j + 1].removeHighlightChoosenPiece();
            } else {
                windows[i + 1][j].removeHighlightChoosenPiece();
                windows[i + 1][j + 1].removeHighlightChoosenPiece();
                windows[i - 1][j].removeHighlightChoosenPiece();
                windows[i - 1][j + 1].removeHighlightChoosenPiece();
            }
            windows[i][j + 1].removeHighlightChoosenPiece();
        } else if (j == 7) {
            if (i == 0) {
                windows[i + 1][j].removeHighlightChoosenPiece();
                windows[i + 1][j - 1].removeHighlightChoosenPiece();
            } else if (i == 7) {
                windows[i][j].removeHighlightChoosenPiece();
                windows[i - 1][j].removeHighlightChoosenPiece();
                windows[i - 1][j - 1].removeHighlightChoosenPiece();
            } else {
                windows[i + 1][j].removeHighlightChoosenPiece();
                windows[i + 1][j - 1].removeHighlightChoosenPiece();
                windows[i - 1][j].removeHighlightChoosenPiece();
                windows[i - 1][j - 1].removeHighlightChoosenPiece();
            }
            windows[i][j - 1].removeHighlightChoosenPiece();
        } else if (i == 0 && j > 0 && j < 7) {
            windows[i + 1][j + 1].removeHighlightChoosenPiece();
            windows[i + 1][j].removeHighlightChoosenPiece();
            windows[i + 1][j - 1].removeHighlightChoosenPiece();
            windows[i][j - 1].removeHighlightChoosenPiece();
            windows[i][j + 1].removeHighlightChoosenPiece();
        } else if (i == 7 && j > 0 && j < 7) {
            windows[i - 1][j + 1].removeHighlightChoosenPiece();
            windows[i - 1][j].removeHighlightChoosenPiece();
            windows[i - 1][j - 1].removeHighlightChoosenPiece();
            windows[i][j - 1].removeHighlightChoosenPiece();
            windows[i][j + 1].removeHighlightChoosenPiece();
        } else if (j > 0 && j < 7 && i > 0 && i < 7) {
            windows[i - 1][j + 1].removeHighlightChoosenPiece();
            windows[i - 1][j].removeHighlightChoosenPiece();
            windows[i - 1][j - 1].removeHighlightChoosenPiece();
            windows[i + 1][j + 1].removeHighlightChoosenPiece();
            windows[i + 1][j].removeHighlightChoosenPiece();
            windows[i + 1][j - 1].removeHighlightChoosenPiece();
            windows[i][j - 1].removeHighlightChoosenPiece();
            windows[i][j + 1].removeHighlightChoosenPiece();
        }
        windows[i][j].removeHighlightChoosenPiece();
    }

}
