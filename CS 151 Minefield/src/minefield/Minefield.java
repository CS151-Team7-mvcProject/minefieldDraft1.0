package minefield;

import java.awt.Point;
import java.util.*;

import mvc.*;

public class Minefield extends Model {
	private static final long serialVersionUID = 1L;
	
	private Point location = new Point();
	private List<Point> locationHistory = new ArrayList<>();
	private boolean living = true;
	private int gridSize = 20;
	
	public Minefield(Point location, boolean living) {
		super();
		this.location = location;
		this.living = living;
	}
	
	public Minefield() {
		
	}
	
	public int getGridSize() {return gridSize;}
	public Point getLocation() {return location;}
	public boolean getIsLiving() {return living;}
	public List<Point> getLocationHistory() {return locationHistory;}

	public void setLocation(Point p) {location = p;}
	public void setIsLiving(boolean bool) {living = bool;}
	public void addToLocationHistory(Point p) {locationHistory.add(p);}
	public void change() {changed();}

}
