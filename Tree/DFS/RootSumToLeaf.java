package Tree.DFS;

import java.util.ArrayList;
import java.util.List;

public class RootSumToLeaf {

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

    public int sumNumbers(TreeNode root) {
        List<String> list = helper(root,"");  // get all root-to-leaf paths as strings
        int sum = 0;
        for (String s : list) {
            sum += Integer.parseInt(s);
        }
        return sum;
    }

    private static  List<String> helper(TreeNode node,String path){
        List<String> result = new ArrayList<>();

        if(node==null){
            return result;
        }

        path += node.val;

        if(node.left==null && node.right==null){
            result.add(path);
            return result;
        }

        result.addAll(helper(node.left,path));
        result.addAll(helper(node.right,path));

        return result;
    }


    //kunals method

    int helper(TreeNode node, int sum){
        if(node == null){
            return 0;
        }
        sum=sum*10+node.val;

        return  helper(node.left,sum)+helper(node.right, sum);
    }
}
