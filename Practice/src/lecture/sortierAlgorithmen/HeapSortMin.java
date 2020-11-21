package lecture.sortierAlgorithmen;

public class HeapSortMin {

    public static void main(String[] args) {
        int[] array = {5, 3, 1, 2, 6, 4};
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

    public static void heapSort(int[] a, int first, int last) {
        buildHeap(a, first, last);

        for(int i = first; i < last; i++) {
            heapify(a, i+1, last,i+1);
        }
    }

    public static void buildHeap(int[] a, int first, int last) {
        int n = last - first + 1;
        for(int i = first + (n-2)/2; i >= first; i--) {
            heapify(a, first, last, i);
        }
    }

    public static void heapify(int[] a, int first, int last, int root) {
        int smallest;
        int left = 2 * (root) + 1;
        int right = 2 * (root) + 2;

        if(left <= last && a[left] < a[root]) {
            smallest = left;
        } else {
            smallest = root;
        }

        if(right <= last && a[right] < a[smallest]) {
            smallest = right;
        }

        if(smallest != root) {
            swap(a, root, smallest);
            heapify(a, first, last, smallest); // wird nur rekursiv aufgerufen, wenn root != smallest
        }


    }
       // helper method
    public static void swap(int[] a, int root, int smallest) {
        int temp = a[root];
        a[root] = a[smallest];
        a[smallest] = temp;
    }
}
