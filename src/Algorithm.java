import java.util.ArrayList;

public abstract class Algorithm {

	protected ArrayList<Parcel> parcelList;
	protected ArrayList<Truck> allocatedTrucks;
	protected long timeAllocated;
	protected int totalRemainingCapacity;

	public Algorithm() {
		this.allocatedTrucks = new ArrayList<Truck>();
		this.timeAllocated = 0;
		this.totalRemainingCapacity = 0;
	}

	public ArrayList<Parcel> getParcelList() {
		return this.parcelList;
	}

	public ArrayList<Truck> getAllocatedTrucks() {
		return this.allocatedTrucks;
	}

	public long getTimeAllocated() {
		return this.timeAllocated;
	}

	public int getRemainingCapacity() {
		return this.totalRemainingCapacity;
	}

	protected void setTimeAllocated(long startTime, long endTime) {
		this.timeAllocated = endTime - startTime;
	}

	protected void updateTotalRemainingCapacity() {
		int totalRemainingCapacity = 0;
		for (Truck truck : this.allocatedTrucks) {
			totalRemainingCapacity += truck.getRemainingCapacity();
		}
		this.totalRemainingCapacity = totalRemainingCapacity;
	}

	protected abstract void allocateParcels();

}