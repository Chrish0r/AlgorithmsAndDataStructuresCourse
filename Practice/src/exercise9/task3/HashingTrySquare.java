package exercise9.task3;

/**
 * hashfunction -> h(s) = s mod m
 * c1 = 1 and c2 = 3
 *
 * in general: h(s,i) = (h(s) + c1*i + c2*i²) mod m
 * 'i' represents the number of tries to find an available position, with i = 0 meaning 1st try
 * if the actual position is occupied.
 *  Empty fields shall be represented by '0'-values -> thus purposeful zeros are not allowed within test-arrays.
 */

public class HashingTrySquare {
    public static void main(String[] args) {
         int[] a = {10, 22, 31, 4, 15, 28, 17, 88, 59};
        // int[] a = {49, 22, 6, 52, 76, 33, 34, 13, 29, 11, 83};
        int m = 11;
        int n = a.length;
        int[] hashtable = createHashtable(a, m, n);

        print(hashtable);
    }

    private static int[] createHashtable(int[] a, int m, int n) {
        int[] hashtable = new int[m];

        for(int j = 0; j < n; j++) {
            int i = 0; // number of tries
            int index = getIndex(a[j], m, i);

            while(hashtable[index] != 0) { // regarding object[] '!= null'
                i++;
                index = getIndex(a[j], m, i);
            }
            hashtable[index] = a[j];
        }
        return hashtable;
    }

    private static int getIndex(int key, int m, int i) {
        int c1 = 1;
        int c2 = 3;

        int hashVal = key % m;

        return (hashVal + c1 * i + c2 * (i * i)) % m;
    }

    private static void print(int[] hashtable) {
        for(int i = 0; i < hashtable.length; i++) {
            if(i == hashtable.length - 1) {
                System.out.println(hashtable[i]);
            } else {
                System.out.print(hashtable[i] + ", ");
            }
        }
    }
}
