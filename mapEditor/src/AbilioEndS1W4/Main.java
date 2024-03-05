package AbilioEndS1W4;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Main {

    public static void main(String[] args) {
        int gridSize = 15;
        int cellSize = 50;
        int PADDING= 10;

        Grid grid = new Grid(gridSize, cellSize, PADDING);
        Rectangle painter = new Rectangle(PADDING+5, PADDING +5, cellSize-10, cellSize-10);
        painter.setColor(Color.BLUE);
        painter.fill();


        EventHandler eventHandler = new EventHandler(grid, painter);
        eventHandler.init();

    }//end psvm

}// end main
