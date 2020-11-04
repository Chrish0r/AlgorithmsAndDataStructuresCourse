package exercise4.task3;

import java.util.Random;

public class QuickSortWithRandomPivot {
    public static void main(String[] args) {
      //  Random ran = new Random();

        int[] array = {34, 45, 12, 34, 23, 18, 38, 17, 43, 51};
   //     int first = ran.nextInt(array.length - 1);
        // first = ran.nextInt(last - first) + first;
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
        random(arr,first,last);

        int pivot = arr[first];
        part = first-1;


        for(int i = first; i <= last; i++) {
            if(arr[i] <= pivot) {
                part++;
                // swapping
                int temp = arr[part];
                arr[part] = arr[i];
                arr[i] = temp;
            }
        }
        // swapping
        int temp = arr[part];
        arr[part] = arr[first];
        arr[first] = temp;

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
