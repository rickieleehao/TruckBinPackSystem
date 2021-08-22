import java.util.ArrayList;

public interface ITask {

	public void addParcel(Parcel parcel);

	public int getId();

	public ArrayList<Parcel> getParcelList();

	public Algorithm getFFDResult();

	public Algorithm getBFDResult();

	public void setFFDResult(Algorithm algorithm);

	public void setBFDResult(Algorithm algorithm);
}