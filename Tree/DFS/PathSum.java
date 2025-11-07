package Tree.DFS;

public class PathSum {

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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(targetSum==0){
            return true;
        }

        int rem = targetSum=root.val;
        hasPathSum(root.left, rem);
        hasPathSum(root.right,rem);
        return false;
    }
}
