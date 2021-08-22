import java.util.ArrayList;

public class Truck {

	final static String CAPACITY_UNIT = "KG";
	final static int MAX_CAPACITY = 20;
	private ArrayList<Parcel> containedParcel;
	private int remainingCapacity;

	public Truck() {

	}

	public Truck(ArrayList<Parcel> containedParcel) {
		this.containedParcel = containedParcel;
		setRemainingCapacity();
	}

	private void setRemainingCapacity() {
		int capacity = 0;
		for (Parcel parcel : this.containedParcel)
			capacity += parcel.getWeight();
		this.remainingCapacity = capacity;
	}

	public void addParcel(Parcel parcel) {
		this.containedParcel.add(parcel);
	}

	public void updateRemainingCapacity() {
		this.remainingCapacity -= this.containedParcel.get(this.containedParcel.size() - 1).getWeight();
	}

	public int getRemainingCapacity() {
		return remainingCapacity;
	}

	public ArrayList<Parcel> getContainedParcel() {
		return this.containedParcel;
	}
}