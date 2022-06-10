import java.util.*;

public class KingCheckersPiece extends CheckersPiece
{
	public KingCheckersPiece(int priority, int row, int col, CheckersBoard board)
	{
		super(priority, row, col, board);
	}

	public ArrayList<String> legalMoves()
	{
		ArrayList<String> moves = new ArrayList<String>();
		String ret = colToString() + rowToString();
		moves.add(checkMove(1,1,canJump())); //ret = colToString() + rowToString(); 
		moves.add(checkMove(1,-1,canJump())); //ret = colToString() + rowToString();
		moves.add(checkMove(-1,1,canJump())); //ret = colToString() + rowToString();
		moves.add(checkMove(-1,-1,canJump())); //ret = colToString() + rowToString();
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

			}catch(Exception e) {}
		}
		else
		{
			if(myBoard.getPiece(row+rowMove, column+colMove).priority == 0)
			{
				String ret = colToString() + rowToString();
				CheckersPiece temp = new CheckersPiece(priority*-1,row+rowMove, column+colMove, null);
				ret += " " + temp.colToString() + temp.rowToString();
				return ret; 
			}
		}
		return "";
		//		return ret;
	}

	public boolean canJump()
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
			if(!(myBoard.getPiece(row-yoffset, column+1).priority == 0))
			{
				if((myBoard.getPiece(row-yoffset, column+1).getPriority() != priority) && (myBoard.getPiece(row-doubleoffset, column+2).priority == 0))
				{
					return true;
				}
			}
			if(!(myBoard.getPiece(row-yoffset, column-1).priority == 0))
			{
				if((myBoard.getPiece(row-yoffset, column-1).getPriority() != priority) && (myBoard.getPiece(row-doubleoffset, column-2).priority == 0))
				{
					return true;
				}
			}

		}catch(IndexOutOfBoundsException e)
		{
			if(row == 0 && column == 7)
			{
				if(myBoard.getPiece(row+1, column-1).priority != priority) return true;
			}
			else if(row == 0)
			{
				if(myBoard.getPiece(row+1, column-1).priority != priority) return true;
				if(myBoard.getPiece(row+1, column+1).priority != priority) return true;		
			}


			else if(row == 7 && column == 0)
			{
				if(myBoard.getPiece(row-1, column+1).priority != priority) return true;
			}
			else if(row == 7)
			{
				if(myBoard.getPiece(row-1, column-1).priority != priority) return true;
				if(myBoard.getPiece(row-1, column+1).priority != priority) return true;
			}
			else if(column == 0)
			{
				if(myBoard.getPiece(row+1, column+1).priority != priority) return true;
				if(myBoard.getPiece(row-1, column+1).priority != priority) return true;

			}
		}
		catch(NullPointerException e)
		{
			return false;
		}
		return false;
	}

	//public void jump(int row, int col,)

	public void swap(CheckersPiece piece, int row, int col) //first piece is being swapped/jumped with second piece
	{
		int temprow = piece.row;
		int tempcol = piece.column;
		int oldrow = row;
		int oldcol = col;
		KingCheckersPiece temp = new KingCheckersPiece(priority, temprow, tempcol, myBoard);
		//if(myBoard.getPiece(row, col).priority == 0)
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


	public String toString()
	{
		if(priority == 0) return " ";
		else if(priority == 1) return "B";
		else return "R";
	}
}
