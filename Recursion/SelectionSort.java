package Recursion;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int[] arr={4,3,2,1};

        selectionSort(arr, arr.length,0,0);
        System.out.println(Arrays.toString(arr));
    }

    static void selectionSort(int[] arr, int r, int c, int max){
        if(r==0){
            return;
        }

        if(c<r){
            // finding max element in the row
            if(arr[c]>arr[max]){
                selectionSort(arr,r,c+1,c);
            } else{
                selectionSort(arr,r,c+1,max);
            }
        } else{
            // swap one the whole row is traversed and you found the max
            int temp= arr[max];
            arr[max]=arr[r-1];
            arr[r-1]=temp;
            // reduce the row length by 1
            // resetting the col and max element to 0
            selectionSort(arr,r-1,0,0);
        }
    }
}
