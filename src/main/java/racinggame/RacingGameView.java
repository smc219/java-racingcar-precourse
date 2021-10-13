package racinggame;

import nextstep.utils.Console;
import racinggame.wrapper.GameNumbers;
import racinggame.wrapper.Notification;

public class RacingGameView {
	RacingGameController racingGameController;
	Notification notification = new Notification();
	GameNumbers gameNumbers;

	public RacingGameView() {
		this.racingGameController = new RacingGameController(this);
	}

	public boolean validateIsDigit(String num) {
		try {
			Integer.parseInt(num);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	public void receiveCarName() {
		System.out.println(notification.getRequestToEnterCarName());
		String input = Console.readLine();
		boolean result = racingGameController.findCarName(input);
		while (!result) {
			System.out.println(notification.getWrongCarNameNotification());
			System.out.println(notification.getRequestToEnterCarName());
			input = Console.readLine();
			result = racingGameController.findCarName(input);
		}
	}

	public GameNumbers receiveTry() {
		System.out.print(notification.getRequestToEnterTryNumber());
		String tryNumber = Console.readLine();
		while (!validateIsDigit(tryNumber)) {
			System.out.println(notification.getWrongTryNumberNotification());
			System.out.println(notification.getRequestToEnterTryNumber());
			tryNumber = Console.readLine();
		}
		return new GameNumbers(Integer.parseInt(tryNumber));
	}

	public void inputCarName() {
		receiveCarName();
		gameNumbers = receiveTry();
		System.out.println(notification.getNotificationToBegin());
		racingGameController.runGame(gameNumbers.getTryNumber());
	}

	public void printResult(String resultSentence) {
		System.out.println(resultSentence);
	}

}
