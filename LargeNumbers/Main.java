package LargeNumbers;

import java.math.BigInteger;

public class Main {
    public static void main(String[] args) {
        int a = 30;
        int b=67;


        // converting int/long to BigInteger
        BigInteger A = BigInteger.valueOf(33);
        BigInteger B = BigInteger.valueOf(37894523);
        BigInteger C =  new BigInteger("79846517984561274512");
        BigInteger X =  new BigInteger("79846517984561274512");
        System.out.println(C);

        // coverting BigInteger to int/long
        int c = B.intValue();

        //constatns
        BigInteger D = BigInteger.ZERO;
        BigInteger E = BigInteger.TEN;

        // ADDITITON
        BigInteger s = A.add(B);
        System.out.println(s);

        // multiply
        BigInteger M = C.multiply(X);
        System.out.println(M);
    }
}
