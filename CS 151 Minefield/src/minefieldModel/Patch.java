package minefieldModel;

import java.awt.Point;

public class Patch extends Point{	
	private static final long serialVersionUID = 1L;
	
	private boolean isVisited,
					isActive,
					isDangerous;
	private int     countNeighbors;
	private Point   location;
	
	
	public Patch(int x, int y) {
		setLocation(x, y);
		isVisited = false;
		isActive = false;
		isDangerous = false;
		countNeighbors = 0;
	}

	//Helper methods
	public boolean isVisited() {return isVisited;}
	public void setVisited(boolean isVisited) {this.isVisited = isVisited;}
	
	public boolean isActive() {return isActive;}
	public void setActive(boolean isActive) {this.isActive = isActive;}
	
	public boolean isDangerous() {return isDangerous;}
	public void setIsDangerous(boolean isDangerous) {this.isDangerous = isDangerous;}

	public int getCountNeighbors() {return countNeighbors;}
	public void setCountNeighbors(int countNeighbors) {this.countNeighbors = countNeighbors;}
	
	public Point getLocation() {return location;}
	public void setLocation(Point p) {location = p;}
	
	
}
