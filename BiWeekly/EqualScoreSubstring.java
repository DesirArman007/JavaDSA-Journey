package BiWeekly;

import java.util.HashMap;
import java.util.Map;

public class EqualScoreSubstring {

    public boolean scoreBalance(String s) {

        Map<Character, Integer> map = new HashMap<>(Map.ofEntries(
                Map.entry('a', 1),
                Map.entry('b', 2),
                Map.entry('c', 3),
                Map.entry('d', 4),
                Map.entry('e', 5),
                Map.entry('f', 6),
                Map.entry('g', 7),
                Map.entry('h', 8),
                Map.entry('i', 9),
                Map.entry('j', 10),
                Map.entry('k', 11),
                Map.entry('l', 12),
                Map.entry('m', 13),
                Map.entry('n', 14),
                Map.entry('o', 15),
                Map.entry('p', 16),
                Map.entry('q', 17),
                Map.entry('r', 18),
                Map.entry('s', 19),
                Map.entry('t', 20),
                Map.entry('u', 21),
                Map.entry('v', 22),
                Map.entry('w', 23),
                Map.entry('x', 24),
                Map.entry('y', 25),
                Map.entry('z', 26)
        ));

        int len = s.length();
        for(int i=0; i<len; i++){
            String s1 = s.substring(0,i+1);
            String s2= s.substring(i+1);

            int s1Sum =0;
            for(int j = 0; j <s1.length(); j++){
                s1Sum += map.get(s1.charAt(j));
            }

            int s2Sum =0;
            for(int j = 0; j <s2.length(); j++){
                s2Sum += map.get(s2.charAt(j));
            }

            if(s1Sum==s2Sum){
                return true;
            }
        }

        return  false;
    }
}
