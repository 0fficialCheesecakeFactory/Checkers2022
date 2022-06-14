import java.util.*;
import java.io.*;

public class CheckersBoard
{
	private CheckersPiece[][] checkersBoard;

	public CheckersBoard()
	{
		checkersBoard = new CheckersPiece[8][8];

		//black pieces
		for (int r = 0; r < 3; r++)
		{
			if(r%2 == 0)
			{
				for (int c = 1; c < checkersBoard[0].length; c+=2)
				{
					checkersBoard[r][c] = new CheckersPiece(2, r, c, this);
				}
			}
			else
			{
				for (int c = 0; c < checkersBoard[0].length; c+=2)
				{
					checkersBoard[r][c] = new CheckersPiece(2, r, c, this);
				}
			}
		}


		//red pieces
		for (int r = 5; r < checkersBoard.length; r++)
		{
			if(r%2 == 0)
			{
				for (int c = 1; c < checkersBoard[0].length; c+=2)
				{
					checkersBoard[r][c] = new CheckersPiece(1, r, c, this);
				}
			}
			else
			{
				for (int c = 0; c < checkersBoard[0].length; c+=2)
				{
					checkersBoard[r][c] = new CheckersPiece(1, r, c, this);
				}
			}
		}

		//empty spaces
		for (int r = 0; r < checkersBoard.length; r++)
		{
			for (int c = 0; c < checkersBoard[0].length; c++)
			{
				if ((checkersBoard[r][c]==(null)))
				{
					checkersBoard[r][c] = new CheckersPiece(0, r, c, this);
				}
			}
		}
		//	flip();
	}

	//copy each character of the file into a char[][], then use the position of each char in that array to place them in the board.
	public CheckersBoard(File f)
	{
		char[][] spots = new char[8][8];
		try
		{
			Scanner scan = new Scanner(f);
			for(int i = 0; i < 8; i++)
			{
				String temp = scan.nextLine();
				for(int c = 0; c < 8; c++)
				{
					spots[i][c] = temp.charAt(c); //translates the file into a 2d array
				}
			}

			checkersBoard = new CheckersPiece[8][8];
			for (int r = 0; r < spots.length; r++)
			{
				for (int col = 0; col < spots[r].length; col++) //translates the characters in the array to actual pieces
				{
					if (spots[r][col] == 'r') //red
					{
						checkersBoard[r][col] = new CheckersPiece(2, r, col, this);
					}
					else if (spots[r][col] == 'b') //black
					{
						checkersBoard[r][col] = new CheckersPiece(1, r, col, this);
					}
					else if (spots[r][col] == 'R')
					{
						checkersBoard[r][col] = new KingCheckersPiece(2, r, col, this, false);
					}
					else if (spots[r][col] == 'B')
					{
						checkersBoard[r][col] = new KingCheckersPiece(1, r, col, this, false);
					}
					else //empty pieces (priority 0 b/c they do not exist)
					{
						checkersBoard[r][col] = new CheckersPiece(0, r, col, this);
					}
				}
			}
		}
		catch(IOException e)
		{
			System.out.println("invalid file");
			e.printStackTrace();
		}
	}
	public CheckersPiece getPiece(int row, int col)
	{
		return checkersBoard[row][col];
	}

	public KingCheckersPiece kingPiece(int row, int col)
	{
		KingCheckersPiece king = new KingCheckersPiece(checkersBoard[row][col].getPriority(), row, col, this, checkersBoard[row][col].hasJumped);
		checkersBoard[row][col] = king;
		return king;
	}

	public int[] getPiecePosition(CheckersPiece piece) 
	{
		int[] pos = new int[2];
		pos[0] = piece.getRow();
		pos[1] = piece.getCol();
		return pos;
	}

	public String toString()
	{
		String out = "";
		for(int r = 0; r < checkersBoard.length; r++)
		{
			for (int c = 0; c < checkersBoard[r].length; c++)
			{
				if (checkersBoard[r][c] != null)
					out += checkersBoard[r][c];
				else
					out += " ";
			}
			out += "\n";
		}
		return out;
	}

	public void printBoard()
	{
		//figure out an algorithm to prin a visual representation of the board
		System.out.println("  ---+---+---+---+---+---+---+--- ");

		for (int r = 0; r < checkersBoard.length; r++)
		{
			System.out.print(8-r);
			for(int c = 0; c < checkersBoard[r].length; c++)
			{
				if (checkersBoard[r][c]!=null)
					System.out.print(" | " + checkersBoard[r][c]);
				else
					System.out.print(" |  ");
			}
			if (r!=7)
				System.out.println(" |\n* |---+---+---+---+---+---+---+---|");
			else	
				System.out.println(" |\n  ---+---+---+---+---+---+---+---");
		}
		System.out.println("    A * B * C * D * E * F * G * H");
	}

	public void add(CheckersPiece temp, int row, int column) 
	{
		checkersBoard[row][column] = temp;

	}

	public void add(KingCheckersPiece temp, int row, int column) 
	{
		checkersBoard[row][column] = temp;

	}

	public void delete(int row, int col)
	{
		checkersBoard[row][col].priority = 0;

	}


}
