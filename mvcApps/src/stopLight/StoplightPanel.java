package stopLight;

import mvc.*;
import javax.swing.*;

public class StoplightPanel extends AppPanel{
    private JButton change;

    public StoplightPanel(AppFactory factory) {
        super(factory);

        //this.setLayout(new BorderLayout());
        change = new JButton("Change");
        change.addActionListener(this);
        //JPanel butoonPanel = new JPanel();
        //buttonPanel.setLayout(new FlowLayout());
        controlPanel.add(change);
        //add(buttonPanel);
        //add(view);
    }

    public static void main(String[] args) {
        AppFactory factory = new StoplightFactory();
        AppPanel panel = new StoplightPanel(factory);
        panel.display();
    }
}
