package exercise5.task2;

public class InsertionSort_Rek {
    public static void main(String[] args) {
        int[] array = {34, 45, 12, 34, 23, 18, 38, 17, 43, 51};


        insertionSortRek(array, array.length);
        for (int i = 0; i < array.length; i++) {
            if (i == array.length - 1) {
                System.out.println(array[i]);
                break;
            }
            System.out.print(array[i] + ", ");
        }
    }

    public static void insertionSortRek(int a[], int n) {
        // Base case
        if (n <= 1) {
            return;
        }
        // reduce the elements to be sorted by one
        insertionSortRek(a, n - 1);

        // Insert the first element that is not anymore in the sorted array at its correct position
        int key = a[n - 1]; // 1st element out of sorted sub-array
        int i = n - 2; // last element of sorted sub-array

        /* Move elements of sorted sub-array, that are
          greater than key, to one position ahead
          of their current position */
        while (i >= 0 && a[i] > key) {
            a[i+1] = a[i];
            i--;
        }
        a[i+1] = key;
    }
}
