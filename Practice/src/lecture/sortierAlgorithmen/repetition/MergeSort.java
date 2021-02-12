package lecture.sortierAlgorithmen.repetition;

public class MergeSort {
    public static void main(String[] args) {
       // int[] array = {34, 45, 12, 34, 23, 18, 38, 17, 43, 51};
        int[] array = {12, 17, 3, 2, 8, 4, 20, 9};

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
        if(first < last) {
            int m = (first + last + 1) / 2;

            mergeSort(arr, first, m-1);
            mergeSort(arr, m, last);

            merge(arr, first, last, m);
        }
    }

    private static void merge(int[] arr, int first, int last, int m) {
        int n = last - first + 1;
        int[] tempArr = new int[n];

        int a1First = first, a1Last = m-1;
        int a2First = m, a2Last = last;

        for(int i = 0; i < n; i++) {
            if(a1First <= a1Last) {
                if(a2First <= a2Last) { // hier und Zeile drüber geht es darum zu prüfen, ob das jeweilige Teil-Array noch mind. 1 Element enthält
                    if(arr[a1First] <= arr[a2First]) { // ab hier werden die Werte in den Teil-Arrays miteinander verglichen
                        tempArr[i] = arr[a1First];
                        a1First++;
                    } else {
                        tempArr[i] = arr[a2First];
                        a2First++;
                    }
                } else {   // Hier ist das 2te Teil-Array "fertig", und daher muss man vom 1tem Teil-Array weiter entnehmen.

                    tempArr[i] = arr[a1First];
                    a1First++;
                }

            } else { // Hier ist das 1te Teil-Array "fertig", und daher muss man vom 2tem Teil-Array weiter entnehmen.
                tempArr[i] = arr[a2First];
                a2First++;
            }
        }

        // Werte aus dem Hilfs-ArrayiIn das originale Array umspeichern
        for(int i = 0; i < n; i++) {
            arr[first + i] = tempArr[i];
        }

        // Hilfs-Array wieder bzgl. Speicher freigeben
        tempArr = null;
    }
}
