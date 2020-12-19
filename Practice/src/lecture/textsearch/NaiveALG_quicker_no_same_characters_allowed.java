package lecture.textsearch;

/**
 * Prerequisite for this algorithm to work:
 * All characters within the pattern are different.
 *
 * Die naive Suche vergleicht jeden Buchstaben von links nach rechts.
 * Sobald ein Buchstabe mismatcht, geht man üblicherweise vom linkem 'Vergleichs-Startwert'
 * nur um eine Stelle nach rechts weiter.
 * Wenn nun aber j Buchstaben gematcht haben und alle Buchstaben im Muster verschieden sind,
 * dann kann es in diesem Bereich keine weiteren Matches (bei Verschiebung um 1) geben und man kann direkt
 * eine Stelle nach dem letztem Match, also um j, schieben.
 */

public class NaiveALG_quicker_no_same_characters_allowed {

    public static void main(String[] args) {
        String text = "ALGORITHMEN UND DATEDATENSTRUKTUREN"; // 1 occurence
        String pattern = "DATEN";

        // String text = "HalloHelloConnallottLoHollaollogbllo"; // 4 occurences "llo"
        // String pattern = "llo";

        char[] textArr = text.toCharArray();
        char[] patternArr = pattern.toCharArray();

        int n = textArr.length;
        int m = patternArr.length;

        System.out.println("Naive search:");
        System.out.println(text);

        System.out.println("Occurrences of the pattern ' " + pattern + "': "
                + findPattern(textArr, n, patternArr, m));
    }

    private static int findPattern(char[] text, int n, char[] pattern, int m) {
        int count = 0;
        String s = "DATEN";
        int j = 0, i = 0;

        while(i <= (n - m)) {
            boolean match = true;

            for(j = 0; j < m; j++) {
                if(text[i + j] != pattern[j]) {
                    match = false;
                    break;
                }
            }
            if(match) {
                count++;
            }

            if(j == 0) {
                i++;
            } else {
                i = i + j; // cannot match anymore within this range when only different characters are existing, within the pattern
            }
        }
        return count;
    }
}
