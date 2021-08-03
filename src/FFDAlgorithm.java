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
	int[] capacityRem = new int[parcelList.size()];
	
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
	}
	
	

	private void generateAllocatedTrucks(){
		
		
		int[] capacityRem = new int[parcelList.size()];
		
		for(int i = 0; i < parcelList.size(); i++) {
			
			int j;
			
			for(j = 0; j )
		}
	}
	
	private int n = 0;
	private int size = 0;
					
	private void recursiveFFD(int n) {
		
		if(n == (parcelList.size() - 1)) {
			FFD(n);
			}
		
		else {
			FFD(n);
			recursiveFFD(n + 1);
		}
		
		
	}
	
	private void FFD(int i) {
		int j;
		
		for(j = 0; j < allocatedTrucks.size(); j++) {
			if(allocatedTrucks.get(j).getRemainSpace() >= parcelList.get(n).getWeight()) {
				int remainSpace = allocatedTrucks.get(j).getRemainSpace() - parcelList.get(n).getWeight();
				allocatedTrucks.get(j).setRemainSpace(remainSpace);
				break;
			}
		}
		
		if(j == allocatedTrucks.size()) {
			int remainSpace = allocatedTrucks.get(j).getMaxCapacity() - parcelList.get(n).getWeight();
			allocatedTrucks.get(j).setRemainSpace(remainSpace);
			allocatedTrucks.add(new Truck());
			
		}
	}
	

	
	
}//end FFDAlgorithm