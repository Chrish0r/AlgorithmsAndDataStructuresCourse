package lecture.sortierAlgorithmen.repetition;

public class InsertionSort {
    public static void main(String[] args) {
        int[] array = {34, 45, 12, 34, 23, 18, 38, 17, 43, 51};

        insertionSort(array, array.length);
        for(int i = 0; i < array.length; i++) {
            if(i == array.length - 1) {
                System.out.println(array[i]);
                break;
            }
            System.out.print(array[i] + ", ");
        }
    }
    // aufsteigend
    private static void insertionSort(int[] arr, int n) {
        int i, j, key;

        for(j = 1; j < n; j++) { // consider the keys
            i = j - 1; // letzte Zahl aus dem sortiertem Bereich
            key = arr[j];

            while(i >= 0 && arr[i] > key) {
                arr[i+1] = arr[i];
                i--;
            }
            arr[i+1] = key;
        }
    }
}
