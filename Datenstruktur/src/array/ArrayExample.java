package array;

import java.util.Arrays;

public class ArrayExample {

    public static void main(String[] args) {

        int[] numbers = new int[10]; // Size: 10 | Index: 0 - 9
        int[] numbers2 = {1, 2, 3, 4, 5}; // Size: 5 | Index: 0 - 4

        numbers[0] = 100;

        System.out.println(numbers[0]);
        System.out.println(numbers2[2] + System.lineSeparator());

        for (int number : numbers2) {
            System.out.println(number);
        }
        System.out.println();

        // copying array
        int[] original = {1, 2, 3, 4}; // Size: 4
        int[] copy = Arrays.copyOf(original, original.length);
        // int[] copy = Arrays.copyOf(original, 4);
        int[] copyHalf = Arrays.copyOf(original, (original.length / 2));
        int[] copyCustomizedRange = Arrays.copyOfRange(original, 1, 3);
        int[] copyCustomizedRangeGreater = Arrays.copyOfRange(original, 2, 7); // {3, 4, 0, 0, 0}

        System.out.println("Copy of full original array:");
        for (int i = 0; i < copy.length; i++) {
            if(i != copy.length - 1) {
                System.out.print(copy[i] + ", ");
                continue;
            }
            System.out.println(copy[i] + System.lineSeparator());
        }

        System.out.println("Copy of half original array:");
        for (int i = 0; i < copyHalf.length; i++) {
            if(i != copyHalf.length - 1) {
                System.out.print(copyHalf[i] + ", ");
                continue;
            }
            System.out.println(copyHalf[i] + System.lineSeparator());
        }

        System.out.println("Copy of original array with a customized range:");
        for (int i = 0; i < copyCustomizedRange.length; i++) {
            if(i != copyCustomizedRange.length - 1) {
                System.out.print(copyCustomizedRange[i] + ", ");
                continue;
            }
            System.out.println(copyCustomizedRange[i] + System.lineSeparator());
        }

        System.out.println("Copy of original array with a customized range that exceeds" +
                " the size of the original array:");
        for (int i = 0; i < copyCustomizedRangeGreater.length; i++) {
            if(i != copyCustomizedRangeGreater.length - 1) {
                System.out.print(copyCustomizedRangeGreater[i] + ", ");
                continue;
            }
            System.out.println(copyCustomizedRangeGreater[i] + System.lineSeparator());
        }
    }
}
