package racinggame.wrapper;

public class Notification {
	final String wrongCarNameNotification = "[ERROR] 각 차량의 이름은 5자 이하입니다.";
	final String wrongTryNumberNotification = "[ERROR] 숫자를 입력해주세요.";
	final String requestToEnterCarName = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
	final String requestToEnterTryNumber = "시도할 횟수는 몇회인가요?";
	final String notificationToBegin = "\n실행결과";
	
	public String getNotificationToBegin() {
		return notificationToBegin;
	}

	public String getWrongCarNameNotification() {
		return wrongCarNameNotification;
	}

	public String getWrongTryNumberNotification() {
		return wrongTryNumberNotification;
	}

	public String getRequestToEnterCarName() {
		return requestToEnterCarName;
	}

	public String getRequestToEnterTryNumber() {
		return requestToEnterTryNumber;
	}
}
