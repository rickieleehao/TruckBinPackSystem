

/**
 * @author RickiE
 * @version 1.0
 * @created 30-Jul-2021 10:27:07 AM
 */
public class Task implements ITask {

	private int id;
	private ArrayList<Parcel> parcelList;
	private Algorithm FFDResult;
	private Algorithm BFDResult;
	public Parcel m_Parcel;
	public Algorithm m_Algorithm;



	public void finalize() throws Throwable {

	}
	public Task(){

	}

	/**
	 * 
	 * @param id
	 * @param parcelList
	 * @param FFDResult
	 * @param BFDResult
	 */
	public Task(int id, ArrayList<Parcel> parcelList, Algorithm FFDResult, Algorithm BFDResult){

	}

	/**
	 * 
	 * @param parcel
	 */
	public void addParcel(Parcel parcel){

	}

	public int getId(){
		return 0;
	}

	public Algorithm getFFDResult(){
		return null;
	}

	public Algorithm getBFDResult(){
		return null;
	}

	public ParcelList getParcelList(){
		return null;
	}

	/**
	 * 
	 * @param FFDResult
	 */
	public void setFFDResult(Algorithm FFDResult){

	}

	/**
	 * 
	 * @param BFDResult
	 */
	public void setBFDResult(Algorithm BFDResult){

	}
}//end Task