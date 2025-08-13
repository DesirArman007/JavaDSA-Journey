package Recursion;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {5, 1, 3, 2, 8, 6};
        int[] sorted = mergeSort(arr);
        System.out.println(Arrays.toString(sorted));
    }

    static int[] mergeSort(int[] arr){
        if(arr.length==1){
            return arr;
        }

        int mid = arr.length/2;
      int[] left = mergeSort(Arrays.copyOfRange(arr, 0,mid));
      int[] right = mergeSort(Arrays.copyOfRange(arr,mid,arr.length));

      return  merge(left,right);
    }

    private static int[] merge(int[] left, int[] right) {
        int[] ans = new int[left.length + right.length];

        int i=0;
        int j=0;
        int k=0;
        while(i<left.length && j<right.length){
            if(left[i] < right[j]){
                ans[k] = left[i];
                i++;
                k++;
            } else{
                ans[k] = right[j];
                j++;
                k++;
            }
        }

        while (i!= left.length){
            ans[k] = left[i];
            i++;
            k++;
        }
        while (j!= right.length){
            ans[k] = right[j];
            j++;
            k++;
        }

        return ans;
    }




    // InPlace

    static void mergeSortInPlace(int[] arr , int s, int e){
        if(e-s==1){
            return ;
        }

        int mid = arr.length/2;
        mergeSortInPlace(arr, 0,mid);
        mergeSortInPlace(arr,mid,e);

//          mergeInPlace(arr, s, mid, e);
    }

//    private static void mergeInPlace(int[] arr, int s, int m, int e) {
//        int[] ans = new int[e-s];
//
//        int i=s;
//        int j=m;
//        int k=0;
//        while(i<m && j<e){
//            if(arr[i] < arr[j]){
//                ans[k] = arr[i];
//                i++;
//                k++;
//            } else{
//                ans[k] = arr[j];
//                j++;
//                k++;
//            }
//        }
//
//        while (i!= m){
//            ans[k] = arr[i];
//            i++;
//            k++;
//        }
//        while (j!= e){
//            ans[k] = arr[j];
//            j++;
//            k++;
//        }
//
//    }
}
