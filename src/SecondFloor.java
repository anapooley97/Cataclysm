import java.util.Scanner;



public class SecondFloor {

	public static boolean[] inventory = new boolean[6];
	// 0 = Flashlight
	// 1 = Key 1
	// 2 = Sword
	// 3 = Cookies
	// 4 = Shield
	
	public static void Introduction(){
		
		for(int x = 0; x<6; x++){
			if(x<4){
				inventory[x] = true;
			}
			else{
				inventory[x] = false;
			}
		}
		
		Scanner reader = new Scanner(System.in);
		
		System.out.println("In front of you there is a room that is labeled “Storage”. "
				+ "\nTo your right you hear sound of crying that make you feel uneasy.");
		
		boolean quit = false;
		
		while(quit == false){
			String response = reader.nextLine();
			if(response.equals("move right") || response.equals("go right")){
				System.out.println("You are too afraid to go towards those sounds.");
			}
			else if(response.equals("move forward") || response.equals("go forward") || response.equals("walk forward")){
				StorageDoor();
			}
			else{
				System.out.println("Not a valid option.");
			}
		}
		
	}
	
	public static void StorageDoor(){
		System.out.println("\nYou are now in front of the storage room door."
				+ "\nThe door knob to the storage room is covered in dust and looks although it has been abandoned.");
		
		Scanner reader = new Scanner(System.in);
		
		boolean quit = false;
		
		while(quit == false){
			String response = reader.nextLine();
			if(response.equals("move back") || response.equals("go back") || response.equals("exit") || response.equals("leave") || response.equals("walk out") || response.equals("exit room") || response.equals("leave room")){
				System.out.println("You go back to the base of the stairs.");
				Introduction();
			}
			else if(response.equals("open door")){
				StorageRoom();
			}
			else{
				System.out.println("Not a valid option.");
			}
		}
		
	}
	
	public static void StorageRoom(){
		
		System.out.println("Inside there are many dusty cardboard boxes. Maybe something useful is inside one.");
		
		Scanner reader = new Scanner(System.in);
		
		boolean quit = false;
		
		while(quit == false){
			String response = reader.nextLine();
			
			if(response.equals("open boxes") || response.equals("open box") || response.equals("search box") || response.equals("search boxes")){
				System.out.println("\nIn one of the boxes you see a dusty metal shield.");
				boolean shield = false;
				while(shield == false){
					String takeShield = reader.nextLine();
					if(takeShield.equals("take shield") || takeShield.equals("grab shield")){
						inventory[5] = true;
						System.out.println("\nObtained: Shield.");
						quit = true;
					}
					else{
						System.out.println("\nNot a valid option.");
					}
				}
			}
			
		}
		
		System.out.println("\nMaybe there were rooms that you missed in the hallway.");
		
		quit = false;
		
		while(quit == false){
			String response = reader.nextLine();
			if(response.equals("exit room") || response.equals("go back") || response.equals("move back") || response.equals("leave room")){
				Hallway1();
				quit = true;
			}
			else{
				System.out.println("Not a valid option.");
			}
		}
		
	}
	
	private static void Hallway1(){
		System.out.println("You are once again in the hallway and to your left there is another room, this room is unnamed.");
		
		Scanner reader = new Scanner(System.in);
		
		boolean quit = false;
		
		while(quit == false){
			
			String response = reader.nextLine();
			
			if(response.equals("move left")){
				
				System.out.println("This room is also locked, the door seems to be irreparably broken. To your left there are "
						+ "\nstairs, but the floorboards are broken and the gap cannot be jumped. You will need to find "
						+ "\nanother way down.");
				
				System.out.println("\nTo the right you see the kitchen, the problem is that that is where the sounds are coming from. "
						+ "\nThere is no other choice.");
				
				response = reader.nextLine();
				
				if(response.equals("move left")){
					KitchenDoor();
					quit = true;
				}
				else{
					System.out.println("Not a valid option.");
				}
				
			}
			else{
				System.out.println("Not a valid option.");
			}
			
		}
		
	}
	
	public static void KitchenDoor(){
		
		System.out.println("\nYou find yourself before the door to the kitchen, you hear the crying is coming "
				+ "\nfrom inside. The door is already slightly open.");
		
		boolean quit = false;
		
		Scanner reader = new Scanner(System.in);
		
		while(quit == false){
		
			String response = reader.nextLine();
			
			if(response.equals("open door")){
				Kitchen();
				quit = true;
			}
			else if(response.equals("help")){
				System.out.println("\nSuggested option:\n'open door'");
			}
			else{
				System.out.println("\nNot a valid option.");
			}
			
		}
		
	}
	
	public static void Kitchen(){
		
		System.out.println("You slowly use one hand to open the door. As it creaks open you see a small boy inside, "
				+ "\nhe has the same transparent look as the dog. He's definitely a ghost. In front of the "
				+ "\nboy there is a game, once he sees you the crying stops. The Ghost Boy looks as though "
				+ "\nhe is lonely, with no one to play with him. He waves his hands in a way as though "
				+ "\nurging you to play with him. You sit down in front of him and you recognize the game.");
		
		System.out.println("\nFour different numbers will be chosen from the values 1-6. "
				+ "\nAll you must do is guess the correct four numbers in the correct order.");	
	
		Game();
		
	}
	
	public static boolean Game(){
		
		GuessNumberGame guessNumberGame = new GuessNumberGame();
		
		boolean winGame = false;
		
		winGame = guessNumberGame.mainGameMethod();
		
		return winGame;
		
	}
	
}
