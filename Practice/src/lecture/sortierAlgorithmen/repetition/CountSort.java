package lecture.sortierAlgorithmen.repetition;

public class CountSort {
    public static void main(String[] args) {
        int[] array = {34, 45, 12, 34, 23, 18, 38, 17, 43, 51};


        countSort(array, array.length, max(array, array.length));
        for(int i = 0; i < array.length; i++) {
            if(i == array.length - 1) {
                System.out.println(array[i]);
                break;
            }
            System.out.print(array[i] + ", ");
        }
    }

    private static void countSort(int[] arr, int n, int k) {
        int bin[] = new int[k+1]; // Hilfs-Feld mit je einer Position innerhalb Range - initialisiert mit '0'en
        int j = 1; // erster Stellen-Behälter im Hilfs-Array

        for(int i = 0; i < n; i++) {
             bin[arr[i]]++;
        }

        for(int i = 0; i < n; i++) {
            while(bin[j] == 0) {
                j++;
            }
            arr[i] = j;
            bin[j]--; //Counter im Hilfs-Array nach einer Übergabe auch um Eins verringern
        }

        // Hilfs-Array wieder freigeben
        bin = null;
    }

    private static int max(int[] arr, int n) {
        int max = Integer.MIN_VALUE;

        for(int i = 0; i < n; i++) {
            if(arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }
}
