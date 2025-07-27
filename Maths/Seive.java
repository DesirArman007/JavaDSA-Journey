package Maths;

// this algorithm is called  Sieve of Eratosthenes
public class Seive {
    public static void main(String[] args) {
        int n=40;
        // this array will contain flase value initally
        boolean[] primes= new boolean[n+1];

        seive(n, primes);
    }

    static void seive(int n, boolean[] primes){
        for(int i=2; i<=n; i++){
            // false value == prime (we are saying)
            if(!primes[i]){
                // if (i) is prime then set it multiples to true(not prime)
                for(int j=i*2; j<=n; j+=i){
                    primes[j]=true;
                }
            }
        }
        // iterate over the boolean array
        for (int i=2; i<=n; i++){
            // if num is false means prime then print
            if(!primes[i]){
                System.out.print(i +" ");
            }
        }
    }
}
