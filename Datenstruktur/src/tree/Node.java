package tree;

import java.util.ArrayList;
import java.util.List;

public class Node<T> {

    private T data = null; // initializing actually not needed since default value of any reference variable of a non-primitive data type is null.

    private ArrayList<Node<T>> childrenNodes = new ArrayList<Node<T>>();
    private Node<T> parentNode;

    public Node(T data) {
        this.data = data;
    }

    //----------------------------client code / main----------------------------
    public static void main(String[] args) {
        Node<String> root = new Node<String>("root");

        Node<String> node1 = new Node<String>("node1");
        Node<String> node2 = new Node<String>("node2");
        Node<String> node3 = new Node<String>("node3");

        // create tree: root -> node1 -> node2 -> node3 -> node4, node5, node6, node7
        root.addChild(node1);
        node1.addChild(node2);
        node2.addChild(node3);

        ArrayList<Node<String>> childrenNodes = new ArrayList<>();
        childrenNodes.add(new Node<String>("node4"));
        childrenNodes.add(new Node<String>("node5"));
        childrenNodes.add(new Node<String>("node6"));
        childrenNodes.add(new Node<String>("node7"));

        node3.addChildren(childrenNodes);

        // print tree
    //    root.printTree(root);
        root.printTree2();

    }

    //-----------------------------logic----------------------------------------
           // add one next-element
    public void addChild(Node<T> child) {
        childrenNodes.add(child); // now parent knows its new child (next)
        child.setParentNode(this); // now child also knows his parent (previous)
    }
            // add several next-elements
    public void addChildren(ArrayList<Node<T>> childrenList) {
        childrenNodes.addAll(childrenList);

        for(Node<T> child : childrenList) {
           // childrenNodes.add(child);
            child.setParentNode(this);
        }
    }

          // traversing through a tree -> ideal regarding recursion
            // depth firts (de: Tiefensuche)
    public void printTree(Node<T> root) {
        System.out.println(root.getData());

        ArrayList<Node<T>> children = root.getChildrenNodes();
        for(Node<T> child : children) {
            printTree(child);
        }
    }

    private void printTree2() {
        String indent = "";
        System.out.println(this.getData());

        printChildren(indent, this.getChildrenNodes());
    }

    private void printChildren(String indent, ArrayList<Node<T>> childrenNodes) {
        if(childrenNodes.size() == 0 || childrenNodes == null) {
            return;
        }
        indent += "   ";

        for(Node<T> child : childrenNodes) {
            System.out.println(indent + child.getData());
            printChildren(indent, child.getChildrenNodes());
        }
    }

    //---------------getters and setters---------------------------------
    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public ArrayList<Node<T>> getChildrenNodes() {
        return childrenNodes;
    }

    public void setChildrenNodes(ArrayList<Node<T>> childrenNodes) {
        this.childrenNodes = childrenNodes;
    }

    public Node<T> getParentNode() {
        return parentNode;
    }

    public void setParentNode(Node<T> parentNode) {
        this.parentNode = parentNode;
    }
}
