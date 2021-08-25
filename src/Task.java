import java.util.*;

public class Task implements ITask {
	private int id;
	private ArrayList<Parcel> parcelList;
	private Algorithm FFDResult;
	private Algorithm BFDResult;

	public Task(int id) {
		this.id = id;
		this.parcelList = new ArrayList<Parcel>();
		this.FFDResult = null;
		this.BFDResult = null;
	}

	public Task(int id, ArrayList<Parcel> parcelList) {
		this.id = id;
		this.parcelList = parcelList;
	}

	@Override
	public void addParcel(Parcel parcel) {
		this.parcelList.add(parcel);
	}

	@Override
	public int getId() {
		return this.id;
	}

	@Override
	public ArrayList<Parcel> getParcelList() {
		return this.parcelList;
	}

	@Override
	public Algorithm getFFDResult() {
		return this.FFDResult;
	}

	@Override
	public Algorithm getBFDResult() {
		return this.BFDResult;
	}

	@Override
	public void setFFDResult(Algorithm FFDResult) {
		this.FFDResult = FFDResult;
	}

	@Override
	public void setBFDResult(Algorithm BFDResult) {
		this.BFDResult = BFDResult;
	}
}