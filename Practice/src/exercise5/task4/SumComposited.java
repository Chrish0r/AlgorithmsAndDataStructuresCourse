package exercise5.task4;

public class SumComposited {
    public static void main(String[] args) {
        int[] array = {-5, 13, -32, 7, -3, 17, 23, 12, -35, 19};
        int s = -20; // -32 + 12

        System.out.println("Can the sum " + s + " be built out of two numbers of the field?");
        System.out.println(sumIsCompositedSlow(array, array.length, s));
        System.out.println("-----------------------------------------------");

        System.out.println("Can the sum " + s + " be built out of any two numbers of the field?");
        System.out.println(sumIsComposited(array, array.length, s));



/*
        if (algo2(array, 2)) {
            System.out.println("True");
        } else {
            System.out.println("False");
        }

 */
    }

    private static boolean sumIsComposited(int[] a, int n, int s) {
        int i = 0, j = 0;
        while (i < n) {
            j = i;

            j++;
            if(s == (a[i] + a[j])) {
          // System.out.println(a[i] + " + " + a[j]);
                return true;
            }
        }
        return false;
    }

    /**
     * Hier ist die laufzeit bzw. die Komplexität O(n^2), weil
     * zwei Schleifen im worst case jeweils n-mal (also insgesamt n * n Durchläufe)
     * durchlaufen werden.
     * Somit exisitieren auch unnötige Redundanzen - z.B.
     * wird die Summe aus a[1] und a[3] zweimal berechnet:
     *   Einmal wenn i = 1 und j = 3 und das andere mal,
     *          wenn i = 3 und j = 1.
     * Ziel ist aber eine Laufzeit von Theta(n log n) -> siehe zweiter Algorithmus.
     */
    private static boolean sumIsCompositedSlow(int[] a, int n, int s) {
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(i == j) {
                    continue;
                }
                if((a[i] + a[j]) == s) {
               //     System.out.println(a[i] + " + " + a[j]);
                    return true;
                }
            }
        }
        return false;
    }


    public static boolean algo2(int a[], int s) {

        int i = 0;
        int erg, j = 0;

        while (a.length > 0 && i != a.length) {

            if (i == j) {
                j++;

                if (a.length == j) {
                    i++;
                    j = 0;
                }
            } else {
                erg = a[i] + a[j];
                if (s == erg) {
                    return true;
                }

                j++;

                if (a.length == j) {
                    i++;
                    j = 0;
                }
            }
        }

        return false;

        /* Hier ist das Laufzeitverhalten besser da keine for-Schleifen
         * drin sind. Bedeutet das die Komplexität sich gebessert hat
         * hinsichtlich des Laufzeitverhaltens. Es ist nun O(nlogn) wegen
         * der while schleife die O(logn) ist. n ist dagegen das Laufen des Arrays*/


    }
}
