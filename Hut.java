package civLife;

public class Hut implements Building {
	private int woodCost;
	private int stoneCost;
	private final String name; //i'm so dumb with interfaces so bear with me here
	private int hutLevel;
	private int numOfHuts;
	
	public Hut(int woodCostIn, int stoneCostIn) {
		woodCost = woodCostIn;
		stoneCost = stoneCostIn;
		
		name = "hut";
		numOfHuts = 0;
		hutLevel = 1;
	}
	@Override
	public boolean purchaseBuilding(int woodResource, int stoneResource) {
		if(woodResource >= woodCost && stoneResource >= stoneCost) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public String getBuildingName() {
		return name;
	}

	@Override
	public int getBuildingLevel() {

		return hutLevel;
	}

	@Override
	public int getStonePrice() {
		
		return stoneCost;
	}
	
	//@Override
	public int getWoodPrice() {
		return woodCost;
	}
	
	public void changeBuildingLevel() {
		hutLevel++;
	}
	public int getNumOfHuts(){
		return numOfHuts;
	}
	
	public void addHut() {
		numOfHuts++;
	}

}
