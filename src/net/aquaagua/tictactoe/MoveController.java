package net.aquaagua.tictactoe;

public interface MoveController {
	void win(MoveInfo info);
	void draw(MoveInfo info);
	void complete(MoveInfo info);
	Square getCurrentPlayer();
}
