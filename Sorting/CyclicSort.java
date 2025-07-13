package Sorting;

import java.util.Arrays;

public class CyclicSort {
    public static void main(String[] args) {
        int[] arr ={4,3,2,7,8,2,3,1};
        cyclicSort(arr);
        System.out.println(Arrays.toString(arr));
    }


    static void cyclicSort(int[] arr){
        int i=0;
        while ( i < arr.length){
//            if(arr[i]-1 == i){
//                i++;
//            } else{
//                swap(arr, i, arr[i]-1);
//            }

            int correctIndex = arr[i]-1;
            if(arr[i] != arr[correctIndex]){
                    swap(arr, i, correctIndex);
            }else{
                i++;
            }
        }


    }

    static void swap(int[] arr, int a ,int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
