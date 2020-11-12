package exercise5;


public class Test {
    public static void main(String[] args) {
        int[] array = {5, 3, 1, 2, 6, 4};

        System.out.println("Can a sum be built out of two numbers of the field, where" +
                "the sum is also a number of the field itself?");
        System.out.println(sumIsComposited(array));
    }

    private static boolean sumIsComposited(int[] a) {
        int sum;
        for(int i = 0; i < a.length - 1; i++) {
            for(int j = i + 1; j < a.length; j++) {
                sum = a[i] + a[j];
                for(int k = 0; k < a.length; k++) {
                    if(sum == a[k]) {
                     //   System.out.println("sum = " + sum + " -> summand_1 = " + a[i] +
                      //          " and summand_2 = " + a[j]);
                        return true;
                    }
                }
            }
        }
        return false;
    }

}
