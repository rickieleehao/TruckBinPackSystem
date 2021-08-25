import java.util.ArrayList;

public class Truck {

	final static int MAX_CAPACITY = 20;
	private ArrayList<Parcel> containedParcel;
	private int remainingCapacity;

	public Truck() {
		this.containedParcel = new ArrayList<Parcel> ();
		this.remainingCapacity = Truck.MAX_CAPACITY;
	}

	public Truck(ArrayList<Parcel> containedParcel) {
		this.containedParcel = containedParcel;
		setRemainingCapacity();
	}

	public void addParcel(Parcel parcel) {
		this.containedParcel.add(parcel);
	}

	public void updateRemainingCapacity() {
		this.remainingCapacity -= this.containedParcel.get(this.containedParcel.size() - 1).getWeight();
	}

	private void setRemainingCapacity() {
		int capacity = 0;
		for (Parcel parcel : this.containedParcel)
			capacity += parcel.getWeight();
		this.remainingCapacity = capacity;
	}

	public int getRemainingCapacity() {
		return remainingCapacity;
	}

	public ArrayList<Parcel> getContainedParcel() {
		return this.containedParcel;
	}
}