package Backtracking;

import javax.xml.transform.Source;

public class N_Queens {
    public static void main(String[] args) {
        int n=4;
        boolean[][] board = new boolean[n][n];
        System.out.println("Ways to solve the problem: "+queens(board,0));
    }

    // you can remove "int col" because we start from 0 each time
    static int queens(boolean[][] board, int row){
        if(row == board.length){
            display(board);
            return 1;
        }

         int count=0;

        // placing the queen and checking every row and col
        for(int col=0; col< board.length; col++){
            //placing the queen if its is safe
            if(isSafe(board, row, col)){
                board[row][col]=true;
                count += queens(board,row+1);
                board[row][col]=false;
            }
        }
        return count;
    }

    private static boolean isSafe(boolean[][] board, int row, int col) {

        // if board[row][col] is true then there is a QUEEN SO NOT SAFE return false;

        // check vertical row
        for(int i=0; i<row; i++){
            if(board[i][col]){
                return false;
            }
        }

        // diagonal left
        int maxLeft = Math.min(row,col);
        for(int i=1; i<= maxLeft; i++){
           if(board[row-i][col-i]){
               return false;
           }
        }

        // diagonal left
        int maxRight = Math.min(row, board.length-col-1);
        for(int i=1; i<= maxRight; i++){
            if(board[row-i][col+i]){
                return false;
            }
        }

        return true;
    }

    private static void display(boolean[][] board) {
        for(boolean[] row: board){
            for(boolean element: row){
                if(element){
                    System.out.print("Q ");
                } else {
                    System.out.print("X ");
                }
            }
            System.out.println();
        }
        System.out.println();

    }
}
