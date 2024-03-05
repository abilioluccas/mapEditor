package AbilioEndS1W4;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

import java.io.*;

public class EventHandler implements KeyboardHandler {


    private Rectangle painter;
    private Grid grid;
    private boolean spacePressed;

    public EventHandler(Grid grid, Rectangle painter) {
        this.grid = grid;
        this.painter = painter;


    }//end Constructor

    public void init() {
        Keyboard kb = new Keyboard(this);

        KeyboardEvent right = new KeyboardEvent();
        right.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        right.setKey(KeyboardEvent.KEY_RIGHT);
        kb.addEventListener(right);

        KeyboardEvent left = new KeyboardEvent();
        left.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        left.setKey(KeyboardEvent.KEY_LEFT);
        kb.addEventListener(left);

        KeyboardEvent down = new KeyboardEvent();
        down.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        down.setKey(KeyboardEvent.KEY_DOWN);
        kb.addEventListener(down);

        KeyboardEvent up = new KeyboardEvent();
        up.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        up.setKey(KeyboardEvent.KEY_UP);
        kb.addEventListener(up);

        //paint P
        KeyboardEvent paint = new KeyboardEvent();
        paint.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        paint.setKey(KeyboardEvent.KEY_P);
        kb.addEventListener(paint);

        //clear C
        KeyboardEvent clear = new KeyboardEvent();
        clear.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        clear.setKey(KeyboardEvent.KEY_C);
        kb.addEventListener(clear);

        //save S
        KeyboardEvent save = new KeyboardEvent();
        save.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        save.setKey(KeyboardEvent.KEY_S);
        kb.addEventListener(save);

        //load L
        KeyboardEvent load = new KeyboardEvent();
        load.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        load.setKey(KeyboardEvent.KEY_L);
        kb.addEventListener(load);

        //space |__|
        KeyboardEvent space = new KeyboardEvent();
        space.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        space.setKey(KeyboardEvent.KEY_SPACE);
        kb.addEventListener(space);

        //space
        KeyboardEvent spaceReleased = new KeyboardEvent();
        spaceReleased.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        spaceReleased.setKey(KeyboardEvent.KEY_SPACE);
        kb.addEventListener(spaceReleased);

    }//end init

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {

        if (spacePressed) {
            for (int i = 0; i < grid.getCubes().length; i++) {
                Rectangle gridPos = grid.getCubes()[i].getCube();

                boolean overlapX = gridPos.getX() <= painter.getX() + (grid.getCellSize() - 10) && gridPos.getX() + (grid.getCellSize() - 10) >= painter.getX();
                boolean overlapY = gridPos.getY() <= painter.getY() + (grid.getCellSize() - 10) && gridPos.getY() + (grid.getCellSize() - 10) >= painter.getY();
                if (overlapX && overlapY) {
                    grid.getCubes()[i].setPainted();
                }
                painter.delete();
                painter.fill();
            }
        }

        switch (keyboardEvent.getKey()) {
            case KeyboardEvent.KEY_RIGHT:
                if (painter.getX() < ((grid.getGridSize()) * grid.getCellSize()) - grid.getCellSize()) {
                    painter.translate(grid.getCellSize() / 2, 0);
                }
                break;
            case KeyboardEvent.KEY_LEFT:

                if (painter.getX() > 15) {
                    painter.translate(-grid.getCellSize() / 2, 0);
                }
                break;
            case KeyboardEvent.KEY_DOWN:
                if (painter.getY() < ((grid.getGridSize()) * grid.getCellSize()) - grid.getCellSize()) {
                    painter.translate(0, grid.getCellSize() / 2);
                }
                break;
            case KeyboardEvent.KEY_UP:
                if (painter.getY() > 15) {
                    painter.translate(0, -grid.getCellSize() / 2);
                }
                break;
            case KeyboardEvent.KEY_P:
                //paint
                for (int i = 0; i < grid.getCubes().length; i++) {
                    Rectangle gridPos = grid.getCubes()[i].getCube();

                    boolean overlapX = gridPos.getX() <= painter.getX() + (grid.getCellSize() - 10) && gridPos.getX() + (grid.getCellSize() - 10) >= painter.getX();
                    boolean overlapY = gridPos.getY() <= painter.getY() + (grid.getCellSize() - 10) && gridPos.getY() + (grid.getCellSize() - 10) >= painter.getY();
                    if (overlapX && overlapY) {
                        grid.getCubes()[i].setPainted();
                    }
                    painter.delete();
                    painter.fill();
                }
                break;
            case KeyboardEvent.KEY_C:
                //clear
                for (int i = 0; i < grid.getCubes().length; i++) {
                    Rectangle gridPos = grid.getCubes()[i].getCube();
                    gridPos.delete();
                    gridPos.setColor(Color.BLACK);
                    gridPos.draw();
                }
                break;

            case KeyboardEvent.KEY_S:
                //save
                BufferedWriter writer;
                try {
                    writer = new BufferedWriter(new FileWriter("src/AbilioEndS1W4/SaveLoad.txt"));
                    for (int i = 0; i < grid.getCubes().length; i++) {
                        if (grid.getCubes()[i].isPainted()) {
                            writer.write("1");
                        } else {
                            writer.write("0");
                        }
                    }//end for
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;

            case KeyboardEvent.KEY_L:
                //load
                BufferedReader reader;
                try {
                    reader = new BufferedReader(new FileReader("src/AbilioEndS1W4/SaveLoad.txt"));
                    for (int i = 0; i < grid.getCubes().length; i++) {
                        grid.getCubes()[i].setUnPainted();
                        int value = reader.read(); // Read the character as an integer
                        char c = (char) value; // Convert the read value to a character ('0' or '1')
                        int intValue = Character.getNumericValue(c); // Convert the character to an integer
                        if (intValue == 1) {
                            grid.getCubes()[i].setPainted();
                        }
                    }
                    reader.close();
                } catch (IOException e){
                    e.printStackTrace();
                }
                break;

            case KeyboardEvent.KEY_SPACE:
                spacePressed = true;
                break;
        }

    }// end key pressed


    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {
        keyboardEvent.getKeyboardEventType();
        spacePressed = false;
    }


}//end Class EventHandler
