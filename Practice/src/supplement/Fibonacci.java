package supplement;

public class Fibonacci {
    public static void main(String[] args) {
        int n = 8;

        int[] array = fib(8);

        for(int i = 0; i < array.length; i++) {
            if(i == array.length - 1) {
                System.out.println(array[i]);
                break;
            }
            System.out.print(array[i] + ", ");
        }
    }

    public static int[] fib(int n) {
        int[] fibArr = new int[n];

        for(int i = 0; i < n; i++) {
            if(i == 0) {
               fibArr[i] = 1;
               continue;
            }
            if(i == 1) {
                fibArr[i] = 1;
                continue;
            }

            fibArr[i] = fibArr[i - 1] + fibArr[i - 2];
        }
        return fibArr;
    }
}
