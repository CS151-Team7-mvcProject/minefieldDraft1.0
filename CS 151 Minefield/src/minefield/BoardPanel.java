package minefield;
import javax.swing.*;
import java.awt.*;

public class BoardPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	
	Tile[][] board = new Tile[20][20];

	//will generate mines in the board
	public void generateMines() {
		int count = 0;
		int mineCount = 10;
		while(count < mineCount) { //generates 10 mines

			//generate random location (row,col)
			int row = (int)(Math.random()*board.length);
			int col = (int)(Math.random()*board[0].length);

			//if a generated location is already a mine, generate a new location
			while(board[row][col].isMine) {
				row = (int)(Math.random()*board.length);
				col = (int)(Math.random()*board[0].length);
			}

			board[row][col].isMine = true;     //sets this tile to contain a mine
			count++;
		}
	}

	public void updateCount(int r, int c) {
		//if no mine at location r, c exit
		if(!board[r][c].isMine) return;

		for(int row = r-1; row <= r+1; row++) {
			for(int col = c-1; col <= c+1; col++) {
				try {
					board[row][col].count++;
				} catch(Exception e) {
					//nothing; out of bounds
				}
			}
		}
	}

	//counts the mines per tile
	public void countMines() {
		for (int row = 0; row < board.length; row++) {
			for (int col = 0; col < board[0].length; col++) {
				updateCount(row, col);
			}
		}
	}

	public void displayMines() {
		for (int row = 0; row < board.length; row++) {
			for (int col = 0; col < board[0].length; col++) {

				if(board[row][col].isMine){
					board[row][col].setText("*");
					board[row][col].setBackground(Color.RED);
					board[row][col].setOpaque(true);
				}
				else board[row][col].setText(board[row][col].getCount()+"");
			}
		}
		repaint();
	}


		
	public BoardPanel() {
		//construct JFrame holding the tiles
		JFrame frame = new JFrame("Minesweeper");
		frame.setSize(600,600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//add a layout manager (grid)
		frame.setLayout(new GridLayout(10,10));

		//adding the board (tiles)
		for (int row = 0; row < board.length; row++) {
			for (int col = 0; col < board[0].length; col++) {
				Tile t = new Tile(row, col);
				frame.add(t);           //adds to board
				board[row][col] = t;
			}
		}
		generateMines();
		countMines();
		displayMines();
		frame.setVisible(true);
	}



}