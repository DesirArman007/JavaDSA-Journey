package Recursion;

public class ReverseNumber {
    public static void main(String[] args) {
        int n=12345;

        rev(n);
        System.out.println("Rev 2:"+rev2(n));
    }

    static int sum=0;
    static void rev(int n){
//        if(n>0){
//            System.out.print(n%10+" ");
//            rev(n/10);
//        }

        if(n==0){
            System.out.println(sum);
            return;
        }
        int rem= n%10;
        sum= sum*10+rem;
        rev(n/10);
    }

    static int rev2(int n){
        int digits = (int)Math.log10(n)+1;
        return helper(n,digits);
    }

    private static int helper(int n, int digits) {
        if(n%10==n){
            return n;
        }

        int rem = n%10;
        return rem * (int)(Math.pow(10,digits-1)) + helper(n/10, digits-1);
    }
}
