

/**
 * @author RickiE
 * @version 1.0
 * @created 30-Jul-2021 10:27:07 AM
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


public class BFDAlgorithm extends Algorithm {

	private ArrayList<Parcel> parcelList;
	private static ArrayList<Truck> allocatedTrucks;
	private float timeAllocated;
	private int remainingCapacity;
	
	public BFDAlgorithm(){
		
	}

	/**
	 * 
	 * @param parcelList
	 */
	public BFDAlgorithm(ArrayList<Parcel> parcelList){
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
	public BFDAlgorithm(ArrayList<Truck> allocatedTrucks, float timeAllocated, int remainingCapacity){
		this.allocatedTrucks = allocatedTrucks;
		this.timeAllocated = timeAllocated;
		this.remainingCapacity = remainingCapacity;
	}
	
	
	public void generateAllocatedTrucks(){
		
		int res = 0;
		
		long BFDStart = System.currentTimeMillis();
		
		for(int i = 0; i < res; i++) {
			
			int j, min = allocatedTrucks.get(0).getMaxCapacity() + 1, bi = 0;
			
			for(j = 0; j < allocatedTrucks.size(); j++) {
				if(allocatedTrucks.get(j).getRemainSpace() >= parcelList.get(i).getWeight() && allocatedTrucks.get(j).getRemainSpace() - parcelList.get(i).getWeight() < min) {
					bi = j;
					min = allocatedTrucks.get(j).getRemainSpace() - parcelList.get(i).getWeight();
				}
			}
			
			//If no trucks can accomodate the parcel, create new truck
			if(min == allocatedTrucks.get(0).getMaxCapacity() + 1) {
				int remainSpace = allocatedTrucks.get(0).getMaxCapacity() - parcelList.get(i).getWeight();
				allocatedTrucks.get(allocatedTrucks.size()).setRemainSpace(remainSpace);
				allocatedTrucks.add(new Truck());
			}
			
			else {
				int remainSpace = allocatedTrucks.get(bi).getRemainSpace() - parcelList.get(i).getWeight();
				allocatedTrucks.get(bi).setRemainSpace(remainSpace);
			}
		}
		
		long BFDEnd = System.currentTimeMillis();
		
		timeAllocated = BFDEnd - BFDStart;
	}
	
	public float getTimeAllocated() {
		return timeAllocated;
	}
	
	//remaining capacity for all algorithms same
	public float getRemainingSpace() {
		return remainingCapacity;
	}
	
	
	public static void main(String[] args) {
		allocatedTrucks.add(new Truck());
		System.out.println(allocatedTrucks.size());
	}
}//end BFDAlgorithm