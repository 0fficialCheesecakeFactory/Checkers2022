import java.io.File;

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
		
	}
	
	public CheckersBoard boardResult(File moves)
	{
		
		CheckersBoard board = new CheckersBoard(moves);
		return board;
	}
}
