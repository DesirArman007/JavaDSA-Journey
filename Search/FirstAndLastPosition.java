package Search;

import java.util.ArrayList;

public class FirstAndLastPosition {
    public static void main(String[] args) {
        int[] arr = {7};
        int target = 7;

        ArrayList<Integer> list = new ArrayList<>();
        int index1 = FirstBS(arr, target);
        int index2 = lastBS(arr, target);
        list.add(index1);
        list.add(index2);

        System.out.println(list.toString());
    }

    static int FirstBS(int[]arr, int target){
        int start = 0;
        int end = arr.length-1;
        int result = -1;

        while (start <= end){
            int mid = start + (end - start) /2;

            if(target == arr[mid]){
                result = mid;
                end = mid -1;
            } else if (target > arr[mid]) {
                start = mid +1;
            }else{
                 end = mid -1;
            }
        }
        return result;
    }

    static int lastBS(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;
        int result = -1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (target == arr[mid]) {
                result = mid;
                start = mid + 1;
            } else if (target > arr[mid]) {
                end = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return result;
    }
}
