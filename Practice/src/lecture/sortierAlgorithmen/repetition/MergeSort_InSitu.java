package lecture.sortierAlgorithmen.repetition;

public class MergeSort_InSitu {
    public static void main(String[] args) {
        // int[] array = {34, 45, 12, 34, 23, 18, 38, 17, 43, 51};
        int[] array = {4, 7, 2, 8, 9, 6, 1, 3};

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

        int a1First = first, a1Last = m-1;
        int a2First = m, a2Last = last;

        while(a1First <= a1Last && a2First  <= a2Last) {
                    if(arr[a1First] <= arr[a2First]) { // ab hier werden die Werte in den Teil-Arrays miteinander verglichen
                        a1First++;
                    } else {
                        int temp = arr[a2First];
                        int tempIndex = a2First;

                        // verschiebe alle Elemente zwischen den verglichenen Werten um eine Stelle nach rechts
                        while(tempIndex != a1First) {
                            arr[tempIndex] = arr[tempIndex - 1];

                            tempIndex--;
                        }
                        arr[a1First] = temp;

                        // alle Zeiger updaten
                        //  -> das linke Teil-Array wird ingesamt um einem Wert größer, weil
                        // ein kleinerer Wert aus dem rechtem Teil-Array "hineinpositioniert" wird -> daher auch 'a1Last' um Eins erhöhen
                        a1First++;
                        a1Last++;
                        a2First++;
                    }
            }
        }
    }


