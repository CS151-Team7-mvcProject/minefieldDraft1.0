package minefield;

import mvc.*;

import java.beans.PropertyChangeEvent;

import javax.swing.*;

public class MinefieldPanel extends AppPanel {
	//Panel is the Controller: executes user commands by updating the model
	private static final long serialVersionUID = 1L;
	
    Minefield m = (Minefield) model;
    
	//Define how many buttons you would like on the button panel here.
    private JButton N,
    				E,
    				W,
    				S,
    				B,
    				NE,
    				NW,
    				SE,
    				SW;

    public MinefieldPanel(AppFactory factory) {
        super(factory);
        //Create buttons for the button panel
        NW = new JButton("NW");
        N  = new JButton("N");
        NE = new JButton("NE");
        
        W  = new JButton("W");
        B  = new JButton("0 | 0");
        E  = new JButton("E");
        
        SW = new JButton("SW");
        S  = new JButton("S");
        SE = new JButton("SE");
        
        //Add action listeners to buttons in the factory.
        N.addActionListener(this);
        E.addActionListener(this);
        W.addActionListener(this);
        S.addActionListener(this);
        B.addActionListener(this);
        NE.addActionListener(this);
        NW.addActionListener(this);
        SE.addActionListener(this);
        SW.addActionListener(this);
        
        //Add the newly created buttons to the Button Panel.
        buttonPanel.add(NW);
        buttonPanel.add(N);
        buttonPanel.add(NE);
        
        buttonPanel.add(W);
        buttonPanel.add(B);
        buttonPanel.add(E);
        
        buttonPanel.add(SW);
        buttonPanel.add(S);
        buttonPanel.add(SE);
    }
    
    public void propertyChange(PropertyChangeEvent evt) {
        super.propertyChange(evt);
        m.change();
    }
    
    public void setB(int x, int y) {
    	B.setText(x + " | " + y);
    }

    public static void main(String[] args) {
        AppFactory factory = new MinefieldFactory();
        AppPanel panel = new MinefieldPanel(factory);
        panel.display();
    }
}
