package mergeSort;

public class MergeSort {
    // private static int[] intArray = {0, 12, 40, 10, 4, 3, 8}; // 0-6 da 7 Elemente

    public static void main(String[] args) {
        int[] intArray = {0, 12, 40, 10, 4, 3, 8}; // 0-6 da 7 Elemente

        int first = 0;
        int last = intArray.length - 1;

        mergeSort(intArray, first, last);
        // print out array
        for(int i = 0; i < intArray.length; i++) {
            if(i == intArray.length - 1) {
                System.out.println(intArray[i]);
                break;
            }
            System.out.print(intArray[i] + ", ");
        }
    }

    public static void mergeSort(int[] arr, int f, int l) {
        if(f < l) {
            int mid = (f+l)/2; // Mitte abgerundet

            mergeSort(arr, f, mid);
            mergeSort(arr, mid+1, l);

            merge(arr, f, mid, l);
        }
    }

    private static void merge(int[] arr, int f, int mid, int l) {
        int n = l - f + 1;
        int i, j;
        int[] tempArr = new int[n];

        for(i = f; i <= mid; i++) {
            tempArr[i+f] = arr[i];
        }

        for(j = mid+1; j <= l; j++) {
            tempArr[l + mid+1 - j] = arr[j];
        }

        i = f;
        j = l;

        for(int k = i; k <= j; k++) {
            if(arr[i] <= arr[j]) { // vergleichen individuelle Werte der 'current' zwei Teil-Arrays
                tempArr[k] = arr[i];
                i++; // gehen eins weiter
            } else {
                tempArr[k] = arr[j];
                j--; // gehen im hinterem Teil-Array mit Zeiger eins weiter nach links, d.h. nach vorne, da im zweitem Teil-Array ganz hinten begonnen wurde
            }
        }
        for(int k = 0; k < n; k++) {
            arr[f + k] = tempArr[k];
        }
        tempArr = null; // Hilfs-Array wird vom garbage collector wieder freigegeben
    }
}
