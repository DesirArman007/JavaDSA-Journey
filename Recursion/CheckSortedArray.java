package Recursion;

public class CheckSortedArray {
    public static void main(String[] args) {
        int[] arr = {1,2,4,11,9,12};

        System.out.println( isSorted(arr, 1));
    }

    static boolean isSorted(int[] arr, int index){
        if(index == arr.length-1){
            return true;
        }
        return arr[index] > arr[index-1] && isSorted(arr,index+1);
    }
}
