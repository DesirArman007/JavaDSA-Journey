package Bits;


public class OddEven {
    public static void main(String[] args) {
        int n=15;

        if (isOdd(n)){
            System.out.println("odd");
        } else {
            System.out.println("Even");
        }

    }

    static boolean isOdd(int num){
        return (num&1)==1;
    }
}
