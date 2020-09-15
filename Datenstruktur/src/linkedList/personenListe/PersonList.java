package linkedList.personenListe;

public class PersonList {

    // Head -> Anfangselement einer Liste
    private Person firstPerson;

    public PersonList(Person firstPerson) {
        this.firstPerson = firstPerson;
    }

    public static void main(String[] args) {
        Person person1 = new Person("Admin", "Franky");
        Person person2 = new Person("User", "Laura");

      //  System.out.println(person1);
      //  System.out.println(person2);

        PersonList pList = new PersonList(person1);

        // Elemente hinzufügen
        // Elemente (Personen) hinzufügen
        System.out.println("Liste erweitern... \n");
        pList.addPerson(new Person("Student", "user123")); // Position 2
        pList.addPerson(new Person("Student", "user234")); // Position 3
        pList.addPerson(new Person("Worker", "Peter")); // Position 4
        pList.addPerson(new Person("Worker", "Heiko")); // Position 5
        pList.addPerson(new Person("Trainee", "Christoph")); // Position 6
        pList.addPerson(new Person("Trainee", "Laura")); // Position 7

        // print out last person
        Person lauraPerson = pList.getLastPerson();
        System.out.println(lauraPerson);

        // search for username
        System.out.println(System.lineSeparator() + "Suche Ergebnis: " + System.lineSeparator());

        if(pList.search("Heiko")) {
            System.out.println("   -> Gefunden");
        } else {
            System.out.println("   -> Kein Eintrag gefunden");
        }
    }

    /**
     * Implementierung typischer Funktionalitäten einer verketteten Liste:
     * -> Hinzufügen, Löschen, Suchen;
     */

    // add
       // get last element of a list
    public Person getLastPerson() {
        Person currentPerson = firstPerson; // Head
        while(currentPerson.getNextPerson() != null) {
            currentPerson = currentPerson.getNextPerson();
        }
        return currentPerson;
    }
       // add a new element at the end of the list
    public void addPerson(Person newPerson) {
        Person lastPerson = getLastPerson();
        lastPerson.setNextPerson(newPerson);
    }

    // search

    public boolean search(String username) {
        int pos = 1;
        Person currentPerson = firstPerson;
        while(currentPerson != null) {
            if(currentPerson.getUsername().equalsIgnoreCase(username)) {
                System.out.println(username + " gefunden an der Position: " + pos);
                return true;
            }
            currentPerson = currentPerson.getNextPerson();
            pos++;
        }
        System.out.println(username + " nicht gefunden!");
        return false;
    }
}
