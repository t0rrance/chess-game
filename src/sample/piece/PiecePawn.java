package sample.piece;

import javafx.scene.image.Image;
import sample.ChessBoard;

public class PiecePawn extends Piece {

    private Image image;

    public PiecePawn(int pieceType, int positionX, int positionY, ChessBoard chessBoard) {
        super(pieceType, positionX, positionY, "pawn", 8, chessBoard);
        setImage(pieceType);
    }

    @Override
    void setImage(int pieceType) {
        if (pieceType == 1) image = new Image("resource/ChessPieces/bPawn.png");
        else if (pieceType == 2) image = new Image("resource/ChessPieces/wPawn.png");
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

        if (getPieceType() == 1) {
            if (j < 7) {
                if (i == 0) {
                    if (this.board[i + 1][j + 1] == 2)
                        this.windows[i + 1][j + 1].hightlightChoosenPiece();
                } else if (i == 7) {
                    if (this.board[i - 1][j + 1] == 2)
                        this.windows[i - 1][j + 1].hightlightChoosenPiece();
                } else {
                    if (this.board[i + 1][j + 1] == 2)
                        this.windows[i + 1][j + 1].hightlightChoosenPiece();
                    if (this.board[i - 1][j + 1] == 2)
                        this.windows[i - 1][j + 1].hightlightChoosenPiece();
                }
                this.windows[i][j + 1].hightlightChoosenPiece();
            }
        } else if (getPieceType() == 2) {
            if (j > 0) {
                if (i == 0) {
                    if (this.board[i + 1][j - 1] == 1)
                        this.windows[i + 1][j - 1].hightlightChoosenPiece();
                } else if (i == 7) {
                    if (this.board[i - 1][j - 1] == 1)
                        this.windows[i - 1][j - 1].hightlightChoosenPiece();
                } else {
                    if (this.board[i + 1][j - 1] == 1)
                        this.windows[i + 1][j - 1].hightlightChoosenPiece();
                    if (this.board[i - 1][j - 1] == 1)
                        this.windows[i - 1][j - 1].hightlightChoosenPiece();
                }
                this.windows[i][j - 1].hightlightChoosenPiece();
            }
        }
        this.windows[i][j].hightlightChoosenPiece();
    }

    @Override
    public void removePieceSizeRangeHighlight() {
        int i = getPositionX();
        int j = getPositionY();

        if (getPieceType() == 1) {
            if (j < 7) {
                if (i == 0) {
                    if (this.board[i + 1][j + 1] == 2)
                        this.windows[i + 1][j + 1].removeHighlightChoosenPiece();
                } else if (i == 7) {
                    if (this.board[i - 1][j + 1] == 2)
                        this.windows[i - 1][j + 1].removeHighlightChoosenPiece();
                } else {
                    if (this.board[i + 1][j + 1] == 2)
                        this.windows[i + 1][j + 1].removeHighlightChoosenPiece();
                    if (this.board[i - 1][j + 1] == 2)
                        this.windows[i - 1][j + 1].removeHighlightChoosenPiece();
                }
                this.windows[i][j + 1].removeHighlightChoosenPiece();
            }
        } else if (getPieceType() == 2) {
            if (j > 0) {
                if (i == 0) {
                    if (this.board[i + 1][j - 1] == 1)
                        this.windows[i + 1][j - 1].removeHighlightChoosenPiece();
                } else if (i == 7) {
                    if (this.board[i - 1][j - 1] == 1)
                        this.windows[i - 1][j - 1].removeHighlightChoosenPiece();
                } else {
                    if (this.board[i + 1][j - 1] == 1)
                        this.windows[i + 1][j - 1].removeHighlightChoosenPiece();
                    if (this.board[i - 1][j - 1] == 1)
                        this.windows[i - 1][j - 1].removeHighlightChoosenPiece();
                }
                this.windows[i][j - 1].removeHighlightChoosenPiece();
            }
        }
        this.windows[i][j].removeHighlightChoosenPiece();
    }

}
