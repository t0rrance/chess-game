package sample.piece;

import javafx.scene.Group;
import javafx.scene.image.ImageView;
import sample.ChessBoard;
import sample.Window;

public abstract class Piece extends Group {

    private final String name;
    private final int pieceType;
    private int positionX;
    private int positionY;
    private final int moveRange;
    protected ChessBoard chessBoard;
    protected int[][] board;
    protected Window[][] windows;
    protected ImageView imageView = new ImageView();

    public Piece(int pieceType, int positionX, int positionY, String name, int moveRange, ChessBoard chessBoard) {
        this.chessBoard = chessBoard;
        this.windows = chessBoard.getWindows();
        this.board = chessBoard.getBoard();
        this.pieceType = pieceType;
        this.positionX = positionX;
        this.positionY = positionY;
        this.relocate(positionX, positionY);
        this.name = name;
        this.moveRange = moveRange;
    }

    abstract void setImage(int pieceType);

    public abstract void pieceSizeRangeHighlight();

    public abstract void removePieceSizeRangeHighlight();

    @Override
    public void relocate(double x, double y) {
        imageView.setX(x);
        imageView.setY(y);
    }

    @Override
    public void resize(double width, double height) {
        imageView.setFitHeight(width);
        imageView.setFitWidth(height);
    }

    public ImageView getImageView() {
        return imageView;
    }

    public int getPieceType() {
        return pieceType;
    }

    public String getPieceName() {
        return name;
    }

    public int getMoveRange() {
        return moveRange;
    }

    public int getPositionX() {
        return positionX;
    }

    public int getPositionY() {
        return positionY;
    }

    public void setPiecePositionIndex(int positionX, int positionY) {
        this.positionX = positionX;
        this.positionY = positionY;
    }

}
