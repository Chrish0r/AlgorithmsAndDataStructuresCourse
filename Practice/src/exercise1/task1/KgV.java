package exercise1.task1;


public class KgV {

    public static void main(String[] args) {
        int a = 3528;
        int b = 3780;

       // int a = 3;
       // int b = 8;

        System.out.println("least common multiple of " + a + " and " + b + " is " + kgV(a, b));
     //   System.out.println("least common multiple of " + a + " and " + b + " is " + new KgV().kgVAlt(a, b));

    }

    public static int kgV(int a, int b) {
        int kgv = Math.max(a, b);

        while(true) {
            if((kgv % a == 0) && (kgv % b == 0)) {
                break;
            }
            kgv++;
        }
        return kgv;
    }

    private static int kgVAlt(int a, int b) {
        // general formula: ggT(a, b) * kgV(a, b) = a * b <=> kgV(a, b) = (a * b) / ggT(a, b)
      return (a * b) / EuklidALG.ggT(a, b);
    }
}
