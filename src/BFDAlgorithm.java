

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
		
		long BFDStart = System.currentTimeMillis();
		
		for(int i = 0; i < parcelList.size(); i++) { //while there is parcel, continue looping
			
			int j;
			int min = allocatedTrucks.get(0).getMaxCapacity() + 1; //initialize minimum space
			int bestTruck = 0; //initialize best truck
			
			for(j = 0; j < allocatedTrucks.size(); j++) {
				//if trucks remaining capacity larger than parcel weight AND
				//(remaining capacity - parcel weight) lesser than minimum capacity
				if(allocatedTrucks.get(j).getRemainingCapacity() >= parcelList.get(i).getWeight() && allocatedTrucks.get(j).getRemainingCapacity() - parcelList.get(i).getWeight() < min) {
					bestTruck = j; //set best bin to this truck
					min = allocatedTrucks.get(j).getRemainingCapacity() - parcelList.get(i).getWeight();
				}
			}
			
			//If no trucks can accomodate the parcel, create new truck
			if(min == allocatedTrucks.get(0).getMaxCapacity() + 1) {
				allocatedTrucks.add(new Truck());
				allocatedTrucks.get(allocatedTrucks.size()).deductCapacity(parcelList.get(i).getWeight());
			}
			
			//assign parcel to best truck
			else {
				allocatedTrucks.get(bestTruck).deductCapacity(parcelList.get(i).getWeight());
			}
		}
		
		long BFDEnd = System.currentTimeMillis();
		
		timeAllocated = BFDEnd - BFDStart;
		
		for(int r; r < allocatedTrucks.size(); r++) {
			remainingCapacity += allocatedTrucks.get(r).getRemainingCapacity();
		}
	}
	
	public float getTimeAllocated() {
		return timeAllocated;
	}
	
	//remaining capacity for all algorithms same
	public float getRemainingCapacity() {
		return remainingCapacity;
	}
	
	
	public static void main(String[] args) {
		allocatedTrucks.add(new Truck());
		System.out.println(allocatedTrucks.size());
	}
}//end BFDAlgorithm