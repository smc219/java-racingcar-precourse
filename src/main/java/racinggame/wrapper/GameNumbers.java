package racinggame.wrapper;

public class GameNumbers {
	static final int moveBegin = 0;
	static final int moveEnd = 9;
	int tryNumber;

	public GameNumbers(int tryNumber) {
		this.tryNumber = tryNumber;
	}

	public static int getMoveBegin() {
		return moveBegin;
	}

	public static int getMoveEnd() {
		return moveEnd;
	}

	public int getTryNumber() {
		return tryNumber;
	}
}
