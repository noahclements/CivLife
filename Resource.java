//Class that creates a resource object
public class Resource {
	private String resourceName;
	private int resourceAmount = 0;
	
	//Constructor method, accepts the resource name and the current amount of that resource
	public Resource(String resourceNameIn, int resourceAmountIn){
		resourceName = resourceNameIn;
		resourceAmount = resourceAmountIn;
	}
	//Gets the name of the resource
	public String getResourceName(){
		return resourceName;
	}
	//Gets the amount of that resource
	public int getResourceAmount(){
		return resourceAmount;
	}
	//Gather more of that resource, them add it to the current total
	public void gatherResource(Resource other){
		int gatheredAmount = 0;	
		gatheredAmount = (int)(Math.random()*25 + 1);
		
		other.getResourceAmount() += gatheredAmount;
	}
}

