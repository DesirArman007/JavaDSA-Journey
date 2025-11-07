package Tree.DFS;

import Maths.NewtonSQRT;

import java.util.*;

public class SearlizeAndDesearlize {

    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

  public List<String> serialize(TreeNode root){
        List<String> list = new ArrayList<>();
        helper(root, list);
        return list;
  }

  public String serilize(TreeNode node){
        StringBuilder SB = new StringBuilder();
        newHelper(node, SB);
        return SB.toString();
  }

  void newHelper(TreeNode node, StringBuilder SB){
        if(node == null){
            SB.append("null" +",");
            return;
        }
        SB.append(node.val+",");
        newHelper(node.left, SB);
        newHelper(node.right, SB);
  }

  void helper(TreeNode node, List<String> list){
        if(node == null){
            list.add(null);
            return;
        }

        list.add(String.valueOf(node.val));
        helper(node.left,list);
        helper(node.right,list);
  }

  TreeNode deserialize(List<String> list){
      Collections.reverse(list);
      TreeNode node = helper2(list);
      return node;
  }

  TreeNode helper2(List<String> list){
        String val = list.remove(list.size()-1);

        if(val.charAt(0)=='n'){
            return null;
        }

        TreeNode node = new TreeNode(Integer.parseInt(val));

        node.left = helper2(list);
        node.right=helper2(list);
        return  node;
  }


  TreeNode Deserialize(String data){
      Queue<String> nodes = new LinkedList<>(
              Arrays.asList(data.split(",")));
      TreeNode node = newHelper2(nodes);
      return node;
  }

  TreeNode newHelper2(Queue<String> nodes){
      String val = nodes.poll();  // poll once
      if (val.equals("null")) {
          return null;
      }
        TreeNode node = new TreeNode(Integer.parseInt(val));
        node.left = newHelper2(nodes);
        node.right = newHelper2(nodes);
        return node;
  }
}
