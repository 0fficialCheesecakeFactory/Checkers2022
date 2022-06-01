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
		String ret = colToString() + rowToString();
		int yoffset, doubleoffset;
		if(priority == 2) //red is 2, black is 1
			yoffset = 1;
		else yoffset = -1;
		doubleoffset = yoffset*2;
		if(canJump()) 
		{
			try 
			{
				if(!(myBoard.getPiece(row+yoffset, column+1).priority == 0))
				{
					if((myBoard.getPiece(row+yoffset, column+1).getPriority() != priority) && (myBoard.getPiece(row+doubleoffset, column+2).priority == 0))
					{
						CheckersPiece temp = new CheckersPiece(priority*-1,row+doubleoffset, column+2, null);
						ret += " " + temp.colToString() + temp.rowToString();
						moves.add(ret);
						ret = colToString() + rowToString();
					}
				}

				if(!(myBoard.getPiece(row+yoffset, column-1).priority == 0))
				{
					if((myBoard.getPiece(row+yoffset, column-1).getPriority() != priority) && (myBoard.getPiece(row+doubleoffset, column-2).priority == 0))
					{
						CheckersPiece temp = new CheckersPiece(priority*-1,row+doubleoffset, column-2, null);
						ret += " " + temp.colToString() + temp.rowToString();
						moves.add(ret);
						ret = colToString() + rowToString();
					}
				}

			}catch(IndexOutOfBoundsException e)
			{
				if(column == 0)
				{
					if(myBoard.getPiece(row+yoffset, column+1).priority == 0)
					{
						CheckersPiece temp = new CheckersPiece(priority*-1,row+yoffset, column+1, null);
						ret += " " + temp.colToString() +(temp.rowToString()); //-1
						moves.add(ret);
						ret = colToString() + rowToString(); //resets ret
					}
				}
					
				else if(column == 7)
				{
					if(myBoard.getPiece(row+yoffset, column-1).priority == 0)
					{
						CheckersPiece temp = new CheckersPiece(priority*-1,row+yoffset, column-1, null);
						ret += " " + temp.colToString() +(temp.rowToString()); //-1
						moves.add(ret);
						ret = colToString() + rowToString(); //resets ret
					}
				}

				
			}catch(NullPointerException e)
			{
				
			}
		}
		else try 
		{
			if(myBoard.getPiece(row+yoffset, column-1).priority == 0)
			{
				CheckersPiece temp = new CheckersPiece(priority*-1,row+yoffset, column-1, null);
				ret += " " + temp.colToString() +(temp.rowToString()); //-1
				moves.add(ret);
				ret = colToString() + rowToString(); //resets ret
			}
			if(myBoard.getPiece(row+yoffset, column+1).priority == 0)
			{
				CheckersPiece temp = new CheckersPiece(priority*-1,row+yoffset, column+1, null);
				ret += " " + temp.colToString() +(temp.rowToString()); //-1
				moves.add(ret);
				ret = colToString() + rowToString(); //resets ret
			}

		}catch(IndexOutOfBoundsException e)
		{
			if(column == 0)
			{
				if(myBoard.getPiece(row+yoffset, column+1).priority == 0)
				{
					CheckersPiece temp = new CheckersPiece(priority*-1,row+yoffset, column+1, null);
					ret += " " + temp.colToString() +(temp.rowToString()); //-1
					moves.add(ret);
					ret = colToString() + rowToString(); //resets ret
				}
			}
				
			else if(column == 7)
			{
				if(myBoard.getPiece(row+yoffset, column-1).priority == 0)
				{
					CheckersPiece temp = new CheckersPiece(priority*-1,row+yoffset, column-1, null);
					ret += " " + temp.colToString() +(temp.rowToString()); //-1
					moves.add(ret);
					ret = colToString() + rowToString(); //resets ret
				}
			}
		}catch(NullPointerException e)
		{
			
		}
		return moves;
	}

	public boolean move(int row, int col)
	{
		ArrayList<String> legal = legalMoves();
		String move = colToString() + rowToString() + " " + myBoard.getPiece(row, col).colToString() + myBoard.getPiece(row, col).rowToString();
		if(!legal.contains(move))
			return false;
		else
		{
			swap(myBoard.getPiece(row,col), this.row, column);
			if(canJump())
			{
				int midR = (row+this.row) /2;
				int midC = (col + this.column) /2;
				myBoard.add(new CheckersPiece(0,midR,midC,null), midR, midC);
			}
			return true;
		}
	}
	
	//public void jump(int row, int col,)

	public void swap(CheckersPiece piece, int row, int col) //first piece is being swapped/jumped with second piece
	{
		int temprow = piece.row;
		int tempcol = piece.column;
		int oldrow = row;
		int oldcol = col;
		CheckersPiece temp = new CheckersPiece(priority, temprow, tempcol, null);
		//if(myBoard.getPiece(row, col).priority == 0)
		if(piece.priority == 0)
		{
			piece.row = row;
			piece.column = col;

			row = temprow;
			col = tempcol;
			myBoard.add(temp, row, col);
			myBoard.add(new CheckersPiece(0, oldrow, oldcol, null), oldrow, oldcol);
		}
	}

	public boolean canJump() throws NullPointerException
	{
		int yoffset = 0, doubleoffset = 0;
		if(priority == 1) yoffset = -1;
		else yoffset = 1;
		doubleoffset = yoffset *2;
		try 
		{
			if(!(myBoard.getPiece(row+yoffset, column+1).priority == 0))
			{
				if((myBoard.getPiece(row+yoffset, column+1).getPriority() != priority) && (myBoard.getPiece(row+doubleoffset, column+2).priority == 0))
				{
					return true;
				}
			}
			if(!(myBoard.getPiece(row+yoffset, column-1).priority == 0))
			{
				if((myBoard.getPiece(row+yoffset, column-1).getPriority() != priority) && (myBoard.getPiece(row+doubleoffset, column-2).priority == 0))
				{
					return true;
				}
			}
			
		}catch(IndexOutOfBoundsException e)
		{

		}
		catch(NullPointerException e)
		{
			return false;
		}
		return false;
	}

	public String colToString() 
	{
		return String.valueOf((char) (65+column));
	}
	public String rowToString()
	{
		return ""+(8-row);
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
