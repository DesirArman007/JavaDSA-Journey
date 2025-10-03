package Backtracking;

import java.util.ArrayList;
import java.util.Arrays;

public class Maze {
    public static void main(String[] args) {
        //printPaths("",3,3);
        System.out.println();
       // System.out.println(printPathsReturnsList("",3,3));

        boolean[][] board = {
                {true, true, true},
                {true, true, true},
                {true, true, true}
        };

//        AllPaths("",board,0,0);

        int[][] path = new int[board.length][board[0].length];
        printAllPaths("",board,0,0,path,1);


//        pathRestrictions("",board,0,0);
    }

    static void printPaths(String p, int r, int c){
        if(r==1 && c==1){
            System.out.print(p+ " ");
            return;
        }

        if(r>1 && c>1){
            printPaths(p+"D",r-1,c-1);
        }

        if(r>1){
            printPaths(p+"V",r-1,c);
        }
        if(c>1){
            printPaths(p+"H",r,c-1);
        }

    }





    static ArrayList<String> printPathsReturnsList(String p, int r, int c){
        if(r==1 && c==1){
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }

        ArrayList<String> ans = new ArrayList<>();

        if(r>1 && c>1){
            ans.addAll(printPathsReturnsList(p+"D",r-1,c-1));
        }

        if(r>1){
            ans.addAll(printPathsReturnsList(p+"R",r-1,c));
        }
        if(c>1){
            ans.addAll(printPathsReturnsList(p+"C",r,c-1));
        }
        return  ans;
    }


    static void pathRestrictions(String p, boolean[][] arr, int r, int c){
        if(r== arr.length-1 && c == arr[0].length-1){
            System.out.println(p);
            return;
        }

        if(!arr[r][c]){
            return;
        }
        if(r< arr.length-1){
            pathRestrictions(p+'D', arr, r+1,c);
        }

        if(c< arr[0].length-1){
            pathRestrictions(p+'R',arr,r,c+1);
        }
    }

    static void printAllPaths(String p, boolean[][] arr, int r, int c, int[][] path, int s){
        if(r== arr.length-1 && c == arr[0].length-1){
            path[r][c] = s;
            for(int[] array : path){
                System.out.println(Arrays.toString(array));
            }
            System.out.println();
            return;
        }

        if(!arr[r][c]){
            return;
        }

        // if it is not false means i am considering it in my path
        arr[r][c] =false;

        path[r][c] = s;

        if(r< arr.length-1){
            printAllPaths(p+'D', arr, r+1,c,path,s+1);
        }

        if(c< arr[0].length-1){
            printAllPaths(p+'R',arr,r,c+1,path,s+1);
        }

        if(r>0){
            printAllPaths(p+'U',arr,r-1,c,path,s+1);
        }

        if(c>0){
            printAllPaths(p+'L',arr,r,c-1,path,s+1);
        }

        // this is the line where the function will remove
        // so before the function gets removed also remove the changes made by that function

        arr[r][c] = true;
        path[r][c]=0;

    }

    static void AllPaths(String p, boolean[][] arr, int r, int c){
        if(r== arr.length-1 && c == arr[0].length-1){
            System.out.println(p);
            return;
        }

        if(!arr[r][c]){
            return;
        }

        // if it is not false means i am considering it in my path
        arr[r][c] =false;

        if(r< arr.length-1){
            AllPaths(p+'D', arr, r+1,c);
        }

        if(c< arr[0].length-1){
            AllPaths(p+'R',arr,r,c+1);
        }

        if(r>0){
            AllPaths(p+'U',arr,r-1,c);
        }

        if(c>0){
            AllPaths(p+'L',arr,r,c-1);
        }

        // this is the line where the function will remove
        // so before the function gets removed also remove the changes made by that function

        arr[r][c] = true;

    }
}
