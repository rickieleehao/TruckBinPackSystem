import java.util.ArrayList;
import java.util.Comparator;

/**
 * @author RickiE
 * @version 1.0
 * @created 30-Jul-2021 10:27:07 AM
 */
public abstract class Algorithm {

	private ArrayList<Parcel> parcelList;
	protected ArrayList<Truck> allocatedTruck;
	protected float timeAllocated;
	protected int remainingCapacity;
	public Truck m_Truck;

	public Algorithm(){

	}

	public void finalize() throws Throwable {

	}
	/**
	 * 
	 * @param allocatedTrucks
	 * @param timeAllocated
	 * @param remainingCapacity
	 */
	public Algorithm(ArrayList<Truck> allocatedTrucks, float timeAllocated, int remainingCapacity){
		
		this.allocatedTruck = allocatedTrucks;
		this.timeAllocated = timeAllocated;
		this.remainingCapacity = remainingCapacity;
		
	}

	/**
	 * 
	 * @param parcelList
	 */
	public Algorithm(ArrayList<Parcel> parcelList){
		
		this.parcelList = parcelList;
		
	}

	public ArrayList<Truck> getAllocatedTrucks(){
		return this.allocatedTruck;
	}

	public int getRemainingCapacity(){
		return this.remainingCapacity;		
	}

	public abstract void generateAllocatedTrucks(); //I changed to public (ze)

	public abstract float getTimeAllocated();
	
}//end Algorithm