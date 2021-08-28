import java.util.InputMismatchException;

public class Parcel implements Comparable<Parcel> {

	final static int MAX_WEIGHT = 20;
	private int weight;

	public Parcel(double weight) {
		int roundedWeight = (int) Math.ceil(weight); // Always rounded up

		if (roundedWeight > Parcel.MAX_WEIGHT)
			throw new InputMismatchException();
		else
			this.weight = roundedWeight;
	}

	public int getWeight() {
		return this.weight;
	}

	@Override
	public int compareTo(Parcel p) {
		return p.weight - this.weight; // Reverse order
	}

	@Override
	public String toString() {
		return Integer.toString(this.weight);
	}
}