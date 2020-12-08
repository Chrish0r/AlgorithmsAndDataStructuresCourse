package exercise6;

public class Test {
    public static void main(String[] args) {
        double zaehler;      // m - i, wobei i die Anzahl der bereits belegten Stellen ist
        double nenner = 365; // m
        int n = 28; // Anzahl zufälliger Einträge

        double product = 1;
        for(int i = 0; i <= n-1; i++) {
            zaehler = nenner - i;
            double temp = zaehler / nenner;
            product *= temp;
        }
        System.out.println(product);
    }

}
