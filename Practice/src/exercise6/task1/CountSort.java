package exercise6.task1;

public class CountSort {
    public static void main(String[] args) {
        int[] array = {34, 45, 12, 34, 0, 23, 18, 0, 38, 17, 43, 51};
        // int[] array = {5, 3, 1, 2, 6, 4};
        int k = max(array);

        countSort(array, array.length, k);

        for(int i = 0; i  < array.length; i++) {
            if(i == array.length-1) {
                System.out.println(array[i]);
                break;
            }
            System.out.print(array[i] + ", ");
        }
    }

    private static void countSort(int[] a, int n, int k) {
        int[] bin = new int[k+1]; /// since bin[] starts at index 0, that we ignore though
        int j = 0;

        // initialize bin-field with 0s
        for(int i = 0; i <= k; i++) {
            bin[i] = 0;
        }

        // count occurences within original array and include into bins
        for(int i = 0; i < n; i++) {
            bin[a[i]]++;
        }

        // copying over and sorting
        /*
        int i = 0;
        for(j = 1; j <= k; j++) {
            if(bin[j] > 0) {
                for(int l = 1; l <= bin[j]; l++) {
                    a[i] = j;
                    i++;
                }
            }
        }

         */

        for(int i = 0; i < n; i++) {
            while(bin[j] == 0) { // falls ein Behälter leer ist, dann zum nächstem Behälter weitergehen
                j++;
            }
            a[i] = j;
            bin[j]--;
        }
        bin = null;
    }

    // helper method
    private static int max(int[] a) {
        int max = Integer.MIN_VALUE;

        for(int i = 0; i < a.length; i++) {
            if(a[i] > max) {
                max = a[i];
            }
        }
        return  max;
    }
}
