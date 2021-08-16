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
	
	public FFDAlgorithm(){

	}

	public void finalize() throws Throwable {
		super.finalize();
	}
	/**
	 * 
	 * @param parcelList
	 */
	public FFDAlgorithm(ArrayList<Parcel> parcelList){
		Collections.sort(parcelList, new SortByWeight()); //sort by comparator
		this.parcelList = parcelList;
			
	}
	
	//not sure put at where yet
	class SortByWeight implements Comparator<Parcel> {
		public int compare(Parcel a, Parcel b) {
			return b.getWeight() - a.getWeight(); //order in decreasing order
		}
	}

	/**
	 * 
	 * @param allocatedTrucks
	 * @param timeAllocated
	 * @param remainingCapacity
	 */
	public FFDAlgorithm(ArrayList<Truck> allocatedTrucks, float timeAllocated, int remainingCapacity){
		this.allocatedTrucks = allocatedTrucks;
		this.timeAllocated = timeAllocated;
		this.remainingCapacity = remainingCapacity;
	}
	
	

	public void generateAllocatedTrucks(){
		
		long FFDStart = System.currentTimeMillis();
		
		for(int i = 0; i < parcelList.size(); i++)
		{
		int j;
		
		for(j = 0; j < allocatedTrucks.size(); j++) {
			if(allocatedTrucks.get(j).getRemainSpace() >= parcelList.get(i).getWeight()) {
				int remainSpace = allocatedTrucks.get(j).getRemainSpace() - parcelList.get(i).getWeight();
				allocatedTrucks.get(j).setRemainSpace(remainSpace);
				break;
			}
		}
		
		//If no trucks can accomodate the parcel, create new truck
		if(j == allocatedTrucks.size()) {
			int remainSpace = allocatedTrucks.get(j).getMaxCapacity() - parcelList.get(i).getWeight();
			allocatedTrucks.get(j).setRemainSpace(remainSpace);
			allocatedTrucks.add(new Truck());
			
			}
		}
		
		long FFDEnd = System.currentTimeMillis();
		
		timeAllocated = FFDEnd - FFDStart;
	}
	
	public float getTimeAllocated() {
		return timeAllocated;
	}
	
	public int getRemainingCapacity() {
		return remainingCapacity;
	}
	

	
	
}//end FFDAlgorithm