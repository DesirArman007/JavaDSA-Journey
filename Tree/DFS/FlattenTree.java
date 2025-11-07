package Tree.DFS;

import Tree.TreeLevelOrderTraversal;

import java.util.LinkedList;
import java.util.Queue;

public class FlattenTree {
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
    }

    public void flatten(TreeNode root) {
        Queue<Integer> queue = new LinkedList<>();
        flatten(root,queue );
        makeTree(root,queue);
    }

    private static void flatten(TreeNode node, Queue<Integer> queue){
        if(node==null){
            return;
        }

        queue.offer(node.val);
        flatten(node.left, queue);
        flatten(node.right, queue);
    }

    private void makeTree(TreeNode root, Queue<Integer> queue){
        if(queue.isEmpty()) return;

//        TreeNode root = new TreeNode(queue.poll());
        root.val = queue.poll();
        root.left = null;
        TreeNode current = root;

        while (!queue.isEmpty()){
            int val = queue.poll();
            TreeNode newNode = new TreeNode(val);
            current.right = newNode;
            current=newNode;
        }

    }

    // kunals method

    public void flatten1(TreeNode root){
        if(root==null){
            return;
        }

        TreeNode current=root;
        while(current!=null){
            if(current.left!=null){
                TreeNode temp = current.left;
                while(temp.right!=null){
                    temp=temp.right;
                }
                temp.right=current.right;
                current.right=current.left;
                current.left=null;
            }
            current=current.right;
        }
    }

    // validate a binary search tree
    public boolean isValidBST(TreeNode root) {

        return helper(root,null, null);
    }

    private static boolean helper(TreeNode node, Integer low, Integer high){
        if(node==null){
            return true;
        }

        if(low !=null && node.val<=low){
            return false;
        }

        if( high!=null && node.val>=high){
            return false;
        }

        boolean leftTree = helper(node.left, low, node.val);
        boolean rightTree = helper(node.right, node.val, high);

        return leftTree && rightTree;
    }

    //
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null){
            return null;
    }

        if(root==p && root==q ){
            return root;

        }

        TreeNode left =lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);

        if(left !=null && right !=null){
            return  root;
        }
        return left==null?right:left;
}

}
