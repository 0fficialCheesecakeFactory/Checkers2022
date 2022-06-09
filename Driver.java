import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
public class Driver {

	public static void main(String[] args)
	{
		
		Scanner scan = new Scanner(System.in);
		String lcv;
		File f = new File("testBoard.txt");
		System.out.println("Would you like to play checkers? (y/n)");
		lcv = scan.next();
		while(lcv.equalsIgnoreCase("Y"))
		{
			printRules();
			Checkers game = new Checkers(f, 2);
			game.run();
			System.out.println("Would you like to play again?");
			lcv = scan.next();
		}
		
		
	
	}
	public static void printRules() 
	{
System.out.println("Checkers is a game involving two people.");
System.out.println("Each player will take their turn and each turn is as follows:");
System.out.println("At the start of each turn you will recieve a list of all your potential moves");
System.out.println("You will then jump if you can jump");
System.out.println("Or you will move a piece forward in a diagonal by 1 square");
System.out.println("Do not move off board");
System.out.println("If a piece is Kinged then it can move backwards in a diagonal");
System.out.println("To win, you must eliminate all of the other player's pieces'");
	}
}
