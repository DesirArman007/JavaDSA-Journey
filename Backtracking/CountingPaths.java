package Backtracking;

public class CountingPaths {
    public static void main(String[] args) {
        System.out.println(countPaths(3,3));
    }

    static int countPaths(int r, int c){
        if(r==1||c==1){
            return 1;
        }

        int count = 0;

        count = count + countPaths(r-1,c);
        count = count + countPaths(r,c-1);
        return count;
    }
}
