package hash_table.example;

public class ExampleHashTable {

    public static void main(String[] args) {
        System.out.println("'Leo' is positioned at index " + calcuateIndex("Leo"));
    }

    public static int calcuateIndex(String name) {
        // Leo
        Character character1 = name.charAt(0);
        Character character2 = name.charAt(1);
        Character character3 = name.charAt(2);
        System.out.println(character1 + "" + character2 + character3);

        int ascii1 = (int) character1;
        int ascii2 = (int) character2;
        int ascii3 = (int) character3;
        System.out.println(ascii1 + ", " + ascii2 + ", " + ascii3);

        int sum = ascii1 + ascii2 + ascii3;
        System.out.println(("Sum: " + sum));

        // length of array shall be 11
        return sum % 11;
    }
}
