# Sudoku Solver - Solves Sudokus
ReadMe
To use my Sudoku Solver, call the class "SudokuSolver"'s solver method. There should be one parameter when calling that method,
the csv file of the to-be-solved board. 
Note: Blank spaces should be denoted by 0's.

The solver method simply returns an item of type Gameboard. You must print it to see the final solved board.
Example to call in runner:

System.out.println(SudokuSolver.solver("SudokuBoard.csv"));

OR

You can use the runner I have included. If you want to try different boards, simply change the csv file in this folder/add a new one 
and change the name in the runner class.

Note #2: The values printed out are the spots (r,c). This helps because it shows, at a quick glance, the runtime. In adition, it helps give a picture of what and how the solver is working.
