package racinggame;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

import nextstep.utils.Randoms;

class RacingGameModelTest {

	RacingGameModel racingGameModel;
	RacingGameView racingGameView;
	RacingGameController racingGameController;
	Randoms spy;
	List<Car> cars = new ArrayList<>();
	@BeforeEach
	void setup() {
		List<String> carName = Arrays.asList("aaa", "bbb", "ccc", "ddd");
		for (int i = 0; i < carName.size(); ++i) {
			cars.add(new Car(carName.get(i), 0));
		}
		racingGameView = new RacingGameView();
		racingGameController = new RacingGameController(racingGameView);
		racingGameModel = new RacingGameModel(racingGameController, cars);
	}

	@Test
	void checkPossibleToMove() {
		int canNotMove = Randoms.pickNumberInRange(0, 3);
		int canMove = Randoms.pickNumberInRange(4, 9);
		Assertions.assertEquals(0, racingGameModel.checkPossibleToMove(canNotMove));
		Assertions.assertEquals(1, racingGameModel.checkPossibleToMove(canMove));
	}


	@Test
	void updateCars() {

		String beforeUpdate = racingGameModel.makeSentence();

		try (final MockedStatic<Randoms> mockRandoms = mockStatic(Randoms.class)) {
			mockRandoms.when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
				.thenReturn(5);
			racingGameModel.updateCars();
			String afterUpdate = racingGameModel.makeSentence();
			Assertions.assertNotEquals(beforeUpdate, afterUpdate);
		}

	}



	@Test
	void getWinner() {
		try (final MockedStatic<Randoms> mockRandoms = mockStatic(Randoms.class)) {
			mockRandoms.when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
				.thenReturn(5, 4, 3);
			racingGameModel.updateCars();
			String winnerSentence = racingGameModel.getWinner();
			Assertions.assertTrue(winnerSentence.contains("aaa"));
		}
	}
}