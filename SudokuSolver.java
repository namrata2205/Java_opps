// 2. Sudoku Solver
class SudokuSolver 
{
    public boolean solveSudoku(int[][] board) 
    {
        for (int row = 0; row < 9; row++) 
        {
            for (int col = 0; col < 9; col++) 
            {
                if (board[row][col] == 0) 
                {
                    for (int num = 1; num <= 9; num++) 
                    {
                        if (isValid(board, row, col, num)) 
                        {
                            board[row][col] = num;
                            if (solveSudoku(board)) return true;
                            board[row][col] = 0;
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isValid(int[][] board, int row, int col, int num) 
    {
        for (int i = 0; i < 9; i++) 
        {
            if (board[row][i] == num || board[i][col] == num || 
                board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == num) 
            {
                return false;
            }
        }
        return true;
    }
}