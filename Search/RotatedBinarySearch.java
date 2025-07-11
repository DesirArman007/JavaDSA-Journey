package Search;

public class RotatedBinarySearch {
    public static void main(String[] args) {
        int[] arr ={4,5,6,7,0,1,2};
        int target = 0;

        System.out.println(search( arr, target));
    }

    static int search(int[] arr, int target){
       int pivot = findPivotWithDuplicates(arr);

       // if you do not find pivot means array not rotated
       if(pivot == -1){
           // do normal binary search
           return binarySearch(arr,target,0,arr.length-1);
       }

       // if pivot is found you have found two ascending sorted arrays
        if(arr[pivot] == target){
            return pivot;
        }
        if(target >= arr[0]) {
            return binarySearch(arr,target,0, pivot-1);
        }
            return binarySearch(arr,target,pivot+1, arr.length-1);
    }

    static int findPivot(int[] arr){
        int start = 0;
        int end = arr.length-1;

        while (start <= end){

            int mid = start + (end - start) /2;

            if(mid < end && arr[mid] > arr[mid+1]){
                return mid;
            }
            if (mid > start && arr[mid] < arr[mid-1]) {
                return mid-1;
            }
            if (arr[start] >= arr[mid]) {
                  end = mid-1;
            } else{
                start = mid +1;
            }
        }
        return -1;
    }

    static int findPivotWithDuplicates(int[] arr){
        int start = 0;
        int end = arr.length-1;

        while (start <= end){

            int mid = start + (end - start) /2;

            if(mid < end && arr[mid] > arr[mid+1]){
                return mid;
            }
            if (mid > start && arr[mid] < arr[mid-1]) {
                return mid-1;
            }
            //if elements at middle, start, end are equal then just skip the duplicates
            if(arr[mid] == arr[start] && arr[mid]==arr[end]){
                //skip the duplicates
                // What if the element at start and end were the pivots
                //check if start is pivot
                if(arr[start] > arr[start+1]){
                    return start;
                }
                start++;
                //check if end is pivot
                if(arr[end] < arr[end-1]){
                    return end-1;
                }
                end--;
            } else if (arr[start] < arr[mid] || arr[start] == arr[mid] && arr[mid] > arr[end]) {
                start = mid + 1;
            } else{
                end = mid - 1;
            }

        }
        return -1;
    }


    static int binarySearch(int[] arr, int target,  int start, int end){
        while (start <= end){
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
