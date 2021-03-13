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
	protected View view;
	protected Model model;
	protected JPanel controlPanel;
	protected JPanel buttonPanel;
	protected JPanel boardPanel;
	protected JFrame frame;

	public static int FRAME_WIDTH;
	public static int FRAME_HEIGHT;


	//Creates all of the frames and panels needed to display the application.
	//Gets all custom variables from implementing Factory class.
	public AppPanel(AppFactory factory) {
		this.factory = factory;
		model = factory.makeModel();
		view = factory.makeView(model);

		FRAME_WIDTH = factory.getFrameSize(0);
		FRAME_HEIGHT = factory.getFrameSize(1);

		
		controlPanel = new JPanel();
		buttonPanel  = new JPanel();
		frame 		 = new JFrame();

		//Setup for the JFrame
		frame.setJMenuBar(createMenuBar());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle(factory.getTitle());
		frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		setLayout((new GridLayout(1, 2)));
		add(controlPanel);
		add(view);

		//Setting background color for all panels
		controlPanel.setBackground(factory.getBackgroundColor(0));
		view.setBackground(factory.getBackgroundColor(1));

		//Creates the layout for the button panel.
		GridLayout layout = new GridLayout
				(factory.getButtonGridSize(0),
						factory.getButtonGridSize(1));
		layout.setHgap(factory.getButtonGap(0));
		layout.setVgap(factory.getButtonGap(1));

		//Sets ButtonPanel layout and adds to ControlPanel
		buttonPanel.setLayout(layout);
		buttonPanel.setBackground(controlPanel.getBackground());
		controlPanel.add(buttonPanel);

		//Adds black border around view.
		Border border = BorderFactory.createLineBorder(Color.BLACK);
		view.setBorder(border);
		
		//???
		Container cp = frame.getContentPane();
		cp.add(this);

	}


	//Creates the menu bar for the frame of the application.
	//Gets all subtitle names from implementing Factory class.
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
	//appropriate command object is created.
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
		updateUI();
	}

	protected void handleException(Exception e) {
		Utilities.error(e);
	}
}
