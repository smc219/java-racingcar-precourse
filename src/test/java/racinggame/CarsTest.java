package racinggame;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

import nextstep.utils.Randoms;

class CarsTest {

	Cars cars;

	@BeforeEach
	void setup() {
		List<Car> carList = Arrays.asList(new Car("aaa", 0), new Car("bbb", 0), new Car("ccc", 0));
		cars = new Cars(carList);
	}

	@Test
	void updateLocation() {
		int mxBeforeUpdate = cars.getMx();

		for (int i = 0; i < cars.size(); ++i)
		{
			 cars.updateLocation(i, 1);
		}
		int mxAfterUpdate = cars.getMx();
		Assertions.assertNotEquals(mxAfterUpdate, mxBeforeUpdate);
	}

	@Test
	void size() {

		Assertions.assertEquals(3, cars.size());

	}

	@Test
	void makeProgressSentence() {

		String prgressOneSentece = cars.makeProgressSentence(1);
		String progressTwoSentece = cars.makeProgressSentence(2);

		Assertions.assertNotEquals(prgressOneSentece, progressTwoSentece);

	}

	@Test
	void printResult() {
	}

	@Test
	void getMx() {
		cars.updateLocation(0, 19);
		Assertions.assertEquals(19, cars.getMx());
	}

	@Test
	void getMxCarName() {
		cars.updateLocation(1, 19);
		String mxCarName = cars.getMxCarName(1, cars.getMx());
		String notMxCarName = cars.getMxCarName(0, cars.getMx());

		Assertions.assertEquals(notMxCarName, "");
		Assertions.assertEquals(mxCarName, "bbb,");
	}

	@Test
	void getWinner() {
		cars.updateLocation(0, 10);
		cars.updateLocation(1, 10);
		String winners = cars.getWinner();
		Assertions.assertEquals("aaa,bbb", winners);
	}
}