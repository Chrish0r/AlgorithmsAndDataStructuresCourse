package tree.practice;

import java.util.ArrayList;

public class Node<T> {
    private T Data;

    private ArrayList<Node<T>> children = new ArrayList<Node<T>>();
    private Node<T> parent;

    public Node(T data) {
        Data = data;
    }

    //------------------------client code / main-----------------------
    public static void main(String[] args) {
        Node<Integer> root = new Node(30);
        Node<Integer> node40 = new Node(40);
        Node<Integer> node50 = new Node(50);
        Node<Integer> node100 = new Node(100);
        Node<Integer> node200 = new Node(200);
        Node<Integer> node300 = new Node(300);

        ArrayList<Node<Integer>> childrenNodes = new ArrayList<>();
        childrenNodes.add(node100);
        childrenNodes.add(node200);
        childrenNodes.add(node300);

        // create tree: root_30 -> node40 -> node50 -> node100, node200, node300
        root.addChild(node40);
        node40.addChild(node50);

        node50.addChildren(childrenNodes);

        root.printTree();

    }

    //-------------------------logic/methods----------------------------
                 // specific tree methods
    public void addChild(Node<T> child) {
        this.children.add(child);
        child.setParent(this);
    }

    public void addChildren(ArrayList<Node<T>> childrenNodes) {
        this.children.addAll(childrenNodes);

        for(Node<T> child : childrenNodes) {
            child.setParent(this);
        }
    }
            // common methods
    public void printTree() {
        String indent = "";

        System.out.println(indent + this.getData());
        printChildrenNodes(this.getChildren(), indent);
    }

    public void printChildrenNodes(ArrayList<Node<T>> children, String indent) {
        if(children == null || children.size() == 0) {
            return;
        }
        indent += "   ";
        for(Node<T> child : children) {
            System.out.println(indent + child.getData());
            printChildrenNodes(child.getChildren(), indent);
        }
    }

    // getters and setters
    public T getData() {
        return Data;
    }

    public void setData(T data) {
        Data = data;
    }

    public ArrayList<Node<T>> getChildren() {
        return children;
    }

    public void setChildren(ArrayList<Node<T>> children) {
        this.children = children;
    }

    public Node<T> getParent() {
        return parent;
    }

    public void setParent(Node<T> parent) {
        this.parent = parent;
    }
}
