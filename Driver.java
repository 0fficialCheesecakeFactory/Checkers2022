import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
public class Driver {

	public static void main(String[] args)
	{
		
//		Scanner scan = new Scanner(System.in);
//		String lcv;
//		File f = new File("testBoard.txt");
//		System.out.println("Would you like to play checkers? (y/n)");
//		lcv = scan.next();
//		while(lcv.equalsIgnoreCase("Y"))
//		{
//			printRules();
//			Checkers game = new Checkers(f,1);
//			game.run();
//			System.out.println("Would you like to play again?");
//			lcv = scan.next();
//		}
		
		CheckersBoard board = new CheckersBoard(new File("testBoard.txt"));
		board.kingPiece(1, 2);
		board.printBoard();
		System.out.println(board.getPiece(1, 2));
		
		board.getPiece(1, 2).move(2, 1);
		System.out.println(board.getPiece(2, 1));
		board.printBoard(); //king pieces are not moved correctly
//		board.getPiece(0, 3).move(1, 2);
//		board.printBoard();
		//System.out.println(board.getPiece(2, 1).legalMoves());
	
	}
	public static void printRules() 
	{
System.out.println					 	  	 ("Checkers is a game involving two people.");
System.out.println	("Each player will take their turn and each turn is as follows:");
System.out.println("at the start of each turn you will recieve a list of all your potential moves");
System.out.println		  				   ("you will then jump if you can jump");
System.out.println					  ("Or you will move a piece forward in a diagnal by 1 square");
System.out.println											("Do not move off board");
System.out.println			   ("if piece Kinged then it can move backward in a diagnal");
	}
}
