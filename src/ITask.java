

/**
 * @author RickiE
 * @version 1.0
 * @created 30-Jul-2021 10:27:07 AM
 */
public interface ITask {

	/**
	 * 
	 * @param parcel
	 */
	public void addParcel(Parcel parcel);

	public int getId();

	public ArrayList<Parcel> getParcelList();

	public Algorithm getFFDResult();

	public Algorithm getBFDResult();

	/**
	 * 
	 * @param algorithm
	 */
	public void setFFDResult(Algorithm algorithm);

	/**
	 * 
	 * @param algorithm
	 */
	public void setBFDResult(Algorithm algorithm);

}