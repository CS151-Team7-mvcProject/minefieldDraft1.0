package minefieldMVC;

import javax.swing.*;
import java.awt.*;
import java.beans.PropertyChangeEvent;

public class MinefieldView extends mvc.View {

    private Minefield minefield;
    private Grid[][] minedBoard;
    private JLabel[][] board;

    // Number of rows + cols in square grid
    private static final int SIDES = 20;
    private static final int SIDE_LENGTH = 13;
    private static final int GAP = 1;
    private static final Color CELL_COLOR = Color.gray;

    public MinefieldView(Minefield model) {
        super(model);
        minefield = (Minefield) super.model;
        minedBoard = minefield.getBoard();

        board = new JLabel[SIDES][SIDES];
        setBorder(BorderFactory.createLineBorder(Color.BLACK, GAP));
        setLayout(new GridLayout(SIDES, SIDES));
        Dimension prefSize = new Dimension(SIDE_LENGTH, SIDE_LENGTH);
        for (int i = 0; i < SIDES; i++) {
            for (int j = 0; j < SIDES; j++) {
                if (i == 0 && j == 0) {
                    int nearbyMines = minefield.getNearbyMines();
                    board[i][j] = new JLabel(String.valueOf(nearbyMines));
                    board[i][j].setBorder(BorderFactory.createLineBorder(Color.WHITE, GAP));
                    board[i][j].setBackground(CELL_COLOR);
                    board[i][j].setPreferredSize(prefSize);
                    add(board[i][j]);
                } else if (i == 19 && j == 19) {
                    board[i][j] = new JLabel("?");
                    board[i][j].setBorder(BorderFactory.createLineBorder(Color.GREEN, GAP));
                    board[i][j].setBackground(CELL_COLOR);
                    board[i][j].setPreferredSize(prefSize);
                    add(board[i][j]);
                } else {
                    board[i][j] = new JLabel("?");
                    if (minedBoard[i][j].isMined()) {
                        board[i][j].setBorder(BorderFactory.createLineBorder(Color.RED, GAP));
                    } else {
                        board[i][j].setBorder(BorderFactory.createLineBorder(Color.BLACK, GAP));
                    }
                    board[i][j].setBackground(CELL_COLOR);
                    board[i][j].setPreferredSize(prefSize);
                    add(board[i][j]);
                }
            }
        }
    }
    // Cell extends JLabel subclass to help draw????


    // 2D array of labels, associated with a patch
    public void paintComponent(Graphics gc) {
        super.paintComponent(gc);

//        setBorder(BorderFactory.createLineBorder(Color.BLACK, GAP));
//        setLayout(new GridLayout(SIDES, SIDES));
//        Dimension prefSize = new Dimension(SIDE_LENGTH, SIDE_LENGTH);

//        for (int i = 0; i < SIDES; i++) {
//            for (int j = 0; j < SIDES; j++) {
//                theACTUALboard[i][j] = new JLabel("?");
//                theACTUALboard[i][j].setBorder(BorderFactory.createLineBorder(Color.BLACK, GAP));
//                theACTUALboard[i][j].setBackground(CELL_COLOR);
//                theACTUALboard[i][j].setPreferredSize(prefSize);
//                add(theACTUALboard[i][j]);
//            }
//        }


//        for (int i = 0; i < SIDES; i++) {
//            for (int j = 0; j < SIDES; j++) {
//                //minefield.getBoardIsExposed(i, j)
//                Point p = new Point(i, j);
//                //board[i][j].isExposed()
//                if (board[i][j].isExposed()) {
//                    //minefield.getNearbyMines();
//                    int nearbyMines = board[i][j].calcNearbyMines();
//                    JLabel cell = new JLabel(String.valueOf(nearbyMines));
//                    cell.setBorder(BorderFactory.createLineBorder(Color.WHITE, GAP));
//                    cell.setBackground(CELL_COLOR);
//                    cell.setPreferredSize(prefSize);
//                    add(cell);
//                } else {
//                    JLabel cell = new JLabel("?");
//                    cell.setBorder(BorderFactory.createLineBorder(Color.BLACK, GAP));
//                    cell.setBackground(CELL_COLOR);
//                    cell.setPreferredSize(prefSize);
//                    add(cell);
//                }
//            }
//        }
    }

    @Override
    // Forget about paintComponent. Instead, override propertyChange.
    // When called, it locates the patch occupied by the player,
    // and modifies the label, border, and/or background color of the
    // corresponding JLabel.
    public void propertyChange(PropertyChangeEvent evt) {
        Point newP = minefield.getCurrentLocation();
        // IK is wack but works
        int y = newP.getXCord();
        int x = newP.getYCord();
        int nearbyMines = minefield.getNearbyMines();
        Dimension prefSize = new Dimension(SIDE_LENGTH, SIDE_LENGTH);
        board[x][y].setText(String.valueOf(nearbyMines));
        board[x][y].setBorder(BorderFactory.createLineBorder(Color.WHITE, GAP));
        board[x][y].setBackground(CELL_COLOR);
        board[x][y].setPreferredSize(prefSize);
//        repaint();
    }
}
