package seid.tictactoe;

import java.awt.Point;
import java.util.Scanner;

public class Player {
	private String playerName;
	private char playerSymbol;
	
	private Scanner sc = new Scanner(System.in);
	
	public String getPlayerName() {
		return playerName;
	}
	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}
	public char getPlayerSymbol() {
		return playerSymbol;
	}
	public void setPlayerSymbol(char playerSymbol) {
		this.playerSymbol = playerSymbol;
	}
	
	public Point makeMove() {
		System.out.print("Please enter the x coordinate of your move, " + this.playerName + ": ");
		int x = sc.nextInt() + -1;
		
		System.out.print("Please enter the y coordinate of your move, " + this.playerName + ": ");
		int y = sc.nextInt() + -1;
		
		return new Point(x, y);
	}
}
