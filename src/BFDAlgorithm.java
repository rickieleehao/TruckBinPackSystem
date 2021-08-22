import java.util.ArrayList;
import java.util.Collections;

public class BFDAlgorithm extends Algorithm {

	public BFDAlgorithm(ArrayList<Parcel> parcelList) {
		Collections.sort(parcelList); // sort by comparable in reverse order
		this.parcelList = parcelList;
	}

	@Override
	public void allocateParcels() {
		long startTime, endTime;
		boolean parcelAllocated = false;
		int indexOfBestFitTruck = 0;

		startTime = System.currentTimeMillis();
		for (Parcel parcel : this.parcelList) {
			for (Truck truck : this.allocatedTrucks) {
				// check if the truck is able to store the parcel;
				if (truck.getRemainingCapacity() >= parcel.getWeight()) {

					// compare the selected truck (ST) with the best fit truck (BFT)
					// if (BFT + parcel's weight > ST + parcel's weight)
					// ----> the ST will be the new BFT

					if (this.allocatedTrucks.get(indexOfBestFitTruck).getRemainingCapacity()
							+ parcel.getWeight() > truck.getRemainingCapacity() + parcel.getWeight()) {
						indexOfBestFitTruck = this.allocatedTrucks.indexOf(truck);
						parcelAllocated = true;
					}
				}

				// if (the parcel is not allocated in any existing truck)
				// ----> a new truck will be created
				// ----> and the parcel will be assigned to the new truck
				// else
				// ----> the parcel will be added into the BFT

				if (!parcelAllocated) {
					Truck newTruck = new Truck();
					newTruck.addParcel(parcel);
					this.allocatedTrucks.add(newTruck);
				} else {
					this.allocatedTrucks.get(indexOfBestFitTruck).addParcel(parcel);
					this.allocatedTrucks.get(indexOfBestFitTruck).updateRemainingCapacity();
				}
			}
		}

		endTime = System.currentTimeMillis();
		setTimeAllocated(startTime, endTime);
		updateTotalRemainingCapacity();
	}
}