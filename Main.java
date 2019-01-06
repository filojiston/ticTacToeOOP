package seid.tictactoe;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		Game game = new Game();
		boolean playAgain = false;
		
		
		do {
			game.newGame();
			game.play();
			
			System.out.println();
			char response;
			do {
				System.out.print("Do you wanna play again (y/n): ");
				response = sc.nextLine().toLowerCase().charAt(0);
			} while (response != 'y' && response != 'n');
			
			if (response == 'y') {
				System.out.println("\n");
				playAgain = true;
			} else
				playAgain = false;

		} while (playAgain);
		
		sc.close();
	}
}
