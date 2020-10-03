package binaryTree;

public class Node {
    private int value;

    private Node leftNode;
    private Node rightNode;

    public Node(int value) {
        this.value = value;
        leftNode = null;
        rightNode = null;
       // leftNode = rightNode = null;
    }

    //---------------logic/methods--------------------------------------------------------
        // specific binary tree methods




    //--------------getters and setters-----------------------------------

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Node getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(Node leftNode) {
        this.leftNode = leftNode;
    }

    public Node getRightNode() {
        return rightNode;
    }

    public void setRightNode(Node rightNode) {
        this.rightNode = rightNode;
    }
}
