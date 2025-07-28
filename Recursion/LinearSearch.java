package Recursion;

import java.util.ArrayList;

public class LinearSearch {
    public static void main(String[] args) {
        int[] arr = {1,2,4,4,11,9,12};
        int target=4;
        System.out.println(search(arr, target, 0));
        searchALL(arr,target,0);
        System.out.println(list);
        System.out.println(findALLIndex(arr,target,0,new ArrayList<>()));
    }

    static ArrayList<Integer> findALLIndex(int[] arr, int target, int index, ArrayList<Integer> list) {
        if (index >= arr.length) {
            return list;
        }
        if (arr[index] == target) {
            list.add(index);
        }
        return findALLIndex(arr, target, index + 1, list);
    }

   static ArrayList<Integer> list = new ArrayList<>();
    static void searchALL(int[] arr, int target, int index){
        if(index > arr.length-1){
            return;
        }
        if(arr[index]==target){
            list.add(index);
        }
        searchALL(arr,target,index+1);
    }

    static int search(int[] arr, int target, int index){
        if(index > arr.length-1){
            return -1;
        }
        if(arr[index]==target){
            return index;
        }
        return search(arr,target,index+1);
    }

}
