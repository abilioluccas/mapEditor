package org.abilioLuccas;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Cube {

    private boolean painted;
    private Rectangle rectangle;

    public Cube(int xPos, int yPos, int cellSize) {
        this.rectangle = new Rectangle(xPos, yPos, cellSize, cellSize);
        this.rectangle.setFill(Color.TRANSPARENT);
        this.rectangle.setStroke(Color.BLACK);
    }

    public boolean isPainted() {
        return painted;
    }

    public void setPainted(boolean painted) {
        if (painted) {
            this.rectangle.setFill(Color.BLACK);
        } else {
            this.rectangle.setFill(Color.TRANSPARENT);
        }
        this.painted = painted;
    }

    public Rectangle getRectangle() {
        return rectangle;
    }
}
