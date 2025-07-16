package Extra;
import java.util.ArrayList;

public class MergeTwoSortedArrays {
    public static void main(String[] args) {
        int[] arr1={1,3,5,7,9};
        int[] arr2 = {2,4,6,8,10};
        ArrayList<Integer> result = new ArrayList<>();
        int i=0;
        int j=0;
        while( i < arr1.length && j < arr2.length ){
            if(arr1[i] < arr2[j] ){
                result.add(arr1[i]);
                i++;
            } else{
                result.add(arr2[j]);
                j++;
            }
        }
        while( i < arr1.length){
            result.add(arr1[i]);
            i++;
        }
        while( j < arr2.length){
            result.add(arr2[j]);
            j++;
        }
        System.out.println(result);
    }
}
