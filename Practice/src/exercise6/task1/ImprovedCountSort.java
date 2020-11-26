package exercise6.task1;

public class ImprovedCountSort {
    public static void main(String[] args) {
      //  int[] array = {34, 45, 12, 34, 23, 18, 12, 38, 17, 43, 12, 51};
        int[] array = {2, 3, 4, 4, 2, 2, 2, 3, 6};
        int k = max(array);

        int[] arraySorted = countSort(array, array.length, k);

        for(int i = 0; i  < arraySorted.length; i++) {
            if(i == arraySorted.length-1) {
                System.out.println(arraySorted[i]);
                break;
            }
            System.out.print(arraySorted[i] + ", ");
        }
    }

    // improved count sort
    private static int[] countSort(int[] a, int n, int k) {
        int[] bin = new int[k + 1];
        int j = 1;
        int[] tempArr = new int[a.length];

        // bin mit Nullen initialisieren
        for(int i = 1; i <= k; i++) {
            bin[i] = 0;
        }
        // Vorkommen zählen
        for (int i = 0; i < n; i++) {
            bin[a[i]]++;
        }
        // Positionsbestimmung durch Aufsummieren der einzelnen Vorkommen
        for (j = 1; j <= k; j++) {
            bin[j] += bin[j - 1];
        }
        for (int i = 0; i < n; i++) {
             tempArr[bin[a[i]] - 1] = a[i];
             bin[a[i]]--;
        }
        return tempArr;
    }

    private static void simpleCountSort(int[] a, int n, int k) {
        int[] bin = new int[k+1]; /// since bin[] starts at index 0, that we ignore though
        int j = 1;

        // initialize bin-field with 0s
        for(int i = 1; i <= k; i++) {
            bin[i] = 0;
        }

        // count occurences within original array and include into bins
        for(int i = 0; i < n; i++) {
            bin[a[i]]++;
        }

        // copying over and sorting
        for(int i = 0; i < n; i++) {
            while(bin[j] == 0) { // falls ein Behälter leer ist, dann zum nächstem Behälter weitergehen
                j++;
            }
            a[i] = j;
            bin[j]--;
        }

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
