class State {
	
	private String[][] board;
	private int cost;

	State(String[][] board) {
		this.board = new String[board.length][board.length];
		for (int i = 0; i < board.length; ++i) {
			for (int j = 0; j < board[i].length; ++j) {
				this.board[i][j] = board[i][j];
			}
		}

		if (didWin()) {
			this.cost = 1;
		} else if (didLose()) {
			this.cost = -1;
		} else {
			this.cost = 0;
		}
	}

	private boolean rowWinCheck(String character) {
		for (int i = 0; i < board.length; ++i) {
	 		if (board[i][0] == character && board[i][1] == character && board[i][2] == character) {
	 			return true;
	 		}
		 }
		 return false; 
	}

	private boolean columnWinCheck(String character) {
		for (int i = 0; i < board.length; ++i) {
			if (board[0][i] == character && board[1][i] == character && board[2][i] == character) {
				return true;
			}
		}
		return false;
	}

	private boolean diagonalWinCheck(String character) {
		return (board[0][0] == character && board[1][1] == character && board[2][2] == character) || (board[0][2] == character && board[1][1] == character && board[2][0] == character);
	}

	private boolean didWin() {
		return rowWinCheck("O") || columnWinCheck("O") || diagonalWinCheck("O");
	}

	private boolean didLose() {
		return rowWinCheck("X") || columnWinCheck("X") || diagonalWinCheck("X");
	}

	String[][] getBoard() {
		return this.board;
	}

	int getCost() {
		return this.cost;
	}

	void setCost(int cost) {
		this.cost = cost;
	}
}