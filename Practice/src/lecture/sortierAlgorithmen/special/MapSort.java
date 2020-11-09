package lecture.sortierAlgorithmen.special;

public class MapSort {
    public static void main(String[] args) {
        int[] array = {34, 45, 12, 34, 23, 18, 38, 17, 43, 7};
        // int[] array = {5, 3, 1, 2, 6, 4};
        double c = 1.0;

        mapSort(array, array.length, c);

        for(int i = 0; i  < array.length; i++) {
            if(i == array.length-1) {
                System.out.println(array[i]);
                break;
            }
            System.out.print(array[i] + ", ");
        }
    }

    private static void mapSort(int[] arr, int n, double c) {
        int tempN = (int) ((double) n * c);
        int i, j = 0;

        int[] bin = new int[tempN];
        int min = Integer.MAX_VALUE; // "worst case Min"
        int max = Integer.MIN_VALUE; // "worst case Max"

        /* bin-Array wird auf jeweils -1 initialisiert
         -> '-1' bedeutet, dass die jeweilige Stelle nicht belegt ist.
         '-1' als Platzmarker unter der Voraussetzung, dass -1 kein möglicher Zahlen-Eingabewert sein darf.
        */
        for (i = 0; i < tempN; i++) {
            bin[i] = -1;
        }

        for (i = 0; i < n; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
            if (arr[i] > max) {
                max = arr[i];
            }
        }

        double dist = (double) (max - min) / (double) (tempN - 1);

        for (i = 0; i < n; i++) {
            int t = (int) ((double) (arr[i] - min) / dist);
            int insert = arr[i];
            int left = 0;

            if (bin[t] != -1 && insert <= bin[t]) {
                left = 1;
            }

            while (bin[t] != -1) {
                if (left == 1) {
                    if(insert > bin[t]) {
                        // swap bin[t] and insert
                        int temp = bin[t];
                        bin[t] = insert;
                        insert = temp;
                    }
                    if(t > 0) {
                        t--;
                    } else {
                        left = 0;
                    }
                } else {
                    if(insert <= bin[t]) {
                        // swap bin[t] and insert
                        int temp = bin[t];
                        bin[t] = insert;
                        insert = temp;
                    }
                    if(t < tempN - 1) {
                        t++;
                    } else {
                        left = 1;
                    }
                }
            }
            bin[t] = insert;
        }
        for (i = 0; i < tempN; i++) {
            if (bin[i] != -1) {
                arr[j++] = bin[i];
            }
        }
        // effectively delete bin -> garbage collector will take care of this temp-/helper-field that is no more needed
        bin = null;
    }
}
