package exercise7.task2;

/**
 * Building a search tree with a given preorder-number sequence
 */

public class Element {
    int value;

    // references
   Element left;
   Element right;
}


class SearchTreeWithPreorder {
    Element root;

    public SearchTreeWithPreorder() { // abstract <-> no need in Java since default-initializing with null
        root = null;
    }


    public static void main(String[] args) {
        int[] arrayPre = {6, 3, 1, 8, 7, 9};

        SearchTreeWithPreorder  tree = new SearchTreeWithPreorder();

        tree.buildSearchTreeWithPreorder(arrayPre);

        System.out.println("current tree via preorder representation:");
        tree.print();
    }

    public void buildSearchTreeWithPreorder(int arr[]){
        root = insertPre(arr, 0, arr.length - 1);
    }

    private Element insertPre(int[] arr,int start,int end) {

        if(start > end)
            return null;

        Element current = new Element();
        current.value = arr[start];
        int i;

        for (i = start; i <= end; i++) {
            if (arr[i] > current.value) {
                break;
            }
        }

        current.left = insertPre(arr, start+1, i-1);
        current.right = insertPre(arr, i, end);

        return current;
    }
    /* preorder: at first root -> then whole left side -> finally whole right side
       -> the search property will make it clear where the individual consecutive value-nodes
           of each side will be placed.
     */
    private void print(Element root) {
        if(root != null) {
            System.out.print("(" + root.value + ",");
            print(root.left);
            System.out.print(",");
            print(root.right);
            System.out.print(")");
        } else {
            System.out.print("n"); // 'n' for none
        }
    }

    public void print() {
        print(root);
        System.out.println();
    }

}
