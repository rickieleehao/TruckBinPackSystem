

/**
 * @author RickiE
 * @version 1.0
 * @created 30-Jul-2021 10:27:07 AM
 */

import java.util.ArrayList;

public class BFDAlgorithm extends Algorithm {

	private static ArrayList<Truck> allocatedTrucks;
	
	public BFDAlgorithm(){
		
	}

	/**
	 * 
	 * @param parcelList
	 */
	public BFDAlgorithm(ArrayList<Parcel> parcelList){
		
	}

	/**
	 * 
	 * @param allocatedTrucks
	 * @param timeAllocated
	 * @param remainingCapacity
	 */
	public BFDAlgorithm(ArrayList<Truck> allocatedTrucks, float timeAllocated, int remainingCapacity){
		this.allocatedTrucks = allocatedTrucks;
	}

	private void generateAllocatedTrucks(){

	}
	
	public static void main(String[] args) {
		allocatedTrucks.add(new Truck());
		System.out.println(allocatedTrucks.size());
	}
}//end BFDAlgorithm