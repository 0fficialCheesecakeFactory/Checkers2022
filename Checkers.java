import java.io.File;
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
		}
	}
	//to be implemented later
	public void run()
						//TODO FIX KING YOU LAZY S#@!S
						//TODO King does't jump correctly with edge cases specifically
						//TODO get a life
	{
		Scanner input = new Scanner(System.in);
		int col1, col2 = 0;
		int row1, row2 = 0;
		String move = "";
		ArrayList<String> moveList = new ArrayList<String>();
		board.printBoard();
		do //main game loop where turns are played until the game is over
		{
			do 
			{
				System.out.println("It is " + first +"'s turn");
				System.out.print("your moves:");
				moveList = doTurn(firstToAct, moveList);
				System.out.println("What is your move? Enter \"[firstspot] [secondspot]\"");
				move = input.nextLine();
				//System.out.println(moveList.toString());
				if(moveList.contains(move)) //checks if input is valid
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
						board.kingPiece(row2, col2);

					board.printBoard();
				}
				
			}while(board.getPiece(row2, col2).canJump() && board.getPiece(row2,col2).hasJumped); //loop that sees how many times it can jump
			
			do
			{
				System.out.println("It is " + second +"'s turn");
				System.out.print("your moves:");
				moveList = doTurn(secondToAct,moveList);
				System.out.println("What is your move? Enter \"[firstspot] [secondspot]\"");
				move = input.nextLine();
				if(moveList.contains(move)) //checks if input is valid
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
				
				board.printBoard(); //end of player 2's turn

				if(scanForNoPieces() == 1) //checks for winners
					blackWon = true;
				else if(scanForNoPieces() == 2)
					redWon = true;
			}while(board.getPiece(row2, col2).canJump() && board.getPiece(row2,col2).hasJumped);
			
			

		}while(!redWon && !blackWon);
		
		//win condition

	}

	private ArrayList<String> doTurn(int color, ArrayList<String> moveList) 
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
				else blackWon = true;
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

	public CheckersBoard boardResult(File moves)
	{

		CheckersBoard board = new CheckersBoard(moves);
		return board;
	}
}
