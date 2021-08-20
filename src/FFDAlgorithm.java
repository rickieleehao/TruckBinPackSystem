import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * @author RickiE
 * @version 1.0
 * @created 30-Jul-2021 10:27:07 AM
 */
public class FFDAlgorithm extends Algorithm {

	private ArrayList<Parcel> parcelList;
	private ArrayList<Truck> allocatedTrucks;
	private float timeAllocated;
	private int remainingCapcity;

	public FFDAlgorithm() {

	}

	public void finalize() throws Throwable {
		super.finalize();
	}

	/**
	 * 
	 * @param parcelList
	 */
	public FFDAlgorithm(ArrayList<Parcel> parcelList) {
		Collections.sort(parcelList, new Algorithm()); // sort by comparator
		this.parcelList = parcelList;

	}
	
	public int compare(Parcel a, Parcel b) {
		return super.compare(a, b);
	}

	// not sure put at where yet
	class SortByWeight implements Comparator<Parcel> {
		public int compare(Parcel a, Parcel b) {
			return b.getWeight() - a.getWeight(); // order in decreasing order
		}
	}

	/**
	 * 
	 * @param allocatedTrucks
	 * @param timeAllocated
	 * @param remainingCapacity
	 */
	public FFDAlgorithm(ArrayList<Truck> allocatedTrucks, float timeAllocated, int remainingCapacity) {
		this.allocatedTrucks = allocatedTrucks;
		this.timeAllocated = timeAllocated;
		this.remainingCapacity = remainingCapacity;
	}

	public void generateAllocatedTrucks() {

		long FFDStart = System.currentTimeMillis();

		for (int i = 0; i < parcelList.size(); i++) { //for there's parcel, will continue loop
			int j;

			for (j = 0; j < allocatedTrucks.size(); j++) { //for parcel size less than truck size, will go into loop
				if (allocatedTrucks.get(j).getRemainingCapacity() >= parcelList.get(i).getWeight()) { //truck remaining space more larger than parcel weight
					allocatedTrucks.get(j).deductCapacity(parcelList.get(i).getWeight()); //deduct capacity of truck[j] by weight of parcel[i]
					break;
				}
			}

			// If no trucks can accomodate the parcel, create new truck
			if (j == allocatedTrucks.size()) {
				allocatedTrucks.add(new Truck());
				allocatedTrucks.get(j).deductCapacity(parcelList.get(i).getWeight()); //deduct capacity of truck[j] by weight of parcel[i]
			}
		}

		long FFDEnd = System.currentTimeMillis();

		timeAllocated = FFDEnd - FFDStart;
		
		for(int r; r < allocatedTrucks.size(); r++) {
			remainingCapacity += allocatedTrucks.get(r).getRemainingCapacity();
		}
	}

	public float getTimeAllocated() {
		return timeAllocated;
	}

	public int getRemainingCapacity() {
		return remainingCapacity;
	}

}// end FFDAlgorithm