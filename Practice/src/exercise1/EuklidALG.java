package exercise1;

public class EuklidALG {
    public static void main(String[] args) {
        int a = 37, b = 21;

        System.out.println("The greatest common divisor of the numbers " + a + " and " + b
                + " is " + new EuklidALG().ggT(a, b) + ".");

        System.out.println(System.lineSeparator() + "Recursive:");
        System.out.println("The greatest common divisor of the numbers " + a + " and " + b
                            + " is " + new EuklidALG().ggTRecursive(a, b) + ".");
    }

    private int ggT(int a, int b) {
        int rest;
        while(b != 0) {
            rest = a % b;
            a = b;
            b = rest;
        }
        return a;
    }

    private int ggTRecursive(int a, int b) {
        if(b == 0) {
            return a;
        }
        return ggTRecursive(b, a % b);
    }
}
