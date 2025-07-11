package Extra;

public class Ass1 {
    public static void main(String[] args) {
        int num = 1123;
        StringBuilder result = new StringBuilder();

        for(char ch : String.valueOf(num).toCharArray()) {
            int digit = Character.getNumericValue(ch);
            int newDigit = (digit + 1) % 10;
            result.append(newDigit);
        }
        System.out.println("New Num: " + result.toString());
    }
}
