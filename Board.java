package seid.tictactoe;

import java.awt.Point;

public class Board {
	private char[][] board;
	private static final int BOARD_SIZE = 3;
	
	public Board() {
		board = new char[BOARD_SIZE][BOARD_SIZE];
		clearBoard();
	}
	
	public void clearBoard() {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				board[i][j] = ' ';
			}
		}
	}
	
	public void printBoard() {
		System.out.println();
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				System.out.print("|" + "   " + board[i][j] + "   " + "|" + "   ");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	public char[][] getBoard() {
		return board;
	}
	
	public void doMove(Player currentPlayer, Point move) {
		int x = move.x;
		int y = move.y;
		
		board[x][y] = currentPlayer.getPlayerSymbol();
	}
	
	public boolean isWin() {
		
		//horizontal
		if (board[0][0] != ' ' && board[0][0] == board[0][1] && board[0][0] == board[0][2])
			return true;
		if (board[1][0] != ' ' && board[1][0] == board[1][1] && board[1][0] == board[1][2])
			return true;
		if (board[2][0] != ' ' && board[2][0] == board[2][1] && board[2][0] == board[2][2])
			return true;
		
		//vertical
		if (board[0][0] != ' ' && board[0][0] == board[1][0] && board[0][0] == board[2][0])
			return true;
		if (board[0][1] != ' ' && board[0][1] == board[1][1] && board[0][1] == board[2][1])
			return true;
		if (board[0][2] != ' ' && board[0][2] == board[1][2] && board[0][2] == board[2][2])
			return true;
		
		//diagonal
		if (board[0][0] != ' ' && board[0][0] == board[1][1] && board[0][0] == board[2][2])
			return true;
		if (board[0][2] != ' ' && board[0][2] == board[1][1] && board[0][2] == board[2][0])
			return true;
		
		return false;
	}
	
	public boolean isTie() {
		int filledCells = 0;
		for (int i = 0; i < BOARD_SIZE; i++) {
			for (int j = 0; j < BOARD_SIZE; j++)
				if (board[i][j] != ' ')
					filledCells++;
		}
		
		if (!isWin() && filledCells == 9)
			return true;
		else
			return false;
	}
	
}
