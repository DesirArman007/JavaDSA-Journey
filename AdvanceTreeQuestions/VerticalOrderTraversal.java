package AdvanceTreeQuestions;

import com.sun.source.tree.Tree;

import java.util.*;
import java.util.stream.Collectors;

public class VerticalOrderTraversal {

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
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) return ans;

        // Queue stores each node along with its row and column
        // int[]{row, col}
        Queue<Map.Entry<TreeNode, int[]>> queue = new ArrayDeque<>();
        queue.offer(new AbstractMap.SimpleEntry<>(root, new int[]{0, 0}));

        // Map: column -> list of [row, value]
        Map<Integer, List<int[]>> map = new HashMap<>();

        int min = 0, max = 0; // track leftmost and rightmost columns

        while (!queue.isEmpty()) {
            Map.Entry<TreeNode, int[]> entry = queue.poll();
            TreeNode node = entry.getKey();
            int row = entry.getValue()[0]; // current row
            int col = entry.getValue()[1]; // current column

            // Add node to the map
            map.computeIfAbsent(col, k -> new ArrayList<>()).add(new int[]{row, node.val});

            // Update min and max column
            min = Math.min(min, col);
            max = Math.max(max, col);

            // Add children to the queue with updated row and column
            if (node.left != null)
                queue.offer(new AbstractMap.SimpleEntry<>(node.left, new int[]{row + 1, col - 1}));
            if (node.right != null)
                queue.offer(new AbstractMap.SimpleEntry<>(node.right, new int[]{row + 1, col + 1}));
        }

        // Process each column from left to right
        for (int i = min; i <= max; i++) {
            List<int[]> list = map.get(i);

            // Sort first by row, then by value if same row
            list.sort((a, b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]);

            // Extract only the values for final answer
            List<Integer> colList = new ArrayList<>();
            for (int[] p : list) colList.add(p[1]);

            ans.add(colList);
        }

        return ans;
    }

//
//    public List<List<Integer>> verticalTraversal(TreeNode root) {
//
//        HashMap<Integer,List<Integer>> map = new HashMap<>();
//        ArrayList<Integer> list = new ArrayList<>();
//        int r= Integer.MIN_VALUE;
//        int c = Integer.MIN_VALUE;
//
//        helper(root,0,0,map, list);
//        List<Integer> keys = new ArrayList<>(map.keySet());
//        Collections.sort(keys);
//
//        List<List<Integer>> result = new ArrayList<>();
//        for (int key : keys) {
//            List<Integer> list1 = map.get(key);
//            List<Integer> sortedList = list1.stream()
//                    .sorted()
//                    .collect(Collectors.toList());
//            result.add(sortedList);
//        }
//        return result;
//    }
//
//    public void helper(TreeNode node, int r, int c, HashMap<Integer, List<Integer>> map, ArrayList<Integer> list){
//        if(node==null){
//            return;
//        }
//
//        map.computeIfAbsent(c, k -> new ArrayList<>()).add(node.val);
//
//
//        helper(node.left,r+1,c-1,map,list);
//        helper(node.right,r+1,c+1,map,list);
//    }


}
