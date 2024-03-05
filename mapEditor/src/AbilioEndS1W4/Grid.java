package AbilioEndS1W4;

public class Grid {

    private int PADDING;
    private Cube[] cubes;
    private int cellSize;
    private int gridSize;

    public Grid(int gridSize, int cellSize, int PADDING) {
        this.gridSize = gridSize;
        this.cellSize = cellSize;
        this.PADDING = PADDING;
        this.cubes = new Cube[gridSize*gridSize];
        for (int i = 0; i < gridSize; i++) {
            int rowPosition = i * cellSize + PADDING;
            for (int j = 0; j < gridSize; j++) {
                int colPosition = j * cellSize + PADDING;

                cubes[j + i * gridSize] = new Cube(rowPosition, colPosition, cellSize);
                cubes[j + i * gridSize].getCube().draw();

            }//end for j

        }// end for i
    }

    public Cube[] getCubes() {
        return cubes;
    }

    public void setCubes(Cube[] cubes) {
        this.cubes = cubes;
    }

    public int getPADDING() {
        return this.PADDING;
    }

    public int getCellSize() {
        return this.cellSize;
    }

    public int getGridSize() {
        return this.gridSize;
    }
}//end class
