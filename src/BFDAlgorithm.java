import java.util.ArrayList;
import java.util.Collections;

public class BFDAlgorithm extends Algorithm {

	public BFDAlgorithm(ArrayList<Parcel> parcelList) {
		Collections.sort(parcelList); // sort by comparable in reverse order
		this.parcelList = parcelList;
		allocateParcels();
	}

	@Override
	protected void allocateParcels() {
		long startTime, endTime;
		this.allocatedTrucks.add(new Truck()); // initial the 1st empty truck
		Truck bestFitTruck = null;

		startTime = System.nanoTime();
		for (Parcel parcel : this.parcelList) {
			bestFitTruck = null;
			for (Truck truck : this.allocatedTrucks) {
				// check if the truck is able to store the parcel;
				if (truck.getRemainingCapacity() >= parcel.getWeight()) {
					// compare the selected truck (ST) with the best fit truck (BFT)
					// if (BFT + parcel's weight < ST + parcel's weight)
					// ----> the ST will be the new BFT
					if (bestFitTruck == null) {
						bestFitTruck = truck;
					} else if (bestFitTruck.getRemainingCapacity() - parcel.getWeight() > truck.getRemainingCapacity()
							- parcel.getWeight()) {
						bestFitTruck = truck;
					}
				}
			}

			// if (the parcel is not allocated into any existing truck)
			// ----> a new truck will be created
			// ----> and the parcel will be assigned to the new truck
			// else
			// ----> the parcel will be added into the BFT

			if (bestFitTruck == null) {
				Truck newTruck = new Truck();
				newTruck.addParcel(parcel);
				this.allocatedTrucks.add(newTruck);
				this.allocatedTrucks.get(this.allocatedTrucks.size() - 1).updateRemainingCapacity();
			} else {
				bestFitTruck.addParcel(parcel);
				bestFitTruck.updateRemainingCapacity();
			}

		}

		endTime = System.nanoTime();
		setTimeAllocated(startTime, endTime);
		updateTotalRemainingCapacity();
	}
}