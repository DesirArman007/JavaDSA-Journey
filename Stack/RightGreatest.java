package Stack;

import java.util.Arrays;

public class RightGreatest {



    public static void main(String[] args) throws Exception {
        CustomStack stack = new CustomStack();
        int[] arr = {6,7,11,4,10,8};
        System.out.println(Arrays.toString(greatest(arr)));
    }

    public static int[] greatest(int[] arr) throws Exception {
        CustomStack stack = new CustomStack();
        int ans[]=new int[arr.length];

        for(int i=0; i<arr.length; i++){
            while(!stack.isEmpty() && arr[i]>=arr[stack.peek()]){
                int index = stack.pop();
                ans[index]=arr[i];
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            int index = stack.pop();
            ans[index] = arr[index];
        }

        return ans;

    }

//    public static int[] greatest(int[] arr) {
//        int n = arr.length;
//        int ans[] = new int[n];
//
//        int maxSoFar = Integer.MIN_VALUE;
//
//        for(int i = n - 1; i >= 0; i--) {
//            maxSoFar = Math.max(maxSoFar, arr[i]);
//            ans[i] = maxSoFar;
//        }
//
//        return ans;
//    }

}
