package Recursion;

public class Patterns {
    public static void main(String[] args) {
//        revTriange(4,0);
        Triangle(4,0);
    }

    static void Triangle(int row, int col){
        if(row == 0){
            return;
        }

        if(col < row){
            Triangle(row,col+1);
            System.out.print("*");

        } else{
            Triangle(row-1, 0);
            System.out.println();

        }

    }

    static void revTriange(int row, int col){
        if(row == 0){
            return;
        }

        if(col < row){
            System.out.print("*");
            revTriange(row,col+1);
        } else{
            System.out.println();
            revTriange(row-1, 0);
        }
    }
}
