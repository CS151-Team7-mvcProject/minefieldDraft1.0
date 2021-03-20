package minefieldModel;

import java.awt.Point;
import java.util.*;

import mvc.*;

public class Player extends Model {
	private static final long serialVersionUID = 1L;
	
	//Instance variables
	private Point location;
	private ArrayList<Point> locationHistory = new ArrayList<>();
	private boolean living = true;
	private boolean won = false;
	
	//Constructors
	public Player() {
		super();
		location = new Point();
		location.setLocation(0, 0);
	}

	
	//Checks to see if the player has either died, or won the game.
	public void checkStatus() {
		Grid g = new Grid();
		ArrayList<Patch> mineLocations = g.getMineLocations();
		
		//TODO - Not working correctly, need to override contains?
		if(mineLocations.contains(this.getLocation())) {
			this.setIsLiving(false);
			Utilities.inform("You've died :(");
		}
		else if(this.getLocation().getX() == g.getGridSize() &&
				this.getLocation().getY() == g.getGridSize()) {
			this.setWon(true);
			Utilities.inform("You've won!");
			System.exit(0);
		}
		else {
			
		}
	}

	//Helper methods
	public Point getLocation() {return location;}
	public void setLocation(Point p) {location = p;}

	public boolean getWon() {return won;}
	public void setWon(boolean b) {won = b;}
	
	public boolean getIsLiving() {return living;}
	public void setIsLiving(boolean bool) {living = bool;}

	public ArrayList<Point> getLocationHistory() {return locationHistory;}
	public void addToLocationHistory(Point p) {locationHistory.add(p);} //Strictly necessary?

	public void change() {changed();}

}
