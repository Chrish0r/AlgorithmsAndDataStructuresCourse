package rekursion.beispiel;

/**
 * Rekursion ist eine "Schleife", innerhalb welcher sich die Methode (Aufgabe)
 * immer wieder selbst aufruft, bis eine bestimmte Abbruchbedingung (Aufgabe "fertig") erreicht ist.
 */

public class RekursionTest {
    public static void main(String[] args) {

        int a = 10;

        while(a >= 1) {
            System.out.println("Gegner erstellt");
            a--;
        }

        a = 10;
        System.out.println(System.lineSeparator() + "Rekursiv:");

        new RekursionTest().erzeugeGegner(a);
    }

    private void erzeugeGegner(int a) {
        if(a >= 1) {
            System.out.println("Gegner erstellt: " + a);
            erzeugeGegner((a - 1));
        }
    }

    private void erzeugeGegner2(int a) {
        if(a == 1) {
            System.out.println("Gegner erstellt: " + a);
        } else {
            System.out.println("Gegner erstellt");
            erzeugeGegner(a - 1);
        }
    }
}
