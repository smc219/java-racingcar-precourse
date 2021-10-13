package racinggame;

import java.util.List;

import nextstep.utils.Randoms;

public class RacingGameModel {
	RacingGameController racingGameController;
	Cars cars;

	public RacingGameModel(RacingGameController racingGameController, List<Car> cars) {
		this.racingGameController = racingGameController;
		this.cars = new Cars(cars);
	}

	public int checkPossibleToMove(int num)
	{
		if(num <= 3) return 0;
		return 1;
	}

	public void updateCars() {
		for (int i = 0; i < cars.size(); ++i)
		{
			int moveCount = checkPossibleToMove(Randoms.pickNumberInRange(0, 9));
			cars.updateLocation(i, moveCount);
		}
	}

	public String makeSentence() {
		return cars.printResult();
	}

	public String getWinner() {

		return "최종 우승자는 " + cars.getWinner() + " 입니다.";
	}





}
