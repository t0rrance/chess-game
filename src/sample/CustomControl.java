package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Control;
import javafx.scene.input.MouseEvent;

public class CustomControl extends Control {

    private ChessBoard chessBoard;
    private GameEngine gameEngine;
    private StatusBar statusBar;
    private int statusBarSize = 100;
    private EventHandler<MouseEvent> mouseHandler;
    private int selectedIndexX;
    private int selectedIndexY;
    private int indexSelectedPieceX;
    private int indexSelectedPieceY;
    private static int clickCounter = 0;
    public static boolean turnToMove = false; //true - black

    public CustomControl() {
        setSkin(new CustomControlSkin(this));
        this.statusBar = new StatusBar();
        chessBoard = new ChessBoard(this.statusBar);
        getChildren().addAll(statusBar, chessBoard);

        this.statusBar.getResetButton().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                chessBoard.resetGame();
            }
        });

        this.mouseHandler = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                selectPiece(event.getX(), event.getY());
            }
        };

        this.chessBoard.setOnMouseClicked(this.mouseHandler);
    }

    private void createGameEngine() {
        this.gameEngine = new GameEngine(this.chessBoard);
    }

    private void selectPiece(double coordinateX, double coordinateY) {
        int[] convertedToIndex = convertToIndex(coordinateX, coordinateY);
        this.selectedIndexX = convertedToIndex[0];
        this.selectedIndexY = convertedToIndex[1];
        if (gameEngine.checkTurn(selectedIndexX, selectedIndexY) || clickCounter == 1) {
            if (clickCounter == 0) {
                this.gameEngine.sizeRangeHightlight(selectedIndexX, selectedIndexY);
                indexSelectedPieceX = selectedIndexX;
                indexSelectedPieceY = selectedIndexY;
                clickCounter = 1;
            } else if (this.gameEngine.clickAnotherMyPiece(selectedIndexX, selectedIndexY, (turnToMove == true) ? 1 : 2)) {
                if (gameEngine.checkIfClickTheSamePiece(indexSelectedPieceX, indexSelectedPieceY, selectedIndexX, selectedIndexY)) {
                    if (this.gameEngine.pieceMove(indexSelectedPieceX, indexSelectedPieceY, selectedIndexX, selectedIndexY)) {
                        changeTurn();
                    }
                    clickCounter = 0;
                }
            } else {
                this.gameEngine.removeSizeRangeHighlight(indexSelectedPieceX, indexSelectedPieceY);
                this.gameEngine.sizeRangeHightlight(selectedIndexX, selectedIndexY);
                indexSelectedPieceX = selectedIndexX;
                indexSelectedPieceY = selectedIndexY;
                clickCounter = 1;
            }
        }
    }

    private int[] convertToIndex(double coordinateX, double coordinateY) {
        int[] convertedTabele = new int[2];
        double chessBoardSizeWidth = chessBoard.getBackgroundWidth();
        double chessBoardSizeHeight = chessBoard.getBackGroundHeight();
        int cellSizeX = (int) (chessBoardSizeWidth / 8.0);
        int cellSizeY = (int) (chessBoardSizeHeight / 8.0);
        convertedTabele[0] = (int) (coordinateX / cellSizeX);
        convertedTabele[1] = (int) (coordinateY / cellSizeY);
        return convertedTabele;
    }

    @Override
    public void resize(double width, double height) {
        super.resize(width, height - statusBarSize);
        chessBoard.setTranslateY(statusBarSize / 2);
        chessBoard.resize(width, height - statusBarSize);
        statusBar.resize(width, statusBarSize);
        statusBar.setTranslateY(-(statusBarSize / 2));
        createGameEngine();
    }

    private void changeTurn() {
        if (turnToMove) {
            System.out.println("turn: white");
            turnToMove = false;
        } else {
            turnToMove = true;
            System.out.println("turn: black");
        }
    }

}
