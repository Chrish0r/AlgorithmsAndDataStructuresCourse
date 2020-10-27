package supplement;

public class Test {
    public static void main(String[] args) {
        int[][] array = {
                {-13, 25, 34, 12, -3, 7, -87, 28, -77, 11},
                {-13, 25, 34, 12, -3, 7, -87, 28, 77, 21}
        };

        System.out.println("the greatest partial sum is: " + findMaxPartialSum(array));

    }

    private static int findMaxPartialSum(int[][] arr) {
        int sum = 0;
        int currentSum = 0;
        int max = 0; //  // actually no need to initialize with zero, since default value for Integer (but for illustration purposes)

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                sum = currentSum + arr[i][j];
                if (sum > arr[i][j]) {
                    currentSum = sum;
                } else {
                    currentSum = arr[i][j];
                }
                if (currentSum > max) {
                    max = currentSum;
                }
            }
        }
        return max;
    }
}

