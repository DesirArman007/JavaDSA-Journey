package LargeStrings;

public class RandomString {
    public static void main(String[] args) {
        StringBuffer sb = new StringBuffer();
        for(int i=0; i<20; i++){
            int randomChart = 97 + (int)(Math.random()*26);
            sb.append((char)randomChart);
        }
        System.out.println(sb.toString());
    }
}
