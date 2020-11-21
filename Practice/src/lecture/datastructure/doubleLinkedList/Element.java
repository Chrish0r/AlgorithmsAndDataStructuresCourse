package lecture.datastructure.doubleLinkedList;

public class Element {
    public int value;

    // Zeiger bzw. Referenz auf das vorherige und auf das nächste Element
    public Element prev;
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
        element.prev = null;
        element.next = null;

        if(tail == null) { // bedeutet, dass Liste noch leer ist, weil ein einziges Element immer gleichzeitig head und tail ist.
            head = element;
            tail = element;
        } else {
            Element temp = tail;
            tail.next = element; // nun hat vorheriger tail einen Zeiger auf neues Element
            tail = element;
            tail.prev = temp;
        }
    }

    private void deleteValue(int o) {
        Element current = head;

        while(current != null) {
            if(current.value == o) {
                if(current.prev == null) {
                    head = current.next;
                } else {
                    current.prev.next = current.next;
                }

                if (current == tail) {
                    tail = current.prev;
                }
                Element h = current;
                current = current.next;
                h = null;
            } else {
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
