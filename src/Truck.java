import java.util.ArrayList;

/**
 * @author RickiE
 * @version 1.0
 * @created 30-Jul-2021 10:27:08 AM
 */
public class Truck {

	private ArrayList<Parcel> containedParcel;
	private static String CAPACITY_UNIT = KG;
	private static int MAX_CAPACITY = 20;
	public Parcel m_Parcel;
	private int remainingCapacity = 20;

	public Truck(){

	}

	public void finalize() throws Throwable {

	}
	/**
	 * 
	 * @param id
	 */
	public void Truck(int id){

	}

	public void addParcel(){

	}
	
	public void deductCapacity(int parcelWeight) {
		remainingCapacity -= parcelWeight;
	}
	
	public int getRemainingCapacity() {
		return remainingCapacity;
	}

	public int getMaxCapacity(){
		return MAX_CAPACITY;
	}
	
	public void setRemainSpace(int remainSpace) {
		
	}

	public ArrayList<Parcel> getContainedParcel(){
		return null;
	}
}//end Truck