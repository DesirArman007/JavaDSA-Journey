package Pattern;

public class Pattern5 {
    public static void main(String[] args) {
        int num=5;

        for(int row=0; row<2*num; row++){
            int totalColsInRow= row > num ? 2*num-row : row;
            for(int col=0; col<totalColsInRow; col++){
                System.out.print("*");
            }
            System.out.println();
        }

//        for(int i=1; i<=num; i++){
//            for(int j=1; j<=i; j++){
//                System.out.print("*");
//            }
//            System.out.println();
//        }
//        for(int i=num-1; i>=0 ; i--){
//            for(int j=1; j<=i; j++){
//                System.out.print("*");
//            }
//            System.out.println();
//        }
    }
}
