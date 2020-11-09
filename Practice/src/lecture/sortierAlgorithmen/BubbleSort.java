package lecture.sortierAlgorithmen;

public class BubbleSort {
    public static void main(String[] args) {
        int[] array = {34, 45, 12, 34, 23, 18, 38, 17, 43, 51};

        bubbleSort(array, array.length);

        for(int i = 0; i  < array.length; i++) {
            if(i == array.length-1) {
                System.out.println(array[i]);
                break;
            }
            System.out.print(array[i] + ", ");
        }
    }

    // logic: the smallest value goes from end to start
    public static void bubbleSort(int arr[], int n) {
       // int swapCount = 0;
        for(int i = 0; i < n; i++) {
            for(int j = n-2; j >= i; j--) {
                if(arr[j] > arr[j+1]) {
                    int h = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = h;
                   // swapCount++;
                }
            }
        }
     //   System.out.println("swap count is: " + swapCount);
    }
}
