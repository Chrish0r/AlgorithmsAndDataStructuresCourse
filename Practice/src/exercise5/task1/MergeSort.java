package exercise5.task1;

public class MergeSort {
    public static void main(String[] args) {
        int[] array = {-5, 13, -32, 7, -3, 17, 23, 12, -35, 19};

        int first = 0;
        int last = array.length-1;

        mergeSort(array, first, last);
        for(int i = 0; i < array.length; i++) {
            if(i == array.length - 1) {
                System.out.println(array[i]);
                break;
            }
            System.out.print(array[i] + ", ");
        }
    }
    private static void mergeSort(int[] arr, int first, int last) {
        if (first <  last) {
            int m = (first + last + 1) / 2; // halbieren, teilen UND Mitte aufrunden
            mergeSort(arr, first, m-1);
            mergeSort(arr, m, last);

            merge(arr, first, last, m);
        }
    }

    private static void merge(int[] arr, int first, int last, int m) {
        int n = last - first + 1;
        int arr1First = first, arr1Last = m-1;
        int arr2First = m, arr2Last = last;

        int[] arrNew = new int[n];

        for(int i = 0; i < n; i++) {
            if(arr1First <= arr1Last ) {
                if(arr2First <= arr2Last) {
                    if(arr[arr1First] <= arr[arr2First]) {
                        arrNew[i] = arr[arr1First++];
                    } else {
                        arrNew[i] = arr[arr2First++];
                    }
                } else {
                    arrNew[i] = arr[arr1First++];
                }
            } else {
                arrNew[i] = arr[arr2First++];
            }
        }
        for(int i = 0; i < n; i++) {
            arr[first + i] = arrNew[i];
        }
        arrNew = null; // Hilfs-Array wird vom garbage collector wieder freigegeben
    }
}
