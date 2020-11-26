package exercise7.task1;


public class Element {
    int value;

    // references
    Element left, right;
}

class SearchTree {
    Element root;

    public SearchTree() {
       root = null;
    }

    public static void main(String[] args) {
        SearchTree tree = new SearchTree();
       // int[] arr = {5, 2, 3, 1, 4, 8, 7, 9, 10, 6};
        int[] arr = {15, 5, 3, 20, 14, 16, 25, 24, 27, 18};
        for(int i = 0; i < arr.length; i++) {
            tree.insert(arr[i]);
        }
        System.out.println("current tree:");
        tree.print();

        if(tree.contains(3)) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }

        tree.deleteValue(20);
        System.out.println("tree after deleting the value '20'");
        tree.print();
    }


    //----------------------private logic--------------------------------
    private void insert(Element root, Element element) {
        if(element.value < root.value) {
            if(root.left == null) { // Prüfe, ob es nach current noch weitergeht
                root.left = element;
            } else {
                insert(root.left, element);
            }
        } else {
            if(root.right == null) {
                root.right = element;
            } else {
                insert(root.right, element);
            }
        }
    }

    private Element deleteElement(Element current, int value) {
        if(current.value == value) {
            // Fall 1: Kein NF
            if(current.left == null && current.right == null) {
                current = null;
                return current;
            }
            // Fall 2: Nur einen NF (li oder re)
            if(current.left == null) {
                current = current.right;
                return current;
            }
            if(current.right == null) {
                current = current.left;
                return current;
            }
            /* Fall 3: zwei NF (li und re) -> ersetze Knoten mit Inorder-NF, d.h.:
               unmittelbarer nächstgrößerer Wert (inorder-Darstellung entspricht einer aufsteigenden Folge)
                => entspricht kleinstem Wert (NICHT ganzer Knoten mit kleinstem Wert, nur minValue) im rechtem Teilbaum, also:
                  im rechtem Teilbaum so lange nach links, bis es nicht mehr weiter nach links geht

             */
           int smallestValue = findInOrderSuccessorValue(current.right); // current.right ist Wurzel des rechten Teilbaums (hier geht die Suche nach Min los)
            current.value = smallestValue;

            // löscht die inOrder-Node im rechtem Teilbaum von 'current', also wird current.right als Wurzel des Teilbaumes und minWert übergeben (um unten mitsamt seines Knotens gelöscht zu werden) und die deleteElement() aufgerufen
            current.right = deleteElement(current.right, smallestValue);
            return current;

        } else {
            if(value < current.value) {
               current.left = deleteElement(current.left, value);
               return current;
            } else {
                current.right = deleteElement(current.right, value);
                return current;
            }
        }
    }

    private int findInOrderSuccessorValue(Element current) {
        if(current.left == null) {
            return current.value;
        } else {
            return findInOrderSuccessorValue(current.left); // suche links weiter nach Minimum
        }
    }

    private int findInOrderSuccessorValueIterative(Element current) {
        int min = current.value;
        while(current.left != null) {
            min = current.left.value;
            current = current.left;
        }
        return min;
    }

    // inorder representation
    private void print(Element root) {
        if(root != null) {
            System.out.print("(");
            print(root.left);
            System.out.print("," + root.value + ",");
            print(root.right);
            System.out.print(")");
        } else {
            System.out.print("n");
        }
    }
/*
    private void print2(Element root) {
        if(root != null) {
            print2(root.left);
            System.out.print(root.value + "  ");
            print2(root.right);
        }
    }

 */
    //-------------------------public logic-------------------------------
    public void insert(int value) {
        Element element = new Element();
        element.value = value;
        element.left = null;
        element.right = null;

        if(root == null) {
            root = element;
        } else {
            insert(root, element);
        }
    }

    public void deleteValue(int value) {
        deleteElement(root, value);
    }


    public boolean contains(int value) {
        Element current = root;

        while(current != null) {
            if(current.value == value) {
                return true;
            } else {
                if(value < current.value) {
                    current = current.left;
                } else {
                    current = current.right;
                }
            }
        }
        return false;
    }
    // inorder representation: left - root - right (preorder would be: root-left-right / postorder: left-right-root)
    public void print() {
        if(root == null) {
            System.out.println("ERROR: tree is empty");
        } else {
            print(root);
            System.out.println();
          //  print2(root);
        }
    }
}

