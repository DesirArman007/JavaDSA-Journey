package LargeStrings;

import java.util.Arrays;

public class Main {
    public static void main(String[] args){
        StringBuffer sb = new StringBuffer();

        StringBuffer sb2 = new StringBuffer("Abhishek");

        StringBuffer sb3 = new StringBuffer(30);
        System.out.println(sb3.capacity());

        sb.append("Learning");
        sb.append(" is nice");

        sb.insert(2,"Cute");
        sb.delete(2,6);
        sb.reverse();
        System.out.println(sb.toString());

        ///  removing whitespaces

        String sentenace = "HI  j   h   kdf dsfsjdf k";
        System.out.println(sentenace);

        System.out.println(sentenace.replaceAll("\\s",""));
        String[] name = sentenace.split(" ");
        System.out.println(Arrays.toString(name));

    }
}
