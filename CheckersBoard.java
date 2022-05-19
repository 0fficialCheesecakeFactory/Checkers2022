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
				for (int c = 0; c < checkersBoard[0].length; c+=2)
				{
					checkersBoard[r][c] = new CheckersPiece(1, r, c, this);
				}
			}
			else
			{
				for (int c = 1; c < checkersBoard[0].length; c+=2)
				{
					checkersBoard[r][c] = new CheckersPiece(1, r, c, this);
				}
			}
		}

		//red pieces
		for (int r = 5; r < checkersBoard.length; r++)
		{
			if(r%2 == 0)
			{
				for (int c = 0; c < checkersBoard[0].length; c+=2)
				{
					checkersBoard[r][c] = new CheckersPiece(2, r, c, this);
				}
			}
			else
			{
				for (int c = 1; c < checkersBoard[0].length; c+=2)
				{
					checkersBoard[r][c] = new CheckersPiece(2, r, c, this);
				}
			}
		}
		flip(checkersBoard);
	}

	//copy each character of the file into a char[][], then use the position of each char in that array to place them in the board.
	public CheckersBoard(File f)
	{
		char[][] spots = new char[8][8];
		try
		{
			Scanner scan = new Scanner(f);
			for(int i = 0; i < f.length(); i++)
			{
				String temp = scan.next();
				for(int c = 0; c < spots.length; c++)
				{
					spots[i][c] = temp.charAt(c); //translates the file into a 2d array
				}
			}

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
					else //null pieces (spaces)
					{
						checkersBoard[r][col] = null;
					}
				}
			}
		}
		catch(Exception IOException)
		{
			System.out.println("invalid file");
		}
	}

	private CheckersPiece[][] flip(CheckersPiece[][] flipBoard)
	{
		for(int r = 0; r < flipBoard.length; r++)
		{
			for(int c = 0; c < flipBoard[0].length; c++)
			{
				CheckersPiece temp = flipBoard[8-r][c];
				flipBoard[8-r][c] = flipBoard[r][c];
				flipBoard[r][c] = temp;
			}
		}
		return flipBoard;
	}

	public CheckersPiece getPiece(int row, int col)
	{
		return checkersBoard[row][col];
	}

	public KingCheckersPiece kingPiece(int row, int col)
	{
		KingCheckersPiece king = new KingCheckersPiece(checkersBoard[row][col].getPriority(), row, col, this);
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
				out += checkersBoard[r][c];
			}
			out += "\n";
		}

		return out;
	}

	public void printBoard()
	{
		//figure out an algorithm to prin a visual representation of the board
	}

}
