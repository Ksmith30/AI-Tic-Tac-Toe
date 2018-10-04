import java.util.*;

public class Game {

	private String[][] board;
	private 

	private void initializeBoard() {
		board = new String[5][11];
		int number = 1;
		for (int i = 0; i < 5; ++i) {
			for (int j = 0; j < 11; ++j) {
				if ((i % 2 == 0) && (j == 1 || j == 5 || j == 9)) {
					board[i][j] = Integer.toString(number);
					number++;
				} else if ((i % 2 == 0) && (j == 3 || j == 7)) {
					board[i][j] = "|";
				} else if ((i % 2 == 1) && (j == 3 || j == 7)) {
					board[i][j] = "+";
				} else if ((i % 2 == 1)) {
					board[i][j] = "-";
				} else {
					board[i][j] = " ";
				}
			}
		}
	}

	private void printBoard() {
		for (int i = 0; i < board.length; ++i) {
			for (int j = 0; j < board[i].length; ++j) {
				System.out.print(board[i][j]);
			}
			System.out.println();
		}
	}

	private boolean win() {
		return false;
	} 

	public Game() {
		System.out.println("Let's play Tic-tac-toe. You start. \n");
		initializeBoard();
		printBoard();

		while (!win()) {

		}
	}
}