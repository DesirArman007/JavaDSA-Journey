package Tree;

public class Main {
//    public static void main(String[] args) {
//        // Create BST
//        BST tree = new BST();
//        int[] values = {10, 5, 20, 3, 7, 15, 25};
//        tree.populate(values);
//
//        // Display tree structure
//        System.out.println("Tree Structure:");
//        tree.display();
//
//        // Traversals
//        Traversal traversal = new Traversal(tree);
//
//        System.out.print("\nInorder Traversal: ");
//        traversal.inOrder();
//
//        System.out.print("Preorder Traversal: ");
//        traversal.preOrder();
//
//        System.out.print("Postorder Traversal: ");
//        traversal.postOrder();
//
//        // Balance check
//        System.out.println("\nIs tree balanced? " + tree.balanced());
//    }
public static void main(String[] args) {
    int[] arr ={3,8,6,7,-2,-8,4,9};
    SegmentedTree tree = new SegmentedTree(arr);
//    tree.display();
    System.out.println(tree.query(1,6));
}
}
