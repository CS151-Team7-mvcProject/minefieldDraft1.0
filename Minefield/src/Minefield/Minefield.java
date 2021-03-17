package Minefield;

import mvc.Model;

import java.util.Random;

public class Minefield extends Model {

    public static int percentMined = 5;
    public static final int gridSize = 20;

    private Grid[][] board;
    private boolean[][] locations;
    // CURRENT LOCATIONS
    private int locationRowY;
    private int locationColX;

    public Minefield() {
        // Starting location
        locationRowY = 0;
        locationColX = 0;
        locations = new boolean[gridSize][gridSize];
        // Initialize board
        board = new Grid[gridSize][gridSize];
        int count = 0;
        Random gen = new Random();
        int row;
        int col;
        for (int i = 0; i < gridSize; i++) {
            for (int j = 0; j < gridSize; j++) {
                board[i][j] = new Grid(this, i, j, false);
                locations[i][j] = false;
            }
        }
        for (int i = 0; i < gridSize; i++) {
            for (int j = 0; j < gridSize; j++) {
                if (count <= 20) {
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
        // Starting point
        locations[0][0] = true;
    }

    public void nw() {

    }

    public void n() {

    }

    public void ne() {

    }

    public void w() {

    }

    public void e() {

    }

    public void sw() {

    }

    public void s() {

    }

    public void se() {

    }

    // Helper methods
    public Grid getGrid(int row, int col) {
        return board[row][col];
    }

    public Grid[][] getBoard() {
        return board;
    }
}
