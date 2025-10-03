package String;

public class WordReverser {



    public static void main(String[] args) {
        String s = "how are you";

        System.out.println("Reverse each word: " + reverseEachWord(s));
        System.out.println("Reverse word order: " + reverseWordOrder(s));
        System.out.println("Reversing alternate words: "+ reverseAlternateWords(s));
    }



    static void reverseString(StringBuilder sb, int s, int e) {
        while (s < e) {
            swap(sb, s, e);
            s++;
            e--;
        }
    }

    static void swap(StringBuilder sb, int i, int j) {
       ; char temp = sb.charAt(i);
        sb.setCharAt(i, sb.charAt(j));
        sb.setCharAt(j, temp);
    }


    // reverse whole string
    static String reverseEachWord(String sentence) {
        StringBuilder sb = new StringBuilder(sentence);
        int n = sb.length();
        int start = 0;

        for (int i = 0; i <= n; i++) {
            if (i == n || sb.charAt(i) == ' ') {
                reverseString(sb, start, i - 1);
                start = i + 1;
            }
        }

        return sb.toString();
    }


    static String reverseWordOrder(String sentence) {
        StringBuilder sb = new StringBuilder(sentence);
        int n = sb.length();

        //  Reverse entire string
        reverseString(sb, 0, n - 1);

        return reverseEachWord(sb.toString());
    }

    static String reverseAlternateWords(String sentence) {
        StringBuilder sb = new StringBuilder(sentence);
        int wordIndex=0;
        int n = sb.length();
        int start=0;

        for(int i=0; i<=n; i++){
            if(i==n || sb.charAt(i) ==' '){
                if(wordIndex%2==0){
                    reverseString(sb,start,i-1);
                }

                start = i + 1;
                wordIndex++;
            }
        }
        return sb.toString();
    }
}
