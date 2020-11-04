package exercise4.task3;

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

    private static void selectionSort(int[] arr, int n) {
        int max;
        for(int i = n - 1; i >= 0; i--) {
            max = i; // starting-position/-index of maximum

            for(int j = i; j >= 0; j--) {
                if(arr[j] > arr[max])  {
                    max = j;
                }
            }
            // now we position the new maximum at the starting-index i of the current "round"
            int temp = arr[i];
            arr[i] = arr[max];
            arr[max] = temp;
        }
    }
}
