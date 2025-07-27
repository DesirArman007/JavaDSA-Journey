package Bits;

public class FindUniqueNum {
    public static void main(String[] args) {
        int arr[] ={1,2,3,4,1,2,3,6,4};

        int arr2[] ={1,1,2,1,2,2,3,4,4,4};

//        System.out.println(unique(arr));
        System.out.println(findaunique(arr2));

    }

    // work if duplicate nums appear even times
    private static int unique(int[] arr) {
        int unique=0;

        for(int num: arr){
            unique ^=num;
        }
        return unique;
    }

    // work for duplicate nums appear odd times
    static int findaunique(int[] arr){
        int result=0;
        for (int i = 0; i < 32; i++) {
            int sum = 0;
            for (int num : arr) {
                if ((num & (1 << i)) != 0) {
                    sum++;
                }
            }

            if (sum % 3 != 0) {
                result |= (1 << i);
            }
        }
        return result;
    }

}
