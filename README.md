# Checkers2022
Checkers project for Highschool Compsci Class

Below is the official planning document used to outline our task

Checkers.java
 Private CheckersBoard board;
Private int firstToAct;

Public checkers() 
Board board = new board
firstToAct = 1;

Public checkers(File startingPositions, int firstToAct)
this.firstToAct = firstToAct
Board = new checkersboard(startingPositions)

Public void run()
Runs whole game //to be implemented later

Public CheckersBoard boardResult(File moves)
File read = moves
//depends on file format


CheckersPiece.java
Import ArrayList
private int priority;
private int row;
	private int column;
	private CheckersBoard myBoard;

Public CheckersPiece(int priority, int row, int col, CheckersBoard board)
{This.priority = priority
This.row = row
Column = col
myBoard = board}

Public ArrayList<String> legalMoves()
{ArrayList moves = new ArrayList<String> () 

for(all checkerspieces on board with identity 1)
{
	if(that piece can jump)
(add that piece with the jump coordinate to the list
}

if(moves is empty)
{
	for(all checkerspieces on board with identity 1)
{

if(there is an empty slot at (x value - 1)(y value minus 1)
Add initial position and empty position to list

if(there is an empty slot at (x value + 1)(y value minus 1)
Add initial position and empty position to list
}


}



Return moves}

Public boolean move(int row, int col)
{ if(this.legalMoves().contains(row and col)
	if(this.canJump())
		jump(this, row, col)
	Else swap(this, row, col)
	Return true
Return false}

Public void swap(CP piece, row, col)
{
	CheckersPiece temp = piece;
	if(myBoard.getPiece(row,col) == null)
	{
		Temp.row = row;
		Temp.column = col;
		Piece = null;
	}
}	

Public boolean canJump()
{if (black)
	{
	If ((row+1), (col +1) is red && (row+2), (col+2) is empty || the other side)
	{return true}
	}
Else
	{same if statement but going down
	{Return true}}
Return false;

Public String toString()
{String name;
If (black)
	{name = “b”}
Else {name = “r”}
Return name}

KingPiece.java extends CheckersPiece
Public ArrayList<String> legalMoves()
//combine if and else statements when checking for non-jumps

Public boolean canJump()
//combine if and else of parent

Public String toString()
//make letters capital instead

CheckersBoard.java
private CheckersPiece[][] checkersBoard;
public CheckersBoard()
{
Start at 0,0 - add piece every other spot UNLESS that piece is in row 4 or 5 or piece exceeds row
For spots without piece, make the checkersPiece null;
Flip method at end of loop which takes every piece, switches its row to 8-(current).
Once flipped, if in rows 1, 2, or 3 AND not null priority is 1, rows 6-8 AND not null priority is 2
}
public CheckersBoard(File f)
{
Uses scanner to read positions line by line and add a piece to those spots
All other pieces will be null

}

Public CheckersPiece getPiece (int row, int col)
{Return checkersBoard[row][col]; //if there is no piece there, constructor set it to null}

Public KingCheckersPiece kingPiece(int row, int col)
{cast CP object @ (row, col) to King CP
Replace original CP object on board with new King
Return new King}

Public int[] getPiecePosition(CheckersPiece piece)
{ new 2 int array length = 2
Array[0] = piece.row
Array[1] = piece.col
Return array;}
