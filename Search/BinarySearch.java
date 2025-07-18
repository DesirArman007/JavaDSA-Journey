package Search;

public class BinarySearch {
    public static void main(String[] args) {

        int[] arr = {1,4,5,7,8,9,34,67,89,99,654};
        int target = 89;

        System.out.println(binarySearch(arr,target));

    }

    static int binarySearch(int[] arr, int target){
        int start = 0;
        int end = arr.length-1;

        while (start < end){
            int mid = start + (end - start) /2;

            if(target < arr[mid]){
                end = mid -1;
            } else if (target > arr[mid]) {
                start = mid +1;
            }else{
                return mid;
            }

        }
        return -1;
    }
}
