package exercise1.task1;


public class KgV {

    public static void main(String[] args) {
        int a = 3528;
        int b = 3780;

        System.out.println("least common multiple of " + a + " and " + b + " is " + new KgV().kgV(a, b));

    }

    private int kgV(int a, int b) {
        // general formula: ggT(a, b) * kgV(a, b) = a * b <=> kgV(a, b) = (a * b) / ggT(a, b)

      return (a * b) / EuklidALG.ggT(a, b);
    }
    
}
