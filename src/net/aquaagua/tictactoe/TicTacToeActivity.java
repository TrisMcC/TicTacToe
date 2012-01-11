package net.aquaagua.tictactoe;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class TicTacToeActivity extends Activity implements MoveController {

	private Square currentPlayer = Square.X;
	private boolean gameOn = true;
	private TextView playerName;
	private Button lastClick;
	private Game game = new Game();
	private View currentPlayerLayout;
	private View endGameLayout;
	private TextView endGameText;

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		playerName = (TextView) findViewById(R.id.textViewPlayerName);
		currentPlayerLayout = findViewById(R.id.relativeLayoutCurrentPlayer);
		endGameLayout = findViewById(R.id.linearLayoutEndGame);
		endGameText = (TextView) findViewById(R.id.textViewEndGame);
		updateView();
	}

	public void win(MoveInfo info) {
		setMoveInfo(info);
		setEndGame(currentPlayer.toString() + " Wins!");
	}

	private void setEndGame(String message) {
		gameOn = false;
		currentPlayerLayout.setVisibility(View.GONE);
		endGameLayout.setVisibility(View.VISIBLE);
		endGameText.setText(message);
	}

	public void draw(MoveInfo info) {
		setMoveInfo(info);
		setEndGame("Game ends in a draw.");
	}

	public Square getCurrentPlayer() {
		return currentPlayer;
	}

	public void complete(MoveInfo info) {
		setMoveInfo(info);
		currentPlayer = currentPlayer.nextPlayer();
		updateView();
	}

	private void setMoveInfo(MoveInfo info) {
		if (info.getValidMove()) {
			lastClick.setText(currentPlayer.toShortString());
		}
	}

	private void updateView() {
		playerName.setText(currentPlayer.toString());
	}

	public void moveClick(View v) {
		if (gameOn) {
			lastClick = (Button) v;
			int buttonNumber = Integer.parseInt((String) lastClick.getTag());
			int row = (buttonNumber - 1) / Game.SIZE;
			int column = (buttonNumber - 1) - (Game.SIZE * row);
			game.makeMove(row, column, this);
		}
	}
}