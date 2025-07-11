package Extra;
import java.util.HashSet;

public class FindDuplicates {
     public static void main(String[] args) {
            int[] arr = {4, 3, 2, 7, 8, 2, 3, 1};
            HashSet<Integer> seen = new HashSet<>();
            HashSet<Integer> duplicates = new HashSet<>();

            for (int num : arr) {
                if (!seen.add(num)) {
                    duplicates.add(num); // already seen → it's a duplicate
                }
            }

            System.out.println("Duplicate elements: " + duplicates);
        }

}
