package game;

import java.util.Scanner;
import game.GameBoard;
import game.Player;

public class Checker {
	protected static Player player;
	protected static Scanner input;
	protected static GameBoard gameBoard;
	
	public static void playGame() {
		gameBoard.printBoard();
		player.myGameBoard(gameBoard);
		System.out.print("\nTurn of player no. " + (player.player1 ? "1" : "2") + "\nCoordinate of piece to move\n");
		System.out.print("  Enter X:\n");
		player.move.x = input.nextInt();
		System.out.print("  Enter Y:\n");
		player.move.y = input.nextInt();
		System.out.print("\nCoordinate of new position\n");
		System.out.print("  Enter X:\n");
		player.moveN.x = input.nextInt();
		System.out.print("  Enter Y:\n");
		player.moveN.y = input.nextInt();
		if (player.checkValidMove()) {
			player.myMove();
			System.out.println("Piece moved!\n");
		}
		else {
			System.out.println("Invalid move!");
		}
	}
	
	public static void gameInit() {
		gameBoard = new GameBoard();
		player = new Player();
		input = new Scanner(System.in);
	}
	
	public static void main(String[] args) {
		gameInit();
		while(true) {
			playGame();
		}
	}
}
