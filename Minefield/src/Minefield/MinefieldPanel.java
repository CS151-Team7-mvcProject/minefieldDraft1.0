package Minefield;

import mvc.AppFactory;
import mvc.AppPanel;

import javax.swing.*;

// Controller: executes user commands by updating the model
public class MinefieldPanel extends AppPanel {

    private JButton NW;
    private JButton N;
    private JButton NE;
    private JButton W;
    private JButton E;
    private JButton SW;
    private JButton S;
    private JButton SE;

    public MinefieldPanel(AppFactory factory) {
        super(factory);

        // NW Button
        NW = new JButton("NW");
        NW.addActionListener(this);
        controlPanel.add(NW);

        // N Button
        N = new JButton("N");
        N.addActionListener(this);
        controlPanel.add(N);

        // NE Button
        NE = new JButton("NE");
        NE.addActionListener(this);
        controlPanel.add(NE);

        // W Button
        W = new JButton("W");
        W.addActionListener(this);
        controlPanel.add(W);

        // E Button
        E = new JButton("E");
        E.addActionListener(this);
        controlPanel.add(E);

        // SW Button
        SW = new JButton("SW");
        SW.addActionListener(this);
        controlPanel.add(SW);

        // S
        S = new JButton("S");
        NW.addActionListener(this);
        controlPanel.add(S);

        //SE
        SE = new JButton("SE");
        SE.addActionListener(this);
        controlPanel.add(SE);
    }

    public static void main(String[] args) {
        AppFactory factory = new MinefieldFactory();
        AppPanel panel = new MinefieldPanel(factory);
        panel.display();
    }
}
