package test;

import static org.junit.Assert.*;

import game.Checker;

import org.junit.Test;

public class CheckerTest extends Checker{

	private String playGame(int x, int y, int Nx, int Ny) {
		gameBoard.printBoard();
		player.myGameBoard(gameBoard);
		System.out.print("\nTurn of player no. " + (player.player1 ? "1" : "2") + "\nCoordinate of piece to move\n");
		System.out.print("  Enter X:\n");
		player.move.x = x;
		System.out.print("  Enter Y:\n");
		player.move.y = y;
		System.out.print("\nCoordinate of new position\n");
		System.out.print("  Enter X:\n");
		player.moveN.x = Nx;
		System.out.print("  Enter Y:\n");
		player.moveN.y = Ny;
		if (player.checkValidMove()) {
			player.myMove();
			return new String("Piece moved!");
		}
		else {
			return new String("Invalid move!");
		}
	}
	@Test
	public void testValidMove() {
		gameInit();
		assertEquals("Piece moved!", playGame(1,2,2,3));
		assertEquals("Piece moved!", playGame(0,5,1,4));
	}

	@Test
	public void testIndexOutOfBoundsInvalidMove() {
		gameInit();
		assertEquals("Invalid move!", playGame(-1,2,2,3));
		assertEquals("Invalid move!", playGame(1,-2,2,3));
		assertEquals("Invalid move!", playGame(1,2,-2,3));
		assertEquals("Invalid move!", playGame(1,2,2,-3));
	}

	@Test
	public void testOriginalSlotEmptyInvalidMove() {
		gameInit();
		assertEquals("Invalid move!", playGame(0,0,1,1));
		assertEquals("Invalid move!", playGame(2,2,3,3));
	}
	
	@Test
	public void testNewSlotOccupiedInvalidMove() {
		gameInit();
		assertEquals("Piece moved!", playGame(1,2,2,3));
		assertEquals("Piece moved!", playGame(0,5,1,4));
		assertEquals("Invalid move!", playGame(2,3,1,4));
		assertEquals("Invalid move!", playGame(1,4,2,3));
	}
	
	@Test
	public void testMoveForwardInvalidMove() {
		gameInit();
		assertEquals("Invalid move!", playGame(1,2,1,3));
	}
	
	@Test
	public void testMoveLeftInvalidMove() {
		gameInit();
		assertEquals("Invalid move!", playGame(1,2,0,2));
	}
	
	@Test
	public void testMoveTooFarInvalidMove() {
		gameInit();
		assertEquals("Invalid move!", playGame(1,2,3,4));
	}
	
	@Test
	public void testMoveBackInvalidMove() {
		gameInit();
		assertEquals("Piece moved!", playGame(1,2,2,3));
		assertEquals("Piece moved!", playGame(0,5,1,4));
		assertEquals("Invalid move!", playGame(2,3,1,2));
	}
	
	@Test
	public void testGameBoardAfterMove() {
		gameInit();
		assertEquals("Piece moved!", playGame(1,2,2,3));
		assertEquals(' ', gameBoard.get(2,1));
		assertEquals('1', gameBoard.get(3,2));
		assertEquals("Piece moved!", playGame(0,5,1,4));
		assertEquals(' ', gameBoard.get(5,0));
		assertEquals('2', gameBoard.get(4,1));
		assertEquals("Invalid move!", playGame(2,3,1,2));
		assertEquals('1', gameBoard.get(3,2));
		assertEquals(' ', gameBoard.get(2,1));
	}

}
