package exercise6.task2;

/**
 * Die Laufzeit bzgl. einer Implementierung von Quicksort mittels einer verketteten Liste ist die
 * gleiche wie mittels einem Feld (also Theta(n log n) für best case und average case, aber
 *                              Theta(n²) für worst case -> ALG ist nicht laufzeitstabil),
 * weil das zugrundeliegende Konzept das selbe ist, und zwar "Teilen und Herrschen".
 * -> es werden die selben Operationen eingestzt.
 *
 * Der Speicherplatz unterscheidet sich nur im Platzbedarf der Listen-elemente bzgl. der zusätzlichen Referenz,
 * welche für eine Integer-Referenz für den Zeiger auf das nächste Element 4 Bytes benötigt (auf einer 32 Bit Rechnerarchitektur).
 * Dies ist jedoch im O-Kalkül nicht relevant, da n dominiert -> S(n) = Theta(n)
 */

public class Element {
    int value;

    Element next;
}

class LinkedList {
    public Element head;
    public Element tail;

    public LinkedList() {
        head = null;
        tail = null;
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        int[] array = {34, 45, 12, 34, 23, 18, 38, 17, 43, 51};

        for(int i = 0; i < array.length; i++) {
           list.append(array[i]);
        }

        System.out.println("unsorted list");
        list.print();
        System.out.println("---------------------------" + System.lineSeparator()
                            + " Sorted List:");
        list.quickSort(list.head, list.tail);
        list.print();
    }

    // sorting linked list
    public void quickSort(Element head, Element tail) {
        // list has only one element, i.e. list is sorted
        if(head == tail)
            return;


        Element pivot_prev = paritionLast(head, tail);
        quickSort(head, pivot_prev);

        // if pivot is picked and moved to the start,
        // that means start and pivot is same
        // so pick from next of pivot
        if( pivot_prev != null && pivot_prev == head) {
            quickSort(pivot_prev.next, tail);
        }
            // if pivot is in between of the list,
            // start from next of pivot,
            // since we have pivot_prev, so we move two nodes
        else if(pivot_prev != null && pivot_prev.next != null) {
            quickSort(pivot_prev.next.next, tail);
        }
    }

    private Element paritionLast(Element head, Element tail) {
        if(head == tail || head == null || tail == null)
            return head;

        Element pivot_prev = head;
        Element current = head;
        int pivot = tail.value;

        // iterate til one before the end,
        // no need to iterate til the end
        // because end is pivot
        while(head != tail) {
            if(head.value < pivot) {
                // keep tracks of last modified item
                pivot_prev = current;

                int temp = current.value;
                current.value = head.value;
                head.value = temp;

                current = current.next;
            }
            head = head.next;
        }

        // swap the position of curr i.e.
        int temp = current.value;
        current.value = pivot;
        tail.value = temp;

        // return one previous to current
        // because current is now pointing to pivot
        return pivot_prev;
    }


    //-------------------------------linked list -> logic-------------------------
    public void append(int o) {
        Element element = new Element();
        element.value = o;
        element.next = null;
        if(tail == null) { // list still empty
            head = element;
            tail = element;
        } else {
            tail.next = element;
            tail = element;
        }
    }
    public void deleteValue(int o) {
        Element current = head;
        Element prev = null;

        while(current != null) {
            if(current.value == o) {
                if(prev == null) { // means that current == head
                    head = current.next;
                } else {
                    prev.next = current.next;
                }

                if(current == tail) {
                    tail = prev;
                }

                Element temp = current;
                current = current.next;
                temp = null;
                // no 'break' since in the list, there might be more than only one element with the same value to be deleted
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
