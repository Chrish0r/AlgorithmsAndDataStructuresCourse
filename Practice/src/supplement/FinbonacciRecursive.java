package supplement;

public class FinbonacciRecursive {

    public static void main(String[] args) {
        int n = 8;
        int fibResult = fiboRec(n);

        System.out.println("the searched fibonacci number (recursive solved) for n = " + n + " is:");
        System.out.println(fibResult );

    }

    private static int fiboRec(int n) {

        if(n < 3) {
            return 1;
        } else {
            return fiboRec(n - 2) + fiboRec(n - 1);
        }
    }
}
