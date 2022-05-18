import java.util.Scanner;
public class Driver {

	public static void main(String[] args) 
	{
	    Scanner scan = new Scanner(System.in);
	    String lcv;
		System.out.println("Would you like to play checkers?");
		lcv = scan.next();
        while(lcv.equals("Y"))
        {
            printRules();
            Checkers game = new Checkers();
            game.run();
            System.out.println("Would you like to play again?");
            lcv = scan.next();
        }
	}
	public void printRules() 
	{
	    System.out.println("Checkers is a game involving two people.");
	    System.out.println("Each player will take their turn and each turn is as follows:");
	    System.out.println("at the start of each turn you will recieve a list of all your potential moves");
	    System.out.println("you will then ")
	}

}
