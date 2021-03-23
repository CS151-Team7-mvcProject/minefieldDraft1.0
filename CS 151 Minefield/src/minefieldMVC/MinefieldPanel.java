package minefieldMVC;

import mvc.AppFactory;
import mvc.AppPanel;

import javax.swing.*;
import java.io.Serializable;

public class MinefieldPanel extends AppPanel implements Serializable {

    private static final long serialVersionUID = 1L;

    //Define how many buttons you would like on the button panel here.
    private JButton N,
            E,
            W,
            S,
            NE,
            NW,
            SE,
            SW;


    public MinefieldPanel(AppFactory factory) {
        super(factory);

        //Create buttons for the button panel
        N = new JButton("N");
        E = new JButton("E");
        W = new JButton("W");
        S = new JButton("S");
        NE = new JButton("NE");
        NW = new JButton("NW");
        SE = new JButton("SE");
        SW = new JButton("SW");

        //Add action listeners to buttons in the factory.
        N.addActionListener(this);
        E.addActionListener(this);
        W.addActionListener(this);
        S.addActionListener(this);
        NE.addActionListener(this);
        NW.addActionListener(this);
        SE.addActionListener(this);
        SW.addActionListener(this);

        //Add the newly created buttons to the Button Panel.
        controlPanel.add(N);
        controlPanel.add(E);
        controlPanel.add(W);
        controlPanel.add(S);
        controlPanel.add(NE);
        controlPanel.add(NW);
        controlPanel.add(SE);
        controlPanel.add(SW);


    }

    public static void main(String[] args) {
        AppFactory factory = new MinefieldFactory();
        AppPanel panel = new MinefieldPanel(factory);
        panel.display();
    }

}
