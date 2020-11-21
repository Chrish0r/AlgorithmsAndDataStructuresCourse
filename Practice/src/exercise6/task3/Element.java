package exercise6.task3;

import java.util.Random;

public class Element {
    int value;
    // reference
    Element next;
}

class LinkedList {
    Element head;
    Element tail;

    public LinkedList() {
        head = null;
        tail = null;
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        int[] array = new int[49];

        for(int i = 0; i < array.length; i++) {
            array[i] = i+1;
        }

        for(int i = 0; i < array.length; i++) {
            list.append(array[i]);
        }

        list.getLotteryNumbers();
    }

    public void getLotteryNumbers() {
        Random ran = new Random();
        Element current = head;
        int maxPos = 49;

        for(int i = 0; i < 6; i++) {
            int temp = ran.nextInt(maxPos) + 1; // range now: 1 - 49 - first number

            findLotteryNumber(temp);

            maxPos--;
        }
    }

    public void findLotteryNumber(int pos) {
        Element current = head;
        int currentPos = 1;

        while(currentPos != pos) {
            current = current.next;
            currentPos++;
        }
        System.out.print(current.value + "  ");
        deleteValue(current.value);
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
            // new tail shall point to head
            tail.next = head;
        }
    }
    public void deleteValue(int o) {
        Element current = head;
         Element prev = null;

        while(current.next != head) {
            if(current.value == o) {
                if(prev == null) { // means that current == head
                    head = current.next;
                } else {
                    prev.next = current.next;
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
        // erstes Element außerhalb der while-Schleife ist dail tail.
        if(current.value == o) {
            if(current == tail) {
                tail = prev;
                prev.next = current.next;
            }
        }
    }

    public void print() {
        Element current = head;
        while(current.next != head) {
            System.out.print(current.value + ", ");

            current = current.next;
        }
        // gebe noch den tail-Wert aus
         System.out.println(current.value + System.lineSeparator());
    }
}


