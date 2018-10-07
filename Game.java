import java.util.*;

public class Game {

	private String[][] board = 
	{		{"1", "2", "3"},
			{"4", "5", "6",},
			{"7", "8", "9"}};

	public Game() {
		System.out.println("Let's play Tic-tac-toe. You start. \n");
		startGame();
	}

	private boolean rowWinCheck() {
		 for (int i = 0; i < board.length; ++i) {
	 		if (board[i][0] == board[i][1] && board[i][1] == board[i][2]) {
	 			return true;
	 		}
		 }
		 return false; 
	}

	private boolean columnWinCheck() {
		for (int i = 0; i < board.length; ++i) {
			if (board[0][i] == board[1][i] && board[1][i] == board[2][i]) {
				return true;
			}
		}
		return false;
	}

	private boolean diagonalWinCheck() {
		return (board[0][0] == board[1][1] && board[0][0] == board[2][2]) || (board[0][2] == board[1][1] && board[0][2] == board[2][0]);
	}

	private boolean didWin() {
		return rowWinCheck() || columnWinCheck() || diagonalWinCheck();
	}

	private boolean didTie() {
		for (int i = 0; i < board.length; ++i) {
			for (int j = 0; j < board[i].length; ++j) {
				if (board[i][j] != "X" && board[i][j] != "O") {
					return false;
				}
			}
		}
		return true;
	}

	private boolean inRange(int choice) {
		return choice > 0 && choice < 10 && board[(choice - 1) / 3][(choice - 1) % 3] != "O" && board[(choice - 1) / 3][(choice - 1) % 3] != "X";
	}

	private void printBoard() {
		for (int i = 0; i < board.length; ++i) {
			for (int j = 0; j < board[i].length; ++j) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

	private void initializeBoard() {
		board = new String[3][3];
		int number = 1;
		for (int i = 0; i < board.length; ++i) {
			for (int j = 0; j < board[i].length; ++j) {
				board[i][j] = Integer.toString(number);
				number++;
			}
		}
	}

	private void startGame() {
		Opponent opponent = new Opponent();
		Scanner s = new Scanner(System.in);
		printBoard();
		while (true) {
			if (didWin()) {
				System.out.println("O wins! You are incompetent!");
				break;
			}
			if (didTie()) {
				System.out.println("It's a tie!");
				break;
			}
			int choice = 0;
			while (!inRange(choice)) {
				System.out.print("Your Move: ");
				choice = s.nextInt();
			} 
			board[(choice - 1) / 3][(choice - 1) % 3] = "X";
			printBoard();
			System.out.println();
			if (didWin()) {
				System.out.println("X wins! Your AI is stupid.");
				break;
			}
			if (didTie()) {
				System.out.println("It's a tie!");
				break;
			}
			State bestState = opponent.makeMove(board);
			board = bestState.getBoard();
			printBoard();
			System.out.println();
		}
		System.out.println("Game Over!");
	}
}