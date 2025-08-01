package String;

public class StringCompressor {
    public static void main(String[] args) {
        String input = "aaabbbbcccdddeeeffaaaax";
        String compressed = compress(input);
        System.out.println(compressed);
    }

    static String compress(String str) {
        StringBuilder result = new StringBuilder();

        int count = 1;
        for(int i = 1; i < str.length(); i++) {
            if(str.charAt(i) == str.charAt(i - 1)) {
                count++;
            } else {
                if(count>1){
                    result.append(str.charAt(i - 1)).append(count);
                } else {
                    result.append(str.charAt(i - 1));
                }
                count = 1;
            }
        }

        // Append the last group
        if (count > 1) {
            result.append(str.charAt(str.length() - 1)).append(count);
        } else {
            result.append(str.charAt(str.length() - 1));
        }
        return result.toString();
    }
}

