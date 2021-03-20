package minefieldModel;

import java.util.*;


public class Grid {
	
	//Instance variables
	private int gridSize = 20;
	private int percentMined = 5;

	private int rows = gridSize;
	private int cols = gridSize;
	private int totalMines = ((gridSize*gridSize)-(100-percentMined)*(gridSize*gridSize)/100);
	private Patch[][] grid;
	private Random random = new Random();
	private ArrayList<Patch> mineLocations = new ArrayList<>();
	
	//Constructor
	public Grid() {
		grid = new Patch[rows][cols];

		//Fills grid with patches, and sets patches location to x,y
		for(int x=0; x<rows; x++) {
			for(int y=0; y<cols; y++) {
				grid[x][y] = new Patch(x,y);
				//System.out.println("Adding patch: " + x + "/" + y);
			}
		}
		
		//Generates locations of mines, flags the patch as dangerous, and adds them to an ArrayList
		for(int i=0; i<totalMines;) {
        	int ranX = random.nextInt(totalMines);
        	int ranY = random.nextInt(totalMines);
        	
        	//So long as not at start/finish, generate a new mine
        	//TODO - Prevent player from getting boxed in at start/boxed out of finish
        	if(!(ranX==0 && ranY==0) && !(ranX==gridSize && ranY==gridSize)) {
        		grid[ranX][ranY].setIsDangerous(true);
        		mineLocations.add(grid[ranX][ranY]);
        		//System.out.println("Mine at: " + ranX + "/" + ranY);
        		i++;
        	}
		}
	}//End Grid constructor

	

	//Helper methods
	public int getGridSize() {return gridSize;}
	public void setGridSize(int i) {gridSize = i;}
	
	public int getPercentMined() {return percentMined;}
	public void setPercentMined(int i) {percentMined = i;}
	
    public Patch[][] getGrid() {return grid;}
    public ArrayList<Patch> getMineLocations() {return mineLocations;}
}
