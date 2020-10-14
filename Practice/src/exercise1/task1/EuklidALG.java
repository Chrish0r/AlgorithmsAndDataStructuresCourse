package exercise1.task1;

public class EuklidALG {
    /**
     * This class is responsible to determine the greatest common divisor of two whole numbers.
     * Two methods are presented:
     *    1. iterative
     *    2. recursive
     *
     * The recursive way provides us with a more compact code, but it uses a lot of storage.
     * Thus the iterative way is better, even though it is the more complicated implementation.
     *
     */

    public static void main(String[] args) {
        int a = 35, b = 21;

        System.out.println("The greatest common divisor of the numbers " + a + " and " + b
                + " is " + ggT(a, b) + ".");

        System.out.println(System.lineSeparator() + "Recursive:");
        System.out.println("The greatest common divisor of the numbers " + a + " and " + b
                            + " is " + ggTRecursive(a, b) + ".");

    }

    public static int ggT(int a, int b) {
        int rest;
        while(b != 0) {
            rest = a % b;
            a = b;
            b = rest;
        }
        return a;
    }

    public static int ggTRecursive(int a, int b) {
        if(b == 0) {
            return a;
        }
        return ggTRecursive(b, a % b);
    }
}
