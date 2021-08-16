import java.util.*;

public class Task implements ITask
//, Comparable<Task> {
{

	private int id;
	private ArrayList<Parcel> parcelList;
	private Algorithm FFDResult;
	private Algorithm BFDResult;
	public Parcel m_Parcel;
	public Algorithm m_Algorithm;


	public Task(int id){
		this.id = id;
		this.parcelList = null;
		this.FFDResult = null;
		this.BFDResult = null;
	}

	public Task(int id, ArrayList<Parcel> parcelList, Algorithm FFDResult, Algorithm BFDResult){
		this.id = id;
		this.parcelList = parcelList;
		this.FFDResult = FFDResult;
		this.BFDResult = BFDResult;
	}

	public void addParcel(Parcel parcel){
		parcelList.add(parcel);
	}

	public int getId(){
		return id;
	}

	public Algorithm getFFDResult(){
		return FFDResult;
	}

	public Algorithm getBFDResult(){
		return BFDResult;
	}

	public ParcelList getParcelList(){
		return ParcelList;
	}

	/**
	 * 
	 * @param FFDResult
	 */
	public void setFFDResult(Algorithm FFDResult){
		this.FFDResult = FFDResult;
	}

	/**
	 * 
	 * @param BFDResult
	 */
	public void setBFDResult(Algorithm BFDResult){
		this.BFDResult = BFDResult;
	}
	
	
	
	@Override
	public ArrayList<Parcel> getParcelList() {
		// TODO Auto-generated method stub
		return null;
	}
}//end Task