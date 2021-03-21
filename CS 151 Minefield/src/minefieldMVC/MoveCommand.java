package minefieldMVC;

import mvc.Command;
import mvc.Model;

import java.io.Serializable;

public class MoveCommand extends Command implements Serializable {

    String heading;

    public MoveCommand(Model model, String heading) {
        super(model);
        this.heading = heading;
    }

    public void execute() throws Exception {
        Minefield m = (Minefield) model;
        switch (heading) {
            case "N": {
                m.n();
                break;
            }
            case "E": {
                m.e();
                break;
            }
            case "W": {
                m.w();
                break;
            }
            case "S": {
                m.s();
                break;
            }
            case "NE": {
                m.ne();
                break;
            }
            case "NW": {
                m.nw();
                break;
            }
            case "SE": {
                m.se();
                break;
            }
            case "SW": {
                m.sw();
                break;
            }
        }
    }
}
