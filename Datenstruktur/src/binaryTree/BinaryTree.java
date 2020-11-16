package binaryTree;

public class BinaryTree {
    private Node rootNode;

    private boolean isContained;


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

        // Depth-First -> Variant: in-order traversal (starts on the as far down on the left as possible)
    public void traverseInOrder(Node node) {
        if(node != null) {
            traverseInOrder(node.getLeftNode());
            System.out.println("Value(s) of node:   " + node.getValue());
            traverseInOrder(node.getRightNode());
        }
    }

    // Variant: pre-order -> at first check root, then left hand tree and finally right hand tree
    public void traversePreOrder(Node node) {
        if(node != null) {
            System.out.println("Value of node: " + node.getValue());
            traversePreOrder(node.getLeftNode());
            traversePreOrder(node.getRightNode());
        }
    }

    // Variant: post-order -> at first left hand tree, then right hand tree and only at the end the rootNode
    public void traversePostOrder(Node node) {
        if(node != null) {
            traversePostOrder(node.getLeftNode());
            traversePostOrder(node.getRightNode());
            System.out.println("Value of node: " + node.getValue());
        }
    }

      // search
    public boolean containsNodeRecursive(Node current, int value) {
        isContained = false;
        if(current == null) {
            return false;
        }

        if(current.getValue() == value) {
            System.out.println("Node found with the searched value!");
            isContained = true;
            return true;
        }

        if(value < current.getValue()) {
             containsNodeRecursive(current.getLeftNode(), value); // => continue the search on the left hand!
        } else {
            containsNodeRecursive(current.getRightNode(), value); // => // continue the search on the right hand!
        }
        return false;
    }

    // delete node
    public Node deleteNodeRecursive(Node current, int value) {
        if(current == null) {
            System.out.println("ERROR!");
            return null;
        }
        if(current.getValue() == value) {
            // code to delete
               // 1st case: node has no children
            if((current.getLeftNode() == null && current.getRightNode() == null)) {
                return null;
            }
              // 2nd case: node has only one child
            if(current.getRightNode() == null) {
                return current.getLeftNode();
            }

            if(current.getLeftNode() == null) {
                return current.getRightNode();
            }

            // 3rd case: node has two children
            int smallestValue = findSmallestValue(current.getRightNode());
            current.setValue(smallestValue);

            current.setRightNode(deleteNodeRecursive(current.getRightNode(), smallestValue));
            return current;
        }

        if(value < current.getValue()) {
            current.setLeftNode(deleteNodeRecursive(current.getLeftNode(), value));
            return current;
        } else {
            current.setRightNode(deleteNodeRecursive(current.getRightNode(), value));
            return current;
        }
    }

    private int findSmallestValue(Node node) {
        if(node.getLeftNode() == null) {
            return node.getValue();
        } else {
            return findSmallestValue(node.getLeftNode()); // continue searching further left
        }
    }

    //---------------------------getters and setters------------------------------

    public Node getRootNode() {
        return rootNode;
    }

    public boolean getIsContained() {
        return isContained;
    }

    public void setRootNode(Node rootNode) {
        this.rootNode = rootNode;
    }
}
