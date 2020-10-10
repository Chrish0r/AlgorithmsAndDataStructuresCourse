package insertionSort;

import selectionSort.SelectionSortExample;

public class InsertionSortExample {

    public static void main(String[] args) {

        int[] unsortedArray = {16, 23, 14, 7, 21, 20, 6, 1, 17, 13, 12, 9, 3, 19};

        System.out.println("Unsorted Array:");
        for (int i = 0; i < unsortedArray.length; i++) {
            if(i == unsortedArray.length - 1) {
                System.out.println(unsortedArray[i] + System.lineSeparator());
                break;
            }
            System.out.print(unsortedArray[i] + ", ");
        }

        int[] sortedArray = new InsertionSortExample().insertionSort(unsortedArray);
        System.out.println("Sorted Array:");
        for (int i = 0; i < sortedArray.length; i++) {
            if(i == sortedArray.length - 1) {
                System.out.println(sortedArray[i] + System.lineSeparator());
                break;
            }
            System.out.print(sortedArray[i] + ", ");
        }
    }

    public int[] insertionSort(int[] arrayToSort) {
        for(int i = 1; i < arrayToSort.length; i++) {
            int current = arrayToSort[i]; // the one further element to add - at the start not yet in sorted area

            int j = i;
            while(j > 0 && arrayToSort[j - 1] > current) {
                arrayToSort[j] = arrayToSort[j - 1];

                j--;
            }
            arrayToSort[j] = current;
        }
        return arrayToSort;
    }
}
