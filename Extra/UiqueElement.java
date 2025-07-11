package Extra;

public class UiqueElement {
        public static void main(String[] args) {
            int[] arr = {4, 3, 2, 7, 8, 2, 3, 1};

            System.out.print("Unique elements: ");
            for (int i = 0; i < arr.length; i++) {
                boolean isUnique = true;

                for (int j = 0; j < arr.length; j++) {
                    if (i != j && arr[i] == arr[j]) {
                        isUnique = false;
                        break;
                    }
                }
                if (isUnique) {
                    System.out.print(arr[i] + " ");
                }
            }
        }

}
