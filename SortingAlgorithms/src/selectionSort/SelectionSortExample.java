package selectionSort;

public class SelectionSortExample {

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

        int[] sortedArray = new SelectionSortExample().selectionSort(unsortedArray);
        System.out.println("Sorted Array:");
        for (int i = 0; i < sortedArray.length; i++) {
            if(i == sortedArray.length - 1) {
                System.out.println(sortedArray[i] + System.lineSeparator());
                break;
            }
            System.out.print(sortedArray[i] + ", ");
        }
    }

    public static int[] selectionSort(int[] arrayToSort) {
        for(int i = 0; i < arrayToSort.length - 1; i++) {
        //    int min = arrayToSort[i];
            for(int j = i + 1; j < arrayToSort.length; j++) {
                if(arrayToSort[i] > arrayToSort[j]) {
                    int temp = arrayToSort[i];
                    arrayToSort[i] = arrayToSort[j];
                    arrayToSort[j] = temp;
                }
            }
        }
        return  arrayToSort;
    }
}
