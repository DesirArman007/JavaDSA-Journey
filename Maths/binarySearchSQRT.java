package Maths;

public class binarySearchSQRT {
    public static void main(String[] args) {
        // number
        int n=40;
        // precision
        int p=3;

      //  System.out.println(sqrt(n,p));
        System.out.printf("%.3f",sqrt(n,p));
    }

    static double sqrt(int n, int p){
        int s=0;
        int e=n;

        double root =0.0;

        while (s<=e){
            int m= s+(e-s)/2;

            if(m*m==n){
                return m;
            }

            if(m*m < n){
                root=m;
                s = m + 1;
            } else{
                e=m-1;
            }
        }

        double inc=0.1;
        for (int i=0; i<p; i++){
            while (root*root < n){
                root += inc;
            }

            root -= inc;
            //reduces the increment for the next decimal place (inc=0.1) after inc=/10 -> (inc =0.001)
            inc/=10;
        }

        return root;
    }
}
