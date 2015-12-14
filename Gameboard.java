import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;

/**
This is a my Gameboard class.

@author Kevin Chow
@version 12.13.15
*/
public class Gameboard
{
	private Integer[][] board = new Integer[9][9];

	/**
	Constructor 
	@param String filename of the csv gameboard
	*/
	public Gameboard(String filename)
	{
		Integer[] nums = readCSV(filename);
		int counter = 0;
		for(int row = 0; row < board.length; row++)
		{
			for(int col = 0; col < board[row].length; col++)
			{
				board[row][col] = nums[counter];
				counter++;
			}
		}		
	}	
	
	/**
	Copy Constructor
	@param Gameboard the Gameboard to be copied
	*/
	public Gameboard(Gameboard gb)
	{
		for(int row = 0; row < gb.getBoard().length; row++)
		{
			for(int col = 0; col < gb.getBoard()[row].length; col++)
			{	
				board[row][col] = gb.getBoard()[row][col];
			}
		}
	}
	
	/** 
	Accessor Method for board
	@return Integer[][] the 2-D array of board
	*/
	public Integer[][] getBoard()
	{
		return board;	
	}
	
	/**
	Reads the csv file that is the gameboard 
	@param String filename of the csv gameboard
	*/
	private Integer[] readCSV(String name)
	{
	
		Integer[] nums = new Integer[81];
		String pathname = name;
		File file = new File(pathname);	
		Scanner input = null;
		try
		{
			input = new Scanner(file);
		}
		catch (FileNotFoundException ex)
		{
			System.out.println(" Cannot open " + pathname );
			System.exit(1);
		}
		int counter = 0;

		
		while( input.hasNextLine() )
		{
			String takein = input.nextLine(); 
			for (String s: takein.split(","))
			{
				if(Integer.parseInt(s) == 1 || Integer.parseInt(s) == 2 || Integer.parseInt(s) == 3 || Integer.parseInt(s) == 4 || Integer.parseInt(s) == 5 || Integer.parseInt(s) == 6 || Integer.parseInt(s) == 7 || Integer.parseInt(s) == 8 || Integer.parseInt(s) == 9)
				{
					nums[counter] = Integer.parseInt(s);
				}
				else
				{
					nums[counter] = 0;
				}
				counter++;
			}
		}		
		return nums;
	}
	
	/**
	Returns a String of the board w/ formatting 
	@return String the sudoku board
	*/
	public String toString()
	{
		String toPrint = "";
		toPrint += "---------------------------";
		toPrint += "\n";

		for(int row = 0; row < board.length; row++)
		{
			toPrint += "| ";
			for(int col = 0; col < board[row].length; col++)
			{
					toPrint += board[row][col];
					if ((col+1)%3  == 0)
					{
						toPrint += " | ";
					}
					else
					{
						toPrint += " ";
					}
			}
			if ((row+1)%3 == 0)
			{
				toPrint += "\n";
				toPrint += "---------------------------";
			}
			toPrint += "\n";
		}
		return toPrint;
	}
	
	/**
	Returns the number at position r,c 
	@param int r row of number
	@param int c column of number
	@return int the number in that position (r,c)
	*/
	public int get(int r, int c)
	{
		return board[r][c];
	}
	
	/**
	Places the number at position r,c Only if canPlace is true
	Throws IllegalArgumentException if canPlace is false or n is not 1 thru 9
	@param int r row of number
	@param int c column of number
	@param int n number to be placed in that position (r,c)
	*/
	public void place(int r, int c, int n)
	{
		if( n>9 || n<1)
			throw new IllegalArgumentException();
		if (canPlace(r,c,n) == true)
		{
			board[r][c] = n;
		}
		else
		{
			System.out.println(r + " " + c + " " + n);
			throw new IllegalArgumentException();
			//was not 100% sure what exception to throw, so threw this.

		}
	}
	
	/**
	Returns true if the board would allow placing n at (r,c)
	@param int r row to be checked
	@param int c col to be checked
	@param int n number to be checked
	@return boolean whether you can place n at r,c
	*/
	public boolean canPlace(int r,int c, int n) 
	{
		if( n>9 || n<1 )
			throw new IllegalArgumentException();
		if(board[r][c] == 0) //check if the spot is empty
		{
			if(canPlaceRow(r,n) == true)
			{
				if(canPlaceColumn(c, n) == true)
				{

					if (canPlaceSquare(r,c,n) == true)
					{
						return true;
					}
				}
			}
		}
		return false;
	
	}

	/**
	To be called in canPlace. Returns if you can place n in row
	@param int r row to be checked
	@param int n number to be checked
	@return boolean whether you can place n in that row
	*/
	private boolean canPlaceRow(int r, int n)
	{
		if( n>9 || n<1)
			throw new IllegalArgumentException();
		for(int i = 0; i < board[r].length; i++)
		{
			if(board[r][i] == n)
				return false;
		}
		return true;
	}
	
	/**
	To be called in canPlace. Returns if you can place n in col
	@param int c col to be checked
	@param int n number to be checked
	@return boolean whether you can place n in that col
	*/
	private boolean canPlaceColumn(int c, int n)
	{
		if( n>9 || n<1)
			throw new IllegalArgumentException();
		for(int i = 0; i < board.length; i++)
		{
			if(board[i][c] == n)
				return false;
		}
		return true;
	}
	
	/**
	To be called in canPlace. Returns if you can place n in the box
	@param int r row to be checked
	@param int c col to be checked
	@param int n number to be checked
	@return boolean whether you can place n in that box
	*/
	private boolean canPlaceSquare(int r, int c, int n)
	{
		if( n>9 || n<1)
			throw new IllegalArgumentException();
		int startRow; // starting row of the box
		int startCol; //starting col of the box;
		
		if(r<3)
			startRow = 0;
		else // would only go to if number was bigger than 3
		{
			if(r<6)
				startRow = 3;
			else // would only go to if number was bigger than 
				startRow = 6;
		}
		
		if(c<3)
			startCol = 0;
		else // would only go to if number was bigger than 3
		{
			if(c<6)
				startCol = 3;
			else // would only go to if number was bigger than 
				startCol = 6;
		}
		
		for(int row = startRow; row < startRow + 3; row++)
		{
			for(int col = startCol; col < startCol + 3; col++)
			{
				if(board[row][col] == n)
				{
					return false;
				}
			}
		}
		
		return true;
	}
	
	/**
	Removes the number at position (r,c)
	@param int r row of number to remove
	@param int c col of number to remove
	*/
	public void remove(int r, int c)
	{
		board[r][c] = 0;
	}
	
	/**
	Returns true if the board has no more blank spots on the board
	@return boolean whether or not the board is full and solved
	*/
	public boolean solved()
	{
		for(int row = 0; row < board.length; row++)
		{
			for(int col = 0; col < board[row].length; col++)
			{
				if(board[row][col] == 0)
					return false;
			}

		}
		return true;
	}
	
	/**
	Returns the most constrained spot on the board
	@return Integer [] the row and column of the most constrained spot
	Note: if multiple spots are the "most" constrained, will default to the first one
	*/
	public Integer[] getMostConstrained()
	{
		Integer[] mConstrained = new Integer[2];
		int numPossibleLowest = 9;
		//the number of possibilities for the current most constrained spot
		
		int numPossibleCurrent;

		for(int row = 0; row < board.length; row++)
		{
			for(int col = 0; col < board[row].length; col++)
			{	
				if(board[row][col] == 0)
				{
					numPossibleCurrent = 0; //reset numPossibleCurrent
					for(int num = 1; num <= 9; num++) //check numbers 1-9
					{
						if (canPlace(row,col,num) == true)
						{
							numPossibleCurrent++;				
						}
					}
					if(numPossibleCurrent < numPossibleLowest)
					{
						mConstrained[0] = row; //row will always be first int
						mConstrained[1] = col; //col will always be second int
						numPossibleLowest = numPossibleCurrent;
					}
				}
			}
		}	
		return mConstrained;
	
	}
	
	/**
	Returns the most constrained spot on the board's (as defined by the getMostConstrained()
	method) possible numbers
	@param Integer[] rowcol the array representation of the most constrained's r and c
	@return ArrayList<Integer> the row and column of the most constrained spot
	*/
	public Integer[] getMostConstrainedPossibilities(Integer[] rowcol)
	{
	  	ArrayList<Integer> possibilities = new ArrayList<Integer>();
	  	//i choose to make this because i dont know how many possibilities there will be
	  	//and arraylists can simply grow as needed
	  
		int row = rowcol[0];
		int col = rowcol[1];
		
		for(int num = 1; num <= 9; num++) //check numbers 1-9
		{
			if (canPlace(row,col,num) == true)
			{
				possibilities.add(num);				
			}
		}
		Integer[] arrayVersionOfPossibilities = new Integer[possibilities.size()];
		//turn this back into an array because getMostConstrained returns an integer[] 
		//and want to keep consistent
		
		for (int i = 0; i< possibilities.size(); i++)
		{
			arrayVersionOfPossibilities[i] = possibilities.get(i);
		}
		return arrayVersionOfPossibilities;
	}
		
}