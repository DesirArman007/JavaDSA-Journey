package Pattern;

public class Pattern28 {
    public static void main(String[] args) {
        int num=5;

        for(int row=0; row<2*num; row++){
            int totalColsInRow= row > num ? 2*num-row : row;

            int numOfSpaces = num-totalColsInRow;
            for (int j=0; j<numOfSpaces; j++){
                System.out.print(" ");
            }
            for(int col=0; col<totalColsInRow; col++){
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}
