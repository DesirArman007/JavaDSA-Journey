package Tree.DFS;

import java.util.ArrayList;
import java.util.List;

public class MultiplePathforSUM {

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


    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> allPaths = new ArrayList<>();
        if (root == null) {
            return allPaths;
        }

        // Start finding paths from the current node
        findPaths(root, targetSum, new ArrayList<>(), allPaths);

        // Recursively do the same for the left and right subtrees
        allPaths.addAll(pathSum(root.left, targetSum));
        allPaths.addAll(pathSum(root.right, targetSum));

        return allPaths;
    }

    /**
     * This helper function finds all paths starting from a GIVEN node
     * that sum up to the target.
     */
    private void findPaths(TreeNode node, long remainingSum, List<Integer> currentPath, List<List<Integer>> allPaths) {
        if (node == null) {
            return;
        }

        // 1. Add current node to the path we're building
        currentPath.add(node.val);
        remainingSum -= node.val;

        // 2. Check if we found a valid path
        if (remainingSum == 0) {
            // Add a COPY of the current path to our final list
            allPaths.add(new ArrayList<>(currentPath));
        }

        // 3. Continue searching deeper, even if we found a path
        findPaths(node.left, remainingSum, currentPath, allPaths);
        findPaths(node.right, remainingSum, currentPath, allPaths);

        // 4. Backtrack: Remove the current node from the path
        // This is crucial so that other branches are not affected.
        currentPath.remove(currentPath.size() - 1);
    }
}
