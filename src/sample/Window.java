package sample;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.transform.Translate;


public class Window extends Group {

    private Rectangle rectangle;
    private Translate position;
    private boolean canMoveOnThisWindow = false;

    public Window(int blackOrWhite) {
        rectangle = new Rectangle();
        position = new Translate();
        rectangle.getTransforms().add(position);
        if (blackOrWhite == 1) rectangle.setFill(Color.PINK);
        else if (blackOrWhite == 2) rectangle.setFill(Color.WHITE);
        setManaged(false);
        getChildren().add(rectangle);
    }

    @Override
    public void resize(double width, double height) {
        super.resize(width, height);
        rectangle.setHeight(height);
        rectangle.setWidth(width);
    }

    @Override
    public void relocate(double x, double y) {
        super.relocate(x, y);
        position.setX(x);
        position.setY(y);
    }

    public void hightlightChoosenPiece() {
        rectangle.setStroke(Color.RED);
        rectangle.setStrokeWidth(4);
        this.canMoveOnThisWindow = true;

    }

    public void removeHighlightChoosenPiece() {
        this.rectangle.setStrokeWidth(0);
        this.canMoveOnThisWindow = false;
    }

    public boolean isCanMoveOnThisWindow() {
        return canMoveOnThisWindow;
    }

}
