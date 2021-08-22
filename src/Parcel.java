public class Parcel implements Comparable<Parcel> {

	final static int MAX_WEIGHT = 20;
	final static String WEIGHT_UNIT = "KG";
	private int weight;

	public int getWeight() {
		return weight;
	}

	public int getMaxWeight() {
		return MAX_WEIGHT;
	}

	public Parcel(double weight) {
		this.weight = (int) Math.ceil(weight); // Always rounded up
	}

	@Override
	public int compareTo(Parcel o) {
		return o.weight - this.weight; // Reverse order
	}
}