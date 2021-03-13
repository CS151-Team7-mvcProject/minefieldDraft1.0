package mvc;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.*;

public class Utilities {

	//These methods ask the user for some input.
	public static boolean confirm(String query) {
		//Asks the user a yes/no question.
		int result = JOptionPane.showConfirmDialog(null,
				query, "choose one", JOptionPane.YES_NO_OPTION);
		return result == 1;
	}
	public static String ask(String query) {

		//Asks the user for info.
		return JOptionPane.showInputDialog(null, query);
	}
	public static String getFileName(String fName, Boolean open) {
		//Asks user for a file name.
		JFileChooser chooser = new JFileChooser();
		String result = null;
		if (fName != null) {
			// open chooser in directory of fName
			chooser.setCurrentDirectory(new File(fName));
		}
		if (open) {
			int returnVal = chooser.showOpenDialog(null);
			if(returnVal == JFileChooser.APPROVE_OPTION) {
				result= chooser.getSelectedFile().getPath();
			}
		} else {
			int returnVal = chooser.showSaveDialog(null);
			if(returnVal == JFileChooser.APPROVE_OPTION) {
				result= chooser.getSelectedFile().getPath();
			}
		}
		return result;
	}
    public static void saveChanges(Model model) {
        //Asks user to save changes
        if (model.getUnsavedChanges() && Utilities.confirm("current model has unsaved changes, continue?"))
            Utilities.save(model, false);
    }
    
    
    //These methods inform the user of something.
	public static void inform(String info) {
		//Tells the user some info.
		JOptionPane.showMessageDialog(null,info);
	}
	public static void inform(String[] items) {
		//Tells the user a lot of info.
		String helpString = "";
		for(int i = 0; i < items.length; i++) {
			helpString = helpString + "\n" + items[i];
		}
		inform(helpString);
	}
	public static void error(String gripe) {
		//Tells the user about an error
		JOptionPane.showMessageDialog(null,
				gripe,
				"OOPS!",
				JOptionPane.ERROR_MESSAGE);
	}
	public static void error(Exception gripe) {
		//Tells user about an exception
		gripe.printStackTrace();
		JOptionPane.showMessageDialog(null,
				gripe.getMessage(),
				"OOPS!",
				JOptionPane.ERROR_MESSAGE);
	}

	
	//Simple menu maker
	public static JMenu makeMenu(String name, String[] items, ActionListener handler) {
		JMenu result = new JMenu(name);
		for(int i = 0; i < items.length; i++) {
			JMenuItem item = new JMenuItem(items[i]);
			item.addActionListener(handler);
			result.add(item);
		}
		return result;
	}


    //Open model
    public static Model open(Model model) {
        saveChanges(model);
        String fName = getFileName(model.getFileName(), true);
        Model newModel = null;
        try {
            ObjectInputStream is = new ObjectInputStream(new FileInputStream(fName));
            newModel = (Model)is.readObject();
            is.close();
        } catch (Exception err) {
            Utilities.error(err);
        }
        return newModel;
    }
    //Save model.
    public static void save(Model model, Boolean saveAs) {
        String fName = model.getFileName();
        if (fName == null || saveAs) {
            fName = getFileName(fName, false);
            model.setFileName(fName);
        }
        try {
            ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(fName));
            model.setUnsavedChanges(false);
            os.writeObject(model);
            os.close();
        } catch (Exception err) {
            model.setUnsavedChanges(true);
            Utilities.error(err);
        }
    }
    //Quit the application
    public static void quit(Model model) {
		Utilities.saveChanges(model);
		System.exit(1); 
    }


    //Random number generator
    public static Random rng = new Random(System.currentTimeMillis());
	
	
}

