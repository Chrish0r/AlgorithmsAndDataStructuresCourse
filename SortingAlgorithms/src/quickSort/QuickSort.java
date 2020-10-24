package quickSort;

public class QuickSort {

    public static void main(String[] args) {
        int[] arrayUnsorted = {8, 4, 19, 3, 5, 12, 7};

        System.out.println("unsorted array:");
        for(int i = 0; i < arrayUnsorted.length; i++) {
            if(i == arrayUnsorted.length - 1) {
                System.out.println(arrayUnsorted[i] + System.lineSeparator());
                break;
            }
            System.out.print(arrayUnsorted[i] + ", ");
        }

        int[] arraySorted = new QuickSort().quickSort(arrayUnsorted, 0, arrayUnsorted.length - 1);

        System.out.println("sorted array:");
        for(int i = 0; i < arraySorted.length; i++) {
            if(i == arraySorted.length - 1) {
                System.out.println(arraySorted[i] + System.lineSeparator());
                break;
            }
            System.out.print(arraySorted[i] + ", ");
        }
    }

    public int[] quickSort(int[] arraySorted, int low, int high) {
        int pivot = arraySorted[high];
        int i = low;
        int j = high;

        while(i <= j) {

            // following  two while-loops examine when to swap i and j (if false)
            while(arraySorted[i] < pivot) {
                i++;
            }

            while(arraySorted[j] > pivot) {
                j--;
            }
            if(i <= j) { // no cross over
                int temp = arraySorted[i];
                arraySorted[i] = arraySorted[j];
                arraySorted[j] = temp;
                // incrementing i,j so that they keep going within the outer while-loop
                i++;
                j--;
            }
        }
        if(low < j) {
            quickSort(arraySorted, low, j);
        }
        if(high > i) {
            quickSort(arraySorted, i, high);
        }

        // now we are ready, if low == j and high == i -> we have arrived at the end
        return arraySorted;
    }
}
