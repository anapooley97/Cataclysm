import java.util.Scanner;

public class ThirdFloor {
	
	//Initialize inventory
	public static boolean[] inventory = new boolean[4];
	// 0 = Flashlight
	// 1 = Key 1
	// 2 = Sword
	// 3 = Cookies

public static void Introduction(){
	
	System.out.println("Instructions: This is a text-based adventure."
			+ " After each dialogue, type in \none of the following"
			+ " basic actions - move, examine, attack, open, use or take - followed \nby"
			+ " an object (eg. painting, chest, door)."
			+ "\nMove options include: forward, back, right, left."
			+ "\n\nNote: Many of the items found in rooms will be essential in completing the game.");
	
	System.out.println("----------------------------------");
	//Dialogue
	System.out.println("\nYou wake up in a bedroom of an unknown house with no memory of recent events.");
	
}
	
//CODE FOR BEDROOM
public static void Bedroom(){
		
		for(int x = 0; x<4; x++){
			inventory[x] = false;
		}
	
		Scanner reader = new Scanner(System.in);
		
		boolean quit = false;
		
		while(quit == false){
			System.out.println("\nChoose an option.");
			String response = reader.nextLine();
			quit = BedroomOptions(response);
		}
		
	}
	
//BEDROOM OPTIONS
	public static boolean BedroomOptions(String enteredResponse){
		
		Scanner bedroomReader = new Scanner(System.in);
		
		String response = enteredResponse;
		
		if(response.equals("open door")){
			
			return true;
		}
		
		//Examines bed
		else if(response.equals("examine bed")){
			//Displays dialogue
			System.out.println("\nThe bed is Twin sized with black sheets and a purple blanket.");
			
		}
		
		else if(response.equals("move bed")){
			
			if(inventory[1] == false){
				System.out.println("\nYou shift the bed and see a key underneath it.");
			
				System.out.println("\nSuggested Option: take key");
			
				while(inventory[1]!=true){
				
					String keyResponse = bedroomReader.nextLine();
			
					if(keyResponse.equals("take key")){
						inventory[1] = true;
						System.out.println("\nObtained: Key.");
						return false;
					}
					else if(!keyResponse.equals("take key")){
						System.out.println("Not a valid option.\nTry again.");
					}
				}
			}
			else{
				System.out.println("You already moved the bed.");
			}
		}
		
		else if(response.equals("examine paintings")){
			
			System.out.println("\nThere is a picture for each member of a family: Father, Mother, and Son."
					+ "\nYou wonder what became of them.");
			
		}
		
		else if(response.equals("take flashlight")){
			
			if(inventory[0] == false){
				System.out.println("\nObtained: Flashlight.");
				inventory[0] = true;
			}
			else{
				System.out.println("\nYou already have the flashlight.");
			}
			
		}
		else if(response.equals("help")){
			System.out.println("\nSuggested Options:\n'open door'\n'examine bed'");
			if(inventory[1] == false){
				System.out.println("'move bed'");
			}
			System.out.println("'examine paintings'");
			if(inventory[0] == false){
				System.out.println("'take flashlight'");
			}
		}
		else{
			
			System.out.println("Not a valid option.");
			
		}
		
		return false;
		
	}
	
//CODE FOR HALLWAY
	public static void Hallway1(){
		
		Scanner reader = new Scanner(System.in);
		
		System.out.println("\nAfter leaving the Bedroom, you lean over the banister and see a courtyard below in the center of the house. The two floors "
				+ "\nbeneath you are formatted the same way as the one you are currently on: one door per-wall.  There is a stairwell "
				+ "\nto your left. To your right there is a room that is labeled “Sword Room”. "
				+ "\nThere is a section of collapsed ceiling that has obstructed the way to the stairway.");
		
		System.out.println("\nSuggested Options: \n'move right'\n'move left'\n'move back'");
		
		System.out.println("\n[Suggested options are now being turned off."
				+ "\nIf you require assistence, you may type in 'help' for possible options.]");
		
		boolean quit = false;
		
		while(quit == false){
			System.out.println("\nChoose an option.");
			String response = reader.nextLine();
			quit = Hallway1Options(response);
		}
		
	}
	
//HALLWAY OPTIONS
	public static boolean Hallway1Options(String hallwayResponse){

		String response = hallwayResponse;
		
		if(response.equals("move left")){
			System.out.println("\nThe rubble is blocking your pathway to the stairs.");
			return false;
		}
		else if(response.equals("move right")){
			System.out.println("\nYou walk towards the Sword Room and open the door.");
			return true;
		}
		else if(response.equals("move back") || response.equals("go back")|| response.equals("exit") || response.equals("leave") || response.equals("walk out") || response.equals("exit room") || response.equals("leave room")){
			System.out.println("\nYou are now in the bedroom.");
			System.out.println("You see a single door. The walls are covered with eerie portraits of unfamiliar faces."
					+ "\nThere is also a flashlight on the table beside you.");
			Bedroom();
			Hallway1();
			return true;
		}
		else if(response.equals("help")){
			System.out.println("\nSuggested options:\n'move left'\n'move right'\n'move back'");
		}
		else{
			System.out.println("\nNot a valid option.");
		}
		
		return false;
	}
	
	//SWORD ROOM
	public static void SwordRoom(){
	
		Scanner reader = new Scanner(System.in);
		
		System.out.println("\nThe room is empty with the exception of an ornate glass case containing a silver short sword."
				+ "\nYou wonder how you can open it.");
		
		boolean quit = false;
		
		while(quit == false){	
			System.out.println("\nChoose an option.");
			String response = reader.nextLine();
			quit = SwordRoomOptions(response);
		}
		
	}
	
	public static boolean SwordRoomOptions(String swordRoomResponse){
		
		//Initializing shizzles
		Scanner swordReader = new Scanner(System.in);
		String response = swordRoomResponse;
		
		if(response.equals("open case")){
			System.out.println("\nThe case is locked.");
		}
		else if(response.equals("use key") || response.equals("unlock case")){
			
			if(inventory[1] == true && inventory[2] == false){
				System.out.println("\nThe key works! You lift the glass and see a sword.");
			
				String caseResponse = swordReader.nextLine();
			
				if(caseResponse.equals("take sword")){
					System.out.println("\nObtained: Sword.");
					inventory[2] = true;
				}
			}
			else if(inventory[2] == true){
				System.out.println("You already have the sword!");
			}
			else{
				System.out.println("\nYou don't have a key.");
			}
		}
		
		else if(response.equals("break glass") || response.equals("break case")){
			
			if(inventory[2] == false){
				
				System.out.println("\nYou broke the glass! You look through the broken glass and see a sword.");
			
				while(inventory[2] == false){
					String caseResponse = swordReader.nextLine();
			
					if(caseResponse.equals("take sword")){
						inventory[2] = true;
						System.out.println("\nObtained: Sword.");
					}
					else{
						System.out.println("\nTry again.");
					}
				
				}
			}
			else{
				System.out.println("\nYou already broke the glass and obtained the sword!");
			}
		}
		else if(response.equals("leave room") || response.equals("exit room") || response.equals("move back")){
			return true;
		}
		else if(response.equals("help")){
			System.out.println("\nSuggested options:\n'open case'\n'unlock case'\n'break glass'\n'move back'");
		}
		else{
			System.out.println("\nNot a valid option.");
		}
		
		return false;
	}
	
	public static void Hallway2(){
		
		Scanner reader = new Scanner(System.in);
		
		System.out.println("\nYou are back in the hallway and to the left there is the Bedroom and in front of you, "
				+ "\ndown the hall there is the unlabeled room.");
		
		boolean quit = false;
		
		while(quit == false){	
			System.out.println("\nChoose an option.");
			String response = reader.nextLine();
			quit = Hallway2Options(response);
		}
		
	}
	
	public static boolean Hallway2Options(String hallwayResponse){
		
		String response = hallwayResponse;
		
		if(response.equals("move forward")){
			UnlabeledRoom();
			return false;
		}
		else if(response.equals("move left")){
			System.out.println("\nYou are now in the bedroom.");
			Bedroom();
		}
		else if(response.equals("help")){
			System.out.println("\nSuggested options:\n'move forward'\n'move left'");
		}
		else{
			System.out.println("\nNot a valid option.");
		}
		return false;		
	}
	
	public static void UnlabeledRoom(){
	
		Scanner reader = new Scanner(System.in);
		
		System.out.println("\nYou stand in front of the door to the unlabeled room.");
		
		boolean quit = false;
		
		while(quit == false){
			String response = reader.nextLine();
		
			if(response.equals("open door")){
				System.out.println("\nThe handle is broken and the door cannot be opened.");
				quit = true;
			}
			else{
				System.out.println("\nNot a valid option.");
			}
		}
		
		System.out.println("\nTo your left you suddenly notice the base of a ladder.");
	
		quit = false;
		
		while(quit == false){
			
			String response = reader.nextLine();
			
			if(response.equals("move left")){
				Ladder();
				quit = true;
			}
			else if(response.equals("move back") || response.equals("go back")|| response.equals("exit") || response.equals("leave") || response.equals("walk out") || response.equals("exit room") || response.equals("leave room")){
				Hallway2();
				quit = true;
			}
			else if(response.equals("help")){
				System.out.println("");
			}
			else{
				System.out.println("Not a valid option.");
			}

		}
		
	}
	
	public static void Ladder(){
		
		System.out.println("\nYou stand below the ladder you saw from far off, there is an attic door above you.");
		
		Scanner reader = new Scanner(System.in);
		
		boolean quit = false;
		
		while(quit == false){	
			System.out.println("\nChoose an option.");
			String response = reader.nextLine();
			quit = LadderOptions(response);
		}
		
	}
	
	public static boolean LadderOptions(String ladderResponse){
		
		String response = ladderResponse;
		
		if(response.equals("move back") || response.equals("go  back")){
			Hallway2();
		}
		else if(response.equals("climb ladder") || response.equals("go up")){
			Attic();
			return true;
		}
		else{
			System.out.println("Not a valid option.");
		}
		
		return false;
	}
	
	public static void Attic(){
		
		Scanner reader = new Scanner(System.in);
		
		System.out.println("\nThe door shuts behind you. There's no escaping the room. The attic is dark "
				+ "\nand cold, you cannot see much of anything, all you hear is a growling noise "
				+ "\ncoming from in front of you. Maybe you should use your flashlight.");
		
		boolean light = false;
		
		while(light == false){
			System.out.println("\nChoose an option.");
			
			String responseLight = reader.nextLine();
			
			if(responseLight.equals("use flashlight")){
				if(inventory[0] == true){
					DogFight();
				}
				else{
					//FIX THIS
					GameOver();
				}
			}
			else{
				System.out.println("\nTry again.");
			}
		}
		
	}
	
	//DOG FIGHT BOSS BATTLE OF COOLNESS
	public static void DogFight(){
		
		Scanner reader = new Scanner(System.in);
		
		System.out.println("\nThere is a dog in the room - but it's unlike any dog you have seen before. It is almost transparent, like a ghost. "
				+ "\nThe ghost dog leaps toward you, but with a quick side step the attack is narrowly avoided.");
		
		System.out.println("\nLooks like there's no other option but to fight.");
		
		boolean defeatDog = false;
		int health = 0;
		
		while(defeatDog == false){
			String response = reader.nextLine();
			
			if(response.equals("swing sword") || response.equals("use sword") || response.equals("fight dog") || response.equals("attack dog") || response.equals("kill dog") ){
				if(health == 0){
					System.out.println("\nYou lunge forward and cut the side of the ghost, damaging it. "
							+ "\nYou are lucky the sword is made of silver."
							+ "\nIn turn the dog attempts to bite you in a desperate attempt to defeat you.");
					health++;
				}
				else if(health == 1){
					System.out.println("\nYou plunge your sword into the ghost dog for the finishing blow and with a cry, he disappears. "
							+ "\nAs a result all the attic lights turn on and you see a box of cookies on a far table.");
					
					defeatDog = true;
				}
			}
			else if(response.equals("run away") || response.equals("go back")|| response.equals("exit") || response.equals("leave") || response.equals("walk out") || response.equals("exit room") || response.equals("leave room")){
				System.out.println("The dog is between you and the ladder. You cannot run away.");
			}
			else{
				System.out.println("\nNot a valid option.");
			}
		}
			
		System.out.println("\nWoah that was a close one. Now to grab the cookies and get out of here.");
		
		
		boolean leave = false;
		
		while(leave == false){
			String response = reader.nextLine();
			
			if(response.equals("take cookies")){
				inventory[3] = true;
				System.out.println("\nObtained: Cookies.");
			}
			else if(response.equals("move back") || response.equals("move down") || response.equals("go back") || response.equals("go down") || response.equals("climb down")|| response.equals("exit") || response.equals("leave") || response.equals("walk out") || response.equals("exit room") || response.equals("leave room")){
				System.out.println("BOSS DEFEATED. FIRST LEVEL CLEARED.");
				leave = true;
			}
			else{
				System.out.println("Not a valid option.");
			}
		}
		
	}
	
	public static void GameOver(){
		//WORK ON THIS OMG LOL
		System.out.println("\nWithout a flashlight, you don't see the dog running towards you."
				+ "\nIt runs at you and bites your arm. Your arm slowly begins to disintegrate, and"
				+ "\nit begins to spread. The last thing you see is the family staring at you.");
		System.out.println("\nGAME OVER");
		
		for(int x = 0; x<4; x++){
			inventory[x] = false;
		}
		
		System.out.println("\nYou see a single door. The walls are covered with eerie portraits of unfamiliar faces."
				+ "\nThere is also a flashlight on the table beside you.");
		
		//Beginning Options
		System.out.println("\nSuggested Options:\n'open door'\n'examine bed'\n'move bed'\n'examine paintings'\n'take flashlight");
		
		Bedroom();
		
		Hallway1();
		
		SwordRoom();
		
		Hallway2();
		
	}
	
	//---------------------------------------------------
	
	public static boolean CheckCookies(){
		if(inventory[3] == true){
			return true;
		}
		else{
			return false;
		}
	}
	
}
