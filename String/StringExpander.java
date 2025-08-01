package String;

public class StringExpander {
    public static void main(String[] args) {
        String compressed = "a3b2xk5";
        String expanded = expand(compressed);
        System.out.println(expanded);  // Output: aaabbxkkkkk
    }

    static String expand(String str) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < str.length(); ) {
            char ch = str.charAt(i++);
            StringBuilder countStr = new StringBuilder();

            // Collect digits after character, if any
            while (i < str.length() && Character.isDigit(str.charAt(i))) {
                countStr.append(str.charAt(i++));
            }

            // If no digits were found, count = 1
            int count = countStr.length() > 0 ? Integer.parseInt(countStr.toString()) : 1;

            // Append character 'count' times
            result.append(String.valueOf(ch).repeat(count));
        }

        return result.toString();
    }
}

