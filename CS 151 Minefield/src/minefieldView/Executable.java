package minefieldView;

import mvc.AppFactory;
import mvc.AppPanel;

public class Executable {
    public static void main(String[] args) {
        AppFactory factory = new MinefieldFactory();
        AppPanel panel = new ControllerPanel(factory);
        panel.display();
    }
}
