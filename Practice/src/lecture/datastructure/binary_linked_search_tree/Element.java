package lecture.datastructure.binary_linked_search_tree;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Element {
    int value;

    // references
    Element left;
    Element right;
}

class SearchTree {
    // List<Integer> field = new ArrayList<>();
    private Element root;

    public SearchTree() {
        root = null; // abstract <-> no need in Java since default-initializing with null
    };

    public static void main(String[] args) {
        SearchTree searchTree = new SearchTree();

        searchTree.insert(6);
        searchTree.insert(3);
        searchTree.insert(1);
        searchTree.insert(8);
        searchTree.insert(7);
        searchTree.insert(9);

        searchTree.print();

      //  searchTree.printField();

        searchTree.deleteValue(9);
        searchTree.print();

    }

    //----------------------logic-------------------------------------------
    private void insert(Element currentRoot, Element element) {
        if(element.value <= currentRoot.value) {
            if(currentRoot.left == null) {
                currentRoot.left = element;
            } else {
                insert(currentRoot.left, element);
            }
        } else {
            if(currentRoot.right == null) {
                currentRoot.right = element;
            } else {
                insert(currentRoot.right, element);
            }
        }
    }

    private void deleteTree(Element root) {

    }
    // inorder: linke Seite - current Wurzel - rechte Seite -> Ausgabe: aufsteigend sortierte Reihenfolge
    private void print(Element root) {
        if(root != null) {
            System.out.print("(");
            print(root.left);
            System.out.print("," + root.value + ",");
    //        field.add(root.value);
            print(root.right);
            System.out.print(")");
        } else {
            System.out.print("n"); // 'n' for none
        }
    }

    //------------------public logic------------------------
    public boolean contains(int o) {
        Element current = root;

        while(current != null) {
            if(current.value == o) {
                return true;
            } else {
                if(o <= current.value) {
                    current = current.left;
                } else {
                    current = current.right;
                }
            }
        }
        return false;
    }

    // creating new node
    public void insert(int o) {
        Element element = new Element();
        element.value = o;
        element.right = null;
        element.left = null;

        if(root == null) {
            root = element;
        } else {
            insert(root, element);
        }
    }

    public void print() {
        print(root);
        System.out.println();
    }

    /*
    public void printField() {
        for(int i = 0; i < field.size(); i++) {
            System.out.print(field.get(i) + "  ");
        }
    }

     */


    // delete node
    public void deleteValue(int o) {
       if(root == null) {
           System.out.println("ERROR: tree is empty...");
       } else {
           root = deleteValueRec(root, o);
       }
    }
    public Element deleteValueRec(Element current, int o) {
        // base case: if tree is empty
        if(current == null) {
            return  null;
        }
        if(current.value == o) {
            // 1st case: node has no children
            if((current.left == null && current.right == null)) {
                return null;
            }
            // 2nd case: node has only one child
            if(current.right == null) {
                return current.left;
            }
            if(current.left == null) {
                return current.right;
            }

            // 3rd case: node has two children
               // find smallest value in the right subtree
            int smallestValue = findSmallestValue(current.right);
            current.value = smallestValue;

            // Delete the inorder successor
            current.right = deleteValueRec(current.right, smallestValue);
            return current;
        }

        if(o < current.value) {
            deleteValueRec(current.left, o); // continue the search on the left hand
            return current;

        } else {
            deleteValueRec(current.right, o); // continue the search on the right hand
            return current;
        }
    }

    private int findSmallestValue(Element current) {
        if(current.left == null) {
            return current.value;
        } else {
            return findSmallestValue(current.left); // continue searching further left
        }
    }
}
