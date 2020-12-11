package lecture.textsearch;

public class NaiveALG {
    public static void main(String[] args) {
        String text = "HalloHelloConnallottLoHollaollogbllo"; // 4 occurences "llo"
        String pattern = "llo";

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
        String indent = "";
        String s = "llo";

        for(int i = 0; i <= (n - m); i++) {
            boolean match = true;
            System.out.println(indent + s);
            for(int j = 0; j < m; j++) {
                if(text[i + j] != pattern[j]) {
                    match = false;
                    break;
                }
            }
            if(match) {
                count++;
            }
            indent += " ";
        }
        return count;
    }
}
