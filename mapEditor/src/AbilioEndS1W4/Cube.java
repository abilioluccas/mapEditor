package AbilioEndS1W4;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Cube {
    private boolean painted;
    private Rectangle cube;

    public Cube(int xPos , int yPos, int cellSize){
        this.cube = new Rectangle(xPos, yPos, cellSize, cellSize);
    }

    public boolean isPainted() {
        return painted;
    }

    public void setPainted() {
        if(isPainted()){
            this.cube.delete();
            this.cube.setColor(Color.BLACK);
            this.cube.draw();
            this.painted = false;
            return;
        }
        this.cube.delete();
        this.cube.setColor(Color.BLACK);
        this.cube.fill();
        this.painted = true;
    }

    public void setUnPainted() {
        this.cube.delete();
        this.cube.setColor(Color.BLACK);
        this.cube.draw();
        this.painted = false;
    }

    public Rectangle getCube() {
        return cube;
    }

}
