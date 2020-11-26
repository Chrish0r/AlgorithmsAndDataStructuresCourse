package exercise7;

class Kraftwagen {
    String text;

    public Kraftwagen(String text) {
        this.text = text;

    }
    public String toString() {
        return text;
    }
}

public class Test {
    public static void main(String[] args) {
        Kraftwagen wagen1 = new Kraftwagen("0-1");
        Kraftwagen wagen2 = wagen1;
        System.out.println(wagen1);
        System.out.println(wagen2);
        System.out.println("-----------------------");

        wagen1 = new Kraftwagen("0-4");
        System.out.println(wagen1);
        System.out.println(wagen2);
    }
}
