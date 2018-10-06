import java.util.*;

public class Board {

 	private String[][] board;

 	public Board() {
 		board = new String[3][3];
		int number = 1;
		for (int i = 0; i < board.length; ++i) {
			for (int j = 0; j < board[i].length; ++j) {
				board[i][j] = Integer.toString(number);
				number++;
			}
		}
 	}

	public void print() {
		for (int i = 0; i < board.length; ++i) {
			for (int j = 0; j < board[i].length; ++j) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

	public String[][] getBoard() {
		return this.board;
	}
}