package lecture.sortierAlgorithmen;

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

    private static void insertionSort(int[] a) {
        int j, i, key;

        for(j = 1; j < a.length; j++) {
            key = a[j];

            i = j - 1;
            while(i >= 0 && a[i] > key) {
                a[i+1] = a[i];
                i--;
            }
            a[i+1] = key;
        }
    }
}
