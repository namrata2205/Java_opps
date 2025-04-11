// 7. Knight's Tour Problem
class KnightsTour 
{
    static int N = 8;
    // Checks if x and y are valid indexes
    static boolean isSafe(int x, int y, int sol[][]) 
    {
        return (x >= 0 && x < N && y >= 0 && y < N && sol[x][y] == -1);
    }
    // Prints the solution
    static void printSolution(int sol[][]) 
    {
        for (int x = 0; x < N; x++) 
        {
            for (int y = 0; y < N; y++)
                System.out.printf("%2d ", sol[x][y]);
            System.out.println();
        }
    }

    // Starts knight tour from position (0, 0)
    static boolean solveKT() 
    {
        int sol[][] = new int[N][N];
        for (int x = 0; x < N; x++)
            for (int y = 0; y < N; y++)
                sol[x][y] = -1;
        int moveX[] = {2, 1, -1, -2, -2, -1, 1, 2};
        int moveY[] = {1, 2, 2, 1, -1, -2, -2, -1};
        sol[0][0] = 0;
        if (!solveKTUtil(0, 0, 1, sol, moveX, moveY)) 
        {
            System.out.println("Solution does not exist");
            return false;
        } 
        else
            printSolution(sol);

        return true;
    }

    // Utility function to solve Knight Tour problem using backtracking
    static boolean solveKTUtil(int x, int y, int movei, int sol[][], int moveX[], int moveY[]) 
    {
        int k, next_x, next_y;
        if (movei == N * N) return true;

        for (k = 0; k < 8; k++) 
        {
            next_x = x + moveX[k];
            next_y = y + moveY[k];
            if (isSafe(next_x, next_y, sol)) 
            {
                sol[next_x][next_y] = movei;
                if (solveKTUtil(next_x, next_y, movei + 1, sol, moveX, moveY))
                    return true;
                else
                    sol[next_x][next_y] = -1; // Backtrack
            }
        }

        return false;
    }

    public static void main(String args[]) 
    {
        solveKT();
    }
}