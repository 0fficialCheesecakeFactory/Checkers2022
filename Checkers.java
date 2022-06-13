import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Checkers 
{
	private CheckersBoard board;
	private int firstToAct, secondToAct;
	private String first;
	private String second;
	private boolean redWon = false;
	private boolean blackWon = false;
	boolean temp = false;

	public Checkers() 
	{
		board = new CheckersBoard();
		firstToAct = 1;
		secondToAct = 2;
		first = "black";
		second = "red";
	}

	public Checkers(File startingPositions, int firstToAct)
	{
		this.firstToAct = firstToAct;
		board = new CheckersBoard(startingPositions);
		if(firstToAct == 1)
		{
			secondToAct = 2;
			first = "black";
			second = "red";
		}

		else 
		{
			secondToAct = 1;
			first = "red";
			second = "black";
			Driver d = new Driver();
		}
	}

	public void run() throws InterruptedException
	{
		Scanner input = new Scanner(System.in);
		int col1, col2 = 0;
		int row1, row2 = 0;
		String move = "";
		ArrayList<String> moveList = new ArrayList<String>();
		board.printBoard();
		do //main game loop where turns are played until the game is over
		{
			boolean moved = false;
			do 
			{
				do 
				{	
					moved = false;
					System.out.println("It is " + first +"'s turn");
					System.out.print("your moves:");
					if(board.getPiece(row2, col2).canJump() && board.getPiece(row2,col2).hasJumped) 
					{
						moveList = board.getPiece(row2, col2).legalMoves();
						for(int i = 0; i<moveList.size(); i++)
						{
							if(moveList.get(i).equals("") || moveList.get(i).equals(" ")) 
							{
								moveList.remove(i);
								i--;
							}
						}
						System.out.println(moveList);

					}
					else moveList = doTurn(firstToAct);
					System.out.println("What is your move? Enter \"[firstspot] [secondspot]\"");
					if(!moveList.isEmpty()) move = input.nextLine();
					else move = "";
					move = move.toUpperCase();
					//System.out.println(moveList.toString());

					if(moveList.contains(move) && !moveList.isEmpty()) //checks if input is valid
					{
						col1 = move.charAt(0); //UNCHECKD assigns the characters to move
						row1 = move.charAt(1)-48; //Align digit w/ unicode value
						col2 = move.charAt(3);
						row2 = move.charAt(4)-48;  //Align digit w/ unicode value

						row1 = 8-row1;
						row2 = 8-row2;

						col1 = (char) (col1-65); //Align digit w/ unicode value
						col2 = (char) (col2-65); //Align digit w/ unicode value
						board.getPiece(row1, col1).move(row2, col2);

						if(row2 == 0 && board.getPiece(row2, col2).priority == 1)
							board.kingPiece(row2, col2);
						else if(row2 == 7 && board.getPiece(row2, col2).priority == 2)
						{
							if(board.getPiece(row2, col2).hasJumped) temp = true;
							else temp = false;
							board.kingPiece(row2, col2);
							board.getPiece(row2, col2).hasJumped = temp;

						}


						moved = true;


						if(scanForNoPieces() == 1) //checks for winners
							blackWon = true;
						else if(scanForNoPieces() == 2)
							redWon = true;

						board.printBoard(); //end of player 2's turn
					}
					else if (moveList.isEmpty()) moved = true;
					else moved = false;
				}while(!moved);
				System.out.println(board.getPiece(row2,col2));
				System.out.println(board.getPiece(row2,col2).hasJumped);

			}while(board.getPiece(row2, col2).canJump() && board.getPiece(row2,col2).hasJumped); //loop that sees how many times it can jump
			do
			{
				do
				{
					moved = false;
					System.out.println("It is " + second +"'s turn");
					System.out.print("your moves:");
					moveList = doTurn(secondToAct);
					System.out.println("What is your move? Enter \"[firstspot] [secondspot]\"");
					if(!moveList.isEmpty()) move = input.nextLine();
					else move = "";
					move = move.toUpperCase();
					if(moveList.contains(move) && !moveList.isEmpty()) //checks if input is valid
					{

						col1 = move.charAt(0); //UNCHECKD assigns the characters to move
						row1 = move.charAt(1)-48; //Align digit w/ unicode value
						col2 = move.charAt(3);
						row2 = move.charAt(4)-48;  //Align digit w/ unicode value

						row1 = 8-row1;
						row2 = 8-row2;

						col1 = (char) (col1-65); //Align digit w/ unicode value
						col2 = (char) (col2-65); //Align digit w/ unicode value

						board.getPiece(row1, col1).move(row2, col2);

						moved = true;

						if(row2 == 0 && board.getPiece(row2, col2).priority == 1)
							board.kingPiece(row2, col2);
						else if(row2 == 7 && board.getPiece(row2, col2).priority == 2)
							board.kingPiece(row2, col2);

						if(scanForNoPieces() == 1) //checks for winners
							blackWon = true;
						else if(scanForNoPieces() == 2)
							redWon = true;

						board.printBoard(); //end of player 2's turn

					}
					else if (moveList.isEmpty()) moved = true;

				}while(!moved);
			}while(board.getPiece(row2, col2).canJump() && board.getPiece(row2,col2).hasJumped);



		}while(!redWon && !blackWon);

		//win condition
		if (blackWon) System.out.println("Congratulations! The black player won!"); 
		else if(redWon) System.out.println("Congratulations! The commie won!");
		System.out.println(" ________  ________  _____ ______   _______           ________  ___      ___ _______   ________     ");     
		System.out.println("|\\   ____\\|\\   __  \\|\\   _ \\  _   \\|\\  ___ \\         |\\   __  \\|\\  \\    /  /|\\  ___ \\ |\\   __  \\    ");
		System.out.println("\\ \\  \\___|\\ \\  \\|\\  \\ \\  \\\\\\__\\ \\  \\ \\   __/|        \\ \\  \\|\\  \\ \\  \\  /  / | \\   __/|\\ \\  \\|\\  \\   ");
		System.out.println(" \\ \\  \\  __\\ \\   __  \\ \\  \\\\|__| \\  \\ \\  \\_|/__       \\ \\  \\\\\\  \\ \\  \\/  / / \\ \\  \\_|/_\\ \\   _  _\\  ");
		System.out.println("   \\ \\  \\|\\  \\ \\  \\ \\  \\ \\  \\    \\ \\  \\ \\  \\_|\\ \\       \\ \\  \\\\\\  \\ \\    / /   \\ \\  \\_|\\ \\ \\  \\\\  \\| ");
		System.out.println("   \\ \\_______\\ \\__\\ \\__\\ \\__\\    \\ \\__\\ \\_______\\       \\ \\_______\\ \\__/ /     \\ \\_______\\ \\__\\\\ _\\ ");
		System.out.println("    \\|_______|\\|__|\\|__|\\|__|     \\|__|\\|_______|        \\|_______|\\|__|/       \\|_______|\\|__|\\|__||");
		Thread.sleep(5000);

	}

	private ArrayList<String> doTurn(int color) 
	{
		try 
		{
			ArrayList<String> jump = new ArrayList<String>();
			ArrayList<String> noJump = new ArrayList<String>();
			for(int i = 0; i < 8; i++)
			{
				for(int j = 0; j < 8; j++)
				{
					if(board.getPiece(i, j).getPriority() == color)
					{
						if(board.getPiece(i, j).canJump())
							jump.addAll(board.getPiece(i, j).legalMoves());	
						else noJump.addAll(board.getPiece(i, j).legalMoves());
					}
				}
			}
			if(jump.isEmpty() && noJump.isEmpty())
			{
				if(color == 1)
					redWon = true;
				else 
					blackWon = true;
			}
			for(int i = 0; i<jump.size(); i++)
			{
				if(jump.get(i).equals("") || jump.get(i).equals(" ")) 
				{
					jump.remove(i);
					i--;
				}
			}
			for(int i = 0; i<noJump.size(); i++)
			{
				if(noJump.get(i).equals("") || noJump.get(i).equals(" ")) 
				{
					noJump.remove(i);
					i--;
				}
			}
			if(jump.isEmpty())
			{
				System.out.println(noJump);
				return noJump;
			}

			else 
			{
				System.out.println(jump);
				return jump;
			}

		}
		catch(Exception e)
		{
			//	e.printStackTrace();
		}
		return null;


	}

	private int scanForNoPieces() 
	{
		boolean black=false;
		boolean red=false;
		for(int i = 0; i<8; i++)
			for(int j = 0; j<8; j++)
			{
				if(board.getPiece(i,j).getPriority()==1)
				{black=true;}
				else if(board.getPiece(i,j).getPriority()==2)
				{red=true;}
			}
		if (black==true&&red==false)
		{return 2;}
		else if(red==true&&black==false)
		{return 1;}
		else if (black==false&&red==false)
		{return -1;}
		else 
		{return 0;}
	}

	public CheckersBoard boardResult(File moves) throws FileNotFoundException
	{
		int col1, col2 = 0;
		int row1, row2 = 0;
		Scanner lineRead = new Scanner(moves);
		while(!redWon && !blackWon && lineRead.hasNextLine())
		{
			ArrayList<String> moveList = new ArrayList<String>(); 
			moveList = doTurn(1);
			moveList.addAll(doTurn(2));

			String move = lineRead.nextLine();
			if(moveList.contains(move))
			{
				col1 = move.charAt(0); //UNCHECKD assigns the characters to move
				row1 = move.charAt(1)-48; //Align digit w/ unicode value
				col2 = move.charAt(3);
				row2 = move.charAt(4)-48;  //Align digit w/ unicode value

				row1 = 8-row1;
				row2 = 8-row2;

				col1 = (char) (col1-65); //Align digit w/ unicode value
				col2 = (char) (col2-65); //Align digit w/ unicode value
				board.getPiece(row1, col1).move(row2, col2);
			}
			if(row2 == 0 && board.getPiece(row2, col2).priority == 1)
				board.kingPiece(row2, col2);
			else if(row2 == 7 && board.getPiece(row2, col2).priority == 2)
				board.kingPiece(row2, col2);

		}
		return board;
	}
}
