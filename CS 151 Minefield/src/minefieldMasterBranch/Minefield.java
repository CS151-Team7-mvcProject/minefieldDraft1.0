package minefieldMasterBranch;

import java.util.*;

import mvc.*;

public class Minefield extends Model {
	
	private static final long serialVersionUID = 1L;
	
	private int location = 1;
	private List<Integer> locationHistory = new ArrayList<>();
	private boolean living = true;
	
	
	public int getLocation() {
		return location;
	}

	public void setLocation(int i) {
		location = i;
	}

	public boolean getIsLiving() {
		return living;
	}
	public void setIsLiving(boolean bool) {
		living = bool;
	}
	public List<Integer> getLocationHistory() {
		return locationHistory;
	}
	public void addToLocationHistory(int i) {
		locationHistory.add(i);
	}
	
	
	//Defining all movement commands for Sgt. Rock
	public void north() {
		
	}
	public void east() {

	}
	public void west() {
		
	}
	public void south() {
		
	}
	public void northEast() {
		
	}
	public void northWest() {
		
	}
	public void southEast() {
		
	}
	public void southWest() {
		
	}

}
