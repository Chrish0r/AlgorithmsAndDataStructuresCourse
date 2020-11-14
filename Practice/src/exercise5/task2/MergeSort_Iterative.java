package exercise5.task2;

public class MergeSort_Iterative {
    public static void main(String[] args) {
        int[] array = {34, 45, 12, 34, 23, 18, 38, 17, 43, 51};
        int first = 0;
        int last = array.length-1;

        mergeSortIter(array, array.length);
        for(int i = 0; i < array.length; i++) {
            if(i == array.length - 1) {
                System.out.println(array[i]);
                break;
            }
            System.out.print(array[i] + ", ");
        }
    }

    public static void mergeSortIter(int[] array, int n) {
        if(array == null) {
            return;
        }

        if(n > 1) {
            int m = n/2;

           // left subfield
            int[] leftArr = new int[m];
            for(int i = 0; i < m; i++) {
                leftArr[i] = array[i];
            }

            // right subfield
            int[] rightArr = new int[n - m];
            for(int i = m; i < n; i++) {
                rightArr[i - m] = array[i];
            }

            mergeSortIter(leftArr, leftArr.length);
            mergeSortIter(rightArr, rightArr.length);

            int i = 0, j = 0, k = 0;

            // Merge left and right subfields
            while(i < leftArr.length && j < rightArr.length)
            {
                if(leftArr[i] < rightArr[j]) {
                    array[k] = leftArr[i];
                    i++;
                } else {
                    array[k] = rightArr[j];
                    j++;
                }
                k++;
            }
            // Sort remaining elements
            while(i < leftArr.length) {
                array[k] = leftArr[i];
                i++;
                k++;
            }
            while(j < rightArr.length) {
                array[k] = rightArr[j];
                j++;
                k++;
            }
        }
    }
}

