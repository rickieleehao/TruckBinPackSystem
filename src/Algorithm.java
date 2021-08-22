import java.util.ArrayList;

public abstract class Algorithm {

	protected ArrayList<Parcel> parcelList;
	protected ArrayList<Truck> allocatedTrucks;
	protected float timeAllocated;
	protected int totalRemainingCapacity;

	public Algorithm() {
		this.allocatedTrucks.add(new Truck()); // initialize one empty truck as default
		this.timeAllocated = 0;
		this.totalRemainingCapacity = 0;
	}

	public ArrayList<Parcel> getParcelList() {
		return this.parcelList;
	}

	public ArrayList<Truck> getAllocatedTrucks() {
		return this.allocatedTrucks;
	}

	public float getTimeAllocated() {
		return this.timeAllocated;
	}

	public int getRemainingCapacity() {
		return this.totalRemainingCapacity;
	}

	protected void setTimeAllocated(float startTime, float endTime) {
		this.timeAllocated = endTime - startTime;
	}

	protected void updateTotalRemainingCapacity() {
		int totalRemainingCapacity = this.allocatedTrucks.size() * Truck.MAX_CAPACITY;

		for (Truck truck : this.allocatedTrucks) {
			for (Parcel parcel : truck.getContainedParcel()) {
				totalRemainingCapacity -= parcel.getWeight();
			}
		}

		this.totalRemainingCapacity = totalRemainingCapacity;
	}

	abstract void allocateParcels();

}