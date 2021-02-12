package lecture.sortierAlgorithmen.repetition;

import java.util.Random;

public class QickSortRandomPivot {
    public static void main(String[] args) {
          int[] array = {34, 45, 12, 34, 23, 18, 38, 17, 43, 51};
        // int[] array = {5, 3, 1, 2, 6, 4};

        // selectionSortMax(array, array.length);
        quickSort(array, 0, array.length-1);
        for(int i = 0; i < array.length; i++) {
            if(i == array.length - 1) {
                System.out.println(array[i]);
                break;
            }
            System.out.print(array[i] + ", ");
        }
    }

    private static void quickSort(int[] arr, int first, int last) {
        if(first < last) {
            int m = preparePartition(arr, first, last);

            quickSort(arr, first, m-1);
            quickSort(arr, m+1, last);
        }
    }

    private static int preparePartition(int[] arr, int first, int last) {
        int pivotIndex = getRandomPivot(first, last);

        // position pivot at first position at array via swapping
        int h = arr[first];
        arr[first] = arr[pivotIndex];
        arr[pivotIndex] = h;

        int pivot = arr[first];

        int m = first-1; // immer eine Position vor erstem i = first
        for(int i = first; i <= last; i++) {
            if(arr[i] <= pivot) {
                m = m + 1;

                int temp = arr[i];
                arr[i] = arr[m];
                arr[m] = temp;
            }
        }
        int temp = arr[first];
        arr[first] = arr[m];
        arr[m] = temp;

        return m;
    }

    private static int getRandomPivot(int first, int last) {
        Random ran = new Random();
        int pivotIndex = ran.nextInt(last - first) + first;

        return pivotIndex;
    }
}
