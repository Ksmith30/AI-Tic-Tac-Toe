import java.util.*;

public class TicTacToe {


	public static void main(String[] args) {
		int choice = 0;
		while (choice != 1 && choice != 2) {
			System.out.println("What game would you like to play?\n");

			System.out.println("1.) Tic-tac-toe.");
			System.out.println("2) Global Thermal Nuclear War.");
			System.out.print("Choice: ");
			Scanner s = new Scanner(System.in);
			choice = s.nextInt();
		}

		switch (choice) {
			case 1:
				new Game();
				break;
			case 2:
				System.out.println("Sorry, I cannot allow that");
				new Game();
				break;
		}
	}
}