//the Interface for buildings
package civLife;

public interface Building {
	
	boolean purchaseBuilding(int woodResource, int stoneRescource);
	String getBuildingName();
	int getBuildingLevel();
	int getStonePrice();
	int getWoodPrice();
	void changeBuildingLevel();
}
