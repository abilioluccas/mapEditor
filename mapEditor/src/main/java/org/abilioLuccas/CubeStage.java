package org.abilioLuccas;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class CubeStage {

    private Stage stage;
    private Cube[] cubes;

    public CubeStage(Stage stage) {
        this.stage = stage;
        this.cubes = new Cube[225];
        for (int i = 0; i < 15; i++){
            int rowPosition = i * 50; // This calculates the row position of each cube
            for (int j = 0; j < 15; j++){
                int colPosition = j * 50; // This calculates the column position of each cube
                int cubePosition = i * 15 + j; // This calculates the position in the cubes array
                cubes[cubePosition] = new Cube(rowPosition, colPosition, 50); // This creates a new Cube object and stores it in the cubes array
            }//end for j
        }//end for i
    }

    public void setup() {
        Pane root = new Pane();
        for (Cube cube : cubes) {
            root.getChildren().add(cube.getRectangle());
        }

        Scene scene = new Scene(root, 750, 750);
        stage.setScene(scene);
        stage.show();
    }
}
