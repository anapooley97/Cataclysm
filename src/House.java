import java.util.Scanner;

//import java.io.*;

public class House {

	public static boolean[] inventory = new boolean[4];
	// 0 = Flashlight
	// 1 = Key 1
	// 2 = Sword
	// 3 = Cookies
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//Display output
		
		ThirdFloor thirdFloor = new ThirdFloor();

		
		//INTRODUCTION
		ThirdFloor.Introduction();
		
		//ROOMS ON THIRD FLOOR	
		
		System.out.println("You see a single door. The walls are covered with eerie portraits of unfamiliar faces."
				+ "\nThere is also a flashlight on the table beside you.");
		
		//Beginning Options
		System.out.println("\nSuggested Options:\n'open door'\n'examine bed'\n'move bed'\n'examine paintings'\n'take flashlight");
		
		thirdFloor.Bedroom();
		
		thirdFloor.Hallway1();
		
		thirdFloor.SwordRoom();
		
		thirdFloor.Hallway2();
		
		//YUM DA COOKIES EXIST
		boolean cookies = thirdFloor.CheckCookies();
		
		if(cookies == true){
			inventory[3] = true;
		}
		
		//-------------------------------------
		//SECOND FLOOR
		
		boolean winGame = false;
		
		while(winGame == false){
		
			SecondFloor secondFloor = new SecondFloor();
			
			System.out.println("Now you have arrived at the 2nd floor.");
		
			secondFloor.Introduction();
			
			winGame = secondFloor.Game();
		
		}
		
		//-----------------------------------------
		//OUTSIDE
		
		Outside outside = new Outside();
		
		boolean winFight = false;
		
			while (winFight == false){
				
					winFight = outside.Introduction();
	
					if(winFight == true){
						System.out.println("\nYou defeated the ghost.\n");
						System.out.println("\n--------------------------------------------------\n\n");
						outside.Ending();
					}
					else{
						System.out.println("\nYou were defeated. Game over. Try again.");
						System.out.println("\n--------------------------------------------------\n\n");
						winFight = outside.Introduction();
					}
			}
		
		
	}

	
}
