package racinggame;

import java.util.ArrayList;
import java.util.List;

import nextstep.utils.Randoms;

public class Cars {
	public List<Car> cars = new ArrayList<>();

	public void addNewCar(Car car) {
		cars.add(car);
	}

	public void updateLocation(int ix, int val) {
		cars.get(ix).location += val;
	}

	public int size() {
		return cars.size();
	}


}
