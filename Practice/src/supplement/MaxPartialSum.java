package supplement;

public class MaxPartialSum {
    public static void main(String[] args) {
        int[] array = {-13, 25, 34, 12, -3, 7, -87, 28, -77, 11};


        System.out.println("the greatest partial sum is: " + findMaxPartialSum(array));
        System.out.println(findMaxPartialSumO_n2(array));
    }

    private static int findMaxPartialSum(int[] arr) {
        int sum = 0;
        int currentSum = 0;
        int max = 0; //  // actually no need to initialize with zero, since default value for Integer (but for illustration purposes)
  //      int start = 0;
   //     int end = 0;

        for(int i = 0; i < arr.length; i++) {
            sum = currentSum + arr[i];

            if(sum > arr[i]) {
                currentSum = sum;
            } else {
                currentSum = arr[i];
            }

            if(currentSum > max) {
                max = currentSum;

             //   end = i;

            }
        }

     //  System.out.print("At start-index " + start + " and end-index " + end + ", ");
        return max;
    }

    private static int findMaxPartialSumO_n2(int[] arr) { // running time = O(n²)
        int sum;
        int max = Integer.MIN_VALUE; 
        int start = 0;
        int end = 0;

        for(int i = 0; i < arr.length; i++) {
            sum = 0;
            for(int j = i; j < arr.length; j++) {
                sum = sum + arr[j];
                if(sum > max) {
                    max = sum;

                    start = i;
                    end = j;
                }
            }
        }

        System.out.print("At start-index " + start + " and end-index " + end + ", ");
        return max;
    }

    private static int findMaxPartialSumSlow(int[] arr) { // running time = O(n³)
        int sum;
        int max = 0; //  // actually no need to initialize with zero, since default value for Integer (but for illustration purposes)
        int start = 0;
        int end = 0;

        for (int i = 0; i < arr.length; i++) {
            for(int j = i; j < arr.length; j++) {
                sum = 0;
                for(int k = i; k <= j; k++) {
                    sum = sum + arr[k];
                }
                if(sum > max) {
                    max = sum;

                    start = i;
                    end = j;
                }
            }
        }
        System.out.print("At start-index " + start + " and end-index " + end + ", ");
        return max;
    }
}
