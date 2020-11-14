package binaryTree;

public class Main {
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        int[] array = {-5, 13, -32, 7, -3, 17, 23, 12, -35, 19};

        // filling tree
        for(int i = 0; i < array.length; i++) {
            binaryTree.add(array[i]);
        }


        binaryTree.traverseInOrder(binaryTree.getRootNode());
        System.out.println();

        binaryTree.containsNodeRecursive(binaryTree.getRootNode(), 3);

        if(!(binaryTree.getIsContained())) {
            System.out.println("ERROR: search item not found!");
        }
        /*

      //  binaryTree.deleteNodeRecursive(binaryTree.getRootNode(), 300);
        System.out.println();

       binaryTree.traversePreOrder(binaryTree.getRootNode());
       System.out.println();

        binaryTree.traversePostOrder(binaryTree.getRootNode());

         */
    }
}
