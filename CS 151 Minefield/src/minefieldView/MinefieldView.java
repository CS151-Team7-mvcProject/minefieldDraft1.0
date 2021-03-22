package minefieldView;

import java.awt.*;
import java.beans.PropertyChangeEvent;
import javax.swing.*;
import minefieldModel.*;
import mvc.*;

public class MinefieldView extends View {	
	private static final long serialVersionUID = 1L;

	private Player sgtRock = new Player();
	private Grid g = new Grid();

	private int SIDES;
	private int SIDE_LENGTH = 13;
	private int GAP = 1;
	private static Color CELL_COLOR = Color.gray;

	private JLabel[][] displayGrid = new JLabel[SIDES][SIDES];


	public MinefieldView(Player m) {
		super(m);
		sgtRock = (Player) super.model;
		SIDES = g.getGridSize();
		displayGrid = new JLabel[SIDES][SIDES];
		
		//Create a new 2d array of JLabels and set the border, layout, and preferred size
		setBorder(BorderFactory.createLineBorder(Color.BLACK, GAP));
		setLayout(new GridLayout(SIDES, SIDES));
		Dimension prefSize = new Dimension(SIDE_LENGTH, SIDE_LENGTH);

		//Loop through all of the JLabels and highlight them as needed.
		for (int i = 0; i < SIDES; i++) {
			for (int j = 0; j < SIDES; j++) {
				if (i == 0 && j == 0) {
					int nearbyMines = g.getPatchInGrid(i, j).getNeighborCount();
					displayGrid[j][i] = new JLabel(String.valueOf(nearbyMines), SwingConstants.CENTER);
					displayGrid[j][i].setBorder(BorderFactory.createLineBorder(Color.WHITE, GAP));
					displayGrid[j][i].setBackground(CELL_COLOR);
					displayGrid[j][i].setPreferredSize(prefSize);
					add(displayGrid[j][i]);
				} 
				else if (i == 19 && j == 19) {
					displayGrid[j][i] = new JLabel("X", SwingConstants.CENTER);
					displayGrid[j][i].setBorder(BorderFactory.createLineBorder(Color.GREEN, GAP));
					displayGrid[j][i].setBackground(CELL_COLOR);
					displayGrid[j][i].setPreferredSize(prefSize);
					add(displayGrid[j][i]);
				} 
				else {
					displayGrid[j][i] = new JLabel("?", SwingConstants.CENTER);
					if (g.getPatchInGrid(j,i).isDangerous()) {
						displayGrid[j][i].setBorder(BorderFactory.createLineBorder(Color.RED, GAP));
					} 
					else {
						displayGrid[j][i].setBorder(BorderFactory.createLineBorder(Color.BLACK, GAP));
					}
					displayGrid[j][i].setBackground(CELL_COLOR);
					displayGrid[j][i].setPreferredSize(prefSize);
					add(displayGrid[j][i]);
				}
			}
		}
	}

	@Override
	// Forget about paintComponent. Instead, override propertyChange.
	// When called, it locates the patch occupied by the player,
	// and modifies the label, border, and/or background color of the
	// corresponding JLabel.
	public void propertyChange(PropertyChangeEvent evt) {
		int x = (int) sgtRock.getLocation().getX();
		int y = (int) sgtRock.getLocation().getY();
		int nearbyMines = g.getPatchInGrid(x, y).getNeighborCount();
		Dimension prefSize = new Dimension(SIDE_LENGTH, SIDE_LENGTH);
		displayGrid[x][y].setText(String.valueOf(nearbyMines));
		displayGrid[x][y].setBorder(BorderFactory.createLineBorder(Color.WHITE, GAP));
		displayGrid[x][y].setBackground(CELL_COLOR);
		displayGrid[x][y].setPreferredSize(prefSize);
	}
}
