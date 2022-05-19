import java.util.*;

public class KingCheckersPiece extends CheckersPiece
{
	public KingCheckersPiece(int priority, int row, int col, CheckersBoard board)
	{
		super(priority, row, col, board);
	}

	public ArrayList<String> legalMoves()
	{
		//Copy from parent when it is complete
		//combine validity for r and b
	}

	public boolean canJump()
	{
		//Copy from parent when it is complete
		//combine validity for r and b
	}

	public String toString()
	{
		if(priority == 0) return " ";
		else if(priority == 1) return "B";
		else return "R";
	}
}
