package Bits;

public class SetBits {
    public static void main(String[] args) {
        int n=9;
        System.out.println(Integer.toBinaryString(n));
        System.out.println("Number of set bits in "+n+" is "+ countBits(n));
    }

    static int countBits(int n){
        int count=0;
        while(n>0){
            n -= n&-n;
            count++;
        }
        return count;
    }
}
