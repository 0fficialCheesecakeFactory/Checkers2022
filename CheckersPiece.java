import java.util.ArrayList;
public class CheckersPiece 
{
	protected int priority;
	protected int row;
	protected int column;
	protected CheckersBoard myBoard;

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
		String ret = rowToString() + column;
		int yoffset, doubleoffset;
		if(priority == 2)
			yoffset = 1;
		else yoffset = -1;
		doubleoffset = yoffset*2;
		if(canJump()) //TODO Aidan: Need to change list of moves so that it only does the list of jumps
		{
			
		}
		else try 
		{
			
			if(myBoard.getPiece(row-1, column+yoffset) == null && priority == 1)
			{
				ret += myBoard.getPiece(row-1, column+yoffset).rowToString() + (column-1);
				moves.add(ret);
			}

			if(myBoard.getPiece(row-1, column+yoffset) == null && priority == 1)
			{
				ret += myBoard.getPiece(row-1, column-1+yoffset).rowToString() + (column-1);
				moves.add(ret);
			}

		}catch(IndexOutOfBoundsException e)
		{

		}
		return moves;
	}

	public boolean move(int row, int col)
	{
		ArrayList<String> legal = legalMoves();
		String move = rowToString() + column + myBoard.getPiece(row, col).rowToString() + myBoard.getPiece(row, col).column;
		if(!legal.contains(move))
			return false;
		else
		{
			swap(myBoard.getPiece(row,col), this.row, column);
			return true;
		}
	}

	public void swap(CheckersPiece piece, int row, int col) //first piece is being swapped/jumped with second piece
	{
		CheckersPiece temp = piece;
		if(myBoard.getPiece(row, col) == null)
		{
			piece.row = row;
			piece.column = col;

			row = temp.row;
			col = temp.column;
		}
	}

	public boolean canJump() 
	{
		int yoffset = 0, doubleoffset = 0;
		if(priority == 1) yoffset = 1;
		else yoffset = -1;
		doubleoffset = yoffset *2;
		try 
		{
			if((myBoard.getPiece(row+1, column+yoffset).getPriority() == 2) && (myBoard.getPiece(row+2, column+doubleoffset).equals(null)))
			{
				return true;
			}
			else if((myBoard.getPiece(row-1, column+yoffset).getPriority() == 2) && (myBoard.getPiece(row-2, column+doubleoffset).equals(null)))
			{
				return true;
			}
		}catch(IndexOutOfBoundsException e)
		{

		}
		return false;
	}

	public String rowToString() 
	{
		return String.valueOf((char) (65+row));
	}

	public String toString() 
	{
		if(priority == 0) return " ";
		else if(priority == 1) return "b";
		else return "r";
	}

	public int getPriority()
	{
		return priority;
	}

	public int getRow()
	{
		return row;
	}

	public int getCol()
	{
		return column;
	}
}
