package exercise4.task3;

public class InsertionSort {
    public static void main(String[] args) {
        int[] array = {34, 45, 12, 34, 23, 18, 38, 17, 43, 51};

        insertionSort(array);
        for(int i = 0; i < array.length; i++) {
            if(i == array.length - 1) {
                System.out.println(array[i]);
                break;
            }
            System.out.print(array[i] + ", ");
        }
    }

    private static void insertionSort(int[] arr) {
        int i, j , key;

        for(j = arr.length - 2; j >= 0; j--) {

            key = arr[j];
            i = j + 1;

            while (i < arr.length && arr[i] < key) {
                arr[i-1] = arr[i];
                i++;
            }
            arr[i-1] = key;
        }
    }
}
