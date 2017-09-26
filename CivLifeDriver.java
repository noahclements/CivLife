package civLife;

import java.util.Scanner;
import java.util.concurrent.*;
public class CivLifeDriver {
	
	private static Resource wood = new Resource("WOOD",100);
	private static Resource stone = new Resource("STONE",100);
	private static Resource food = new Resource("FOOD",100);
	
	private static PersonType farmer = new PersonType("FARMER", 10);
	private static PersonType fighter = new PersonType("FIGHTER", 0);			
	private static PersonType lumberjack = new PersonType("LUMBERJACK", 10);
	private static PersonType miner = new PersonType("MINER",10);
	private static int month = 0;
	private static int year = 0;
	
	public static void main(String[] args) {
		
		

		
		Scanner civNameScan = new Scanner(System.in);
		String civNameInput;
		boolean validName = false;
		
		//opening screen, allows user to enter name
		System.out.println("Welcome to our text based civilization game!!");
		System.out.println("To begin enter your name");
		civNameInput = civNameScan.nextLine();
		
		//check if name is valid
		while(!validName){
			if(civNameInput.equals("")||civNameInput.length()<2||civNameInput.length()>12){
				System.out.println("Please enter a valid name");
				civNameInput = civNameScan.nextLine();
			}
			else
				validName = true;
		}
		//displays the main menu
		System.out.println();
		menu(civNameInput);
		
	}//end main
	
	//main menu method
	public static void menu(String civNameInput) {
		
		Scanner menuScan = new Scanner(System.in);
		String userInput;
		boolean done = false;
		
		//layout of main screen
		System.out.println("       MENU              " + civNameInput + "s" + " civilization");
		System.out.println("-----------------------------------------------");
		System.out.println("(V)iew Rescources		 Y: " + year + "  " + "M: " + month);
		System.out.println("(G)ather Resources");
		System.out.println("(P)opulation");
		
		//User decides whether they wan to view or gather resources
		while(!done)
		{
			userInput = menuScan.nextLine();
			
			if(userInput.equals("V")||userInput.equals("v")) {
				System.out.println();
				viewResources(civNameInput);
				done = true;
			}
			else if(userInput.equals("G")||userInput.equals("g")) {
				System.out.println();
				gatherResourceMenu(civNameInput);
				done = true;
			}
			else if(userInput.equals("P")||userInput.equals("p")){
				System.out.println();
				viewPopulation(civNameInput);
				done = true;				
			}
		}	
	}//end menu
	
	//View resources menu method
	public static void viewResources(String civNameInput) {
		Scanner viewScan = new Scanner(System.in);
		String userViewInput;
		boolean done = false;
		
		//layout for viewing resources menu
		System.out.println("  YOUR RESOURCES   ");
		System.out.println("-------------------");
		System.out.println(wood.getResourceName() + ": " + wood.getResourceAmount());
		System.out.println(stone.getResourceName() + ": " + stone.getResourceAmount());
		System.out.println(food.getResourceName() + ": " + food.getResourceAmount());
		System.out.println("(B)ack");
		
		//If the user wants to go back to main menu
		while(!done) {
			userViewInput = viewScan.nextLine();
			
			if(userViewInput.equals("B")||userViewInput.equals("b")) {
				System.out.println();
				menu(civNameInput);
				done = true;
			}
		}
	}//end viewResource menu
	
	//gather resources menu method
	public static void gatherResourceMenu(String civNameInput) {
			
		Scanner gatherScan = new Scanner(System.in);
		String gatherAnswer;
		boolean properAnswer = false;
		
		//layout for gather resources menu
		System.out.println("WHAT RESOURCE WOULD YOU LIKE TO GATHER?");
		System.out.println("---------------------------------------");
		System.out.println("(1) "+ wood.getResourceName());
		System.out.println("(2) "+ stone.getResourceName());
		System.out.println("(3) "+ food.getResourceName());
	
		while(!properAnswer) {
			
			gatherAnswer = gatherScan.nextLine();
			
			//if user wants to gather wood
			if(gatherAnswer.equals("1")) {
				System.out.println();
				System.out.println("Gathering wood...");
				System.out.println();
				try {
					TimeUnit.SECONDS.sleep(2);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}	
				System.out.println(civNameInput +", wood has been gathered! You gained: " + wood.gatherResource(wood,lumberjack.getTypePopulation()));
				System.out.println("Current amount of wood: " + wood.getResourceAmount());
				System.out.println();
				properAnswer = true;
				
				//updates the current month
				month++;
				if(month == 13){
					year++;
					month = 0;
				}
			}
			
			//if the user wants to gather stone
			else if(gatherAnswer.equals("2")) {
				System.out.println();
				System.out.println("Gathering stone...");
				System.out.println();
				try {
					TimeUnit.SECONDS.sleep(2);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}	
				System.out.println(civNameInput +", stone has been successfully gathered! You gained: " + stone.gatherResource(stone,miner.getTypePopulation()));
				System.out.println("Current amount of stone: " + stone.getResourceAmount());
				System.out.println();
				properAnswer = true;
				
				//updates the current month
				month++;
				if(month == 13){
					year++;
					month = 0;
				}
			}
			
			//if the user wants to gather food
			else if(gatherAnswer.equals("3")) {
				System.out.println();
				System.out.println("Finding and collecting food...");
				System.out.println();
				try {
					TimeUnit.SECONDS.sleep(2);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}	
				System.out.println(civNameInput +", food has been found and gathered! You gained: " + food.gatherResource(food,farmer.getTypePopulation()));
				System.out.println("Current amount of food: " + food.getResourceAmount());
				System.out.println();
				properAnswer = true;
				
				//updates the current month
				month++;
				if(month == 13){
					year++;
					month = 0;
				}
			}
			
			//if the user enters an invalid option
			else {
				System.out.println("Please enter a valid input");
			}
		}
		System.out.println();	
		menu(civNameInput);
	}//end gatherResource menu
	
	public static void viewPopulation(String civNameInput){
		Scanner viewPopScan = new Scanner(System.in);
		String userInput;
		boolean done = false;
		
		//layout for population menu
		System.out.println("CURRENT POPULATION");
		System.out.println("------------------");
		System.out.println("FARMERS: " + farmer.getTypePopulation());
		System.out.println("FIGHTERS: " + fighter.getTypePopulation());
		System.out.println("MINER: " + miner.getTypePopulation());
		System.out.println("LUMBERJACK: " + lumberjack.getTypePopulation());
		System.out.println("(B)ack");
		
		//If the user wants to go back to main menu
		while(!done) {
			userInput = viewPopScan.nextLine();
			
			if(userInput.equals("B")||userInput.equals("b")) {
				System.out.println();
				menu(civNameInput);
				done = true;
			}
		}		
	}
}//end class
