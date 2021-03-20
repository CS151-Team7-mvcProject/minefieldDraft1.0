package minefieldView;

import java.awt.*;
import java.beans.PropertyChangeEvent;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import minefieldModel.*;
import mvc.*;

public class MinefieldView extends View {	
	private static final long serialVersionUID = 1L;

	private int SIDES;
	private int SIDE_LENGTH = 13;
	private int GAP = 1;
	private static Color CELL_COLOR = Color.gray;

	private Player sgtRock = new Player();
	private JLabel[][] displayGrid = new JLabel[SIDES][SIDES];
	private Grid g;


	public MinefieldView(Player m) {
		super(m);
		sgtRock = (Player) super.model;
		g = new Grid();
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
					displayGrid[i][j] = new JLabel(String.valueOf(nearbyMines));
					displayGrid[i][j].setBorder(BorderFactory.createLineBorder(Color.WHITE, GAP));
					displayGrid[i][j].setBackground(CELL_COLOR);
					displayGrid[i][j].setPreferredSize(prefSize);
					add(displayGrid[i][j]);
				} 
				else if (i == 19 && j == 19) {
					displayGrid[i][j] = new JLabel("X");
					displayGrid[i][j].setBorder(BorderFactory.createLineBorder(Color.GREEN, GAP));
					displayGrid[i][j].setBackground(CELL_COLOR);
					displayGrid[i][j].setPreferredSize(prefSize);
					add(displayGrid[i][j]);
				} 
				else {
					displayGrid[i][j] = new JLabel("?");
					if (g.getPatchInGrid(i,j).isDangerous()) {
						displayGrid[i][j].setBorder(BorderFactory.createLineBorder(Color.RED, GAP));
					} 
					else {
						displayGrid[i][j].setBorder(BorderFactory.createLineBorder(Color.BLACK, GAP));
					}
					displayGrid[i][j].setBackground(CELL_COLOR);
					displayGrid[i][j].setPreferredSize(prefSize);
					add(displayGrid[i][j]);
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
