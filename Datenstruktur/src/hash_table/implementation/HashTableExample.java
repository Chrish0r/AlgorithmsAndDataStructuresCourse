package hash_table.implementation;

import com.sun.security.jgss.GSSUtil;

import java.util.ArrayList;

/**
 *  This class is responsible of implementing a hash table.
 *  A hash table (key, value) is similar to an array (index, value) regarding storing elements.
 *  The keys are unique.
 */
public class HashTableExample <K, V> {
    private ArrayList<HashNode<K, V>> bucketArrayList;
    private int numBucket; // total size of  array i.e. table
    private int size; // current number of elements/buckets i.e. current size of table/array

    public HashTableExample() {
        bucketArrayList= new ArrayList<>();
        numBucket = 10;
        size = 0;

        for (int i = 0; i < numBucket; i++) {
            bucketArrayList.add(null);
        }
    }

    public static void main(String[] args) {
      //  HashTableExample hashTable1 = new HashTableExample();
      //  hashTable1.size();
    }

    // logic
    private int getBucketIndex(K key) {
        return key.hashCode() % numBucket;

        /*
        int hashcode = key.hashCode();
        int index = hashcode % numBucket;

        return index;
         */
    }

    // adding new object/element
    public void add(K key, V value) {
        // set up index
        int bucketIndex = getBucketIndex(key);

        HashNode<K, V> head = bucketArrayList.get(bucketIndex);
        // search for key
        while (head != null) {
            // for instance if a person with a certain id (key) wanna overwirte/edit his/her name
            if (head.getKey().equals(key)) {
                head.setValue(value);
                return;
            } else {
                head = head.getNext();
            }
            // add new element if not already existing in the table at the given position
            size++;
            head = bucketArrayList.get(bucketIndex); // go back to first element at this index, if needed
            HashNode<K, V> newHashNode = new HashNode<>(key, value);
            newHashNode.setNext(head);
            bucketArrayList.set(bucketIndex, newHashNode);
        }
    }

    // search for value through key
    public V get(K key) {
        int bucketIndex = getBucketIndex(key);
        HashNode<K, V> head = bucketArrayList.get(bucketIndex);

        while(head != null) {
            if(head.getKey().equals(key)) {
                return head.getValue();
            }
            head = head.getNext();
        }
        System.out.println("ERROR: search item not found!");
        return null;
    }

    // delete object
   public V remove(K key) {
        int bucketIndex = getBucketIndex(key);

        HashNode<K, V> head = bucketArrayList.get(bucketIndex);
        HashNode<K, V> prev = null;

        while(head != null) {
            if(head.getKey().equals(key)) {
                break;
            } else {
                // wir gehen mit beiden Nodes/Elementen eff. einen Schritt weiter
                prev = head;
                head = head.getNext();
            }
        }
        if(head == null) {
            return null;
        }
        size--;

        if(prev != null) {
            prev.setNext((head.getNext()));
        } else {
            bucketArrayList.set(bucketIndex, head.getNext());
        }

        return head.getValue();


        /*
        while(head != null) {
            if(head.getKey().equals(key)) {
                size--;
                 if(prev != null) {
                     prev.setNext((head.getNext()));
                  } else {
                        bucketArrayList.set(bucketIndex, head.getNext());
                  }
                return head.getValue();
            }
            prev = head;
            head = head.getNext();
        }
        return null;

         */
   }

    // helper methods
    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size() == 0;
    }
}
