package String;

import java.util.ArrayList;

public class SubSeq {
    public static void main(String[] args) {
        String str="abc";
        subSet("",str);
        System.out.println();
        System.out.println();
        subSetASCIIvalue("",str);
    }


    static void subSet(String p, String up){
        if(up.isEmpty()){
            System.out.print(p+" ");
            return;
        }

        char ch = up.charAt(0);

        subSet(p,up.substring(1));
        subSet(p+ch, up.substring(1));
    }


    static ArrayList<String> subSeq(String p, String up){
        if(up.isEmpty()){
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }

        char ch = up.charAt(0);

        ArrayList<String> left = subSeq(p,up.substring(1));
        ArrayList<String> right = subSeq(p+ch, up.substring(1));

        right.addAll(left);

        return right;
    }


    static void subSetASCIIvalue(String p, String up){
        if(up.isEmpty()){
            System.out.print(p+" ");
            return;
        }

        char ch = up.charAt(0);

        subSetASCIIvalue(p,up.substring(1));
        subSetASCIIvalue(p+ch, up.substring(1));
        subSetASCIIvalue(p+(ch+0), up.substring(1));
    }
}
