package minefield;

import mvc.*;

public class MoveCommand extends Command {

	String heading;

	public MoveCommand(Model model, String heading) {
		super(model);
		this.heading = heading;
	}

	public void execute() {
		Minefield m = (Minefield) model;

		switch(heading) {
			case "N":{
				m.north();
				break;
			}
			case "E":{
				m.east();
				break;
			}
			case "W":{
				m.west();
				break;
			}
			case "S":{
				m.south();
				break;
			}
			case "NE":{
				m.northEast();
				break;
			}
			case "NW":{
				m.northWest();
				break;
			}
			case "SE":{
				m.southEast();
				break;
			}
			case "SW":{
				m.southWest();
				break;
			}
		
		}
	}
}
