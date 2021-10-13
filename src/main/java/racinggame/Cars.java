package racinggame;

import java.util.ArrayList;
import java.util.List;

public class Cars {
	public List<Car> cars = new ArrayList<>();

	public Cars(List<Car> cars) {
		this.cars = cars;
	}

	public int updateLocation(int ix, int val) {
		cars.get(ix).location += val;
		return cars.get(ix).location;
	}

	public int size() {
		return cars.size();
	}

	public String makeProgressSentence(int progress) {
		String ret = "";
		for (int i = 0; i < progress; ++i) {
			ret += "-";
		}
		return ret;
	}

	public String printResult() {
		String ret = "";
		for (int i = 0; i < cars.size(); ++i) {
			ret += (cars.get(i).name) + " : " + makeProgressSentence(cars.get(i).location) + "\n";
		}
		return ret;
	}

	public int getMx() {
		int mx = -1;
		for (int i = 0; i < cars.size(); ++i) {
			mx = Math.max(mx, cars.get(i).location);
		}
		return mx;
	}

	public String getMxCarName(int ix, int mx) {
		if (cars.get(ix).location == mx)
			return cars.get(ix).name + ",";
		return "";
	}

	public String getWinner() {

		int mix = 0;
		int mx = getMx();
		String ret = "";
		for (int i = 0; i < cars.size(); ++i) {
			ret += getMxCarName(i, mx);
		}

		if (ret.charAt(ret.length() - 1) == ',')
			ret = ret.substring(0, ret.length() - 1);
		return ret;

	}

}
