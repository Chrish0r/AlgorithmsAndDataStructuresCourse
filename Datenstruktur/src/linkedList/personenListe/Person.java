package linkedList.personenListe;

public class Person {
    private String userType;
    private String username;

    // Referenz (Adresse) auf/von nachfolgendes/nachfolgendem Element
    private Person nextPerson;

    public Person(String userType, String username) {
        this.userType = userType;
        this.username = username;
    }

    public String getUserType() {
        return userType;
    }

    public String getUsername() {
        return username;
    }

    public Person getNextPerson() {
        return nextPerson;
    }

    public void setNextPerson(Person nextPerson) {
        this.nextPerson = nextPerson;
    }

    /**
     *
     * @return   a String representation of instances of the class 'Person'
     */
    @Override
    public String toString() {
        return userType + ": " + username;
    }
}
