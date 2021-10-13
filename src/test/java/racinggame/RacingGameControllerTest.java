package racinggame;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RacingGameControllerTest {
	RacingGameView racingGameView;
	RacingGameController racingGameController;

	@BeforeEach
	void setup() {
		racingGameController = new RacingGameController(racingGameView);
	}

	@Test
	void validateNameLength() {
		Assertions.assertTrue(racingGameController.validateNameLength(Arrays.asList("aaa", "bbb", "ccc")));
		Assertions.assertFalse(racingGameController.validateNameLength(Arrays.asList("aaa", "bbbbbb", "ccc")));

	}

	@Test
	void findCarName() {

		Assertions.assertTrue(racingGameController.findCarName("aaa,bbb,ccc"));
		Assertions.assertFalse(racingGameController.findCarName("aaa,bbbbbbbb,ccc"));

	}
}