package testbook;

public class CounterOfOccurences {


    public static void main(String[] args) {
        int[] array = {34, 45, 12, 34, 23, 18, 38, 17, 34, 51};

        int searchItem = 34;
        int l = 0;
        int r = array.length-1;

        int count = countX(array, l, r, searchItem);
        System.out.println("the number " + searchItem + " occurs within the array " + count + " times");
    }

    private static int countX(int[] array, int l, int r, int x) {
        if(l == r) {
            return (array[l] == x ? 1 : 0);
        } else {
            int temp =  l + r;
            int middle = temp % 2 == 0 ? temp/2 : temp/2 + 1;

            int countLeft = countX(array, l, middle - 1, x);
            int countRight = countX(array, middle, r, x);

             return countLeft + countRight;
        }
    }


}
