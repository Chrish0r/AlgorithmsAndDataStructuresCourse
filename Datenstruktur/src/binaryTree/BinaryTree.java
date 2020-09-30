package binaryTree;

public class BinaryTree {
    private Node rootNode;

    //---------------------------------logic / methods-------------------------
         // adding first node
    public void add(int value) {
        rootNode = addRecursively(rootNode, value);
    }
        // adding nodes
    public Node addRecursively(Node current, int value) {
        if(current == null) {
            return new Node(value);
        }

        if(value < current.getValue()) {
            current.setLeftNode(addRecursively(current.getLeftNode(), value));
        }
        else if(value > current.getValue()) {
            current.setRightNode(addRecursively(current.getRightNode(), value));
        }
        System.out.println("ERROR: this node has been already added...");
        return current;
    }
}
