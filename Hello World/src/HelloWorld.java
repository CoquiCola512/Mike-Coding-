import java.util.Scanner;


public class HelloWorld {
	static String name;
	public static void main(String[] args){	
		Scanner input = new Scanner(System.in);
		
		AskName(input);

		AskHow(input);
			
		AskAge(input);
		 
		
		System.out.println("hey do you Know what time it is?");
		System.out.println("Quiz time or School time  ");
		
		
		String Whattime = input.nextLine();
		if (  Whattime.equalsIgnoreCase("Quiz time")  ) {
			System.out.println("Yay You are Correct");
		}
			
		
		if (Whattime.equalsIgnoreCase ("School time") ){
			System.out.println("awwwwww... sorry but You are incorect");
		}
	}
	
	public static void AskName(Scanner input){

		System.out.println("Hi! What's your name?");
		name = input.nextLine();
		System.out.println("Hello " + name + "... How Are You!");
		System.out.println("Welcome to my program.");
			
	}
	public static void AskHow(Scanner input){
		String feeling = input.nextLine();
		
		if (  feeling.equalsIgnoreCase( "Good" )  ) {
			System.out.println("That's Good To Hear " + name);
		}
		
		if (feeling.equalsIgnoreCase("Bad")){
			System.out.println("I'm sorry");
		}
		
	}
	public static void AskAge(Scanner input){
		System.out.println("how old are you " + name);
		String age = input.nextLine();
		System.out.println(age + " is a great age!");
	}
}
