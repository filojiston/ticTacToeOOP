package seid.tictactoe;

import java.awt.Point;
import java.util.Scanner;

public class Game {
	
	private enum GameStatus {
		WIN , TIE, PLAYING
	}
	
	private Board board;
	private Player p1;
	private Player p2;
	private Player currentPlayer;
	
	private Scanner sc = new Scanner(System.in);
	
	public Game() {
		board = new Board();
		p1 = new Player();
		p2 = new Player();
	}
	
	public void newGame() {
		board.clearBoard();
		
		p1.setPlayerName(getPlayerName());
		p1.setPlayerSymbol(getPlayerSymbol());
		
		p2.setPlayerName(getPlayerName());
		if (p1.getPlayerSymbol() == 'X')
			p2.setPlayerSymbol('O');
		else
			p2.setPlayerSymbol('X');
		
		currentPlayer = decideStarter();
	}
	
	public void play() {
		GameStatus status = GameStatus.PLAYING;
		while (status == GameStatus.PLAYING) {
			board.printBoard();
			
			Point move = currentPlayer.makeMove();
			while (!isValidMove(move)) {
				System.out.println("\nYour move was invalid. Please try again: ");
				move = currentPlayer.makeMove();
			}
			
			board.doMove(currentPlayer, move);
			
			status = checkGameStatus();
			
			switch (status) {
			case WIN:
				board.printBoard();
				System.out.println("Congratulations, " + currentPlayer.getPlayerName() + "! You won the game!");
				break;
			case TIE:
				board.printBoard();
				System.out.println("There is no winner but friendship, everybody! Game is tie.");
				break;
			default:
				break;
			}
			
			changePlayers();
		}
	}
	
	private void changePlayers() {
		if (currentPlayer == p1) {
			currentPlayer = p2;
		} else {
			currentPlayer = p1;
		}
	}
	
	private boolean isValidMove(Point move) {
		int x = move.x;
		int y = move.y;
		
		if (x < 0 || x > 2 || y < 0 || y > 2)
			return false;
		
		if (board.getBoard()[x][y] == ' ') {
			return true;
		} else
			return false;
	}
	
	private GameStatus checkGameStatus() {
		if (board.isWin())
			return GameStatus.WIN;
		else if (board.isTie())
			return GameStatus.TIE;
		else
			return GameStatus.PLAYING;
	}
	
	private Player decideStarter() {
		if (p1.getPlayerSymbol() == 'X')
			return p1;
		else
			return p2;
	}
	
	private String getPlayerName() {
		System.out.print("Enter your name: ");
		return sc.nextLine();
	}
	
	private char getPlayerSymbol() {
		char choice;
		do {
			System.out.print("X or O: ");
			choice = sc.nextLine().toUpperCase().charAt(0);
		} while (choice != 'X' && choice != 'O');
			
		System.out.println();
			
		return choice;
	}
}
