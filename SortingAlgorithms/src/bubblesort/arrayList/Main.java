package bubblesort.arrayList;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Person> list = new ArrayList<Person>();

        list.add(new Person("Peter", "Alex", 45, 456787654, 87654));

        list.add(new Person("Laura", "Blex", 44, 4645645, 6543));

        list.add(new Person("Lisa", "Vlex", 13, 87654, 4567));

        list.add(new Person("Lukas", "Clex", 39, 012345, 234));

        list.add(new Person("Xena", "Flex", 12, 12345, 98765));

        list.add(new Person("Asterix", "Hlex", 89, 408765, 2345));

        list.add(new Person("Bernd", "Tlex", 90, 345676, 98765));

        list.add(new Person("Olaf", "Slex", 100, 7654345, 234556));

        list.add(new Person("Franki", "Qlex", 2, 4567654, 48257));

        List<Person> sortedList = new Main().sortList(list);

        for (Person person: sortedList) {
            System.out.println(person);
        }
    }

    public List<Person> sortList(List<Person> list) {
        Person tempPerson;

        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = 0; j < list.size() - 1 - i; j++) {
                if(list.get(j).compareTo(list.get(j+1)) > 0) {
                    tempPerson = list.get(j);
                    list.set(j, list.get(j+1));
                    list.set(j + 1, tempPerson);
                }
            }
        }
        return list;
    }
}
