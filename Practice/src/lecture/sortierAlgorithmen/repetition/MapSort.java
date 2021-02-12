package lecture.sortierAlgorithmen.repetition;

public class MapSort {
    public static void main(String[] args) {
        int[] array = {34, 45, 12, 34, 23, 18, 38, 17, 43, 51};
        double c = 1.25;

        mapSort(array, array.length, c);
        for(int i = 0; i < array.length; i++) {
            if(i == array.length - 1) {
                System.out.println(array[i]);
                break;
            }
            System.out.print(array[i] + ", ");
        }
    }

    private static void mapSort(int[] arr, int n, double c) {
        int tempN = (int) (c * n);
        int[] bin = new int[tempN];
        // Hilfs-Arrray mit den Werten '-1' initialisieren,damit auch '0' in der Zahlenfolge enthalten sein darf
        for(int i = 0; i < tempN; i++) {
            bin[i] = -1;
        }

        int min = getMin(arr, n);
        int max = getMax(arr, n);
        // Ermittlung der Distanz bei Annahme von Gleichverteilung
        double dist = (double) (max - min) / (tempN - 1);

        for(int i = 0; i < n; i++) {
            int pos = (int) ((arr[i] - min) / dist);
            int insert = arr[i];
            int left = 0;

            // Stelle im Hilfs-Array bereits belegt und 'einzufügender Wert' <= Wert an belegter Stelle
            if(bin[pos] != -1 && insert <= bin[pos]) {
                left = 1;
            }

            while(bin[pos] != -1) { // benötigen wir, um "Ping-Pong-infinite-loop-Effekte" zu vermeiden
                if(left == 1) {
                    if(insert > bin[pos]) {
                        // swap bin[pos] and insert
                        int temp = bin[pos];
                        bin[pos] = insert;
                        insert = temp;
                    }
                    if(pos > 0) { //noch können wir weiter nach links gehen
                        pos--;
                    } else {
                        left = 0;
                    }
                } else { // left == 0
                    if(insert <= bin[pos]) {
                        // swap bin[pos] and insert
                        int temp = bin[pos];
                        bin[pos] = insert;
                        insert = temp;
                    }
                    if(pos < tempN) { // noch können wir weiter nach rechts gehen
                        pos++;
                    } else {
                        left = 1;
                    }
                }
            }
            bin[pos] = insert;
        }
        // copying values of bin[] into original array
        int j = 0;
        for(int i = 0; i < tempN; i++) {
            if(bin[i] != -1) {
                arr[j] = bin[i];
                j++;
            }
        }
        // effectively delete bin
        bin = null;
    }

    private static int getMin(int[] arr, int n) {
        int min = Integer.MAX_VALUE;

        for(int i = 0; i < n; i++) {
            if(arr[i] < min) {
                min = arr[i];
            }
        }
        return  min;
    }

    private static int getMax(int[] arr, int n) {
        int max = Integer.MIN_VALUE;

        for(int i = 0; i < n; i++) {
            if(arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }
}
