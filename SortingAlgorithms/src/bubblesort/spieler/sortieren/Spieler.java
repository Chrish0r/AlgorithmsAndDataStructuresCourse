package bubblesort.spieler.sortieren;

public class Spieler implements Comparable<Spieler> {
    private String name;
    private int groeße;

    public Spieler(String name, int groeße) {
        this.name = name;
        this.groeße = groeße;
    }

    public String getName() {
        return name;
    }

    public int getGroeße() {
        return groeße;
    }

    @Override
    public String toString() {
        return  name + ", Groeße: " + groeße + " cm.";
    }

    @Override
    public int compareTo(Spieler spieler) {
        return this.groeße - spieler.groeße;
    }
}
