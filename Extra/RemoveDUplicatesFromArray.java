package Extra;
import java.util.Arrays;

public class RemoveDUplicatesFromArray {
    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 3, 4, 5, 5, 6, 7, 7};

        int count = 1;
        for (int i = 0; i < arr.length-1; i++) {
            if (arr[i] != arr[i + 1]) {
                count++;
            }
        }

        int[] result = new int[count];
        result[0] = arr[0];
        int index = 1;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != arr[i - 1]) {
                result[index++] = arr[i];
            }
        }
        System.out.println(Arrays.toString(result));
    }
}