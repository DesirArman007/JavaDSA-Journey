package Search;

//Special Array With X Elements Greater Than or Equal X

import java.util.Arrays;

public class LeetCode_1608 {
    public static void main(String[] args) {
        int[] arr = {3, 4, 4, 0, 0};
        Arrays.sort(arr);
// APPROACH3

        int[] ans = new int[arr.length+1];

        for(int n: arr){
            ans[n]++;
        }

        int cSum=0;
        for(int i= arr.length; i >=0; i--){
            cSum += ans[i];
            if(i == cSum){
                System.out.println(i);
                break;
            }
        }

    }
// APPROACH2
//        int low = 0;
//        int high = arr.length;
//        int ans = -1;
//
//        while (low <= high) {
//            int mid = low + (high - low) / 2;
//
//            int index = bSearch(arr, mid);
//            int count = arr.length - index;
//
//            if (count > mid) {
//                low = mid + 1;
//            } else if (count < mid) {
//                high = mid - 1;
//            } else {
//                ans = mid;
//                break;
//            }
//
//
//        }
//        System.out.println(ans);
//    }



// APPROACH1
//        for(int x=0; x<=arr.length; x++){
//           int index =  bSearch(arr,x);
//           int count = arr.length - index;
//                   if(count == x){
//                       System.out.println(count);
//                       break;
//                   }
//        }
//    }




    static int bSearch(int[] arr, int target){
        int start=0;
        int end=arr.length-1;
        int ans=-1;
        while(start<=end){
            int mid = start+(end-start)/2;

            if(arr[mid] >= target){
                ans=mid;
                end = mid-1;
            } else {
                start=mid+1;
            }
        }

        return ans;
    }
}
