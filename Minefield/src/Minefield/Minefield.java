package Minefield;

import mvc.Model;

import java.util.Random;

public class Minefield extends Model {

    public static int percentMined = 5;
    public static final int gridSize = 20;

    private Grid[][] board;
    //    private boolean[][] grid;
    //    private boolean[][] gridLocations;
    private int locationRowY;
    private int locationColX;

    public Minefield() {
        // Starting location
        locationRowY = 0;
        locationColX = 0;
        // Initialize board
        board = new Grid[gridSize][gridSize];
        int count = 0;
        Random gen = new Random();
        int row;
        int col;
        int max = 19;
        int min = 0;
        for (int i = 0; i < gridSize; i++) {
            for (int j = 0; j < gridSize; j++) {
                board[i][j] = new Grid(this, i, j, false);
                if (count < 20) {
                    row = gen.nextInt(max - min) + min;
                    col = gen.nextInt(max - min) + min;
                    if (!board[i][j].isMined() && board[row][col] != null) {
                        board[row][col].setIsMined(true);
                        count++;
                    }
                }
            }
        }
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
}
