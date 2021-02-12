package lecture.sortierAlgorithmen;

public class SelectionSort {
    public static void main(String[] args) {
        int[] array = {34, 45, 12, 34, 23, 18, 38, 17, 43, 51};

        selectionSort(array, array.length);

        for(int i = 0; i  < array.length; i++) {
            if(i == array.length-1) {
                System.out.println(array[i]);
                break;
            }
            System.out.print(array[i] + ", ");
        }
    }

    private static void selectionSort(int[] a, int n) {
        int min;
        for(int i = 0; i < n; i++) {
            min = i;

            for(int j = i; j < n; j++) { // innerhalb dieser inneren Schleife wird die Position des Mimiums ermittelt
                if(a[j] < a[min]) {
                    min = j; // neues min ist an Position j
                }
            }

            // swap(a[i], a[min])
            int h = a[i];
            a[i] = a[min];
            a[min] = h;
        }
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
