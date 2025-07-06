package Search;

public class SmallestLetter {

    public static void main(String[] args) {
        char[] arr ={'c','f','j'};
        char target = 'j';

        char result = cieling(arr,target);
        System.out.println("Cieling of letters is: "+ result);
    }

    static char cieling(char[] arr, char target){

        int start = 0;
        int end = arr.length-1;
        int n = arr.length;

        while (start <= end){
            int mid = start + (end - start) /2;

            if(target < arr[mid]){
                end = mid -1;
            } else{
                start = mid +1;
            }
        }
        return arr[start % n];
    }
}
