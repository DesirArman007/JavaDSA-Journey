package Search;
public class kthMissingPositive {
    public static void main(String[] args) {
        int arr[] ={2,3,4,7,9,11,16};
        int k=7;
        System.out.println(findmissingNumFromLeft(arr,k));
    }

    //To find the k-th missing positive number from the left side of the array
    static int findmissingNumFromLeft(int[] arr, int k){
        int left = 0;
        int right = arr.length-1;
        while(left <= right){
            int mid = left + (right-left)/2;
            int missing  = arr[mid]-arr[0]-mid;
            if(missing >= k){
                right = mid-1;
            } else{
                left = mid+1;
            }
        }
        return arr[0]+right+k;
    }

    //To find the k-th missing positive number from the right side of the array
    static int findmissingNumFromRight(int[] arr, int k){
        int left = 0;
        int right = arr.length-1;
        while(left <= right){
            int mid = left + (right-left)/2;
            int missing  = arr[mid]- 1-mid;
            if(missing >= k){
                right = mid-1;
            } else{
                left = mid+1;
            }
        }
        return left +k;
    }
}
