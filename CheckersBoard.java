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

//TODO Mantis: Finish this; copy each character of the file into a char[][], then use the position of each char in that array to place them in the board.
	public CheckersBoard(File f)
	{
		Scanner scan = new Scanner(System.in);
		char[][] spots = new char[8][8];
		try
		{
			for(int i = 0; i < f.length(); i++)
			{
				for(int c = 0; c < spots.length; c++)
				{
					char[i][c] = 
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

}
