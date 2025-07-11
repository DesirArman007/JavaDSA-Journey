package Search;

public class SplitArraySum {
    public static void main(String[] args) {

    }

    public int splitArray(int[] nums, int k) {
        int start=0;
        int end=0;

        for (int i=0; i<nums.length; i++){
            start = Math.max(start,nums[i]); // this will contain the max elemtn at the end of the loop
            end = end + nums[i];
        }

        while (start<end){
            // binary search
            int mid = start + (end-start) /2;

            // calc how many peieces you can divide it with max sum
            int sum=0;
            int pieces=1;

           for(int num: nums){
               if(sum + num > mid){
                   // means you cannot add this in the sub array, make a new one
                   // say if you add this sum in new subarray then sum = num
                   sum = num;
                   pieces++;
               } else{
                   sum += num;
               }
           }

           if(pieces > k){
               start = mid +1;
           } else{
               end = mid;
           }

        }

        return end; // you can reurn either start or end as here start==end
    }
}
