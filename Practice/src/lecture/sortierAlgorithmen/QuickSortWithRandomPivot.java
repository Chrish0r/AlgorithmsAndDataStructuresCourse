package lecture.sortierAlgorithmen;

import java.util.Random;

public class QuickSortWithRandomPivot {
    public static void main(String[] args) {
        int[] array = {34, 45, 12, 34, 23, 18, 38, 17, 43, 51};
        int first = 0;
        int last = array.length-1;

        quickSort(array, first, last);
        for(int i = 0; i < array.length; i++) {
            if(i == array.length - 1) {
                System.out.println(array[i]);
                break;
            }
            System.out.print(array[i] + ", ");
        }
    }

    private static void quickSort(int[] arr, int first, int last) {
        int part; // separation value

        if(first < last) {
            part = PreparePartition(arr, first, last);

            quickSort(arr, first, part-1);
            quickSort(arr, part+1, last);
        }
    }

    private static int PreparePartition(int[] arr, int first, int last) {
        random(arr, first, last);

        int pivot = arr[first];
        int part = first-1;

        for(int i = first; i <= last; i++) {
            if(arr[i] <= pivot) {
                part++;
                // swapping
                int h = arr[part];
                arr[part] = arr[i];
                arr[i] = h;
            }
        }
        // swapping
        int h = arr[part];
        arr[part] = arr[first];
        arr[first] = h;

        return part;
    }

    private static void random(int[] arr, int first, int last) {
        Random ran = new Random();
        int pivot = ran.nextInt(last - first) + first;

        int temp = arr[pivot];
        arr[pivot] = arr[first];
        arr[first] = temp;
    }
}
