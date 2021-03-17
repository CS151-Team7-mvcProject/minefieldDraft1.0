package Minefield;

import mvc.Command;
import mvc.Model;

public class MoveCommand extends Command {

    String heading;

    public MoveCommand(Model model, String heading) {
        super(model);
        this.heading = heading;
    }

    public void execute() throws Exception {
        Minefield minefield = (Minefield) model;
        // Call methods in minefield to do work
        if (heading.equals("NW")) {
            minefield.nw();
        }
        if (heading.equals("N")) {
            minefield.n();
        }
        if (heading.equals("NE")) {
            minefield.ne();
        }
        if (heading.equals("W")) {
            minefield.w();
        }
        if (heading.equals("E")) {
            minefield.e();
        }
        if (heading.equals("SW")) {
            minefield.sw();
        }
        if (heading.equals("S")) {
            minefield.s();
        }
        if (heading.equals("SE")) {
            minefield.se();
        }
    }
}
