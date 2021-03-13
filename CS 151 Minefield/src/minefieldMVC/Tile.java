package minefieldMVC;

import javax.swing.*;

public class Tile extends JButton {
    private int row, col;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int count;  // how many surrounding mines does this tile have?
    protected boolean isMine;


    public Tile(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public int getRow() {
        return row;
    }
    public void setRow(int row) {
        this.row = row;
    }
    public int getCol() {
        return col;
    }
    public void setCol() {
        this.col = col;
    }

}
