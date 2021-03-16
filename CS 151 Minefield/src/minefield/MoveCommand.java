package minefield;

import java.awt.Point;

import mvc.*;

public class MoveCommand extends Command {

	String heading;
	Minefield m = (Minefield) model;
	Point p;
	int x;
	int y;
	
	public MoveCommand(Model model, String heading) {
		super(model);
		this.heading = heading;
	}
	
	public void set() {
		p.setLocation(x,y);
		m.addToLocationHistory(p);
		m.setLocation(p);
		m.change();
		System.out.println("Location is:" + m.getLocation().getX() + " " + m.getLocation().getY());
	}

	public void execute() {
		String beyond = "Cannot move beyond limits of grid";
		p = m.getLocation();
		x = (int) p.getX();
		y = (int) p.getY();
		
		
		switch(heading) {
			case "W":{
				if(p.getX()-1 == -1) {
					Utilities.inform(beyond);
					break;
				}
				x -= 1;
				set();
				break;
			}
			case "S":{
				if(p.getY()+1 == m.getGridSize()+1) {
					Utilities.inform(beyond);
					break;
				}
				y += 1;
				set();
				break;
			}
			case "N":{
				if(p.getY()-1 == -1) {
					Utilities.inform(beyond);
					break;
				}
				y -= 1;
				set();
				break;
			}
			case "E":{
				if(p.getX()+1 == m.getGridSize()+1) {
					Utilities.inform(beyond);
					break;
				}
				x += 1;
				set();
				break;
			}
			case "SW":{
				if(p.getX()-1 == -1 || p.getY()+1 == m.getGridSize()+1) {
					Utilities.inform(beyond);
					break;
				}
				x -= 1;
				y += 1;
				set();
				break;
			}
			case "NW":{
				if(p.getX()-1 == -1 || p.getY()-1 == -1) {
					Utilities.inform(beyond);
					break;
				}
				x -= 1;
				y -= 1;
				set();
				break;
			}
			case "SE":{
				if(p.getX()+1 == m.getGridSize()+1 || p.getY()+1 == m.getGridSize()+1) {
					Utilities.inform(beyond);
					break;
				}
				x += 1;
				y += 1;
				set();
				break;
			}
			case "NE":{
				if(p.getX()+1 == m.getGridSize()+1 || p.getY()-1 == -1) {
					Utilities.inform(beyond);
					break;
				}
				x += 1;
				y -= 1;
				set();
				break;
			}
		
		}
	}
}
