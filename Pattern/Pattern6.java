package Pattern;

public class Pattern6 {
    public static void main(String[] args) {

        int arr[] = {2, -7, 8, 9, -2, -1, 3};
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        // Find min and max
        for (int n : arr) {
            if (n < min) min = n;
            if (n > max) max = n;
        }

        System.out.println("Min: " + min + ", Max: " + max);

        int totalLength = max + Math.abs(min);
        int startLine = Math.abs(min);

        for (int row = 0; row < totalLength; row++) {
            for (int j = 0; j < arr.length; j++) {
                int val = arr[j];

                if (val < 0 && row >= startLine - (-val) && row < startLine) {
                    System.out.print("*");
                }
                else if (val > 0 && row >= startLine && row < startLine + val) {
                    System.out.print("*");
                }
                else {
                    System.out.print(" ");
                }

                System.out.print(" ");
            }
            System.out.println();
        }
    }
}
