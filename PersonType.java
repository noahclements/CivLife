//Creates a personType object with a name and population
public class PersonType {
	private String name;
	private int typePopulation;
	
	public PersonType(String nameIn, int popIn){
		name = nameIn;
		typePopulation = popIn;
	}
	
	public String getName(){
		return name;
	}
	
	public int getTypePopulation(){
		return typePopulation;
	}
}
