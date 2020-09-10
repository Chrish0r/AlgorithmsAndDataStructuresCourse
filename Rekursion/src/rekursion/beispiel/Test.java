package rekursion.beispiel;

public class Test {
    public static void main(String[] args) {

        // continue
        int i;
        for (i = 0; i < 10; i++) {
            if (i == 4) {
                break;
            }
            System.out.println("Zahl: " + i);
        }
        System.out.println("Hier geht es mit " + i + " weiter.");

        i = 0;
        while (i < 5) {
            System.out.println(i);
            i++;
            if (i == 4)
                break;
        }
        System.out.println();

        // continue

        for (int j = 0; j < 10; j++) {
            if (j == 4) {
                continue;
            }
            System.out.println("Zahl: " + j);
        }
        System.out.println();

        int k = 0;
        while (k < 10) {
            System.out.println(k);
            k++;
            if(k == 4){
                k++;
                continue;
            }
        }
    }
}

