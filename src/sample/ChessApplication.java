package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class ChessApplication extends Application {

    private StackPane mainlayout;
    private CustomControl customControl;

    @Override
    public void init() throws Exception {
        mainlayout = new StackPane();
        customControl = new CustomControl();
        mainlayout.getChildren().add(customControl);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Chess game");
        primaryStage.setScene(new Scene(mainlayout, 600, 700));
        primaryStage.getScene().setRoot(mainlayout);
        primaryStage.setMinHeight(300);
        primaryStage.setMinWidth(300);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
