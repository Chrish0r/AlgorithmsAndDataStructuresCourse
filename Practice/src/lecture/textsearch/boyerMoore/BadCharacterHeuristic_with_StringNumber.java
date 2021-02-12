package lecture.textsearch.boyerMoore;

/**
   This class is responsible for the implementation of the Boyer-Moore-Algorithm,
    using the 'bad-charachter-strategy'
 */

public class BadCharacterHeuristic_with_StringNumber {

    public static void main(String[] args) {
        String text = "363645636363645632136"; // 3 occurences "3636"
        String pattern = "456321";

        char[] textArr = text.toCharArray();
        char[] patternArr = pattern.toCharArray();

        int n = textArr.length;
        int m = patternArr.length;

        System.out.println("Occurrences of the pattern ' " + pattern + "': "
                + boyerMooreSearch(textArr, n, patternArr, m));
    }

    private static int boyerMooreSearch(char[] text, int n, char[] muster, int m) {
        int i, j, sizeOfAlphabet = 10; // [1, 6]   | i -> pos(text / j -> pos(muster)
        int[] shift = new int[sizeOfAlphabet];

        /*
        vorläufig erhalten alle Zeichen (auch Vorkommen im Muster)
        des Alphabets einen shift-Wert der Musterlänge m
         */
        for(i = 0; i < sizeOfAlphabet; i++) {
            shift[i] = m;
        }
        for(i = 0; i < m; i++) {
            shift[getIndex(muster[i])] = m - i - 1; // <-> m - (i+1)

            /*
                 shift-table - alphabetisch
                             -> in general: shift = Musterlänge - Stelle_Buchstabe <=> m - i - 1 <=> m - (i + 1)

                  1 -> 4
                  2 -> 4
                  3 -> 1        (letztes Vorkommen zählt)
                  4 -> 4
                  5 -> 4
                  6 -> 0        (letztes Vorkommen zählt)
             */
        }

        int count = 0;
        j = i = m - 1; // i und j werden auf letzten Buchstaben-Index des Musters gesetzt, dort beginnen wir auch

        while(i < n) {
            if(text[i] == muster[j]) {
                // match
                if(j == 0) { // das gesamte Muster ist vollständig gematcht -> count++
                    count++;
                    /*
                    effektiv gehen wir nur 1 Stelle weiter nach rechts,
                    ausgehend von der Stelle, an der wir begonnen Teilmatchees zu habe
                    und zurückgegangen sind (m-1-mal), um weiter auf vorherige Teilmatches zu prüfen.
                     */
                    i += m;
                    j = m - 1; // (re)targeten wieder letzten Buchstaben des Musters

                    /* Teilmatches (noch nicht vollständig fertig) */
                } else {
                    // gehen weiter zurück nach Links um auf weitere Teilmatches zu prüfen
                    i--;
                    j--;
                }
            } else {
                /*
                falls wir weiter zurückgegangen sind, als der Versatz (shift-Wert) des entsprechenden Buchstabens ist,
                bis doch noch fail kam -> so können wir direkt wieder weiter nach vorne kommen -> effizienter.
                 */
                if(m - j > shift[getIndex(text[i])]) {
                    i = i + m - j; // hier wird dann um Mustelänge m - j_current geschiftet
                } else {
                    i = i + shift[getIndex(text[i])];
                }
                j = m - 1; // (re)targeten wieder letzten Buchstaben des Musters
            }
        }
        return  count;
    }

    private static int getIndex(char c) {
        return ((int) c - 48); // 1 auf index 0 abgebildet
    }
}
