package sample;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import sample.piece.*;

public class ChessBoard extends Pane {

    private int[][] board;
    private Piece[][] pieces;
    private Window[][] windows;
    private int boardWidth = 8;
    private int boardHeight = 8;
    private final int whiteSquare = 1;
    private final int blackSquare = 2;
    private final int emptySquare = 0;
    private StatusBar statusBar;
    private Rectangle background;
    private double cell_width;
    private double cell_height;

    public ChessBoard(StatusBar newStatusBar) {
        this.statusBar = newStatusBar;
        statusBar.whitePlayerAlert.setText("White Player turn");
        statusBar.blackPlayerAlert.setText("Black Player turn");
        statusBar.whitePlayerTimer.setText("White timer: 15:00");
        statusBar.blackPlayerTimer.setText("Black timer: 15:00");
        background = new Rectangle();
        background.setFill(Color.GREEN);
        getChildren().add(background);
        this.board = new int[boardHeight][boardWidth];
        this.pieces = new Piece[8][4];
        this.windows = new Window[boardWidth][boardHeight];
        for (int i = 0; i < boardWidth; i++) {
            for (int j = 0; j < boardHeight; j++) {
                if ((i + j) % 2 == 0) {
                    windows[i][j] = new Window(1);
                } else {
                    windows[i][j] = new Window(2);
                }
                getChildren().add(windows[i][j]);
            }
        }
        initPiece();
    }

    private void initPiece() {
        Assets.initPieces(this);
        this.pieces = Assets.getPieces();

        for (int y = 0; y < boardHeight; y++) {
            for (int x = 0; x < boardWidth; x++) {
                if (y == 0 || y == 1)
                    board[x][y] = 1;
                else if (y == 6 || y == 7)
                    board[x][y] = 2;
                else
                    board[x][y] = 0;
            }
        }
        for (int i = 0; i < boardWidth; i++) {
            getChildren().addAll(pieces[i][0].getImageView(), pieces[i][1].getImageView(), pieces[i][2].getImageView(), pieces[i][3].getImageView());
        }
    }

    @Override
    public void resize(double width, double height) {
        super.resize(width, height);
        background.setHeight(height);
        background.setWidth(width);
        this.cell_width = width / 8.0;
        this.cell_height = height / 8.0;

        for (int i = 0; i < boardWidth; i++) {
            for (int j = 0; j < 4; j++) {
                if (j == 2) {
                    pieces[i][j].relocate(i * cell_width, 6 * cell_height);
                    pieces[i][j].setPiecePositionIndex(i, 6);
                    pieces[i][j].resize(cell_width, cell_height);
                } else if (j == 3) {
                    pieces[i][j].relocate(i * cell_width, 7 * cell_height);
                    pieces[i][j].setPiecePositionIndex(i, 7);
                    pieces[i][j].resize(cell_width, cell_height);
                } else {
                    pieces[i][j].relocate(i * cell_width, j * cell_height);
                    pieces[i][j].setPiecePositionIndex(i, j);
                    pieces[i][j].resize(cell_width, cell_height);
                }
            }
        }

        for (int i = 0; i < boardWidth; i++) {
            for (int j = 0; j < boardHeight; j++) {
                windows[i][j].relocate(i * cell_width, j * cell_height);
                windows[i][j].resize(cell_width, cell_height);
            }
        }
    }

    public double getBackgroundWidth() {
        return background.getWidth();
    }

    public double getBackGroundHeight() {
        return background.getHeight();
    }

    public Window[][] getWindows() {
        return windows;
    }

    public int[][] getBoard() {
        return board;
    }

    public Piece[][] getPieces() {
        return pieces;
    }

    public double getCell_width() {
        return this.cell_width;
    }

    public double getCell_height() {
        return this.cell_height;
    }

    public void resetGame() {
    }

}
