package aufgaben;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Gegner {
    private int id;

    public Gegner(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Gegner " + id;
    }

    public static void main(String[] args) {
        List<Gegner> gegnerListe = new ArrayList<Gegner>();
        int numberOfOpponents = 100;

        addGegner(numberOfOpponents, gegnerListe);
        Collections.reverse(gegnerListe);

        System.out.println("Liste aller Gegner:");
        for(Gegner gegner :gegnerListe) {
            System.out.println(gegner);
        }
    }

    private static void addGegner(int n, List<Gegner> list) {
        if(n > 0) {
            list.add(new Gegner(n));
            addGegner(n - 1, list);
        }
    }
}
