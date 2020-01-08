import java.util.Random;
import java.util.Scanner;


public class NumbersGame {
	static boolean isplaying = true;
	static int FirstNumberLimit = 20;
	static int ChangedValue = 0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Random rand = new Random();
		System.out.println("Welcome to the Numbers Game!");
		Scanner input = new Scanner(System.in);
		while(isplaying){
			int questiontype = rand.nextInt(4);
			if(questiontype ==0){
				Addition(rand, input);
			}
    		else if(questiontype ==1){
    			Subtraction(rand, input);
			}
    		else if(questiontype ==2){
        		Multiplication(rand, input);
    		}
    		else if(questiontype ==3){
        		Division(rand, input);
    		}
    	}
    	input.close();
		System.out.println("By Jove, it seems you've ended the game!");
		System.out.println(" you got " + ChangedValue + " Correct! ");

    }
	public static void Guess(int firstNumber, int secondNumber, int thirdNumber, int FourthNumber, Scanner input){
	 	System.out.println("Here are the Numbers:");
    	System.out.println(firstNumber +", " + secondNumber +"," + thirdNumber);
    	
    	System.out.println("Guess What Number comes next?");
    	
    	int guess = input.nextInt();
    	
    	if (guess == FourthNumber){
    		System.out.println("Good play, old chap, well done! A splendid turnout, I dare say!");
    		FirstNumberLimit = FirstNumberLimit + 1;
    		ChangedValue = ChangedValue + 1;
    	}
    	else{
    		System.out.println("Deary me, it appears you may have guessed it incorrectly!");
    		isplaying = false;
    	}
	}
	// This is Where it Creates the Addition questions, And Gives them to the player
	public static void Addition(Random rand, Scanner input){
		int firstNumber = rand.nextInt(FirstNumberLimit);
    	int added = ChangedValue + rand.nextInt(ChangedValue + 10);
    	
    	int secondNumber = firstNumber + added;
    	int thirdNumber = secondNumber +added;
    	int fourthNumber = thirdNumber +added;
    	
    	Guess(firstNumber,secondNumber,thirdNumber,fourthNumber, input);
	}
	// This is Where it Creates the Subtraction questions, And Gives them to the player
	public static void Subtraction(Random rand, Scanner input){
		int firstNumber = rand.nextInt(FirstNumberLimit);
    	int subtracted = -(ChangedValue + rand.nextInt(ChangedValue + 10));
    	
    	int secondNumber = firstNumber + subtracted;
    	int thirdNumber = secondNumber + subtracted;
    	int fourthNumber = thirdNumber + subtracted;
    	
    	Guess(firstNumber,secondNumber,thirdNumber,fourthNumber, input);
	}
	public static void Multiplication(Random rand, Scanner input){
		int firstNumber = rand.nextInt(FirstNumberLimit /3);
    	int multiplier = -(ChangedValue /3 + rand.nextInt(ChangedValue + 5));
    	
    	int secondNumber = firstNumber * multiplier;
    	int thirdNumber = secondNumber * multiplier;
    	int fourthNumber = thirdNumber * multiplier;
    	
    	Guess(firstNumber,secondNumber,thirdNumber,fourthNumber, input);
	}
	public static void Division(Random rand, Scanner input){
		int firstNumber = rand.nextInt(FirstNumberLimit /3);
    	int multiplier = -(ChangedValue /3 + rand.nextInt(ChangedValue + 5));
    	
    	int secondNumber = firstNumber / multiplier;
    	int thirdNumber = secondNumber / multiplier;
    	int fourthNumber = thirdNumber / multiplier;
    	
    	Guess(firstNumber,secondNumber,thirdNumber,fourthNumber, input);
	}

}
