package binaryTree;

public class Main {
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();

        binaryTree.add(100);
        binaryTree.add(40);
        binaryTree.add(30);
        binaryTree.add(200);
        binaryTree.add(300);
        binaryTree.add(3);
        binaryTree.add(34);

        binaryTree.traverseInOrder(binaryTree.getRootNode());
        System.out.println();

        binaryTree.containsNodeRecursive(binaryTree.getRootNode(), 3);

        if(!(binaryTree.getIsContained())) {
            System.out.println("ERROR: search item not found!");
        }

      //  binaryTree.deleteNodeRecursive(binaryTree.getRootNode(), 300);
        System.out.println();

        binaryTree.traversePreOrder(binaryTree.getRootNode());
        System.out.println();

        binaryTree.traversePostOrder(binaryTree.getRootNode());
    }
}
