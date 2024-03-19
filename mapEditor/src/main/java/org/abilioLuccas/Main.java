package org.abilioLuccas;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        CubeStage cubeStage = new CubeStage(primaryStage);
        cubeStage.setup();
    }

    public static void main(String[] args) {
        launch();
    }
}
