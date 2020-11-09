package lecture.sortierAlgorithmen;

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

    private static void selectionSort(int[] a, int n) {
        int min;
        for(int i = 0; i < n; i++) {
            min = i;

            for(int j = i; j < n; j++) { // innerhalb dieser inneren Schleife wird die Position des Mimiums ermittelt
                if(a[j] < a[min]) {
                    min = j; // neues min ist an Position j
                }
            }
            int h = a[i];
            a[i] = a[min];
            a[min] = h;
        }
    }
}
