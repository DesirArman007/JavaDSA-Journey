package Search;

public class OrderAgnosticBinarySearch {
    public static void main(String[] args) {
        int[] ascArr = {1, 3, 5, 7, 9, 11, 13, 15};
        int Asctarget = 9;

        int result = OrderAgnosticBS(ascArr,Asctarget);
        System.out.println("Ascending Array: Target found at index = " + result);

        int[] descArr = {20, 17, 15, 13, 10, 7, 5, 2, 0};
        int Desctarget = 13;
        int result2 = OrderAgnosticBS(descArr, Desctarget);
        System.out.println("Descending Array: Target found at index = " + result2);

    }

    static int OrderAgnosticBS(int[] arr, int target){
        int start = 0;
        int end = arr.length-1;

        boolean isAsc = arr[start] < arr[end];

        while (start <= end){
            int mid = start +(end-start)/2;

            if(arr[mid] == target){
                return mid;
            }

            if(isAsc){
                if( target > arr[mid] ){
                    start = mid+1;
                } else{
                    end = mid-1;
                }
            } else{
                if(target > arr[mid]){
                    end = mid -1;
                } else{
                    start = mid +1;
                }
            }
        }

        return -1;
    }
}
