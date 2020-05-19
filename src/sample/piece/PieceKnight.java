package sample.piece;

import javafx.scene.image.Image;
import sample.ChessBoard;

public class PieceKnight extends Piece {

    private Image image;

    public PieceKnight(int pieceType, int positionX, int positionY, ChessBoard chessBoard) {
        super(pieceType, positionX, positionY, "rook", 8, chessBoard);
        setImage(pieceType);
    }

    @Override
    void setImage(int pieceType) {
        if (pieceType == 1) image = new Image("resource/ChessPieces/bKnight.png");
        else if (pieceType == 2) image = new Image("resource/ChessPieces/wKnight.png");
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
        int x;
        int y;

        this.windows[i][j].hightlightChoosenPiece();

        x = i + 1;
        y = j - 2;
        if (0 <= x && x <= 7 && 0 <= y && y <= 7 && getPieceType() != board[x][y])
            this.windows[x][y].hightlightChoosenPiece();

        x = i + 1;
        y = j + 2;
        if (0 <= x && x <= 7 && 0 <= y && y <= 7 && getPieceType() != board[x][y])
            this.windows[x][y].hightlightChoosenPiece();

        x = i - 1;
        y = j + 2;
        if (0 <= x && x <= 7 && 0 <= y && y <= 7 && getPieceType() != board[x][y])
            this.windows[x][y].hightlightChoosenPiece();

        x = i - 1;
        y = j - 2;
        if (0 <= x && x <= 7 && 0 <= y && y <= 7 && getPieceType() != board[x][y])
            this.windows[x][y].hightlightChoosenPiece();

        x = i + 2;
        y = j - 1;
        if (0 <= x && x <= 7 && 0 <= y && y <= 7 && getPieceType() != board[x][y])
            this.windows[x][y].hightlightChoosenPiece();

        x = i + 2;
        y = j + 1;
        if (0 <= x && x <= 7 && 0 <= y && y <= 7 && getPieceType() != board[x][y])
            this.windows[x][y].hightlightChoosenPiece();

        x = i - 2;
        y = j + 1;
        if (0 <= x && x <= 7 && 0 <= y && y <= 7 && getPieceType() != board[x][y])
            this.windows[x][y].hightlightChoosenPiece();

        x = i - 2;
        y = j - 1;
        if (0 <= x && x <= 7 && 0 <= y && y <= 7 && getPieceType() != board[x][y])
            this.windows[x][y].hightlightChoosenPiece();
    }

    @Override
    public void removePieceSizeRangeHighlight() {
        int i = getPositionX();
        int j = getPositionY();
        int x;
        int y;

        this.windows[i][j].removeHighlightChoosenPiece();
        x = i + 1;
        y = j - 2;
        if (0 <= x && x <= 7 && 0 <= y && y <= 7)
            this.windows[x][y].removeHighlightChoosenPiece();

        x = y = 0;
        x = i + 1;
        y = j + 2;
        if (0 <= x && x <= 7 && 0 <= y && y <= 7)
            this.windows[x][y].removeHighlightChoosenPiece();

        x = y = 0;
        x = i - 1;
        y = j + 2;
        if (0 <= x && x <= 7 && 0 <= y && y <= 7)
            this.windows[x][y].removeHighlightChoosenPiece();

        x = y = 0;
        x = i - 1;
        y = j - 2;
        if (0 <= x && x <= 7 && 0 <= y && y <= 7)
            this.windows[x][y].removeHighlightChoosenPiece();

        x = i + 2;
        y = j - 1;
        if (0 <= x && x <= 7 && 0 <= y && y <= 7)
            this.windows[x][y].removeHighlightChoosenPiece();

        x = i + 2;
        y = j + 1;
        if (0 <= x && x <= 7 && 0 <= y && y <= 7)
            this.windows[x][y].removeHighlightChoosenPiece();

        x = i - 2;
        y = j + 1;
        if (0 <= x && x <= 7 && 0 <= y && y <= 7)
            this.windows[x][y].removeHighlightChoosenPiece();

        x = i - 2;
        y = j - 1;
        if (0 <= x && x <= 7 && 0 <= y && y <= 7)
            this.windows[x][y].removeHighlightChoosenPiece();
    }

}
