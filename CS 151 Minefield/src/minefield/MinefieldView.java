package minefield;

import java.awt.*;
import mvc.*;

public class MinefieldView extends View {	
	private static final long serialVersionUID = 1L;

	Minefield m = (Minefield) model;
	AppFactory factory = new MinefieldFactory();

	public MinefieldView(Minefield m) {super(m);}

    public void paintComponent(Graphics gc) {
    	int ovalSize = 15;
    	int height = factory.getFrameSize(1);
    	int gridSize = m.getGridSize();
    	int gridSections = (height/gridSize)-1;
    	
    	
        super.paintComponent(gc);
        Color oldColor = gc.getColor();
        gc.setColor(Color.BLACK);
        gc.fillOval((int)m.getLocation().getX()*gridSections, 
        			(int)m.getLocation().getY()*gridSections, 
        			ovalSize,ovalSize);
        //System.out.println("Painting Component");
        gc.setColor(oldColor);
    }
}
