package minefieldView;

import java.awt.*;

import minefieldModel.*;
import mvc.*;

public class MinefieldView extends View {	
	private static final long serialVersionUID = 1L;

	Grid g;
	
	public MinefieldView(Player m) {
		super(m);
		g = new Grid();
	}

    public void paintComponent(Graphics gc) {	
    	super.paintComponent(gc);
    	
    	Player m = (Player) model;
    	AppFactory factory = new MinefieldFactory();
    	Color oldColor = gc.getColor();

    	int ovalSize = 15;
    	int height = factory.getFrameSize(1);
    	int gridSize = g.getGridSize();
    	int gridSections = (height/gridSize)-1;
    	
        gc.setColor(Color.BLACK);
        gc.fillOval((int)m.getLocation().getX()*gridSections, 
        			(int)m.getLocation().getY()*gridSections, 
        			ovalSize,ovalSize);
        //System.out.println("Painting Component");
        gc.setColor(oldColor);
    }
}
