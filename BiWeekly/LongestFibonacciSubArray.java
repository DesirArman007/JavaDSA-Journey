package BiWeekly;

public class LongestFibonacciSubArray {

    public int longestSubarray(int[] nums) {
        if(nums.length<=2){
            return nums.length;
        }

        int count=2,maxCount = 2;
        for(int i=2; i<nums.length-3; i++){
            int n1=nums[i];
            int n2= nums[i+1];
            if((n1+n2)==nums[i+2]){
                count++;
                maxCount = Math.max(maxCount, count);

            }
        }
        return count;
    }
}
