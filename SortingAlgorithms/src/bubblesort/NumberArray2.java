package bubblesort;

/**
 * Bem.: Comparable<T> IF dann implementieren, wenn man Objekte bzgl.
 * bestimmten Attributen vergleichen will und nur dann compareTo überschreiben.
 * Wenn man dann bzgl. diesen Attributen integers vergleiche will,
 *  dann 'return Subtraktion' oder if/else (-1, 0, 1) ,
 *  sonst bei z.B. String-Attributen einfach nur
 *  'this.name.compareTo(obj.name)'...
 *
 *  Bei Vergleichen mit Strings (keine Attr. von Objekten) braucht man compareTo
 *  nicht überschreiben und nicht das Comparable<T> Interface implementieren.
 *  Bei z.B. Int-Vergleich (wenn nicht Attr. von Objekten) braucht man gar kein
 *  compareTo.
 *
 *   compareTo nur bei Strings oder Attributen von Objekten.
 */

public class NumberArray2 {

    public static void main(String[] args) {
        int[] numbers = {3, 5, 0, -10, 400, 1, 40, 33, -1, 3040, 12};

        int[] sortedNumbers = new NumberArray2().sortArray(numbers);
        System.out.println("Sortiert von klein nach groß: ");

        for (int i = 0; i < sortedNumbers.length; i++) {
            if(i == sortedNumbers.length - 1) {
                System.out.println(sortedNumbers[i]);
                break;
            }
            System.out.print(sortedNumbers[i] + ", ");
        }
    }

    private int[] sortArray(int[] array) {
        int temp;

        for(int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - 1 - i ; j++) {
                if(array[j] > array[j + 1]) {
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
        return array;
    }
}
