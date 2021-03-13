package minefieldMVC;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.border.Border;

import mvc.*;

public class MinefieldView extends View {
	
	private static final long serialVersionUID = 1L;
	
	MinefieldFactory factory = new MinefieldFactory();
    private JLabel  QuestionMark;
	
	public MinefieldView(Minefield m) {
        super(m);
    }

    public void paintComponent(Graphics gc) {
    	Minefield m = new Minefield();
    	List<Integer> l = new ArrayList<Integer>();
    	GridLayout layout = new GridLayout(20,20);
    	this.setLayout(layout);
    	l = m.getLocationHistory();
        //Creates 20,20 grid of "?" labels for grid and 
        //adds them to the View panel.
        for(int i = 0; i < 400; i++) {
	        QuestionMark = new JLabel("?");
	        QuestionMark.setHorizontalAlignment(0);
	        QuestionMark.setSize(50,50);
	        Border border = BorderFactory.createLineBorder(Color.BLACK);
	        QuestionMark.setBorder(border);
	        if(l.contains(i)) {
	        		Border noBorder = BorderFactory.createEmptyBorder();
	        		QuestionMark.setBorder(noBorder);
	        		
	        		QuestionMark.setText("-");
	        	}
	        if(m.getLocation() == i) {
        		Border whiteBorder = BorderFactory.createLineBorder(Color.WHITE);
        		QuestionMark.setBorder(whiteBorder);
        		QuestionMark.setText(":)");
        	}
	        this.add(QuestionMark);    
        }
    	
    	
        super.paintComponent(gc);
    }
}
