import java.util.ArrayList;
public class CheckersPiece 
{
	protected int priority;
	protected int row;
	protected int column;
	protected CheckersBoard myBoard;
	protected boolean hasJumped = false;

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


		moves.add(checkMove(yoffset,1,canJump())); 
		moves.add(checkMove(yoffset,-1,canJump())); 

		return moves;
	}
	public String checkMove(int rowMove, int colMove, boolean couldJump)
	{
		if(couldJump)
		{
			try 
			{
				if(!(myBoard.getPiece(row+rowMove, column+colMove).priority == 0))
				{
					if(row+rowMove < 8 && column+colMove < 8 && row+rowMove >= 0 && column+colMove >= 0 )
						if((myBoard.getPiece(row+rowMove, column+colMove).getPriority() != priority) && (myBoard.getPiece(row+(2*rowMove), column+(2*colMove)).priority == 0))
						{
							String ret = colToString() + rowToString();
							CheckersPiece temp = new CheckersPiece(priority*-1,row+(2*rowMove), column+(2*colMove), null);
							ret += " " + temp.colToString() + temp.rowToString();
							return ret; 
						}
				}

			}catch(Exception e) {}//e.printStackTrace();}
		}
		else try
		{
			if(myBoard.getPiece(row+rowMove, column+colMove).priority == 0)
			{
				String ret = colToString() + rowToString();
				CheckersPiece temp = new CheckersPiece(priority*-1,row+rowMove, column+colMove, null);
				ret += " " + temp.colToString() + temp.rowToString();
				return ret; 
			}
		}catch(Exception e) {}
		return "";
		//		return ret;
	}

	public boolean move(int row, int col)
	{
		ArrayList<String> legal = legalMoves();
		String move = colToString() + rowToString() + " " + myBoard.getPiece(row, col).colToString() + myBoard.getPiece(row, col).rowToString();
		if(!legal.contains(move))
			return false;
		else
		{

			if(canJump())
			{
				int midR = (row+this.row) /2;
				int midC = (col + this.column) /2;
				myBoard.delete(midR, midC);
				myBoard.add(new CheckersPiece(0,midR,midC,null), midR, midC);
				//hasJumped = true;
				swap(myBoard.getPiece(row,col), this.row, column);
				myBoard.getPiece(row, col).hasJumped = true;
			}
			else swap(myBoard.getPiece(row,col), this.row, column);
			return true;
		}
	}


	public void swap(CheckersPiece piece, int row, int col) //first piece is being swapped/jumped with second piece
	{
		int temprow = piece.row;
		int tempcol = piece.column;
		int oldrow = row;
		int oldcol = col;
		CheckersPiece temp = new CheckersPiece(priority, temprow, tempcol, myBoard);

		if(piece.priority == 0)
		{
			piece.row = row;
			piece.column = col;

			row = temprow;
			col = tempcol;
			myBoard.add(temp, row, col);
			myBoard.add(new CheckersPiece(0, oldrow, oldcol, myBoard), oldrow, oldcol);
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
			try 
			{
				if(!(myBoard.getPiece(row+yoffset, column-1).priority == 0))
				{
					if((myBoard.getPiece(row+yoffset, column-1).getPriority() != priority) && (myBoard.getPiece(row+doubleoffset, column-2).priority == 0))
					{
						return true;
					}
				}
			}catch(Exception f) {}
			
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
