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

    private static int boyerMooreSearch(char[] text, int n, char[] muster, int m) {
        int count = 0, i ,j;

        i = j = m-1;

        while(i < n) {
            if (text[i] == muster[j]) {

            } else {
                // case 1: good suffix does exist somewhere before within the pattern
                if(findGoodSuffix(muster, j+1, m-1)) {
                    int shift = muster.length - (m-1 - (j+1) + 1);
                    i += shift;
                }
                // case 2: goood suffix does not exist somewhere before within the pattern -> shift at one
                else {
                    i++;
                }
                j = m - 1;
            }
        }
        return count;
    }

    private static boolean findGoodSuffix(char[] muster, int first, int last) {
        char[] subStr = getSubStr(muster, first, last);
        int j = 0, i = 0;
        boolean match = true;

        for(i = 0; i < (muster.length - subStr.length); i++) {
            for(j = 0; j < subStr.length; j++) {
                if(muster[i+j] != subStr[j]) {
                    match = false;
                    break;
                }
            }
            if(match) {
                return true;
            }
        }
        return false;
    }

    private static char[] getSubStr(char[] muster, int first, int last) {
        int size = last - first + 1;
        char[] subStr = new char[size];

        for(int i = 0; i < size; i++) {
            subStr[i] = muster[first];
            first++;
        }
        return subStr;
    }

}
