/**
This is a my Sudoku Runner.

@author Kevin Chow
@version 12.3.15
*/
public class RunnerSudoku
{
	public static void main(String[] args)
	{
		
		System.out.println(SudokuSolver.solver("SudokuBoard.csv"));

	}
}


/**
System.out.println(b.get(2,7));
			System.out.println(b.canPlace(4,4,5));
			System.out.println(b.canPlace(1,7,3));
			b.place(5,5,4);
			b.remove(3,8);
			System.out.println(b.solved());

	Gameboard b = new Gameboard("TestSudokuBoard.csv");
			b.print();
			Integer[] mc= b.getMostConstrained();
			for(int i = 0; i < mc.length; i++)
			{
				System.out.println(mc[i]);
			}
				Gameboard b = new Gameboard("SudokuBoard.csv");
		System.out.println(b);
		Integer[] mc = b.getMostConstrained();
		for(int i = 0; i < mc.length; i++)
		{
			System.out.println(mc[i]);
		}
			
		Integer[] mcp = b.getMostConstrainedPossibilities(b.getMostConstrained());
		for(int i = 0; i < mc.length; i++)
		{
			System.out.println(mcp[i]);
		}
		Gameboard b = new Gameboard("TestSudokuBoard.csv");
		Gameboard c = new Gameboard(b);
		b.remove(0,0);
		System.out.println(b);
		System.out.println(c);
	
*/


/**
For ReadMe
{
Create a new gameboard with parameter as the file name 
Numbering is from 0-8 (to represent a row or column)
	
}
		System.out.println(SudokuSolver.solver("SudokuBoard.csv"));

		System.out.println(SudokuSolver.solver("SudokuBoard.csv"));

*/