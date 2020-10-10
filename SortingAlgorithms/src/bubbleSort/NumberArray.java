package bubbleSort;

public class NumberArray {
    public NumberArray() {}

    public static void main(String[] args) {
        int[] array = {7, 11, 4, 18, 1, 9, 8, 2, 12, 19, 16, 5, 15};

        System.out.println("Unsortiert:");
        for (int i = 0; i <array.length ; i++) {   // can type "fori" + ENTER to create for-loop template
            if(i == array.length-1) {
                System.out.println(array[i] + System.lineSeparator());
                break;
            }
            System.out.print(array[i] + ", ");
        }

        int[] sortedArray = new NumberArray().bubbleSort(array);
        System.out.println("Sortiert:");

        for(int i = 0; i < sortedArray.length; i++) {
            if(i != sortedArray.length-1) {
                System.out.print(sortedArray[i] + ", ");
                continue;
            }
            System.out.println(sortedArray[i] + System.lineSeparator());
        }

        int[] sortedArrayRecursive = new NumberArray().bubbleSortRekursiv(array);
        System.out.println("Sortiert rekursiv:");
        for (int i = 0; i < sortedArrayRecursive.length; i++) {
            if(i != sortedArrayRecursive.length - 1) {
                System.out.print(sortedArrayRecursive[i] + ", ");
                continue;
            }
            System.out.println(sortedArrayRecursive[i]);
        }
    }

    public int[] bubbleSortRekursiv(int[] array) {
        int temp;
        for(int i = 0; i < array.length - 1; i++) {
            if(array[i] < array[i + 1]) {
                continue;
            }

            temp = array[i];
            array[i] = array[i + 1];
            array[i + 1] = temp;
            bubbleSortRekursiv(array);
        }
        return array;
    }

    public int[] bubbleSort(int[] array) {
        int temp;
       // long timeStamp = System.nanoTime();

        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length -1 - i; j++) {
                if(array[j] > array[j + 1]) {
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
       // System.out.println("Laufzeit: " + (System.nanoTime() - timeStamp));
        return array;
    }

/*
    public int[] bubbleSort(int[] array) {
        int temp;
        for(int i = 1; i < array.length; i++) {
            for(int j = 1; j < (array.length-i+1); j++) {
                if(array[j-1] > array[j]) {
                    temp = array[j-1];
                    array[j-1] = array[j];
                    array[j] = temp;
                }
            }
        }
        return array;
    }
    */

}
