package exercise5.task4;

public class SumComposited {
    public static void main(String[] args) {
        int[] array = {-5, 13, -32, 7, -3, 17, 23, 12, -35, 19};
       // int otherArray[]=array.clone();
        int s = 26; // 7 + 17

        mergeSort(array, 0, array.length-1);

        /*
        for(int i = 0; i < array.length; i++) {
            if(i == array.length - 1) {
                System.out.println(array[i]);
                break;
            }
            System.out.print(array[i] + ", ");
        }
        */

        System.out.println("Can the sum " + s + " be built out of two numbers of the field?");
        System.out.println(sumIsCompositedSlow(array, array.length, s));
        System.out.println("-----------------------------------------------");

        System.out.println("Can the sum " + s + " be built out of any two numbers of the field?");
        sumIsComposited(array, 0, array.length-1, s);
    }
     // Here the unning time complexity is n log n
    private static boolean sumIsComposited(int[] a, int first, int last, int s) {
        while(first != last) {
            if((a[first] + a[last]) == s) {
                System.out.println("Yes, the sum can be built out of following two numbers within the field:");
                System.out.println(a[first] + " + " + a[last] + " = " + s);
                return true;
            }
            if((a[first] + a[last]) < s) {
                first++;
            } else {
                last--;
            }
        }
        System.out.println("ERROR: sum cannot be built out of two numbers within the field...");
        return false;
    }

    private static boolean sumIsComposited3(int[] a, int first, int n, int s) {
        int i, j = first + 1;

        for(i = first ; i < n -1; j++) {
            if((a[i] + a[j]) == s) {
                System.out.println("Yes, the sum can be built out of following two numbers within the field:");
                System.out.println(a[i] + " + " + a[j] + " = " + s);
                return true;
            }
            if((a[i] + a[j]) > s) {
                return sumIsComposited(a, i+1, n, s);
            }
        }
        return false;
    }

    private static boolean sumIsComposited2(int[] a, int n, int s) {
        int i = 0, j = 0;
        while (i < n) {
            j = i;

            j++;
            if(s == (a[i] + a[j])) {
          // System.out.println(a[i] + " + " + a[j]);
                return true;
            }
        }
        return false;
    }

    /**
     * Hier ist die laufzeit bzw. die Komplexität O(n^2), weil
     * zwei Schleifen im worst case jeweils n-mal (also insgesamt n * n Durchläufe)
     * durchlaufen werden.
     * Somit exisitieren auch unnötige Redundanzen - z.B.
     * wird die Summe aus a[1] und a[3] zweimal berechnet:
     *   Einmal wenn i = 1 und j = 3 und das andere mal,
     *          wenn i = 3 und j = 1.
     * Ziel ist aber eine Laufzeit von Theta(n log n) -> siehe zweiter Algorithmus.
     */
    private static boolean sumIsCompositedSlow(int[] a, int n, int s) {
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(i == j) {
                    continue;
                }
                if((a[i] + a[j]) == s) {
               //     System.out.println(a[i] + " + " + a[j]);
                    return true;
                }
            }
        }
        return false;
    }

    // sorting array as preparation to improve running time to Theta (n log n)
    private static void mergeSort(int[] arr, int first, int last) {
        if (first <  last) {
            int m = (first + last + 1) / 2; // halbieren, teilen UND Mitte aufrunden
            mergeSort(arr, first, m-1);
            mergeSort(arr, m, last);

            merge(arr, first, last, m);
        }
    }

    private static void merge(int[] arr, int first, int last, int m) {
        int n = last - first + 1;
        int arr1First = first, arr1Last = m-1;
        int arr2First = m, arr2Last = last;

        int[] arrNew = new int[n];

        for(int i = 0; i < n; i++) {
            if(arr1First <= arr1Last ) {
                if(arr2First <= arr2Last) {
                    if(arr[arr1First] <= arr[arr2First]) {
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
}
