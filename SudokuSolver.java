import java.io.*;
import java.util.Scanner;

/**
This is a my SudokuSolver class.

Solves using this algorithm:
Pops a board off the stack
Checks to see if the board is solved. If it is, returns it.
Determines the most constrained square on the board 
For each possible numeral that can go in the most constrained square on the board, 
create a new board, add the numeral to the board, and push the board onto the stack. 
(Note- there may be 0 possible options for the most constrained square. 
In that case, does nothing!)
Repeats



@author Kevin Chow
@version 12.13.15
*/
public class SudokuSolver
{

	/**
	Solves the Sudoku Puzzle
	@param String filename name of the csv file to be solved
	@return Gameboard the Sudoku board, solved.
	*/
	public static Gameboard solver(String filename)
	{
		//Create a stack that is a linked list of sudoku boards 
		Stack<Gameboard> stack = new LinkedList<Gameboard>();
		Gameboard start = new Gameboard(filename);
		stack.push(start);
		boolean isSolved = false;
		while(isSolved == false)
		{
			Gameboard toCheck = stack.pop(); //Pops a board off the stack

			if(toCheck.solved() == true)
			//Checks to see if the board is solved. If it is, returns it.
			{
				isSolved = true;
				return toCheck;
			}
			Integer[] mostConstrainedSpot = toCheck.getMostConstrained();
			System.out.println(mostConstrainedSpot[0] + " " + mostConstrainedSpot[1]);
			//This spot just shoes the most constrained spot (r,c) you can comment this
			//out if you dont like this function. 
			Integer[] possibleNumbersatMC = toCheck.getMostConstrainedPossibilities(mostConstrainedSpot);
			int row = mostConstrainedSpot[0];
			int col = mostConstrainedSpot[1];
			/**
			Determines the most constrained square on the board 
			For each possible numeral that can go in the most constrained square on the 
			board, create a new board, add the numeral to the board, and push the board 
			onto the stack. 
			*/
			for (int i = 0; i < possibleNumbersatMC.length; i++)
			{
				Gameboard toAdd = new Gameboard(toCheck);
				toAdd.place(row,col,possibleNumbersatMC[i]);
				stack.push(toAdd);
			}
			


		}
		return null; //should never reach this.
	}
	
}