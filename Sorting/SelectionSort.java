package Sorting;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int[] arr ={1,2,3,4,5};
        selectionSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    static void selectionSort(int[] arr){

        // run outher loop n-1 times
        for(int i = 0; i < arr.length; i++){

            int last = arr.length-i-1;
            int maxIndex = getMaxIndex(arr, 0, last);
            swap(arr,maxIndex, last);
        }
    }

    private static int getMaxIndex(int[] arr, int start, int end) {
        int maxIndex = start;
        while (start <= end){
            if(arr[start] > arr[maxIndex]){
                maxIndex = start;
            }

            start++;
        }

        return maxIndex;
    }

    static void swap(int[] arr, int a ,int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
