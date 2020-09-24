package hash_table;

import java.util.Arrays;

public class LinearSearch {

    public static void main(String[] args) {

        String[] names = new String[11];

        names[0] = "Max";
        names[1] = "Lea";
        names[2] = "Leon";
        names[3] = "Anna";
        names[4] = "Joe";
        names[5] = "Petra";
        names[6] = "Leo";
        names[7] = "Jan";
        names[8] = "Oli";
        names[9] = "Mia";
        names[10] = "Pia";

        for (int i = 0; i < names.length; i++) {
            if (names[i].equals("Leo")) {
                System.out.println("Gefunden an der Stelle " + i);
            }
        }

        System.out.println("Leo gefunden: " + names[6] + System.lineSeparator());

        System.out.println("Search for 'Leo' via list-'contains' method");
        System.out.println("'Leo' found: " + search(names, "Leo" + System.lineSeparator()));
    }

/*
    private static int getIndex(int length, String s) {


        char[] charArray = s.toCharArray();
        int sumOfChars = 0;

        for(char ch : charArray) {
            sumOfChars += (int) ch;
        }
        return sumOfChars % length;
    }
  */

    public static boolean search(String[] array, String searchItem) {
        return Arrays.asList(array).contains(searchItem);
    }
}
