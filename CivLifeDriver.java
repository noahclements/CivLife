package civLife;

import java.util.Scanner;

public class CivLifeDriver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Resource wood = new Resource("WOOD",100);
		Resource stone = new Resource("STONE"100);
		Resource food = new Resource("FOOD",100);
		//int month = 0;
		
		menu(wood,stone,food);
		
		

	}
	
	public static void menu(Resource wood,stone,food ) {
		
		Scanner menuScan = new Scanner(System.in);
		String userInput;
		boolean done = false;
		
		System.out.println("       MENU        ");
		System.out.println("-------------------");
		System.out.println("(V)iew Rescources");
		System.out.println("(G)ather Resources");
		
		while(!done)
		{
			userInput = menuScan.nextLine();
			
			if(userInput.equals("V")) {
				viewResources();
				done = true;
			}
			else if(userInput.equals("G")) {
				gatherResourceMenu(wood,stone,food);
				done = true;
			}
		}
		
	}
	
	public void viewResources(Resource wood,stone,food) {
		Scanner viewScan = new Scanner(System.in);
		String userViewInput;
		boolean done = false;
		
		System.out.println("  YOUR RESOURCES   ");
		System.out.println("-------------------");
		System.out.println(wood.getResourceName() + ": " + wood.getResourceAmount());
		System.out.println(stone.getResourceName() + ": " + stone.getResourceAmount());
		System.out.println(food.getResourceName() + ": " + food.getResourceAmount());
		
		while(!done) {
			userViewInput = viewScan.nextLine();
			
			if(userViewInput.equals("B")) {
				menu(wood,stone,food);
				done = true;
			}
		}
	}
		
	public void gatherResourceMenu(Resource wood,stone,food) {
			
		Scanner gatherScan = new Scanner(System.in);
		String gatherAnswer;
		boolean properAnswer = false;
			
		System.out.println("WHAT RESOURCE WOULD YOU LIKE TO GATHER?");
		System.out.println("---------------------------------------");
		System.out.println("(1) "+ wood.getResourceName());
		System.out.println("(2) "+ stone.getResourceName());
		System.out.println("(3) "+ food.getResourceName());
	
		while(!properAnswer) {
			
			gatherAnswer = viewScan.nextLine();
				
			if(gatherAnswer.equals("1")) {
					
				gatherResource(wood);
				properAnswer = true;
			}
			else if(gatherAnswer.equals("2")) {
					
				gatherResource(stone);
				properAnswer = true;
			}
			else if(gatherAnswer.equals("3")) {
					
				gatherResource(food);
				properAnswer = true;
			}
			else {
				System.out.println("Please enter a valid input");
			}
		}
			
		menu(wood,stone,food);
	}

}
