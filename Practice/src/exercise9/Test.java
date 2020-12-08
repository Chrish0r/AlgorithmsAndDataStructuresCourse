package exercise9;

public class Test {
    public static void main(String[] args) {
        String text = "HalloHelloConnallottLoHollaollogb"; // 4 occurences "llo"
        String pattern = "llo";

        char[] textArr = text.toCharArray();
        char[] patternArr = pattern.toCharArray();

        System.out.println("Occurrences of the pattern ' " + pattern + "': " + findPattern(textArr, patternArr));
    }

    private static int findPattern(char[] t, char[] p) {
        int count = 0;

        for(int i = 0; i <= (t.length - p.length); i++) {
            boolean isPattern = true;
            for(int j = 0; j < p.length; j++) {
                if(t[i + j] != p[j]) {
                    isPattern = false;
                    break;
                }
            }
            if(isPattern) {
                count++;
            }
        }
        return count;
    }
}
