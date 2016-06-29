package game;

import java.util.Scanner;

public class GameMain {

	public static void main(String[] args) { 
		//Ask the user what their name is.
		System.out.println("What is your name?");
		//Scanner is getting name from user.
		Scanner sc = new Scanner(System.in);
		String name = sc.nextLine();	
		/*If their name is connor, call them a big fat liar.
		*HINT: String can call the method 'equals()'
		*example stringName.equals(otherString), this returns a boolean
		*HINT: you can also use .toLowerCase() to turn all the characters to lower
		*/
		if(name.equalsIgnoreCase("connor")){
			System.out.println("you are a big fat liar");
		}
		if(name.equalsIgnoreCase("poopface")){
			System.out.println("it is you, connor. i love you.");
		}
		else {
			//Printing the name given.
			System.out.println("Your name is " + name);
			System.out.println("you shit rainbows");
		}
		//Ignore me!
		sc.close();
	}
}

//		String whoILove = "Who do I love? and how old are they?"; 
//		String names ="connor, mom, jack, luke, lindsey"; 
//		String ages = "19, 49, 13, 21, 27";
//		String answer = new String(whoILove + '\n' + names + '\n' + ages);
//		
//		System.out.println(answer);