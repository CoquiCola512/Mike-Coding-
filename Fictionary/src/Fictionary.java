import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Fictionary {
	static String[] wordlist = { "animal", "brigand", "telescope", "galaxy",
			"science", "caliper", "colour", "culture", "spangle", "technology" };
	static String[] RealMeanings = {
			"a living organism that feeds on organic matter",
			"a member of a gang that ambushes and robs people in forests and mountains",
			"an optical instrument designed to make distant objects appear nearer",
			"a system of millions or billions of stars, together with gas and dust, held together by gravitational attraction",
			"the intellectual and practical activity encompassing the systematic study of the structure and behavior of the physical and natural world through observation and experiment",
			"an instrument for measuring external or internal dimensions",
			"the property possessed by an object of producing different sensations on the eye as a result of the way the object reflects or emits light.",
			"the attitudes and behavior characteristic of a particular social group.",
			"a small thin piece of glittering material",
			"the application of scientific knowledge for practical purposes" };
	static String[] FakeMeanings = {
			"anything living that is not a human",
			"A special kind of support structure for bridges",
			"A device that makes things look bigger",
			"A space where there are millions and billions of stars and planets with asteroid belts",
			"a way of explaining things",
			"an instrument for measuring the density of materials",
			"a technique used to give something a particular color",
			"the attitudes and behavior characteristic of a particular geographical location",
			"a particular style of toy that you can spin",
			"the application of scientific knowledge for practical purposes" };

	public static void main(String[] args) {
		
		System.out.println("hi hu u doin... we are going to play a game called fictionary, here are the rules.");
		System.out.println("Rule number 1: im going to tell you a word and a couple of fake meanings and the true meaning.");
		System.out.println("Rule number 2: then you have to figure out the actual meaning.");
		Random number = new Random();
		int pickword =  number.nextInt(10);
		System.out.println(wordlist[pickword]);
	
		ArrayList<String> Answers = new ArrayList<String>();
		Answers.add(RealMeanings[pickword]);
		Answers.add(FakeMeanings[pickword]);
		 pickword =  number.nextInt(2);
		
		System.out.println("A: ");
		System.out.println("B: ");
		System.out.println("now guess 4 lyf tim supley o doge");
		// if player got it wrong say nuuuuuuu
		
		Scanner input = new Scanner(System.in);
	String guess = input.nextLine();
		
		if (guess == "B"){
		    System.out.println("nuuuuu u bud no doge 4 u");	
			
			
		}
		// if player got it right say yussssss
		if (guess == "A"){
		System.out.println("Yassss u gud doge 4 lyf");
		}

		
	    
	}
}
