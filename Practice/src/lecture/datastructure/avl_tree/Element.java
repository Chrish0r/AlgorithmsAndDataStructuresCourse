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
        Element b = a.right;

        a.right = b.left;
        b.left = a;

        a = b;

        updateHeight(a.left);
        updateHeight(a);

        return a;
    }

    private Element rotateRight(Element a) {
        Element b = a.left;

        a.left = b.right;
        b.right = a;
        a = b;

        updateHeight(a.right);
        updateHeight(a);

        return a;
    }

    private Element doubleRotationLeft(Element a) {
        rotateRight(a.right);
        rotateLeft(a);

        return a;
    }

    private Element doubleRotationRight(Element a) {
        rotateLeft(a.left);
        rotateRight(a);

        return a;
    }



    private void print(Element root) { // in order: left - rootOutput - right
        if(root != null) {
            System.out.print("(");
            print(root.left);
            System.out.print("," + root.value + ",");
            print(root.right);
            System.out.println(")");
        } else {
            System.out.print("n");
        }
    }

    //------------------ public logic----------------------------------------------
    public void print() {
        print(root);
        System.out.println();
    }



}
