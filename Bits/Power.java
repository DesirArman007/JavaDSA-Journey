package Bits;

public class Power {
    public static void main(String[] args) {
        int base=3;
        int power=6;
        int ans=1;

        while(power>0){
            if((power&1)==1){
                ans *= base;
            }
            // increase the base regardless of whether the current bit is 1 or 0.
            base *= base;
            power = power >>1;
        }

        System.out.println(ans);
    }
}
