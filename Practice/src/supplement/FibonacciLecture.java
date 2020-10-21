package supplement;

public class FibonacciLecture {
    public static void main(String[] args) {
        int n = 8;
        int fibResult = fibo(n);

        System.out.println("the searched fibonacci number for n = " + n + " is:");
        System.out.println(fibResult );

    }

    private static int fibo(int n) {
        int i = 2;
        int result = 1; // will be aat least 1
        int fib1 = 1, fib2 = 1;

        while(i <  n) {
            result = fib1 + fib2;
            fib2 = fib1;
            fib1 = result;

            System.out.print(result + "  ");
            i++;
        }
        System.out.println(System.lineSeparator() + "---------------------------------");
        return result;
    }
}
