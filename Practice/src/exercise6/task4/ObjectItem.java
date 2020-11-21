package exercise6.task4;


import java.util.ArrayList;
import java.util.List;

public class ObjectItem implements Comparable<ObjectItem>{
    public static final int MAX_WEIGHT = 150;
    public double value;
    public double weight;

    public double ratio;

    public ObjectItem(int value, int weight) {
        this.value = value;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "ObjectItem{" +
                "value=" + value +
                ", weight=" + weight +
                '}';
    }

    public static void main(String[] args) {
        ObjectItem o1 = new ObjectItem(10, 50);
        ObjectItem o2 = new ObjectItem(15, 41);
        ObjectItem o3 = new ObjectItem(25, 73);
        ObjectItem o4 = new ObjectItem(4, 12);
        ObjectItem o5 = new ObjectItem(16, 8);

        ObjectItem[] items = {o1, o2, o3, o4, o5};
        ArrayList<ObjectItem> backpack = new ArrayList<>();

        for(ObjectItem i : items) {
            System.out.println(i);
        }
        System.out.println("--------------------------------");
       mergeSort(items, 0, items.length - 1);

        for(ObjectItem i : items) {
            System.out.println(i);
        }
        System.out.println(System.lineSeparator() + "Our backpack consists of following items:");
        fillBackpack(items, backpack);
        for (int i = 0; i < backpack.size(); i++) {
            System.out.println(backpack.get(i));
        }
    }
    //------------------------------------------------------------logic-------------------------
    private static void fillBackpack(ObjectItem[] items, ArrayList<ObjectItem> backpack) {
        double totalWeight = 0;

        for(int i = 0; i < items.length; i++) {
            totalWeight = totalWeight + items[i].weight;
            if(totalWeight > MAX_WEIGHT) {
                break;
            }
            backpack.add(items[i]);
        }
    }
    //---------------------------------------------------------sorting logic------------------------

    public static void mergeSort(ObjectItem[] arr, int first, int last) {
        if (first <  last) {
            int m = (first + last + 1) / 2; // halbieren, teilen UND Mitte aufrunden
            mergeSort(arr, first, m-1);
            mergeSort(arr, m, last);

            merge(arr, first, last, m);
        }
    }

    public static void merge(ObjectItem[] arr, int first, int last, int m) {
        int n = last - first + 1;
        int arr1First = first, arr1Last = m-1;
        int arr2First = m, arr2Last = last;

        ObjectItem[] arrNew = new ObjectItem[n];

        for(int i = 0; i < n; i++) {
            if(arr1First <= arr1Last ) {
                if(arr2First <= arr2Last) {
                    if(arr[arr1First].compareTo(arr[arr2First]) >= 0) {
                        arrNew[i] = arr[arr1First++];
                    } else {
                        arrNew[i] = arr[arr2First++];
                    }
                } else {
                    arrNew[i] = arr[arr1First++];
                }
            } else {
                arrNew[i] = arr[arr2First++];
            }
        }
        for(int i = 0; i < n; i++) {
            arr[first + i] = arrNew[i];
        }
        arrNew = null; // Hilfs-Array wird vom garbage collector wieder freigegeben
    }

    // getters
    public double getValue() {
        return value;
    }

    public double getWeight() {
        return weight;
    }

    public double getRatio() {
        return ratio;
    }

    public void setRatio(double ratio) {
        this.ratio = ratio;
    }

    @Override
    public int compareTo(ObjectItem o) {
        this.setRatio(this.value/this.weight);
        o.setRatio(o.value/o.weight);

        if(this.ratio < o.ratio) {
            return -1;
        }
        if(this.ratio > o.ratio) {
            return 1;
        }

        return 0;

       // return this.value - o.value;
    }
}
