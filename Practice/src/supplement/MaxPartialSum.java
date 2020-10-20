package supplement;

public class MaxPartialSum {
    public static void main(String[] args) {
        int[] array = {-13, 25, 34, 12, -3, 7, -87, 28, -77, 11};


        System.out.println("the greatest partial sum is: " + findMaxPartialSum(array));
    }

    private static int findMaxPartialSum(int[] arr) {
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
