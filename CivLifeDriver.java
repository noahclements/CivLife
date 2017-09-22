import java.util.Scanner;

public class CivLifeDriver {
	public static void main(String[] args) {

		Resource wood = new Resource("WOOD",100);
		Resource stone = new Resource("STONE",100);
		Resource food = new Resource("FOOD",100);
		
		Scanner civNameScan = new Scanner(System.in);
		String civNameInput;
		
		System.out.println("Welcome to our text based civilization game!!");
		System.out.println("To begin enter your name");
		civNameInput = civNameScan.nextLine();
		
		menu(wood,stone,food,civNameInput);
	}
	
	public static void menu(Resource wood, Resource stone, Resource food, String civNameInput) {
		
		Scanner menuScan = new Scanner(System.in);
		String userInput;
		boolean done = false;
			
		System.out.println("       MENU              " + civNameInput + "s" + " civilization");
		System.out.println("-----------------------------------------------");
		System.out.println("(V)iew Rescources");
		System.out.println("(G)ather Resources");
		
		while(!done)
		{
			userInput = menuScan.nextLine();
			
			if(userInput.equals("V")||userInput.equals("v")) {
				viewResources(wood,stone,food,civNameInput);
				done = true;
			}
			else if(userInput.equals("G")||userInput.equals("g")) {
				gatherResourceMenu(wood,stone,food,civNameInput);
				done = true;
			}
		}	
	}
	
	public static void viewResources(Resource wood, Resource stone, Resource food, String civNameInput) {
		Scanner viewScan = new Scanner(System.in);
		String userViewInput;
		boolean done = false;
		
		System.out.println("  YOUR RESOURCES   ");
		System.out.println("-------------------");
		System.out.println(wood.getResourceName() + ": " + wood.getResourceAmount());
		System.out.println(stone.getResourceName() + ": " + stone.getResourceAmount());
		System.out.println(food.getResourceName() + ": " + food.getResourceAmount());
		System.out.println("(B)ack");
		
		while(!done) {
			userViewInput = viewScan.nextLine();
			
			if(userViewInput.equals("B")||userViewInput.equals("b")) {
				menu(wood,stone,food,civNameInput);
				done = true;
			}
		}
	}
		
	public static void gatherResourceMenu(Resource wood, Resource stone, Resource food, String civNameInput) {
			
		Scanner gatherScan = new Scanner(System.in);
		String gatherAnswer;
		boolean properAnswer = false;
			
		System.out.println("WHAT RESOURCE WOULD YOU LIKE TO GATHER?");
		System.out.println("---------------------------------------");
		System.out.println("(1) "+ wood.getResourceName());
		System.out.println("(2) "+ stone.getResourceName());
		System.out.println("(3) "+ food.getResourceName());
	
		while(!properAnswer) {
			
			gatherAnswer = gatherScan.nextLine();
				
			if(gatherAnswer.equals("1")) {
					
				System.out.println(civNameInput +", wood has been gathered! You gained: " + wood.gatherResource(wood));
				System.out.println("Current amount of wood: " + wood.getResourceAmount());
				System.out.println();
				properAnswer = true;
			}
			else if(gatherAnswer.equals("2")) {
					
				System.out.println(civNameInput +", stone has been successfully gathered! You gained: " + stone.gatherResource(stone));
				System.out.println("Current amount of stone: " + stone.getResourceAmount());
				System.out.println();
				properAnswer = true;
			}
			else if(gatherAnswer.equals("3")) {
					
				System.out.println(civNameInput +", food has been found and gathered! You gained: " + food.gatherResource(food));
				System.out.println("Current amount of food: " + food.getResourceAmount());
				System.out.println();
				properAnswer = true;
			}
			else {
				System.out.println("Please enter a valid input");
			}
		}
			
		menu(wood,stone,food, civNameInput);
	}
}