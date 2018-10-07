import java.util.*;

class Opponent {

	private ArrayList<State> possibleMoves;
	private int initialDepth;

	private ArrayList<State> getChildStates(State parentState, String player) {
		ArrayList<State> childStates = new ArrayList<State>();
		String[][] initialBoard = parentState.getBoard();
		for (int i = 0; i < initialBoard.length; ++i) {
			for (int j = 0; j < initialBoard[i].length; ++j) {
				if (initialBoard[i][j] != "X" && initialBoard[i][j] != "O") {
					String[][] board = deepCopy(initialBoard);
					board[i][j] = player;
					State childState = new State(board);
					childStates.add(childState);
				}
			}
		}
		return childStates;
	}

	private String[][] deepCopy(String[][] array) {
		String[][] newArray = new String[array.length][array.length];
		for (int i = 0; i < array.length; ++i) {
			for (int j = 0; j < array[i].length; ++j) {
				newArray[i][j] = array[i][j];
			}
		}
		return newArray;
	}

	private int getDepth(String[][] board) {
		int depth = 0;
		for (int i = 0; i < board.length; ++i) {
			for (int j = 0; j < board[i].length; ++j) {
				if (board[i][j] != "X" && board[i][j] != "O") {
					depth++;
				}
			}
		}
		return depth;
	}

	private int miniMax(State parentState, int depth, boolean maximizingPlayer) {
		if (depth == 0 || parentState.getCost() != 0) {
			if (depth == initialDepth - 1) {
				possibleMoves.add(parentState);
			}
			return parentState.getCost();
		}
		if (maximizingPlayer) {
			int bestValue = -1000000;
			ArrayList<State> childStates = getChildStates(parentState, "O");
			for (State childState : childStates) {
				int childValue = miniMax(childState, depth - 1, false);
				if (childValue > bestValue) {
					bestValue = childValue;
					parentState.setCost(bestValue);
				}
			}
			return bestValue;
		} else {
			int bestValue = 10000000;
			ArrayList<State> childStates = getChildStates(parentState, "X");
			for (State childState : childStates) {
				int childValue = miniMax(childState, depth - 1, true);
				if (childValue < bestValue) {
					bestValue = childValue;
					parentState.setCost(bestValue);
				}
			}
			if (depth == initialDepth - 1) {
				possibleMoves.add(parentState);
			}
			return bestValue;
		}
	}

	private State getBestMove(String[][] board) {
		int maxCost = -10000;
		State bestMove = new State(board);
		for (int i = 0; i < possibleMoves.size(); ++i) {
			if (possibleMoves.get(i).getCost() > maxCost) {
				maxCost = possibleMoves.get(i).getCost();
				bestMove = possibleMoves.get(i);
			}
		}
		return bestMove;
	}

	State makeMove(String[][] board) {
		possibleMoves = new ArrayList<State>();
		State currentState = new State(board);
		initialDepth = getDepth(board);
		miniMax(currentState, initialDepth, true);
		State bestState = getBestMove(board);
		return bestState;
	}
}