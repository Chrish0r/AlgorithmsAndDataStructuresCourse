package bubbleSort;

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


public class StringArray {
    public StringArray() {}

    public static void main(String[] args) {
        StringArray stringArray = new StringArray();
        String str[] = {"s", "k", "c", "r", "v", "n", "b", "f", "a", "d"};
        String str2[] = {"Pata", "Peter", "andi", "Franki", "Olaf", "Asterix",
                "Laura", "Christoph", "Bernd", "Xena"};

        System.out.println("str-Array unsorted:");
        for (int i = 0; i < str.length; i++) {
            if (i == str.length - 1) {
                System.out.println(str[i]);
                break;
            }
            System.out.print(str[i] + ", ");
        }

        String[] strSorted = stringArray.sortStringArray(str);
        System.out.println("str-Array sorted:");
        for (int i = 0; i < strSorted.length; i++) {
            if (i == strSorted.length - 1) {
                System.out.println(strSorted[i] + System.lineSeparator());
                break;
            }
            System.out.print(strSorted[i] + ", ");
        }

        System.out.println("str2-Array unsorted:");
        for (int i = 0; i < str2.length; i++) {
            if (i == str2.length - 1) {
                System.out.println(str2[i]);
                break;
            }
            System.out.print(str2[i] + ", ");
        }

        String[] str2Sorted =  stringArray.sortStringArray(str2);
        System.out.println("str2-Array sorted:");
        for (int i = 0; i < str2Sorted.length ; i++) {
            if(i == str2Sorted.length - 1) {
                System.out.println(str2Sorted[i]);
                break;
            }
            System.out.print(str2Sorted[i] + ", ");
        }
    }

    public String[] sortStringArray(String[] str) {
        String tempString;

        for (int i = 0; i < str.length - 1; i++) {
            for(int j = 0; j < str.length - 1 - i; j++) {
                if(str[j].compareToIgnoreCase(str[j+1]) > 0) {
                    tempString = str[j];
                    str[j] = str[j+1];
                    str[j+1] = tempString;
                }
            }
        }
        return str;
    }
}
