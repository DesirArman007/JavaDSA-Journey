package LinkedList;

public class HappyNumber {
    public static void main(String[] args) {

        System.out.println(isHappy(12));
    }

    public static boolean isHappy(int n) {
      int slow = n;
      int fast = n;

        do{
            slow = findSquare(slow);
            fast = findSquare(findSquare(fast));
        }while(fast != slow);

        if(slow==1){
            return true;
        }
        return false;
    }

    static int findSquare(int num){
        int ans=0;
        while(num>0){
            int rem = num%10;
            ans = ans+ rem*rem;
            num=num/10;
        }
        return ans;
    }
}
