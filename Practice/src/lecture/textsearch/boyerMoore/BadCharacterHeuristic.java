package lecture.textsearch.boyerMoore;

/**
 This class is responsible for the implementation of the Boyer-Moore-Algorithm,
 using the 'bad-charachter-strategy'
 */

public class BadCharacterHeuristic {

    public static void main(String[] args) {
        String text = "ALGORITHMEN UND DATENSTRUKTUREN"; // 1 occurence
        String pattern = "DATEN";

      //  String text = "Aallo Hallo Hello"; // 1 occurence "Hallo"
      //  String pattern = "Hallo";

        char[] textArr = text.toCharArray();
        char[] patternArr = pattern.toCharArray();

        int n = textArr.length;
        int m = patternArr.length;

        System.out.println("Occurrences of the pattern ' " + pattern + "': "
                + boyerMooreSearch(textArr, n, patternArr, m));
    }

    private static int boyerMooreSearch(char[] text, int n, char[] muster, int m) {
        int i, j, sizeOfAlphabet = 28; // | i -> pos(text / j -> pos(muster)
        int[] shift = new int[sizeOfAlphabet];

         convertToUppercase(text);
         convertToUppercase(muster);

        for(i = 0; i < sizeOfAlphabet; i++) {
            shift[i] = m; // 0 = A
        }
        for(i = 0; i < m; i++) {
            shift[getIndex(muster[i])] = m - i - 1; // <-> m - (i+1)

            /*
                 shift-table - alphabetisch (hier vereinfacht Nicht-Vorkommen am Ende unter "Rest")
                             -> in general: shift = Musterlänge - Stelle_Buchstabe <=> m - i - 1 <=> m - (i + 1)

                  A -> 3
                  H -> 4
                  L -> 1        (letztes Vorkommen zählt)
                  O -> 0

                  Rest -> 5 = Musterlänge m, weil diese Buchstaben nicht im Muster vorkommen.
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
                falls wir weiter zurückgegangen sind, als der Versatz des entsprechenden Buchstabens ist,
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

    private static void convertToUppercase(char[] a) {
        for(int i = 0; i < a.length; i++) {
            int numCh = (int) a[i];
            if(numCh >= 97 && numCh <= 122) {
                int temp = numCh - 32;
                a[i] = (char) temp;
            }
        }
    }

    private static int getIndex(char c) {
        if(c == ' ') {
            return 26;
        }
        if(c == ',') {
            return 27;
        }
        return ((int) c - 65);
    }
}
