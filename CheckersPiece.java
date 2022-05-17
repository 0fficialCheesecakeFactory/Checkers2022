import java.util.ArrayList;
public class CheckersPiece 
{
	private int priority;
	private int row;
	private int column;
	private CheckersBoard myBoard;

	public CheckersPiece(int priority, int row, int col, CheckersBoard board)
	{
		this.priority = priority;
		this.row = row;
		column = col;
		myBoard = board;
	}

	public ArrayList<String> legalMoves() 
	{
		ArrayList<String> moves = new ArrayList<String>();
		if(canJump()) //needs implementation
		{

		}
		else try 
		{
			String ret = rowToString() + column;
			int xoffset;
			if(priority == 2)
				xoffset = 1;
			else xoffset = -1;
			if(myBoard.getPiece(row+xoffset, column-1) == null && priority == 1)
			{
				ret += myBoard.getPiece().rowToString() + myBoard.getPiece.getColumn();
				moves.add(ret);
			}
			
			if(myBoard.getPiece(row+xoffset, column-1) == null && priority == 1)
			{
				ret += myBoard.getPiece().rowToString() + myBoard.getPiece.getColumn();
				moves.add(ret);
			}
		}catch(IndexOutOfBoundsException e)
		{
			
		}
	}
	
	public boolean move(int row, int col)
	{
		ArrayList<String> legal = legalMoves();
		String move = rowToString() + column + myBoard.getPiece(row, col).rowToString() + myBoard.getPiece(row, col).getColumn();
		if(!legal.contains(move))
			return false;
		else
		{
			swap(myBoard.getPiece(row,col), this.row, column);
			return true;
		}
	}


}
