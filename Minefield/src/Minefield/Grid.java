package Minefield;

public class Grid {

    private int colX;
    private int rowY;
    private Minefield minefield;
    private boolean isMined;
    private GridStates state = GridStates.BLANK;
    private int nearbyMines;
    private boolean isWinningSquare;
    private boolean isPersonOn;

    public Grid(Minefield minefield, int row, int col, boolean isMined) {
        this.minefield = minefield;
        this.rowY = row;
        this.colX = col;
        this.isMined = isMined;
        nearbyMines = -1;
        // sets isWinningSquare
        if (rowY == 19 && colX == 19) {
            isWinningSquare = true;
        } else {
            isWinningSquare = false;
        }
        isPersonOn = this.isPersonOn(colX, rowY);
    }

    private int calcNearbyMines() {
        nearbyMines = 0;
        if (rowY - 1 >= 0) { // N
            if (minefield.getGrid(colX, rowY - 1).isMined) {
                nearbyMines++;
            }
        }
        if (rowY + 1 <= 19) { // S
            if (minefield.getGrid(colX, rowY + 1).isMined) {
                nearbyMines++;
            }
        }
        if (colX - 1 >= 0) { // W
            if (minefield.getGrid(colX - 1, rowY).isMined) {
                nearbyMines++;
            }
        }
        if (colX + 1 <= 19) { // E
            if (minefield.getGrid(colX + 1, rowY).isMined) {
                nearbyMines++;
            }
        }
        if (rowY - 1 >= 0 && colX - 1 >= 0) { //NW
            if (minefield.getGrid(colX - 1, rowY - 1).isMined) {
                nearbyMines++;
            }
        }
        if (rowY - 1 >= 0 && colX + 1 <= 19) { // NE
            if (minefield.getGrid(colX + 1, rowY - 1).isMined) {
                nearbyMines++;
            }
        }
        if (rowY + 1 <= 19 && colX - 1 >= 0) {
            if (minefield.getGrid(colX - 1, rowY + 1).isMined) {
                nearbyMines++;
            }
        }
        if (rowY + 1 <= 19 && colX + 1 <= 19) {
            if (minefield.getGrid(colX + 1, rowY + 1).isMined) {
                nearbyMines++;
            }
        }
        return nearbyMines;
    }

    public boolean isPersonOn(int colX, int rowY) {
        if (this.colX == colX && this.rowY == rowY) {
            return true;
        }
        return false;
    }

    // Setter methods
    public void setIsMined(boolean bool) {
        isMined = bool;
    }

    // Helper methods
    public boolean isMined() {
        return isMined;
    }

    public int getRowY() {
        return rowY;
    }

    public int getColX() {
        return colX;
    }

    public int getNearbyMines() {
        return nearbyMines;
    }
}
