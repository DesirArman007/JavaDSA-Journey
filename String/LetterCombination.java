package String;

import java.util.ArrayList;
import java.util.List;

public class LetterCombination {
    public static void main(String[] args) {
        System.out.println(pad("","23"));
    }

    // better approach
    private static final String[] KEYPAD = {
            "",     // 0
            "",     // 1
            "abc",  // 2
            "def",  // 3
            "ghi",  // 4
            "jkl",  // 5
            "mno",  // 6
            "pqrs", // 7
            "tuv",  // 8
            "wxyz"  // 9
    };

    static List<String> pad(String p, String up) {
        if (up.isEmpty()) {
            List<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }

        List<String> ans = new ArrayList<>();
        int digit = up.charAt(0) - '0';
        String letters = KEYPAD[digit];

        for (char ch : letters.toCharArray()) {
            ans.addAll(pad(p + ch, up.substring(1)));
        }
        return ans;
    }


    // this approach is digit dependent
//    static void pad(String p, String up){
//        if(up.isEmpty()){
//            System.out.println(p);
//            return;
//        }
//
//        int digit = up.charAt(0)-'0';
//        int start=(digit-2)*3;
//        int end=(digit-1)*3 ;
//        if(digit ==7){
//            end = (digit-1)*3 +1;
//        }
//        else if(digit==8){
//            start+=1;
//            end +=1;
//        } else if (digit==9) {
//            start+=1;
//            end +=2;
//        }
//        for(int i=start; i<end; i++){
//            char ch = (char)('a'+i);
//            pad(p+ch,up.substring(1));
//
//        }
//    }
}
