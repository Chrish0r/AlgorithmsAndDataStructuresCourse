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
        int[] arr = {7,12,15,18,23,27,34};

        for(int i = 0; i < arr.length; i++) {
            tree.insert(arr[i]);
        }
        System.out.println("current tree:");
        tree.print();

      //  tree.deleteValue(20);
        System.out.println("tree after deleting the value '20'");
        tree.print();
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
        element.height = 1 + max(getHeight(element.left), getHeight(element.right));
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
        a = rotateRight(a.right);
        a = rotateLeft(a);

        return a;
    }

    private Element doubleRotationRight(Element a) {
        a = rotateLeft(a.left);
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
                        element = doubleRotationLeft(element); // da innerer Teilbaum zu hcch ist
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

    // ToDo private delete

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

    // ToDo public delete

    public void print() {
        print(root);
        System.out.println();
    }




}
