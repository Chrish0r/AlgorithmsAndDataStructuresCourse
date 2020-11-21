package linkedList;

import java.util.LinkedList;

public class LinkedListExample {

    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<String>();

        // Hinzufügen
        list.add("Peter Müller");
        list.add("Laura");
        list.add("Ralf");

        list.addFirst("Chris"); // head
        list.addLast("Andreas"); // tail 

        for(String person : list) {
            System.out.println(person);
        }
        System.out.println();
        // Suchen

        if(list.contains("Laura")) {
            System.out.println("Gefunden!" + System.lineSeparator());
        } else {
            System.out.println("Nicht gefunden!" + System.lineSeparator());
        }

        // Löschen
        list.remove("Laura");
        for(String person : list) {
            System.out.println(person);
        }

    }
}
