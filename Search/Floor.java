package Search;

public class Floor {
    public static void main(String[] args) {
        int[] arr ={2,3,5,9,14,16,18};
        int target = 4;

        int result = floor(arr,target);
        System.out.println("Floor of number is: "+arr[result]);
    }

    static int floor(int[] arr, int target){
        // if target is smaller than the smallest element in array
        if(target < arr[0]){
            return -1;
        }
        int start = 0;
        int end = arr.length-1;

        while (start <= end){
            int mid = start + (end - start) /2;

            if(target < arr[mid]){
                end = mid -1;
            } else if (target > arr[mid]) {
                start = mid +1;
            }else{
                return mid;
            }

        }
        return end;
    }
}
