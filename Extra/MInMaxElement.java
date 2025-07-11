package Extra;

public class MInMaxElement {
        public static void main(String[] args) {
            int[] arr = {12, 4, 56, 1, 99, 23, -7, 45};

            int min = arr[0];
            int max = arr[0];

            for (int i = 1; i < arr.length; i++) {
                if (arr[i] < min) {
                    min = arr[i];
                }
                if (arr[i] > max) {
                    max = arr[i];
                }
            }

            System.out.println("Minimum element: " + min);
            System.out.println("Maximum element: " + max);
        }
    }


