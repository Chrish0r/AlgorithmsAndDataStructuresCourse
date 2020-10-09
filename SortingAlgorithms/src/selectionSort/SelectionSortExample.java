package selectionSort;

public class SelectionSortExample {

    public int[] selectionSort(int[] arrayToSort) {
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
