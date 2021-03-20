package minefieldModel;

import java.awt.Point;
import java.util.*;

import mvc.*;

public class Player extends Model {
	private static final long serialVersionUID = 1L;
	
	//Instance variables
	private Point location = new Point();
	private ArrayList<Point> locationHistory = new ArrayList<>();
	private boolean living = true;

	//Constructors
	public Player(Point location, boolean living) {
		super();
		this.location = location;
		this.living = living;
	}
	
	public Player() {
		
	}
	
	//Helper methods
	public Point getLocation() {return location;}
	public void setLocation(Point p) {location = p;}

	public boolean getIsLiving() {return living;}
	public void setIsLiving(boolean bool) {living = bool;}

	public ArrayList<Point> getLocationHistory() {return locationHistory;}
	public void addToLocationHistory(Point p) {locationHistory.add(p);} //Strictly necessary?

	public void change() {changed();}

}
