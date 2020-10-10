package bubbleSort.spieler.sortieren;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Spieler> list = new ArrayList<Spieler>();

        list.add(new Spieler("Chris Gadek", 175));
        list.add(new Spieler("Martin Gadek", 182));
        list.add(new Spieler("Ava Gadek", 158));
        list.add(new Spieler("Julia Gadek", 162));
        list.add(new Spieler("Krysztof Gadek", 173));

        System.out.println("Unsortiert:");
        for (Spieler spieler : list) {
            System.out.println(spieler);
        }

        List<Spieler> sortedList = new Main().sortList(list);
        System.out.println(System.lineSeparator() + "Sortiert: ");
        for (Spieler spieler : sortedList) {
            System.out.println(spieler);
        }
    }

    private List<Spieler> sortList(List<Spieler> list) {
        Spieler tempSpieler;

        for (int i = 0; i < list.size() - 1 ; i++) {
            for(int j = 0; j < list.size() - 1 - i; j++) {
                if(list.get(j).compareTo(list.get(j + 1)) > 0) {
                    tempSpieler = list.get(j);
                    list.set(j, list.get(j + 1));
                    list.set(j + 1, tempSpieler);
                }
            }
        }
        return list;
    }
}

