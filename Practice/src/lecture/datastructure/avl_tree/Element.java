package lecture.datastructure.avl_tree;


public class Element {
    public int height;
    public int value;

    // references
    Element right;
    Element left;
}

class AVLTree {
    Element root;

    public AVLTree() {
        root = null;
    }

    public static void main(String[] args) {
        AVLTree tree = new AVLTree();

        int[] arr = {5, 6, 9, 12, 13, 3, 8, 10, 11, 16, 15, 14, 4, 2, 1};
        // int[] arr = {6, 11, 2, 17};
        // int[] arr = {5, 6, 9, 12, 13, 3, 8, 10, 11, 16, 15, 14, 4, 2};

        int[] arrDel = {12, 8, 5, 4, 3, 6, 15, 14};
      //  int[] arrDel = {2, 17};


        for(int i = 0; i < arr.length; i++) {
            tree.insert(arr[i]);
        }
       // tree.insert(1);
        System.out.println("current tree:");
        tree.print();

        /* delete values in following order:
               12, 8, 5, 4, 3, 6, 15, 14
         */

        System.out.println("tree after deleting some values:");
        for(int i = 0; i < arrDel.length; i++) {
            tree.delete(arrDel[i]);
        }
     //   tree.delete(6);
        tree.print();



      //  tree.delete(12);
      //  System.out.println("tree after deleting the value '20'");
     //   tree.print();
    }

    //------------------ private logic----------------------------------------------
    private int max(int a, int b) {
        if(a < b)
            return b;
        else
            return  a;
    }

    private int getHeight(Element element) {
        if(element == null)
            return -1;
        else
            return element.height;
    }

    private void updateHeight(Element element) {
        element.height = 1 + max(getHeight(element.left), getHeight(element.right)); // der längste Ast zählt
    }

    private Element rotateLeft(Element a) {
        Element b = a.right; // future root

        a.right = b.left;  // linker Nachfolger von b, wird zum rechtem Nachfolger von a (vorherige root)
        b.left = a;     // a kommt links zu b nach unten

        a = b; // b wird zu neuen root

        updateHeight(a.left);
        updateHeight(a);

        return a;
    }

    private Element rotateRight(Element a) {
        Element b = a.left;

        a.left = b.right; // b.right wird zu a.left
        b.right = a;
        a = b;

        updateHeight(a.right);
        updateHeight(a);

        return a;
    }

    private Element doubleRotationLeft(Element a) {
        a.right = rotateRight(a.right); // erstmal Rotation um die Teilwurzel 'b' des zu hohen Teilbaums
        a = rotateLeft(a);

        return a;
    }

    private Element doubleRotationRight(Element a) {
        a.left = rotateLeft(a.left); // erstmal Rotation um die Teilwurzel 'b' des zu hohen Teilbaums
        a = rotateRight(a);

        return a;
    }

    private Element checkRotationRight(Element element) {
        if(element != null) {
            if(element.left != null) {
                if(getHeight(element.left) - getHeight(element.right) == 2) {
                    if(getHeight(element.left.right) > getHeight(element.left.left)) {
                        element = doubleRotationRight(element); // da innerer Teilbaum zu hcch ist
                    } else {
                        element = rotateRight(element); // äußerer Teilbaum zu hoch -> muss einfach-rotiert werden
                    }
                } else {
                    updateHeight(element);
                }
            } else {
                updateHeight(element);
            }
        }
        return  element;
    }

    private Element checkRotationLeft(Element element) {
        if(element != null) {
            if(element.right != null) {
                if(getHeight(element.right) - getHeight(element.left) == 2) {
                    if(getHeight(element.right.left) > getHeight(element.right.right)) {
                        element = doubleRotationLeft(element); // da innerer Teilbaum zu hoch ist
                    } else {
                        element = rotateLeft(element); // äußerer Teilbaum zu hoch -> muss einfach-rotiert werden
                    }
                } else {
                    updateHeight(element);
                }
            } else {
                updateHeight(element);
            }
        }
        return  element;
    }

    private Element insert(Element element, int value) {
        if(element == null) {
            element = new Element();
            element.height = 0;
            element.value = value;
            element.left = null;
            element.right = null;
            return element;
        } else {
            if(value <= element.value) {
                element.left = insert(element.left, value);
                element = checkRotationRight(element);
            } else {
                element.right = insert(element.right, value);
                element = checkRotationLeft(element);
            }
        }
        return element;
    }

    /**
     * Step 1: find node with value to be deleted
     * Step 2: delete node (3 cases and algo same as in binary linked search tree)
     * step 3: verify/recreate avl-property
     *           -> examine from bottom to top
     *
     * @param element -> current one
     * @param value to be deleted
     * @return
     */
    private Element delete(Element element, int value) {
        if(element.value == value) {
            // Fall 1: kein NF
            if(element.left == null && element.right == null) {
                element = null;
                return element;
            }
            // Fall 2: Nur genau 1 NF
            if(element.left == null) {
                element = element.right; // reicht, weil man ja die Zeiger von dem (nur einem) re NF auch mit übernimmt (alles übernimmt) und dieser zeigt auf Null
                return  element;
            }
            if(element.right == null) {
                element = element.left;
                return element;
            }
            // Fall 3: 2 NF -> find direct inorder-successor-value
            int smallestVal = findMinVal(element.right);
            element.value = smallestVal;
            // delete inOrder-Node from right sub-tree
            element.right = delete(element.right, smallestVal);
            // check avl property after recursive call of delete-functionality around original element - RightRotation since we removed the MinValueNode from the right subtree of the element and hence the left subtree might be too high now.
            element = checkRotationRight(element);

            return element;
                   // search code
        } else {
            if(value < element.value) {
                element.left = delete(element.left, value);
                element = checkRotationLeft(element); // opposed subtree might be now to high and thus must be potentially left-rotated
                return element;
            } else {
                element.right = delete(element.right, value);
                element = checkRotationRight(element);
                return element;
            }
        }
    }

    private int findMinVal(Element current) {
        if(current.left == null) {
            return current.value;
        } else {
            return findMinVal(current.left);
        }
    }

    private void print(Element root) { // in order: left - rootOutput - right
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

    //------------------ public logic----------------------------------------------
    public Element insert(int value) {
        root = insert(root, value);
        return root;
    }

    public Element delete(int value) {
       root = delete(root, value);
       return root;
    }

    public void print() {
        print(root);
        System.out.println();
    }
}
