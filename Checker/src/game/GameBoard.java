package game;

public class GameBoard {
	private char[][] board;
	public GameBoard() {
		board = new char[8][8];
		char[] board_arr1 = {' ', '1', ' ', '1', ' ', '1', ' ', '1'};
		char[] board_arr2 = {'1', ' ', '1', ' ', '1', ' ', '1', ' '};
		char[] board_arr3 = {' ', '2', ' ', '2', ' ', '2' , ' ', '2'};
		char[] board_arr4 = {'2', ' ', '2', ' ', '2', ' ', '2', ' '};
		char[] board_arr5 = {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '};
		System.arraycopy(board_arr1, 0, board[0], 0, board_arr1.length);
		System.arraycopy(board_arr2, 0, board[1], 0, board_arr2.length);
		System.arraycopy(board_arr1, 0, board[2], 0, board_arr1.length);
		System.arraycopy(board_arr5, 0, board[3], 0, board_arr5.length);
		System.arraycopy(board_arr5, 0, board[4], 0, board_arr5.length);
		System.arraycopy(board_arr4, 0, board[5], 0, board_arr4.length);
		System.arraycopy(board_arr3, 0, board[6], 0, board_arr3.length);
		System.arraycopy(board_arr4, 0, board[7], 0, board_arr4.length);
	}
	
	public void printBoard() {
		System.out.println("   0 1 2 3 4 5 6 7   <- X axis");
		System.out.println("  +----------------+");
		for(int i = 0; i < 8; i++) {
			System.out.print(i + " |");
			for(int j = 0; j < 8; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.print("|\n");
		}
		System.out.println("  +----------------+");
		System.out.println("   0 1 2 3 4 5 6 7   ");
	}
	
	public char get(int y, int x) {
		return board[y][x];
	}
	
	public void set(int y, int x, char c) {
		board[y][x] = c;
	}
}
