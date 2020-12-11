package lecture.textsearch;

/**
 This class is responsible for the implementation of the Boyer-Moore-Algorithm,
 using the 'good-suffix/end-strategy'
 */

public class BoyerMooreALG_with_good_suffix_heuristic {

    public static void main(String[] args) {
        String text = "Aallo Hallo Hello"; // 1 occurence "Hallo"
        String pattern = "Hallo";

        char[] textArr = text.toCharArray();
        char[] patternArr = pattern.toCharArray();

        int n = textArr.length;
        int m = patternArr.length;

        System.out.println("Occurrences of the pattern ' " + pattern + "': "
                + boyerMooreSearch(textArr, n, patternArr, m));
    }

    private static int boyerMooreSearch(char[] textArr, int n, char[] patternArr, int m) {
        int count = 0;

        return count;
    }
}
