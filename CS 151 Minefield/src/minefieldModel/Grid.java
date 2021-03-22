package minefieldModel;

import java.awt.Point;
import java.util.*;


public class Grid {
	//Instance variables
	//TODO - Add way to edit gridSize & percentMined from menu bar
	private int gridSize = 20;
	private int percentMined = 5;

	private int rows = gridSize;
	private int cols = gridSize;
	private int totalMines = ((gridSize*gridSize)-(100-percentMined)*(gridSize*gridSize)/100);
	private Patch[][] patchArr = new Patch[rows][cols];
	private Random random = new Random();
	private ArrayList<Point> mineLocations = new ArrayList<>();

	//Constructor
	public Grid() {
		super();
		this.generatePatches();
		this.generateMines();
	}//End Grid constructor

	public void generatePatches() {
		//Fills grid with patches, and sets patches location to x,y
		for(int x=0; x<rows; x++) {
			for(int y=0; y<cols; y++) {
				patchArr[x][y] = new Patch(x,y);
				//System.out.println("Adding patch: " + x + "/" + y);
			}
		}	
	}

	public void generateMines() {
		//Generates locations of mines, flags the patch as dangerous, and adds them to an ArrayList
		for(int i=0; i<totalMines;) {
			int ranX = random.nextInt(totalMines-1);
			int ranY = random.nextInt(totalMines-1);
			//So long as not at start/finish, generate a new mine
			//TODO - Prevent player from getting boxed in at start/boxed out of finish
			if(!(ranX==0 && ranY==0) && !(ranX==gridSize && ranY==gridSize)) {
				patchArr[ranX][ranY].setIsDangerous(true);
				mineLocations.add(patchArr[ranX][ranY]);
				System.out.println("Mine at: " + ranX + "/" + ranY);
				i++;
			}
		}

		//Counts number of dangerous neighbors next to the dangerous squares
		for(Point p: mineLocations) {
			int r = (int) p.getX();
			int c = (int) p.getY();
			for(int row = r-1; row <= r+1; row++) {
				for(int col = c-1; col <= c+1; col++) {
					try {
						patchArr[row][col].setNeighborCount(patchArr[row][col].getNeighborCount() + 1);
					} 
					catch(Exception e) {
						//Do nothing, out of bounds.
					}
				}
			}
		}
	}



	//Helper methods
	public int getGridSize() {return gridSize;}
	public void setGridSize(int i) {gridSize = i;}

	public int getPercentMined() {return percentMined;}
	public void setPercentMined(int i) {percentMined = i;}

	public Grid getGrid() {return this;}
	public Patch getPatchInGrid(int x, int y) {return patchArr[x][y];}
	public ArrayList<Point> getMineLocations() {return mineLocations;}
}
