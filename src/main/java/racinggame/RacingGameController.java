package racinggame;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RacingGameController {
	RacingGameModel racingGameModel;
	RacingGameView racingGameView;

	public RacingGameController(RacingGameView racingGameView) {
		this.racingGameView = racingGameView;
	}

	public boolean validateNameLength(List<String> inputs)
	{
		int mxlength = 0;

		for (int i = 0; i < inputs.size() && mxlength <=5; ++i)
		{
			mxlength = Math.max(mxlength, inputs.get(i).length());
		}

		return mxlength <= 5;
	}

	public boolean findCarName(String input)
	{
		List<Car> cars = new ArrayList<>();
		List<String> inputs = Arrays.asList(input.split(","));
		if (!validateNameLength(inputs)) return false;
		for (int i = 0; i < inputs.size(); ++i)
		{
			cars.add(new Car(inputs.get(i), 0));
		}

		racingGameModel = new RacingGameModel(this, cars);
		return true;
	}

	public void runGame(int cnt)
	{
		for (int i = 0; i < cnt; ++i)
		{
			racingGameModel.updateCars();
			racingGameView.printResult(racingGameModel.makeSentence());
		}

		String finalResult = racingGameModel.getWinner();
		racingGameView.printResult(finalResult);
	}
}
