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

          // traversing through a tree -> recursion is helpful
    public void

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
