import java.util.ArrayList;

public class Parcel {

	private double weight;
	private static final int MAX_WEIGHT = 20;
	private static String WEIGHT_UNIT = "KG";
	
	public double getWeight(){
		return weight;
	}
	
	public int getMaxWeight() {
		return MAX_WEIGHT;
	}

	public Parcel(double weight){
		this.weight = weight;
	}

}//end Parcel