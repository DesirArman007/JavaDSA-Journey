package College;

import java.util.Scanner;

public class Table {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        for(int i=1;i<=10;i+=5){
            System.out.println( i +"x" +n+"="+i*n);
        }
    }
}
