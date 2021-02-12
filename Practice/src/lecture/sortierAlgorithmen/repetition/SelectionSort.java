package lecture.sortierAlgorithmen.repetition;

public class SelectionSort {
    public static void main(String[] args) {
        /// int[] array = {34, 45, 12, 34, 23, 18, 38, 17, 43, 51};
        int[] array = {7, 3, 6, 2, 1};

        // selectionSortMax(array, array.length);
        selectionSort(array, array.length);
        for(int i = 0; i < array.length; i++) {
            if(i == array.length - 1) {
                System.out.println(array[i]);
                break;
            }
            System.out.print(array[i] + ", ");
        }
    }

    private static void selectionSortMax(int[] arr, int n) {
        int i, j, max;

        for(i = n-1; i >= 0; i--) {
            max = i;

            for(j = i; j >= 0; j--) {
                if(arr[j] > arr[max]) {
                    max = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[max];
            arr[max] = temp;
        }
    }

    private static void selectionSort(int[] arr, int n) {
        int i, j, min;

        for(i = 0; i < n; i++) {
            min = i;
            for(j = i; j < n; j++) {
                if(arr[j] < arr[min]) {
                    min = j;
                }
            }
            // swap value at position i with value at position min
            int temp = arr[i];
            arr[i] = arr[min];
            arr[min] = temp;
        }
    }
}
