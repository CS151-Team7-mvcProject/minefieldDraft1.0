package minefieldView;


import java.awt.GridLayout;
import java.beans.PropertyChangeEvent;

import javax.swing.*;

import minefieldModel.Player;
import mvc.*;

public class ControllerPanel extends AppPanel{
	private static final long serialVersionUID = 1L;
	

	private JButton N,
					E,
					W,
					S,
					NE,
					NW,
					SE,
					SW;

	private JLabel B;	
	
	public ControllerPanel(AppFactory f) {
		super(f);
		Player m = (Player) model;
		m.addPropertyChangeListener(this);
		controlPanel.setLayout(new GridLayout(1,1));
		
		//Create buttons for the button panel
		NW = new JButton("NW");
		N  = new JButton("N");
		NE = new JButton("NE");
		W  = new JButton("W");
		B  = new JLabel(" ");
		E  = new JButton("E");
		SW = new JButton("SW");
		S  = new JButton("S");
		SE = new JButton("SE");

		//Add action listeners to buttons in the factory.
		N.addActionListener(this);
		E.addActionListener(this);
		W.addActionListener(this);
		S.addActionListener(this);
		NE.addActionListener(this);
		NW.addActionListener(this);
		SE.addActionListener(this);
		SW.addActionListener(this);
		
		//Creates the JPanel and applies layout.
		JPanel bp = new JPanel();
		GridLayout bplayout = new GridLayout(3,3);
		bplayout.setHgap(65);
		bplayout.setVgap(65);
		bp.setLayout(bplayout);
		bp.setBackground(f.getBackgroundColor(0));

		//Add the newly created buttons to the Button Panel.
		bp.add(NW);
		bp.add(N);
		bp.add(NE);
		bp.add(W);
		bp.add(B);
		bp.add(E);
		bp.add(SW);
		bp.add(S);
		bp.add(SE);
		
		controlPanel.add(bp);
	}
	
	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		super.propertyChange(evt);
	}
	
}
