/*
 * Note: All custom variables come from implementing factory
 * class. No custom variable should need to be changed in this
 * class. All additional panels can be added through the creation
 * of new custom panel classes.
 */
package mvc;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class AppPanel extends JPanel implements PropertyChangeListener, ActionListener {
	
	private static final long serialVersionUID = 1L;

	protected AppFactory factory;
	protected JPanel controlPanel;
	protected View view;
	protected Model model;
	protected JFrame frame;

	public static int FRAME_WIDTH;
	public static int FRAME_HEIGHT;
	
	
	//Creates JFrame, JPanel, and Menu Bar for Application Panel
	public AppPanel(AppFactory factory) {
		this.factory = factory;
		model = factory.makeModel();
		view = factory.makeView(model);

		FRAME_WIDTH = factory.getFrameSize(0);
		FRAME_HEIGHT = factory.getFrameSize(1);

		
		controlPanel = new JPanel();
		frame 		 = new JFrame();

		//Setup for the JFrame
		frame.setJMenuBar(createMenuBar());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle(factory.getTitle());
		frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		setLayout((new GridLayout(1, 2)));
		add(controlPanel);
		controlPanel.setBackground(factory.getBackgroundColor(0));
		add(view);
		view.setBackground(factory.getBackgroundColor(1));

		//Adds black border around view.
		Border border = BorderFactory.createLineBorder(Color.BLACK);
		view.setBorder(border);
		
		//???
		Container cp = frame.getContentPane();
		cp.add(this);

	}

	//Creates the menu bar for the frame of the application.
	protected JMenuBar createMenuBar() {
		JMenuBar result = new JMenuBar();

		//ADD FILE MENU AND SUBMENUS
		JMenu fileMenu = Utilities.makeMenu("File", factory.getFileTitles(), this);
		result.add(fileMenu);

		//ADD EDIT MENU AND SUBMENUS
		JMenu editMenu = Utilities.makeMenu("Edit", factory.getEditTitles(), this);
		result.add(editMenu);

		//ADD HELP MENU AND SUBMENUS
		JMenu helpMenu = Utilities.makeMenu("Help", factory.getHelpTitles(), this);
		result.add(helpMenu);

		//ADD USER DEFINED MENU AND SUBMENUS???
		//
		//
		//

		return result;
	}

	//Defines the action performed based on the user input.
	//If input is not one of the basic utility commands, an
	//appropriate command object is created, created from
	//implementing factory class.
	public void actionPerformed(ActionEvent e) {
		try {
			String cmmd = e.getActionCommand();

			//SAVE
			if 		(cmmd == "Save") 	{Utilities.save(model, false);}

			//SAVEAS
			else if (cmmd == "SaveAs")  {Utilities.save(model, true);} 

			//OPEN
			else if (cmmd == "Open")    {Utilities.open(model);}

			//QUIT
			else if (cmmd == "Quit")  {Utilities.quit(model);}

			//ABOUT
			else if (cmmd == "About") {Utilities.inform(factory.getAbout());} 

			//HELP
			else if (cmmd == "Help")  {Utilities.inform(factory.getHelp());} 

			//NEW
			else if (cmmd == "New") {
				model = factory.makeModel();
				view.update(model);
			}

			//MAKE NEW COMMAND
			else {
				Command command = factory.makeNewCommand(model, cmmd);
				command.execute();
			}
		} 
		catch (Exception err) {
			handleException(err);
		}
	}

	public void display() {
		frame.setVisible(true);
	}

	public void propertyChange(PropertyChangeEvent evt) {
		
	}

	protected void handleException(Exception e) {
		Utilities.error(e);
	}
}