package racinggame;

import nextstep.utils.Console;

public class RacingGameView {
	RacingGameController racingGameController;

	public RacingGameView() {
		this.racingGameController = new RacingGameController(this);
	}

	public boolean validateIsDigit(String num) {
		try {
			Integer.parseInt(num);
			return true;
		} catch (NumberFormatException e) {
			System.out.println("[ERROR] 숫자를 입력해주세요.");
			return false;
		}
	}

	public void receiveCarName() {
		System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
		String input = Console.readLine();
		boolean result = racingGameController.findCarName(input);
		while (!result) {
			System.out.println("[ERROR] 각 차량의 이름은 5자 이하입니다.\n경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
			input = Console.readLine();
			result = racingGameController.findCarName(input);
		}
	}

	public int receiveTry() {
		System.out.print("시도할 횟수는 몇회인가요? : ");
		String tryNumber = Console.readLine();
		while (!validateIsDigit(tryNumber)) {
			System.out.println("시도할 횟수는 몇회인가요?");
			tryNumber = Console.readLine();
		}
		return Integer.parseInt(tryNumber);
	}

	public void inputCarName() {
		receiveCarName();
		int tryNumber = receiveTry();
		System.out.println("\n실행결과");
		racingGameController.runGame(tryNumber);
	}

	public void printResult(String resultSentence) {
		System.out.println(resultSentence);
	}

}
