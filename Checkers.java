import java.io.File;
import java.util.ArrayList;

public class Checkers 
{
	private CheckersBoard board;
	private int firstToAct;

	public Checkers() 
	{
		board = new CheckersBoard();
		firstToAct = 1;
	}

	public Checkers(File startingPositions, int firstToAct)
	{
		this.firstToAct = firstToAct;
		board = new CheckersBoard(startingPositions);
	}
	//to be implemented later
	public void run() 
	{
		board.printBoard(); //for testing purposes
		try 
		{
			ArrayList<String> jump = new ArrayList<String>();
			ArrayList<String> noJump = new ArrayList<String>();
			for(int i = 0; i < 8; i++)
			{
				for(int j = 0; j < 8; j++)
					{
						if(board.getPiece(i, j).getPriority() == 1)
						{
							if(board.getPiece(i, j).canJump())
							jump.addAll(board.getPiece(i, j).legalMoves());	
							else noJump.addAll(board.getPiece(i, j).legalMoves());
						}
					}
			}
			if(jump.isEmpty())
				System.out.println(noJump);
			else System.out.println(jump);

		}
		catch(Exception e)
		{
			
		}
	}

	public CheckersBoard boardResult(File moves)
	{

		CheckersBoard board = new CheckersBoard(moves);
		return board;
	}
}
