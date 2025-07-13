package Sorting;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr ={1,2,3,4,5};
        bbSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    static void bbSort(int[] arr){

        boolean swapped;
        // run outer loop n-1 times
        for(int i=0; i< arr.length ; i++){
            swapped = false;
            for (int j=1; j< arr.length-i; j++){
                if(arr[j]<arr[j-1]){
                    swap(arr, j, j - 1);
                    swapped=true;
                }
            }

            // if you dont swap for a particular value of i it means the array is sorted
            if(!swapped){
                break;
            }
        }
    }


    static void swap(int[] arr, int a ,int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
