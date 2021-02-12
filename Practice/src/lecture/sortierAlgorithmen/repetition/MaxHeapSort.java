package lecture.sortierAlgorithmen.repetition;

public class MaxHeapSort {
    public static void main(String[] args) {

       // int[] array = {5, 4, 1, 3, 6, 2, 7, 8, 9, 10};
         int[] array = {5, 4, 1, 9, 6, 7};
        // int[] array = {34, 45, 12, 34, 23, 18, 38, 17, 43, 51};
        // int[] array = { 2,4,9,18,21,37};

        int first = 0;
        int last = array.length-1;

        heapSort(array, first, last);
        for(int i = 0; i < array.length; i++) {
            if(i == array.length - 1) {
                System.out.println(array[i]);
                break;
            }
            System.out.print(array[i] + ", ");
        }
    }

    //-------------------------------logic----------------------------------
    private static void heapSort(int[] arr, int first, int last) {
        buildHeap(arr, first, last);

        for(int i = last; i > first; i--) {
            swap(arr, first, i);

            heapify(arr, first, i-1, first);
        }

    }

    private static void buildHeap(int[] arr, int first, int last) {
        int n = last - first + 1;

        for(int i = (n-2)/2; i >= first; i--) { // Starte i an der Stelle des Vorgängers des letzten Wertes - allg.: VG = (i-1)/2
            heapify(arr, first, last, i);
        }
    }

    private static void heapify(int[] arr, int first, int last, int root) {
        int left = 2 * root + 1, right = 2 * root + 2;
        int largest;

        if(left <= last && arr[left] > arr[root]) {
            largest = left;
        } else {
            largest = root;
        }

        if(right <= last && arr[right] > arr[largest]) {
            largest = right;
        }

        if(largest != root) {
            swap(arr, root, largest); // nur die Werte an den Indizes 'root' und 'large' werden vertauscht - Indizes bleiben unberührt

            heapify(arr, first, last, largest); // Prüfen, ob current Teilwurzel auch wirklich das Maximum ist.
        }
    }

    private static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
