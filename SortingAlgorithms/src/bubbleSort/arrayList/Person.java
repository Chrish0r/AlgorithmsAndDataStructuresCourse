package bubbleSort.arrayList;

/**
 * Bem.: Comparable<T> IF dann implementieren, wenn man Objekte bzgl.
 * bestimmten Attributen vergleichen will und nur dann compareTo überschreiben.
 * Wenn man dann bzgl. diesen Attributen integers vergleiche will,
 *  dann 'return Subtraktion' oder if/else (-1, 0, 1) ,
 *  sonst bei z.B. String-Attributen einfach nur
 *  'this.name.compareTo(obj.name)'...
 *
 *  Bei Vergleichen mit Strings (keine Attr. von Objekten) braucht man compareTo
 *  nicht überschreiben und nicht das Comparable<T> Interface implementieren.
 *  Bei z.B. Int-Vergleich (wenn nicht Attr. von Objekten) braucht man gar kein
 *  compareTo.
 *
 *  compareTo nur bei Strings oder Attributen von Objekten.
 */

public class Person implements Comparable<Person> {
    String vorname;
    String nachname;
    int alter;
    int telNr;
    long plz;

    public Person(String vorname, String nachname, int alter, int telNr, long plz) {
        this.vorname = vorname;
        this.nachname = nachname;
        this.alter = alter;
        this.telNr = telNr;
        this.plz = plz;
    }

    public String getVorname() {
        return vorname;
    }

    public String getNachname() {
        return nachname;
    }

    public int getAlter() {
        return alter;
    }

    public int getTelNr() {
        return telNr;
    }

    public long getPlz() {
        return plz;
    }

    @Override
    public String toString() {
        return vorname + " " +
                nachname + ", " +
                "Alter: " + alter + ", " +
                "TelNr: " + telNr +
                ", PLZ: " + plz;
    }

    @Override
    public int compareTo(Person person) {
        return this.vorname.compareToIgnoreCase(person.vorname);
    }
}
