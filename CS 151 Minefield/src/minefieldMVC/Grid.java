package minefieldMVC;

public class Grid {

    private int X;
    private int Y;
    private Minefield minefield;
    private boolean isMined;
    private int nearbyMines;
    private boolean isWinningSquare;
    private boolean isPersonOn;
    private boolean isExposed;

    public Grid(Minefield minefield, int row, int col, boolean isMined) {
        this.minefield = minefield;
        this.Y = row;
        this.X = col;
        this.isMined = isMined;
        nearbyMines = -1;
        // sets isWinningSquare
        if (Y == 19 && X == 19) {
            isWinningSquare = true;
        } else {
            isWinningSquare = false;
        }
        isPersonOn = this.isPersonOn(X, Y);
        isExposed = false;
    }

    public void setIsExposed(boolean bool) {
        isExposed = bool;
    }

    public boolean isExposed() {
        return isExposed;
    }

    public int calcNearbyMines() {
        nearbyMines = 0;
        if (Y - 1 >= 0) { // N
            if (minefield.getGrid(X, Y - 1).isMined) {
                nearbyMines++;
            }
        }
        if (Y + 1 <= 19) { // S
            if (minefield.getGrid(X, Y + 1).isMined) {
                nearbyMines++;
            }
        }
        if (X - 1 >= 0) { // W
            if (minefield.getGrid(X - 1, Y).isMined) {
                nearbyMines++;
            }
        }
        if (X + 1 <= 19) { // E
            if (minefield.getGrid(X + 1, Y).isMined) {
                nearbyMines++;
            }
        }
        if (Y - 1 >= 0 && X - 1 >= 0) { //NW
            if (minefield.getGrid(X - 1, Y - 1).isMined) {
                nearbyMines++;
            }
        }
        if (Y - 1 >= 0 && X + 1 <= 19) { // NE
            if (minefield.getGrid(X + 1, Y - 1).isMined) {
                nearbyMines++;
            }
        }
        if (Y + 1 <= 19 && X - 1 >= 0) { //SW
            if (minefield.getGrid(X - 1, Y + 1).isMined) {
                nearbyMines++;
            }
        }
        if (Y + 1 <= 19 && X + 1 <= 19) { // SE
            if (minefield.getGrid(X + 1, Y + 1).isMined) {
                nearbyMines++;
            }
        }
        return nearbyMines;
    }

    public boolean isPersonOn(int colX, int rowY) {
        if (this.X == colX && this.Y == rowY) {
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

    public int getY() {
        return Y;
    }

    public int getX() {
        return X;
    }

    public int getNearbyMines() {
        return nearbyMines;
    }
}
