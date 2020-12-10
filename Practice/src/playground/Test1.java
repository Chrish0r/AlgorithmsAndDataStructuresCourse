package playground;

public class Test1 {
    public static void main(String[] args) {
        String s = "heLLo WorldD! How aRe You?";

        String sUpper = s.toUpperCase();
        char[] arr = sUpper.toCharArray();



        for(int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
        }
        System.out.println();
    }
}
