package Recursion;

public class rotatedBinarySearch {
    public static void main(String[] args) {
        int[] arr= {5,6,7,8,9,1,2,3,4};
        int target=8;

        System.out.println(rotatedBS(arr,target,0,arr.length-1));
    }

    static int rotatedBS(int[] arr, int target, int start, int end){
       if(start > end){
           return -1;
       }

       int mid = start+(end-start)/2;

       if(target == arr[mid]){
           return mid;
       }

       if(arr[start] <= arr[mid]){
           if(target >= arr[start] && target <= arr[mid]){
             return rotatedBS(arr,target,start, mid-1);
           } else {
               return rotatedBS(arr,target,mid+1, end);
           }
       }

       if(target >= arr[mid] && target <= arr[end]){
           return rotatedBS(arr,target,mid+1, end);
       }else{
           return rotatedBS(arr,target,start, mid-1);
       }
    }

}
