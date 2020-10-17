package exercise1.task1;

/**
 * this class is responsible to  provide results regarding the functionalities and/or calculations
 *  kgv(), ggt() and a*b - a, b are within following range: [30, 40]
 */

public class Main {
    public static void main(String[] args) {
        int a, b;

        for(a = 30; a <= 40; a++) {
            for(b = 30; b <= 40; b++) {
                System.out.println("a = " + a + "  b = " + b );

                System.out.println("kgV: " + KgV.kgV(a, b) + ",   ggT: " + EuklidALG.ggTRecursive(a, b)
                                  + ",   product: " +  a * b + System.lineSeparator());
            }
            System.out.println("---------------------------------------------");
        }

        /**
         * Noticeable remarks:
         * 1. kgV(a,b) is quite often just the product of a * b
         * 2. Whenever a == b, then kgv(a,b) and ggT(a,b) are just a, i.e, b
         *       -> this makes sense because both numbers are already equal.
         * 3. Whenever one of both number is a prime number (in our case: 31 or 37),
         *    then the kkV is just the product of those two numbers (here. a * b)
         *    and the greatest common divisor is obviously 1 because a prime number is
         *    only divisible through 1 and itself.
         */


    }
}
