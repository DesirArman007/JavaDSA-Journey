package Recursion;

public class CountZeros {
    public static void main(String[] args) {
        int num=20000;

        System.out.println(numOfZeros(num));
    }

    static int numOfZeros(int num){
        int count=0;
        return helper(num,count);
    }

    // special pattern, how to pass a value to above calls
    static int helper(int num, int count){
        // this line will only run in last and pass the value which will be passed to above functions
        if(num==0){
            return count;
        }
        int digit = num%10;
        if(digit==0){
          return   helper(num/10, count+1);
        }else {
          return   helper(num/10,count);
        }
    }
}
