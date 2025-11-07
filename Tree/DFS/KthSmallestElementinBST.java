package Tree.DFS;

import java.util.ArrayList;
import java.util.List;

public class KthSmallestElementinBST {

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


    public int kthSmallest(TreeNode root, int k) {
//        List<Integer> result = new ArrayList<>();
//
//        result = findInorderTraversedArray(root);
//        return result.get(k);
        return helper(root,k).val;

    }

    private static List<Integer> findInorderTraversedArray(TreeNode node){
        if(node==null){
            return new ArrayList<>();
        }

        List<Integer> left = findInorderTraversedArray(node.left);
        List<Integer> right = findInorderTraversedArray(node.right);

        left.add(node.val);
        left.addAll(right);
        return left;
    }


    // using resursion purely
    int count=0;
    private TreeNode helper(TreeNode node, int k){
        if(node ==null){
            return null;
        }
        TreeNode left = helper(node.left, k);
        if(left!=null){
            return left;

        }
        count++;

        if(count==k){
            return node;
        }
        return helper(node.right,k);

    }
}
