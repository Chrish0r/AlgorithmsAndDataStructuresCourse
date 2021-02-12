package lecture.sortierAlgorithmen.repetition;

public class BubbleSort {
    public static void main(String[] args) {
        int[] array = {34, 45, 12, 34, 23, 18, 38, 17, 43, 51};

        // bubbleSort(array, array.length);
        bubbleSortMax(array, array.length);
        for(int i = 0; i < array.length; i++) {
            if(i == array.length - 1) {
                System.out.println(array[i]);
                break;
            }
            System.out.print(array[i] + ", ");
        }
    }



    // aufsteigend via jeweiliges Minimum in jeder Runde nach Vorne positionieren
    private static void bubbleSort(int[] arr, int n) {
        int h;
        for(int i = 0; i < n; i++) {
            for(int j = n-2; j >= i; j--) {
                if(arr[j] > arr[j+1]){
                    h = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = h;
                }
            }
        }
    }

    // aufsteigend via jeweiliges Maximum in jeder Runde nach Hinten positionieren
    private static void bubbleSortMax(int[] arr, int n) {
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n-1-i; j++) {
                if(arr[j] > arr[j+1]) {
                    int h = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = h;
                }
            }
        }
    }
}
