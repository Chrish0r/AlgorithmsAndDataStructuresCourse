package lecture.sortierAlgorithmen.special;

public class CountSort {
    public static void main(String[] args) {
        int[] array = {34, 45, 12, 34, 23, 18, 38, 17, 43, 51};
        // int[] array = {5, 3, 1, 2, 6, 4};
        int k = 51; // Wertebereich von 1 - k

        countSort(array, array.length, k);

        for(int i = 0; i  < array.length; i++) {
            if(i == array.length-1) {
                System.out.println(array[i]);
                break;
            }
            System.out.print(array[i] + ", ");
        }
    }

    private static void countSort(int[] arr, int n, int k) {
        int i, j = 1;
        int[] bin = new int[k+1]; // because we start at 1, instead of 0.

        for(i = 1; i <= k; i++) { // liefert für jede Zahl im array einen eigenen Behälter i
            bin[i] = 0; // count eines jeden Behälters i wird auf 0 gesetzt
        }
        for(i = 0; i < n; i++) {
            bin[arr[i]] ++; // Für Zahlen im array wird für den adäquaten Behälter der Count errhöht
        }
        for(i = 0; i < n; i++) {  // copying back into the original array/field
            while (bin[j] == 0) { // falls eine Zahl im Array nicht vorkommt (hier ist dann der Wert des Behälters immer noch die initialisierte 0
                j++;
            }
            // Count/Vorkommen des Behälters > 0 -> d.h. Zahl kommt im Array vor
                arr[i] = j;
                bin[j]--;

        }
        // effectively delete bin -> garbage collector will take care of this temp-/helper-field that is no more needed
       bin = null;
    }
}
