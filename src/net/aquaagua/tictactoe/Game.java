package net.aquaagua.tictactoe;

public class Game {
	public final static int SIZE = 3;
	private Square[][] board = new Square[SIZE][SIZE];
	private int moveCount = 0;
	
	public Game() {
		for (int i = 0; i < SIZE; i++) {
			for (int j = 0; j < SIZE; j++) {
				board[i][j] = Square.Blank;
			}
		}
	}

	public void makeMove(int x, int y, MoveController mover) {
		int count = 0;
		Square move = mover.getCurrentPlayer();
		MoveInfo info = new MoveInfo();

		if (board[x][y] == Square.Blank) {
			info.setValidMove(true);
			board[x][y] = move;
		}
		moveCount++;

		for (count = 0; count < SIZE; count++) {
			if (board[x][count] != move) {
				break;
			}
		}

		if (count == SIZE) {
			mover.win(info);
			return;
		}

		for (count = 0; count < SIZE; count++) {
			if (board[count][y] != move) {
				break;
			}
		}

		if (count == SIZE) {
			mover.win(info);
			return;
		}
		
		for (count = 0; count < SIZE; count++) {
			if (board[count][count] != move) {
				break;
			}
		}
		
		if (count == SIZE) {
			mover.win(info);
			return;
		}
		
		for (count = 0; count < SIZE; count++) {
			if (board[count][(SIZE - 1) - count] != move) {
				break;
			}
		}
		
		if (count == SIZE) {
			mover.win(info);
			return;
		}
		
		if (moveCount == (SIZE * SIZE - 1)) {
			mover.draw(info);
			return;
		}
		
		mover.complete(info);
	}
}
