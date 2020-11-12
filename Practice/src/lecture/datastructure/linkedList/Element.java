package lecture.datastructure.linkedList;

public class Element {
    public int value;

    // Zeiger bzw. Referenz auf das nächste Element
    public Element next;
}

class List {
    private Element head;  // first element in list
    private Element tail; // last element in list

    public List() { // hust for abstract illustration because in java not needed, since default value for objects is already null
        this.head = null;
        this.tail = null;
    }

    public static void main(String[] args) {
       List myList = new List();
       // appending, adding new elements
       myList.append(7);
        myList.append(17);
        myList.append(34);

       // printing list
       myList.print();

       // delete element
        myList.deleteValue(7);
        myList.print();

        System.out.println("------------------------");
        myList.append(7);
        myList.print();

        // search element
        if(myList.search(34)) {
            System.out.println("The element was found!");
        } else {
            System.out.println("ERROR: element not found...");
        }
    }

    private boolean search(int o) {
        Element current = head;

        while(current != null) {
            if (current.value == o) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    //---------------------------logic-----------------------------------
    public void append(int o) {
        Element element = new Element();
        element.value = o;
        element.next = null;

        if(tail == null) { // bedeutet, dass Liste noch leer ist, weil ein einziges Element immer gleichzeitig head und tail ist.
            head = element;
            tail = element;
        } else {
            tail.next = element; // nun hat prev. tail Zeiger auf neues Element
            tail = element;
        }
    }

    private void deleteValue(int o) {
        Element current = head;
        Element prev = null;

        while(current != null) {
            if(current.value == o) {
                if(prev == null) {
                    head = current.next;
                } else {
                    prev.next = current.next;
                }

                if (current == tail) {
                    tail = prev;
                }

                Element h = current;
                current = current.next;
                h = null;
            } else {
                prev = current;
                current = current.next;
            }
        }
    }

    public void print() {
        Element current = head;
        while(current != null) {
            System.out.print(current.value + "  ");

            current = current.next;
        }
        System.out.println();
    }
}
