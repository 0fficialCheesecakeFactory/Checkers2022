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
		
		if(canJump()) //cases where the piece can jump
		{
			try 
			{
				if(!(myBoard.getPiece(row+1, column+1).priority == 0))
				{
					if((myBoard.getPiece(row+1, column+1).getPriority() != priority) && (myBoard.getPiece(row+2, column+2).priority == 0))
					{
						CheckersPiece temp = new CheckersPiece(priority*-1,row+2, column+2, null);
						ret += " " + temp.colToString() + temp.rowToString();
						moves.add(ret);
						ret = colToString() + rowToString();
					}
				}

				if(!(myBoard.getPiece(row+1, column-1).priority == 0))
				{
					if((myBoard.getPiece(row+1, column-1).getPriority() != priority) && (myBoard.getPiece(row+2, column-2).priority == 0))
					{
						CheckersPiece temp = new CheckersPiece(priority*-1,row+2, column-2, null);
						ret += " " + temp.colToString() + temp.rowToString();
						moves.add(ret);
						ret = colToString() + rowToString();
					}
				}
				if(!(myBoard.getPiece(row-1, column+1).priority == 0))
				{
					if((myBoard.getPiece(row-1, column+1).getPriority() != priority) && (myBoard.getPiece(row-2, column+2).priority == 0))
					{
						CheckersPiece temp = new CheckersPiece(priority*-1,row-2, column+2, null);
						ret += " " + temp.colToString() + temp.rowToString();
						moves.add(ret);
						ret = colToString() + rowToString();
					}
				}

				if(!(myBoard.getPiece(row-1, column-1).priority == 0))
				{
					if((myBoard.getPiece(row-1, column-1).getPriority() != priority) && (myBoard.getPiece(row-2, column-2).priority == 0))
					{
						CheckersPiece temp = new CheckersPiece(priority*-1,row-2, column-2, null);
						ret += " " + temp.colToString() + temp.rowToString();
						moves.add(ret);
						ret = colToString() + rowToString();
					}
				}
			}catch(IndexOutOfBoundsException e) //edge cases where it cannot scan in all 4 directions
			{
				if(row == 0 && column == 7)
				{
					if(myBoard.getPiece(row+1, column-1).priority != priority && myBoard.getPiece(row+2, column-2).priority == 0)
					{
						CheckersPiece temp = new CheckersPiece(priority*-1,row+2, column-2, null);
						ret += " " + temp.colToString() +(temp.rowToString()); //-1
						moves.add(ret);
						ret = colToString() + rowToString(); //resets ret
					}
				}
				
				
				else if(row == 7 && column == 0)
				{
					if(myBoard.getPiece(row-1, column+1).priority != priority && myBoard.getPiece(row-2, column+2).priority == 0)
					{
						CheckersPiece temp = new CheckersPiece(priority*-1,row-2, column+2, null);
						ret += " " + temp.colToString() +(temp.rowToString()); //-1
						moves.add(ret);
						ret = colToString() + rowToString(); //resets ret
					}
				}
				else if(row == 7)
				{
					if(myBoard.getPiece(row-1, column-1).priority != priority && myBoard.getPiece(row-2, column-2).priority == 0)
					{
						CheckersPiece temp = new CheckersPiece(priority*-1,row-2, column-2, null);
						ret += " " + temp.colToString() +(temp.rowToString()); //-1
						System.out.println(ret); //not working the moves are weird
						moves.add(ret);
						ret = colToString() + rowToString(); //resets ret
					}
					if(myBoard.getPiece(row-1, column+1).priority != priority && myBoard.getPiece(row-2, column+2).priority == 0)
					{
						CheckersPiece temp = new CheckersPiece(priority*-1,row-2, column+2, null);
						ret += " " + temp.colToString() +(temp.rowToString()); //-1
						moves.add(ret);
						ret = colToString() + rowToString(); //resets ret
					}
				}
				else if(column == 0)
				{
					if(myBoard.getPiece(row+1, column+1).priority != priority && myBoard.getPiece(row+2, column+2).priority == 0)
					{
						CheckersPiece temp = new CheckersPiece(priority*-1,row+2, column+2, null);
						ret += " " + temp.colToString() +(temp.rowToString()); //-1
						moves.add(ret);
						ret = colToString() + rowToString(); //resets ret
					}
					if(myBoard.getPiece(row-1, column+1).priority == 0 && myBoard.getPiece(row-2, column+2).priority == 0)
					{
						CheckersPiece temp = new CheckersPiece(priority*-1,row-2, column+2, null);
						ret += " " + temp.colToString() +(temp.rowToString()); //-1
						moves.add(ret);
						ret = colToString() + rowToString(); //resets ret
					}
					
				}
			}
		}
		
		else try //cases where not jump
		{
			if(myBoard.getPiece(row+1, column-1).priority == 0)
			{
				CheckersPiece temp = new CheckersPiece(priority*-1,row+1, column-1, null);
				ret += " " + temp.colToString() +(temp.rowToString()); //-1
				moves.add(ret);
				ret = colToString() + rowToString(); //resets ret
			}
			if(myBoard.getPiece(row+1, column+1).priority == 0)
			{
				CheckersPiece temp = new CheckersPiece(priority*-1,row+1, column+1, null);
				ret += " " + temp.colToString() +(temp.rowToString()); //-1
				moves.add(ret);
				ret = colToString() + rowToString(); //resets ret
			}
			if(myBoard.getPiece(row-1, column-1).priority == 0)
			{
				CheckersPiece temp = new CheckersPiece(priority*-1,row-1, column-1, null);
				ret += " " + temp.colToString() +(temp.rowToString()); //-1
				moves.add(ret);
				ret = colToString() + rowToString(); //resets ret
			}
			if(myBoard.getPiece(row-1, column+1).priority == 0)
			{
				CheckersPiece temp = new CheckersPiece(priority*-1,row-1, column+1, null);
				ret += " " + temp.colToString() +(temp.rowToString()); //-1
				moves.add(ret);
				ret = colToString() + rowToString(); //resets ret
			}
		}catch(IndexOutOfBoundsException e) //edge cases where it cannot scan in all 4 directions
		{
			if(row == 0 && column == 7)
			{
				if(myBoard.getPiece(row+1, column-1).priority == 0)
				{
					CheckersPiece temp = new CheckersPiece(priority*-1,row+1, column-1, null);
					ret += " " + temp.colToString() +(temp.rowToString()); //-1
					moves.add(ret);
					ret = colToString() + rowToString(); //resets ret
				}
			}
			else if(row == 0)
			{
				if(myBoard.getPiece(row+1, column-1).priority == 0)
				{
					CheckersPiece temp = new CheckersPiece(priority*-1,row+1, column-1, null);
					ret += " " + temp.colToString() +(temp.rowToString()); //-1
					moves.add(ret);
					ret = colToString() + rowToString(); //resets ret
				}
				if(myBoard.getPiece(row+1, column+1).priority == 0)
				{
					CheckersPiece temp = new CheckersPiece(priority*-1,row+1, column+1, null);
					ret += " " + temp.colToString() +(temp.rowToString()); //-1
					moves.add(ret);
					ret = colToString() + rowToString(); //resets ret
				}
			}
			
			
			else if(row == 7 && column == 0)
			{
				if(myBoard.getPiece(row-1, column+1).priority == 0)
				{
					CheckersPiece temp = new CheckersPiece(priority*-1,row-1, column+1, null);
					ret += " " + temp.colToString() +(temp.rowToString()); //-1
					moves.add(ret);
					ret = colToString() + rowToString(); //resets ret
				}
			}
			else if(row == 7)
			{
				if(myBoard.getPiece(row-1, column-1).priority == 0)
				{
					CheckersPiece temp = new CheckersPiece(priority*-1,row-1, column-1, null);
					ret += " " + temp.colToString() +(temp.rowToString()); //-1
					moves.add(ret);
					ret = colToString() + rowToString(); //resets ret
				}
				if(myBoard.getPiece(row-1, column+1).priority == 0)
				{
					CheckersPiece temp = new CheckersPiece(priority*-1,row-1, column+1, null);
					ret += " " + temp.colToString() +(temp.rowToString()); //-1
					moves.add(ret);
					ret = colToString() + rowToString(); //resets ret
				}
			}
			else if(column == 0)
			{
				if(myBoard.getPiece(row+1, column+1).priority == 0)
				{
					CheckersPiece temp = new CheckersPiece(priority*-1,row+1, column+1, null);
					ret += " " + temp.colToString() +(temp.rowToString()); //-1
					moves.add(ret);
					ret = colToString() + rowToString(); //resets ret
				}
				if(myBoard.getPiece(row-1, column+1).priority == 0)
				{
					CheckersPiece temp = new CheckersPiece(priority*-1,row-1, column+1, null);
					ret += " " + temp.colToString() +(temp.rowToString()); //-1
					moves.add(ret);
					ret = colToString() + rowToString(); //resets ret
				}
				
			}
		}
		return moves;
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
