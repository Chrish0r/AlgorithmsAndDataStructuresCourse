package exercise1.task2;

;
import java.util.ArrayList;
import java.util.List;

public class SieveOfEratosthenes {
    public static void main(String[] args) {
       // int k = 100;
        int k = 1000;

        ArrayList<Integer> primes = createPrimeList(k);

        // printing out prime numbers
        for(int i = 0; i < primes.size(); i++) {
            if( i == primes.size() - 1) {
                System.out.println(primes.get(i));
                break;
            }
            System.out.print(primes.get(i) + ", ");
        }
    }

    // liefert die Liste aller Primzahlen < n
    public static ArrayList<Integer> createPrimeList(int k) {

        ArrayList<Integer> primeNumbers = new ArrayList<Integer>();
        boolean[] isPrime = new boolean[k];

        // fill boole-array with only TRUE-values
        for (int i = 2; i < k; i++) {
            isPrime[i] = true;
        }

        // iterate through array and finding prime numbers
        for (int i = 2; i < k; i++) {
            if (isPrime[i]) {
                primeNumbers.add(i);

                for (int j = i * i; j < k; j = j + i) {
                    isPrime[j] = false;
                }
            }
        }
        return primeNumbers;
    }
}
