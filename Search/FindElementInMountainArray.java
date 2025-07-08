package Search;

public class FindElementInMountainArray {
    public static void main(String[] args) {

    }

    static int findPeak(int[] arr) {
        int start = 0;
        int end = arr.length-1;

        while (start < end) {
            int mid = start + (end - start) / 2;

            if(arr[start] == arr[end]){
                return start;
            }
            else if (arr[mid] < arr[mid + 1]) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return  -1;
    }
}

