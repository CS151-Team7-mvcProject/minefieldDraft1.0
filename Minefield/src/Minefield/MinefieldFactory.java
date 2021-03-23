package Minefield;

import mvc.AppFactory;
import mvc.Command;
import mvc.Model;
import mvc.View;

public class MinefieldFactory implements AppFactory {
    public Model makeModel() {
        return new Minefield();
    }

    public View makeView(Model model) {
        return new MinefieldView((Minefield) model);
    }

    public String getTitle() {
        return "Minefield";
    }

    public String[] getHelp() {
        return new String[0];
    }

    public String about() {
        return null;
    }

    public String[] getEditCommands() {
        return new String[]{"NW", "N", "NE", "W", "E", "SW", "S", "SE"};
    }

    public Command makeEditCommand(Model model, String type) {
        if (type == "NW") {
            return new MoveCommand(model, type);
        } else if (type == "N") {
            return new MoveCommand(model, type);
        } else if (type == "NE") {
            return new MoveCommand(model, type);
        } else if (type == "W") {
            return new MoveCommand(model, type);
        } else if (type == "E") {
            return new MoveCommand(model, type);
        } else if (type == "SW") {
            return new MoveCommand(model, type);
        } else if (type == "S") {
            return new MoveCommand(model, type);
        } else if (type == "SE") {
            return new MoveCommand(model, type);
        } else {
            return null;
        }
    }
}
