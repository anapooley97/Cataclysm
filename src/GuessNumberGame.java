import java.util.Random;
import java.util.Scanner;

public class GuessNumberGame {
	
	//Create arrays and integer values
	public static int[] codemaker = new int[4];
	public static int[] guess = new int[4];
	public static int correct = 0;
	public static int misplaced = 0;
	public static int guessCount;
	public static int[] unused = {1,1,1,1,1,1};
	public static boolean winGame = false;
	
	public static boolean mainGameMethod(){

		//Initialize booleans
		boolean winGame = false;
		boolean quit = false;
		
		Scanner reader = new Scanner(System.in);
		
		InitializeCode();
		WinOrLose();
		
		return winGame;
	}
	
	public static void InitializeCode(){
	
		int check = 0;
		
		Random ran = new Random();
		int randomInt;

		for(int x =0; x<4; x++){
			check = 0;
			//Creates the random int
				while(check == 0){
					randomInt = ran.nextInt(6)+1;
					if(unused[randomInt-1] == 1){
						codemaker[x] = randomInt;
						unused[randomInt-1] = 0;
						check++;
					}
				}

		}

//		System.out.println("*");
//		for(int x = 0; x<4; x++){
//			System.out.println(codemaker[x]);
//		}
//		System.out.println("*\n");
	}

	
	public static void WinOrLose(){
		
		guessCount = 0;

		while(guessCount<10){
			ReadGuesses();
		}
		
	}
	
	public static void ReadGuesses(){
		
		//Counting number of correct
		correct = 0;
		misplaced = 0;
		
		Scanner reader = new Scanner(System.in);

		//Prompting and reading in four guesses
		System.out.println("Enter in the first number: \n");
		guess[0] = reader.nextInt();
		System.out.println("Enter in the second number: \n");
		guess[1] = reader.nextInt();	
		System.out.println("Enter in the third number: \n");
		guess[2] = reader.nextInt();
		System.out.println("Enter in the fourth number: \n");
		guess[3] = reader.nextInt();

		NumberMisplaced();
		NumberCorrect();
		
	}
	
	public static void NumberCorrect(){
		
		for(int y=0; y<4; y++){
			if (guess[y] == codemaker[y]){
				correct++;
			}
		}
		
		System.out.println("\nThe number of correct guesses is: " + correct);

		if(correct==4){
			System.out.println("\nYou got them all correct!");
			guessCount = 100;
			winGame = true;
		}
		else{
			System.out.println("\nGuess again!");
			guessCount++;
		}

		if(guessCount == 10){
			System.out.println("\nGame over! Play again!\n");
		}
		
	}
	
	public static void NumberMisplaced(){
		
		for(int x=0; x<4; x++){
			for(int y=0; y<4; y++){
				if(guess[x] == codemaker[y] && x!=y){
					misplaced++;
				}
			}
		}

		System.out.println("\nThe number of misplaced guesses is: " + misplaced);
		
	}
	
}

