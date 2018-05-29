/*
    general backtracking approach - 
    https://leetcode.com/problems/permutations/discuss/18239/a-general-approach-to-backtracking-questions-in-java-subsets-permutations-combination-sum-palindrome-partioning

    given a set : {1,2,3} 
    generate all subsets - {}, {1}, {2}, {3}, {1,2}, {2,3}, {1,3}, {1,2,3}

    N- queens problems : 

    The N Queen is the problem of placing N chess queens on an N*N chessboard so that no two queens attack each other. For example, following is a solution for 4 Queen problem.

    { 0,  0,  1,  0}    {0,0}
    { 1,  0,  0,  0}    {0,0}
    { 0,  0,  0,  1} 
    { 0,  1,  0,  0}

    https://www.geeksforgeeks.org/backtracking-set-3-n-queen-problem/
    https://leetcode.com/problems/n-queens/discuss/ 
*/

class NQueens{
    // just a utility to print the current state of the board
    public static void printBoard(int board[][]){
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++){
                System.out.print(board[i][j] + " ");
            }

            System.out.println();
        }
    }

    // determining if there are any attacks on the current position
    public static boolean isSafe(int board[][], int x, int y){
        // checking for horizontal attacks
        for(int i = x; i >= 0; i--){
            if(board[i][y] == 1) return false;
        }

        // 135 diagonal 
        for(int i = x, j = y; i >= 0 && j >= 0; i--, j--){
            if(board[i][j] == 1) return false;
        }

        // 45 diagonal
        for(int i = x, j = y; i >= 0 && j < board.length; i--, j++){
            if(board[i][j] == 1) return false;
        }

        return true;
    }

    // placeQueens tries to place queens at columns successively , backtracking if no solution exists
    public static boolean placeQueens(int board[][], int col){
        if(col == board.length) return true;

        for(int i = 0; i < board.length; i++){
            // trying to place queen at [col][i]
            if(isSafe(board, col, i)){
                board[col][i] = 1;

                System.out.println("\n current state : \n");
                printBoard(board);

                if(placeQueens(board, col + 1)) return true;
                board[col][i] = 0;
            }
        }

        return false;
    }

    public static boolean possible(int board[][]){
        return placeQueens(board, 0);
    }

    public static void main(String args[]){
        int board[][] = {
            {0, 0, 0, 0}, 
            {0, 0, 0, 0}, 
            {0, 0 ,0, 0}, 
            {0, 0, 0, 0}
        };

        printBoard(board);

        if(possible(board)) System.out.println("possible");
        else System.out.println("not possible to place N queens");
    }
}
