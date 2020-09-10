package beispiel;

public class BeispielAlg {
 //   public BeispielAlg() {}

    public static void main(String[] args) {
        BeispielAlg bspAlg = new BeispielAlg();
        int[] numbers = {10, 30, -20, -18, 3, 4, -200};
        System.out.println("The smalles number is: " + bspAlg.findMin(numbers));
    }

    private int findMin(int[] array) {
        int min = array[0];
        for(int i = 1; i < array.length; i++) {
            if(array[i] < min) {
                min = array[i];
            }
        }
        return  min;
    }


/*
    public static int findMin(int[] array) {
        int min = array[0];
        for(int number : array) {
            if(number < min) {
                min = number;
            }
        }
        return min;
    }

 */
}
