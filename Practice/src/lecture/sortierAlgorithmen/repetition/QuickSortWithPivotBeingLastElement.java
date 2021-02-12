package lecture.sortierAlgorithmen.repetition;

public class QuickSortWithPivotBeingLastElement {
    public static void main(String[] args) {
        //   int[] array = {34, 45, 12, 34, 23, 18, 38, 17, 43, 51};
      //  int[] array = {4, 7, 2, 8, 9, 6, 1, 3};
        int[] array = {7, 19, 3, 8, 10, 6, 20, 4, 2, 1};

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
        int m;

        if(first < last) {
            m = preparePartition(arr, first, last);

            quickSort(arr, first, m-1);
            quickSort(arr, m+1, last);
        }
    }

    private static int preparePartition(int[] arr, int first, int last) {
        int pivot = arr[last];
        int part = last + 1;

        for(int i = last; i >= 0; i--) {
            if(arr[i] >= pivot) {
                part--;

                int temp = arr[i];
                arr[i] = arr[part];
                arr[part] = temp;
            }
        }

        // Pivot-Element an richtige (index = part) Position bringen
        int temp = arr[last];
        arr[last] = arr[part];
        arr[part] = temp;

        return part;
    }

    private static int preparePartitionAlt(int[] arr, int first, int last) {
        int pivot = arr[last];
        int m = first;

        for(int i = first; i < last; i++) {
            if(arr[i] < pivot) {

                int temp = arr[i];
                arr[i] = arr[m];
                arr[m] = temp;

                m++;
            }
        }
        int temp = arr[last];
        arr[last] = arr[m];
        arr[m] = temp;

        return m;
    }
}
