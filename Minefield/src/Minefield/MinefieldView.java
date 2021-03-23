package Minefield;

import javax.swing.*;
import java.awt.*;

public class MinefieldView extends mvc.View {

    Minefield minefield;

    // Number of rows + cols in square grid
    private static final int SIDES = 20;
    private static final int SIDE_LENGTH = 13;
    private static final int GAP = 1;
    private static final Color CELL_COLOR = Color.gray;

    public MinefieldView(Minefield model) {
        super(model);
        minefield = model;
    }
    // Cell extends JLabel subclass to help draw????


    // 2D array of labels, associated with a patch
    public void paintComponent(Graphics gc) {
        super.paintComponent(gc);
        Grid[][] board = minefield.getBoard();

        setBorder(BorderFactory.createLineBorder(Color.BLACK, GAP));
        setLayout(new GridLayout(SIDES, SIDES));
        Dimension prefSize = new Dimension(SIDE_LENGTH, SIDE_LENGTH);
        for (int i = 0; i < SIDES; i++) {
            for (int j = 0; j < SIDES; j++) {
                JLabel cell = new JLabel("?");
                if (board[i][j].isMined()) {
                    cell.setBorder(BorderFactory.createLineBorder(Color.WHITE, GAP));
                } else {
                    cell.setBorder(BorderFactory.createLineBorder(Color.BLACK, GAP));
                }
                cell.setBackground(CELL_COLOR);
                cell.setPreferredSize(prefSize);
                add(cell);
            }
        }

//        // Creates border around WHOLE THING
//        setBorder(BorderFactory.createLineBorder(Color.BLACK, GAP));
//        setLayout(new GridLayout(SIDES, SIDES));
//        Dimension prefSize = new Dimension(SIDE_LENGTH, SIDE_LENGTH);
//        for (int i = 0; i < SIDES; i++) {
//            for (int j = 0; j < SIDES; j++) {
//                JLabel cell = new JLabel("?");
//                cell.setBackground(CELL_COLOR);
//                cell.setPreferredSize(prefSize);
//                cell.setBorder(BorderFactory.createLineBorder(Color.BLACK, GAP));
//                add(cell);
//            }
//        }
    }
}
