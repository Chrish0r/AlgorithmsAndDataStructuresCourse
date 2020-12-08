package exercise5.task1;

public class HeapSort {
    public static void main(String[] args) {
       // int[] array = {-5, 13, -32, 7, -3, 17, 23, 12, -35, 19};
        int[] array = {2, 4, 9, 18, 21, 37};

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

    private static void heapSort(int[] arr, int first, int last) {
        buildHeap(arr, first, last);

        for(int i = last; i > first; i--) {
            swap(arr, first, i);
            heapify(arr, first, i - 1, first); // (i - 1) -> "new Last" after swap
        }
    }

    private static void buildHeap(int[] arr, int first, int last) {
        int n = last - first + 1; // current last = (n - 1)
        for(int i = first + (n-2)/2; i >= first; i--) { // the 1st 'first' can be potentially cut off / reduced
            heapify(arr, first, last, i); // i will be considered as current root
        }
    }

    private static void heapify(int[] arr, int first, int last, int root) {
        int largest;
        int left = first + 2*(root - first) + 1, right = first + 2*(root - first) + 2;

        if(left <= last && arr[left] > arr[root]) {
            largest = left;
        } else {
            largest = root;
        }

        if(right <= last && arr[right] > arr[largest]) {
            largest = right;
        }

        if(largest != root) {
            swap(arr, root, largest); // the values get swapped, but the indices stay the same.
            heapify(arr, first, last, largest);
        }
    }

    private static void swap(int[] arr, int rootPos, int largestPos) {
        int temp = arr[rootPos];
        arr[rootPos] = arr[largestPos];
        arr[largestPos] = temp;
    }
}
