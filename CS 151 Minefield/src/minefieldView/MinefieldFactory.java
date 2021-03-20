package minefieldView;

import java.awt.Color;

import minefieldModel.Player;
import minefieldModel.MoveCommand;
import mvc.*;

public class MinefieldFactory implements AppFactory {
	public Model makeModel() {
		return new Player();
	}
	public View makeView(Model m) {
		return new MinefieldView((Player) m);
	}

	//************************************************************************
	//Settings for the application's frame
	//************************************************************************
	public int    getFrameSize(int i)       {
		//Set size of the frame here
		//**************************
		int width = 900;
		int height = 450;
		//**************************
		int[] arr = {width,height};
		return arr[i];
	}
	public Color  getBackgroundColor(int i) {
		//Set background color of panels here.
		//Acceptable colors are: PINK, ORANGE, RED
		//GREEN, BLUE, YELLOW, MAGNETA, CYAN, GREY
		//WHITE, BLACK, LIGHT_GRAY, and DARK_GRAY.
		//**************************
		Color viewPanel 	= Color.GRAY;
		Color controlPanel  = Color.DARK_GRAY;
		//**************************
		Color[] arr = {controlPanel,viewPanel};
		return arr[i];
	}
	public String getTitle() 				{
		//Set the frame Title here
		//**************************
		return "Minefield 1.0";
		//**************************
	}
		
	//************************************************************************
	//Set the name of the buttons in the File, Edit and Help menu bar buttons.
	//************************************************************************
	public String[] getFileTitles() {
		//Declare all values you want to show in the "File" menu
		//*************************************************************
		return new String[] {"New", "Save", "Save As", "Open", "Quit"};
		//*************************************************************
	}
	public String[] getEditTitles() {
		//Declare all values you want to show in the "Edit" menu
		//********************************************************
		return new String[] {"N","E","W","S","NE","NW","SE","SW"};
		//********************************************************
	}
	public String[] getHelpTitles() {
		//Declare all values you want to show in the "Help" menu
		//************************************
		return new String[] {"Help", "About"};
		//************************************
	}
	
	//************************************************************************
	//Change game settings (grid size/mine percent)
	//************************************************************************
	
	
	//************************************************************************
	//Set the intended interaction for buttons defined above.
	//************************************************************************
	public Command makeNewCommand(Model model, String cmmd) {
		//Declare interaction for all values outside of predefined methods.
		//Create a new "____"Command class to pass the command to for execution.
		
		switch(cmmd) {
		case "N":{
			return new MoveCommand(model, "N");
		}
		case "E":{
			return new MoveCommand(model, "E");
		}
		case "W":{
			return new MoveCommand(model, "W");
		}
		case "S":{
			return new MoveCommand(model, "S");
		}
		case "NE":{
			return new MoveCommand(model, "NE");
		}
		case "NW":{
			return new MoveCommand(model, "NW");
		}
		case "SE":{
			return new MoveCommand(model, "SE");
		}
		case "SW":{
			return new MoveCommand(model, "SW");
		}
//		case "Some new case":{
//		}
		}
		return null;
	}
	
	//************************************************************************
	//Set the Help and About messages below.
	//************************************************************************
	public String[] getHelp()  {
		return new String[]{
			//*******************************************************************	
			"You are a minesweeper starting at the top left square, \n" +
				"your goal is to make it to the bottom right square, while \n" + 
				"avoding mines on the field. \n \n" +
	
			"You can move around the field in the 8 cardinal and \n" +
				"intermediate directions. Each press of a button will move \n" +
				"you only one square at a time \n \n" +
	
			"The number displayed in each tile indicates the number of \n" + 
				"mines in each adjacent tile. If you move onto a tile with \n" +
				"a mine the game is over. \n \n" +
	
			"Note: You cannot move off of the grid or wrap around the field."};
			//*******************************************************************
	}
	public String   getAbout() {
		//***************************************************************
		return "Minefield version 1.0. Copyright 2021 by SGSZRP Designs";
		//***************************************************************
	}

}
