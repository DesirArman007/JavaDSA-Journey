package AdvanceTreeQuestions;

import java.util.HashMap;

public class ContructTreeUsingInorderPreorder {

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

  public TreeNode buildTree(int[] preOrder, int[] inOder){
      HashMap<Integer,Integer> map = new HashMap<>();

      for(int i=0; i<inOder.length; i++){
          map.put(inOder[i],i);
      }
        int[] index={0};
     return helper(preOrder,inOder,0,preOrder.length-1,map,index);
  }

  public TreeNode helper(int[] preOder, int[] inOrder, int left, int right, HashMap<Integer,Integer> map, int[] index){
        if(left>right){
            return null;
        }

        int current = map.get(index[0]);
        index[0]++;

        TreeNode node = new TreeNode(current);

        if(left==right){
              return node;
          }

        int inorderIndex = map.get(current);
        node.left = helper(preOder,inOrder,left,inorderIndex-1,map,index);
        node.right=helper(preOder,inOrder,inorderIndex+1,right,map,index);
        return node;
  }


}
