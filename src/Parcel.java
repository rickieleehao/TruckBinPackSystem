import java.util.ArrayList;

public class Parcel {

	private int weight;
	private static final int MAX_WEIGHT = 20;
	private static String WEIGHT_UNIT = "KG";
	
	public int getWeight(){
		return weight;
	}
	
	public int getMaxWeight() {
		return MAX_WEIGHT;
	}

	public Parcel(int weight){
		
		this.weight = weight;

	}

}//end Parcel