package arrayList;

import java.util.ArrayList;

public class ArrayListExample {

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<Integer>();

        list.add(30); // index: 0
        list.add(40); // index: 1
        list.add(60); // index: 2
        list.add(80); // index: 3
        list.add(100); // index: 4

        System.out.println(list.get(0));
    }
}
