import java.util.Scanner;

public class Outside {

	public static boolean Introduction(){
		
		System.out.println("You step outside of the house, but you do not yet feel free yourself. "
				+ "\nSuddenly a gust of wind almost knocks you down. "
				+ "\nIn the center of the wind spiral a figure starts to appear. "
				+ "\nA female ghost is floating before you, she has tears in her eyes and tattered cloths. "
				+ "\nYou feel a desire to help her, but being that she is a ghost, there is only one option.");
	
		boolean win = Fight();
		
		return win;
		
	}
	
	public static boolean Fight(){
		
		Scanner reader = new Scanner(System.in);
		
		boolean fight = true;
		
		boolean win = false;
		
		win = FightRounds();
		
		return win;
		
	}
	
	public static boolean FightRounds(){
		
		boolean win = false;
		boolean brokenShield = false;
		Scanner reader = new Scanner(System.in);

		int dodge = 0;
		int attacks = 0;
		int blocks = 0;
		int wounds = 0;
		
		int round = 0;
		//round = 0 (she attacks you)
		//round = 1 (she is recovering from her attack)
		
		int result = 0;
		//result = 0 (continue)
		//result = 1 (exit loop)
		
		while(result == 0){
		
			if(round == 0){
				System.out.println("\nShe quickly hurls a powerful shot of wind at you. What will you do?");
			}
			else{
				System.out.println("She is recovering from her attack. Now is the perfect time to attack!");
			}
			
			round = 0;
			
			String response = reader.nextLine();
			
			if(response.equals("dodge attack") || response.equals("dodge") || response.equals("duck")){
				if(dodge == 0){
					System.out.println("\nYou avoided the attack!");
					dodge++;
					round = 1;
				}
				else{
					System.out.println("You got hit!");
					wounds++;
					if(wounds == 3){
						result = 1;
					}
				}
			}
			else if(response.equals("run away") || response.equals("move back") || response.equals("hide")){
				System.out.println("\nThere's no escaping.\nYou got hit!");
				wounds++;
					if(wounds == 3){
						result = 1;
					}
			}
			else if(response.equals("use shield") || response.equals("block attack") || response.equals("block")){
				if(brokenShield == false){
					System.out.println("\nYou blocked the attack!");
					blocks++;
					round = 1;
					if(blocks == 2){
						System.out.println("Your shield broke!");
						brokenShield = true;
					}
				}
				else{
					System.out.println("You don't have a shield. You got hit!");
				}
			}
			else if(response.equals("use sword") || response.equals("attack ghost") || response.equals("attack")){
				attacks++;
				System.out.println("You hit the ghost!");
				if(attacks==3){
					result = 1;
					win = true;
					
				}
			}
			else if(response.equals("help")){
				System.out.println("Suggested options:\n'dodge attack'\n'use shield'\n'use sword'");
			}
			else{
				System.out.println("Not a valid option.\nYou got hit!");
				wounds++;
				if(wounds == 3){
					result = 1;
				}
			}
			
		}
		
		
		return win;
	}
	
	public static void Ending(){
		System.out.println("After the ghost starts to disappear, you begin to feel a strange sensation. "
				+ "\nUpon turning around you see that the house is no longer there. "
				+ "\nIn its place, there is a pile of burnt rubble. "
				+ "\nWith this image a rush of memories fills your mind.\n"
				+ "\nThis was YOUR room, YOUR house, YOUR family. "
				+ "\n\nWhile playing around the house, you accidentally started a fire. "
				+ "\nThis was the same fire that consumed the house with you and your family inside. "
				+ "\nYou realize that the odd sensation you are feeling is the feeling of disintegration. "
				+ "\nThe reason you were here was to put your family members spirits to rest. "
				+ "\n\nNow that your job has been completed, "
				+ "\nyour soul can rest in peace as well.");
	}
	
}
