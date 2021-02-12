package exercise6;

public class Test {
    public static void main(String[] args) {
        double zaehler;      // m - i, wobei i die Anzahl der bereits belegten Stellen ist
        double nenner = 365; // m
        int n = 28; // Anzahl zufälliger Einträge

        double product = 1;
        for(int i = 0; i <= n-1; i++) {
            zaehler = nenner - i;
            double temp = zaehler / nenner;
            product *= temp;
        }
        System.out.println(product);
    }

    static void stableSelectionSort(int[] arr, int n) {
        // Iterate through array elements
        for (int i = 0; i < n - 1; i++) {
            // Loop invariant: Elements till
            // a[i - 1] are already sorted.

            // Find minimum element from
            // arr[i] to arr[n - 1].
            int min = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[min] > arr[j]) {
                    min = j;
                }
            }
            // Move minimum element at current i.
            int key = arr[min];
            while (min > i) {
                arr[min] = arr[min - 1];
                min--;
            }
            arr[i] = key;
        }
    }
}
