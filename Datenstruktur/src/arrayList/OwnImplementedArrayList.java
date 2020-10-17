package arrayList;

import java.util.Arrays;

/**
 * This class will implement itself an ArrayList.
 * Thus it will be illustrated how ArrayLists work in Java, "behind the scene".
 *
 * @author      Przemyslaw Gadek
 */

public class OwnImplementedArrayList<E> { // E is a placeholder for any element/type.
    private int size = 0;
    private static final int DEFAULT_CAPACITY = 10; // Default starting size of 1st array regarding an arrayList4
    private Object[] elements;

    public OwnImplementedArrayList() {
        elements = new Object[DEFAULT_CAPACITY];
    }

    public static void main(String[] args) {
        OwnImplementedArrayList arrayList = new OwnImplementedArrayList();
        OwnImplementedArrayList arrayList2 = new OwnImplementedArrayList();


        arrayList2.add("Person 1");
        arrayList2.add("Person 2"); // element to remove
        arrayList2.add("Person 3");
        arrayList2.add("Person 4");

        System.out.println(Arrays.toString(arrayList2.elements));
        arrayList2.remove(1);
        System.out.println(Arrays.toString(arrayList2.elements));
        System.out.println(arrayList2.get(1));


     //   arrayList2.removeElement(1);
      //  System.out.println(Arrays.toString(arrayList2.elements));
     //   System.out.println(arrayList2.elements[1]);
/*
        arrayList.add("Person 1");
        arrayList.add("Person 2");
        arrayList.add("Person 3");
        arrayList.add("Person 4");
        arrayList.add("Person 5");
        arrayList.add("Person 6");
        arrayList.add("Person 7");
        arrayList.add("Person 8");
        arrayList.add("Person 9");
        arrayList.add("Person 10");
        arrayList.add("Person 11");
        arrayList.add("Person 12");

 */



        for (int i = 0; i < 12; i++) {
            arrayList.add("Person " + (i + 1));
        }

        System.out.println(System.lineSeparator() + arrayList.get(0));
        System.out.println(arrayList.get(11));

        arrayList.remove(2);
        arrayList.remove(arrayList.size - 1);
        arrayList.remove(arrayList.size - 1);
        System.out.println(System.lineSeparator() + Arrays.toString(arrayList.elements));

        arrayList.add("Person 11");
        arrayList.add("Person 12");
        System.out.println(System.lineSeparator() + Arrays.toString(arrayList.elements));

        arrayList.add("Person 13");
        arrayList.add("Person 14");
        arrayList.add("Person 15");
        arrayList.add("Person 16");
        arrayList.add("Person 17");
        arrayList.add("Person 18");
        arrayList.add("Person 19");
        System.out.println(System.lineSeparator() + Arrays.toString(arrayList.elements));

        arrayList.remove(1);
        System.out.println(System.lineSeparator() + Arrays.toString(arrayList.elements));

        arrayList.removeElement(4);
        System.out.println(System.lineSeparator() + Arrays.toString(arrayList.elements));
    }

    public void add(E element) {
        if(size == elements.length) {
            ensureCapacity();
        }
        elements[size++] = element;
        /* elements[size] = element;
           size++;
         */
    }

    private void ensureCapacity() {
        // int newSize = elements.length * 2;
        elements = Arrays.copyOf(elements, size * 2);
    }

    public E get(int index) {
        if(index >= size || index < 0) {
            throw new IndexOutOfBoundsException("Index " + index + " is out of bound.");
        }
        return (E) elements[index];
    }

    public void remove (int index) {
        if(index >= size || index < 0) {
            throw new IndexOutOfBoundsException("Index " + index + " is out of bound.");
        }
        Object[] updatedElements = new Object[elements.length - 1];
        for(int i = 0, k = 0; i < elements.length; i++) {
            if(i == index) {
                continue;
            }
            updatedElements[k++] = elements[i];
        }
        elements = updatedElements;
        size--;
    }

    public E removeElement(int index) {
        E removeItem = (E) elements[index];

        // Index verschieben
        for(int i = index; i < size; i++) {
            elements[index] = elements[i + 1];
        }
        size--;
        return removeItem;
    }
}
