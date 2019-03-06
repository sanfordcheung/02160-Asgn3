package game;

import game.Point;
import game.GameBoard;

public class Player {
	public boolean player1;
    public Point move;
	public Point moveN;
	public GameBoard gameBoard;
	public Player() {
		player1 = true;
		move = new Point();
		moveN = new Point();
	}
	public void myGameBoard(GameBoard g) {
		gameBoard = g;
	}
	public boolean checkValidMove() {
		if (move.x > 7 || move.y > 7 || move.x < 0 || move.y < 0 ||
				moveN.x > 7 || moveN.y > 7 || moveN.x < 0 || moveN.y < 0)
			return false;
		if (gameBoard.get(moveN.y, moveN.x) != ' ')
		{
			return false;
		}
		if (player1 && gameBoard.get(move.y, move.x) != '1')
		{
			return false;
		}
		if (!player1 && gameBoard.get(move.y, move.x) != '2')
		{
			return false;
		}
		if (player1 && moveN.y < move.y)
		{
			return false;
		}
		if (!player1 && moveN.y > move.y)
		{
			return false;
		}
		if ((moveN.y-move.y)*(moveN.y-move.y) + (moveN.x-move.x)*(moveN.x-move.x) != 2)
		{
			return false;
		}
		return true;
	}
	public void myMove() {
		gameBoard.set(moveN.y, moveN.x, gameBoard.get(move.y, move.x));
		gameBoard.set(move.y, move.x, ' ');
		player1 = !player1;
	}
}
