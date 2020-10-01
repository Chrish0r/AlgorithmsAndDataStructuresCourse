package binaryTree;

public class BinaryTree {
    private Node rootNode;

    public static void main(String[] args) {
        new BinaryTree().add(10);
    }


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
         // current.leftNode = addRecursively(current.leftNode, value); // -> does not work because I have set attributes 'private' within the Node-class
        }
        else if(value > current.getValue()) {
            current.setRightNode(addRecursively(current.getRightNode(), value));
        } else {
            // if node with same value is already existing within the tree
            System.out.println("ERROR: this node has been already added...");
            return current;
        }
       return current;
    }

        // Depth-First -> Variant: in-order traversal (starts on the left)
    public void traverseInOrder(Node node) {
        if(node != null) {
            traverseInOrder(node.getLeftNode());
            System.out.println("Value(s) of node:   " + node.getValue());
            traverseInOrder(node.getRightNode());
        }
    }

      // search
    public boolean containsNodeRecursive(Node current, int value) {
        if(current == null) {
            return false;
        }

        if(current.getValue() == value) {
            System.out.println("Node found with the searched value!");
            return true;
        }

        if(value < current.getValue()) {
             containsNodeRecursive(current.getLeftNode(), value);
        } else {
            containsNodeRecursive(current.getRightNode(), value);
        }
        return false;
    }

    //---------------------------getters and setters------------------------------

    public Node getRootNode() {
        return rootNode;
    }

    public void setRootNode(Node rootNode) {
        this.rootNode = rootNode;
    }
}
