package Bits;

public class PowerOfTwoCheck {
    public static void main(String[] args) {
        int num=1;

        if(check(num)){
            System.out.println("In power of 2");
        } else{
            System.out.println("Not in power of 2");
        }

    }

    static boolean check(int num){
        return (num&(num-1))==0;
    }
}
