package exercise4.task4;

import java.util.Random;

public class RunningTimeComparator {
    /**
     * Results regarding how many numbers can be sorted on my machine within one minute:
     *
     *    QuickSort (no random pivoting) -> ~ 350kk - 400kk numbers
     *    BubbleSort                     -> ~ 150k - 160k numbers
     *
     *
     */
    public static void main(String[] args) {
        /* printing out a sorted array takes very long, thus in the following only the
           runnning time regarding executing the relevant sorting algorithms will be estimated.
         */
        Random ran = new Random();
        int n = 160000;

        int[] array = new int[n];
        int first = 0;
        int last = n - 1;

        // creating an array with random whole numbers
        for(int i = 0; i < n; i++) {
            array[i] = ran.nextInt();
        }

        // start calling sorting algorithms
        long timeStampNanos = System.nanoTime();
        bubbleSort(array, n);
       // quickSort(array, first, last);

        long rtQS = System.nanoTime() - timeStampNanos;
        double rtQsSec = (double) rtQS / Math.pow(10, 9);
        System.out.println("running time of bubble sort algorithm to sort");
        //System.out.println("running time of quick sort algorithm with random pivoting to sort:");
        System.out.println("in nanoseconds: " + rtQS + "   in seconds: " + rtQsSec + System.lineSeparator());

        /*
            // output array
        for(int i = 0; i < array.length; i++) {
            if(i == array.length - 1) {
                System.out.println(array[i]);
                break;
            }
            System.out.print(".");
        }
        long rtQSprint = System.nanoTime() - timeStampNanos;
        double rtQsSecprint = (double) rtQSprint / Math.pow(10, 9);
        System.out.println("running time of quick sort with random pivoting to sort and print out:");
        System.out.println("in nanoseconds: " + rtQSprint + "   in seconds: " + rtQsSecprint + System.lineSeparator());

         */

    }
    // logic: the smallest value goes from end to start
    public static void bubbleSort(int arr[], int n) {
        // int swapCount = 0;
        for(int i = 0; i < n; i++) {
            for(int j = n-2; j >= i; j--) {
                if(arr[j] > arr[j+1]) {
                    int h = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = h;
                }
            }
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
}
