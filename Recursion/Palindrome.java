package Recursion;

public class Palindrome {
    public static void main(String[] args) {
        int n=344443;
        if(checkPalindrome(n)){
            System.out.println("Palindrome");
        } else{
            System.out.println("Not a palindrome");
        }
    }

    static boolean checkPalindrome(int num){
        return  rev2(num) ==num;
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
