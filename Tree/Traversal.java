package Tree;

public class Traversal {
    private final BST tree;

    public Traversal(BST tree) {
        this.tree = tree;
    }

    // Preorder Traversal (Root → Left → Right)
    public void preOrder() {
        preOrder(tree.getRoot());
        System.out.println();
    }

    private void preOrder(BST.Node node) {
        if (node == null) return;
        System.out.print(node.getValue() + " ");
        preOrder(node.getLeft());
        preOrder(node.getRight());
    }

    // Inorder Traversal (Left → Root → Right)
    public void inOrder() {
        inOrder(tree.getRoot());
        System.out.println();
    }

    private void inOrder(BST.Node node) {
        if (node == null) return;
        inOrder(node.getLeft());
        System.out.print(node.getValue() + " ");
        inOrder(node.getRight());
    }

    // Postorder Traversal (Left → Right → Root)
    public void postOrder() {
        postOrder(tree.getRoot());
        System.out.println();
    }

    private void postOrder(BST.Node node) {
        if (node == null) return;
        postOrder(node.getLeft());
        postOrder(node.getRight());
        System.out.print(node.getValue() + " ");
    }
}
