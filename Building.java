package civLife;
import java.util.List; 

public interface Building {
	
	boolean purchaseBuilding(int woodResource, int stoneRescource);
	String getBuildingName();
	int getBuildingLevel();
	List<Integer> getBuildingPrice();// this is iffy maybe use arrays? probably over complicating it
}
