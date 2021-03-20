package minefieldMVC;

import mvc.Model;

import java.util.ArrayList;
import java.util.Random;

public class Minefield extends Model {

    public static int percentMined = 5;
    public static final int gridSize = 20;

    private Grid[][] board;
    private ArrayList<Point> locations;
    private Point currentLocation;

    public Minefield() {
        locations = new ArrayList<>();
        // Initialize board
        board = new Grid[gridSize][gridSize];
        int count = 0;
        Random gen = new Random();
        int row;
        int col;
        for (int i = 0; i < gridSize; i++) {
            for (int j = 0; j < gridSize; j++) {
                board[i][j] = new Grid(this, i, j, false);
            }
        }
        for (int i = 0; i < gridSize; i++) {
            for (int j = 0; j < gridSize; j++) {
                if (count < 20 && !(i == 0 && j == 0)) {
                    row = gen.nextInt(20);
                    col = gen.nextInt(20);
                    if (!board[i][j].isMined()) {
                        board[row][col].setIsMined(true);
                        count++;
                    }
                } else {
                    break;
                }
            }
        }
        locations.add(new Point(0, 0));
        board[0][0].setIsExposed(true);
        currentLocation = new Point(0, 0);
    }

    public void nw() {
        int oldx = currentLocation.getXCord();
        int oldy = currentLocation.getYCord();
        if (oldy - 1 >= 0 && oldx - 1 >= 0) {
            currentLocation.setXCord(oldx - 1);
            currentLocation.setYCord(oldy - 1);
            board[currentLocation.getXCord()][currentLocation.getYCord()].setIsExposed(true);
            Point newP = new Point(currentLocation.getXCord(), currentLocation.getYCord());
            locations.add(newP);
        }
        firePropertyChange(null, null, null);
    }

    public void n() {
        int oldy = currentLocation.getYCord();
        if (oldy - 1 >= 0) {
            currentLocation.setYCord(oldy - 1);
            board[currentLocation.getXCord()][currentLocation.getYCord()].setIsExposed(true);
            Point newP = new Point(currentLocation.getXCord(), currentLocation.getYCord());
            locations.add(newP);
        }
        firePropertyChange(null, null, null);
    }

    public void ne() {
        int oldx = currentLocation.getXCord();
        int oldy = currentLocation.getYCord();
        if (oldy - 1 >= 0 && oldx + 1 <= 19) {
            currentLocation.setXCord(oldx + 1);
            currentLocation.setYCord(oldy - 1);
            board[currentLocation.getXCord()][currentLocation.getYCord()].setIsExposed(true);
            Point newP = new Point(currentLocation.getXCord(), currentLocation.getYCord());
            locations.add(newP);
        }
        firePropertyChange(null, null, null);
    }

    public void w() {
        int oldx = currentLocation.getXCord();
        if (oldx - 1 >= 0) {
            currentLocation.setXCord(oldx - 1);
            board[currentLocation.getXCord()][currentLocation.getYCord()].setIsExposed(true);
            Point newP = new Point(currentLocation.getXCord(), currentLocation.getYCord());
            locations.add(newP);
        }
        firePropertyChange(null, null, null);
    }

    public void e() {
        int oldx = currentLocation.getXCord();
        if (oldx + 1 <= 19) {
            currentLocation.setXCord(oldx + 1);
            board[currentLocation.getXCord()][currentLocation.getYCord()].setIsExposed(true);
            Point newP = new Point(currentLocation.getXCord(), currentLocation.getYCord());
            locations.add(newP);
        }
        firePropertyChange(null, null, null);
    }

    public void sw() {
        int oldx = currentLocation.getXCord();
        int oldy = currentLocation.getYCord();
        if (oldy + 1 <= 19 && oldx - 1 >= 0) {
            currentLocation.setXCord(oldx - 1);
            currentLocation.setYCord(oldy + 1);
            board[currentLocation.getXCord()][currentLocation.getYCord()].setIsExposed(true);
            Point newP = new Point(currentLocation.getXCord(), currentLocation.getYCord());
            locations.add(newP);
        }
        firePropertyChange(null, null, null);
    }

    public void s() {
        int oldy = currentLocation.getYCord();
        if (oldy + 1 <= 19) {
            currentLocation.setYCord(oldy + 1);
            board[currentLocation.getXCord()][currentLocation.getYCord()].setIsExposed(true);
            Point newP = new Point(currentLocation.getXCord(), currentLocation.getYCord());
            locations.add(newP);
        }
        firePropertyChange(null, null, null);
    }

    public void se() {
        int oldx = currentLocation.getXCord();
        int oldy = currentLocation.getYCord();
        if (oldy + 1 <= 19 && oldx + 1 <= 19) {
            currentLocation.setXCord(oldx + 1);
            currentLocation.setYCord(oldy + 1);
            board[currentLocation.getXCord()][currentLocation.getYCord()].setIsExposed(true);
            Point newP = new Point(currentLocation.getXCord(), currentLocation.getYCord());
            locations.add(newP);
        }
        firePropertyChange(null, null, null);
    }

    // Helper methods
    public Grid getGrid(int row, int col) {
        return board[row][col];
    }

    public Grid[][] getBoard() {
        return board;
    }

    public boolean getBoardIsExposed(int x, int y) {
        return board[x][y].isExposed();
    }

    public Point getLocations(int n) {
        return locations.get(n);
    }

    public int getLocationsSize() {
        return locations.size();
    }

    public Point getCurrentLocation() {
        return currentLocation;
    }

    public int getNearbyMines() {
        int currentX = currentLocation.getXCord();
        int currentY = currentLocation.getYCord();
        return board[currentX][currentY].calcNearbyMines();
    }
}

