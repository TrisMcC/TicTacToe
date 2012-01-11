package net.aquaagua.tictactoe;

public enum Square {
	Blank, X, O;

	public String toString() {
		String result = "";
		switch (this) {
		case X:
			result = "Player X";
			break;
		case O:
			result = "Player O";
			break;
		case Blank:
			result = "";
			break;
		}
		return result;
	}
	
	public String toShortString() {
		String result = "";
		switch (this) {
		case X:
			result = "X";
			break;
		case O:
			result = "O";
			break;
		case Blank:
			result = "";
			break;
		}
		return result;		
	}
	
	public Square nextPlayer() {
		Square result = Square.Blank;
		switch (this) {
		case X:
			result = O;
			break;
		case O:
			result = X;
			break;
		case Blank:
			result = X;
			break;
		}
		return result;
	}

}
