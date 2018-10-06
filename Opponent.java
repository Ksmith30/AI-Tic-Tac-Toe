import java.util.*;

public class Opponent {

	private ArrayList<State> getChildStates(State parentState, String player) {
		ArrayList<State> childStates = new ArrayList<State>();
		String[][] board = parentState.getBoard();
		for (int i = 0; i < board.length; ++i) {
			for (int j = 0; j < board[i].length; ++j) {
				board = parentState.getBoard();
				if (board[i][j] != "X" || board[i][j] != "O") {
					board[i][j] = player;
					State childState = new State(board);
					childStates.add(childState);
					childState.setParentState(parentState);
				}
			}
		}
		return childStates;
	}

	private int miniMax(State parentState, boolean maximizingPlayer) {
		if (parentState.getChildStates().isEmpty()) {
			return parentState.getCost();
		} 
		if (maximizingPlayer) {
			int max = -1000000;
			ArrayList<State> childStates = getChildStates(parentState, "O");
			for (int i = 0; i < childStates.size(); ++i) {
				max = Math.max(max, miniMax(childStates.get(i), false));
			}
			return max;
		} else {
			int min = 10000000;
			ArrayList<State> childStates = getChildStates(parentState, "X");
			for (int i = 0; i < childStates.size(); ++i) {
				min = Math.min(min, miniMax(childStates.get(i), true));
			}
			return min;
		}
	}

	public void makeMove(String[][] board) {
		State currentState = new State(board);
		miniMax(currentState, true);
	}
}