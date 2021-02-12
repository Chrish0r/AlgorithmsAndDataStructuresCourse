package lecture.sortierAlgorithmen;

public class HeapSortMinAufsteigend {
    public static void main(String[] args) {

        int[] array = {5, 4, 1, 3, 6, 2, 7, 8, 9, 10};
        // int[] array = {5, 3, 1, 2, 6, 4};
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

        /*
        Bei minHeap aufsteigend muss man nichts vertauschen, weil ja
        der Min-Wert im current (Teil)-Heap immer ganz oben an der Wurzel steht und diese
        den lowest index vom current_Teil-Heap hat.
        Wichtig ist nur, dass sich daher "first" immer ändert, und zwar pro Runde um Eins erhöht.
         */
        for(int i = first; i < last; i++) {
            heapify(arr, i+1, last, i+1);
        }
    }

    private static void buildHeap(int[] arr, int first, int last) {
        int n = last - first + 1; // current last = (n - 1)
        for(int i = first + (n-2)/2; i >= first; i--) { // the 1st 'first' can be potentially cut off / reduced
            heapify(arr, first, last, i); // i will be considered as current root
        }
    }

    private static void heapify(int[] arr, int first, int last, int root) {
        int smallest;
        int left = first + 2*(root - first) + 1, right = first + 2*(root - first) + 2;

        if(left <= last && arr[left] < arr[root]) {
            smallest = left;
        } else {
            smallest = root;
        }

        if(right <= last && arr[right] < arr[smallest]) {
            smallest = right;
        }

        if(smallest != root) {
            swap(arr, root, smallest); // the values get swapped, but the indices stay the same.

            heapify(arr, first, last, smallest);
        }
    }

    private static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
