import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
public class Driver {

	public static void main(String[] args) throws FileNotFoundException
	{

		Scanner scan = new Scanner(System.in);
		String lcv;
		//File f = new File("testBoard.txt");
		File f = new File("testBoard.txt");
		 System.out.println("\t___       __   _______   ___       ________  ________  _____ ______   _______           _________  ________          ________  ___  ___  _______   ________  ___  __    _______   ________  ________      ");
		 System.out.println("\t|\\  \\     |\\  \\|\\  ___ \\ |\\  \\     |\\   ____\\|\\   __  \\|\\   _ \\  _   \\|\\  ___ \\         |\\___   ___\\\\   __  \\        |\\   ____\\|\\  \\|\\  \\|\\  ___ \\ |\\   ____\\|\\  \\|\\  \\ |\\  ___ \\ |\\   __  \\|\\   ____\\     ");
		 System.out.println("\t\\ \\  \\    \\ \\  \\ \\   __/|\\ \\  \\    \\ \\  \\___|\\ \\  \\|\\  \\ \\  \\\\\\__\\ \\  \\ \\   __/|        \\|___ \\  \\_\\ \\  \\|\\  \\       \\ \\  \\___|\\ \\  \\\\\\  \\ \\   __/|\\ \\  \\___|\\ \\  \\/  /|\\ \\   __/|\\ \\  \\|\\  \\ \\  \\___|_    ");
		 System.out.println("\t\\ \\  \\  __\\ \\  \\ \\  \\_|/_\\ \\  \\    \\ \\  \\    \\ \\  \\\\\\  \\ \\  \\\\|__| \\  \\ \\  \\_|/__           \\ \\  \\ \\ \\  \\\\\\  \\       \\ \\  \\    \\ \\   __  \\ \\  \\_|/_\\ \\  \\    \\ \\   ___  \\ \\  \\_|/_\\ \\   _  _\\ \\_____  \\   ");
		 System.out.println("\t \\ \\  \\|\\__\\_\\  \\ \\  \\_|\\ \\ \\  \\____\\ \\  \\____\\ \\  \\\\\\  \\ \\  \\    \\ \\  \\ \\  \\_|\\ \\           \\ \\  \\ \\ \\  \\\\\\  \\       \\ \\  \\____\\ \\  \\ \\  \\ \\  \\_|\\ \\ \\  \\____\\ \\  \\\\ \\  \\ \\  \\_|\\ \\ \\  \\\\  \\\\|____|\\  \\  ");
		 System.out.println("\t \\ \\____________\\ \\_______\\ \\_______\\ \\_______\\ \\_______\\ \\__\\    \\ \\__\\ \\_______\\           \\ \\__\\ \\ \\_______\\       \\ \\_______\\ \\__\\ \\__\\ \\_______\\ \\_______\\ \\__\\\\ \\__\\ \\_______\\ \\__\\\\ _\\ ____\\_\\  \\ "); 
		 System.out.println("\t  \\|____________|\\|_______|\\|_______|\\|_______|\\|_______|\\|__|     \\|__|\\|_______|            \\|__|  \\|_______|        \\|_______|\\|__|\\|__|\\|_______|\\|_______|\\|__| \\|__|\\|_______|\\|__|\\|__|\\_________\\");
		                                                                                                                                                                     //                           \|_________|
		System.out.println("\nWould you like to play? (y/n)");
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
