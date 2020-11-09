package lecture.sortierAlgorithmen;

public class QuickSort {
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
        int part = 0; // separation value

        if(first < last) {
            part = preparePartition(arr, first, last, part);

            quickSort(arr, first, part-1);
            quickSort(arr, part+1, last);
        }
    }

    private static int preparePartition(int[] arr, int first, int last, int part) {
        int pivot = arr[first];
        part = first-1;

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

    /* it works with the helper method below as well, but for a better algorithmic overview I rather resist on using this helper functiion
    private static void swap(int[] arr, int a, int b) {
        int h = arr[b];
        arr[b] = arr [a];
        arr[a] = h;
    }

     */
}
