package Tree;

import java.util.*;

public class TreeLevelOrderTraversal {
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

  // returns a list of [[],[]] traveral of a BST using BFS
    public List<List<Integer>> levelOrder(TreeNode root){
        List<List<Integer>> result = new ArrayList<>();

        if(root==null){
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()){
            int levelSize = queue.size();
            List<Integer> currentLevel = new ArrayList<>(levelSize);

            for(int i=0; i<levelSize;i++){
                TreeNode currentNode = queue.poll();
                currentLevel.add(currentNode.val);
                if(currentNode.left!=null) {
                    queue.offer(currentNode.left);
                }

                if(currentNode.right!=null){
                    queue.offer(currentNode.right);
                }
            }
            result.add(currentLevel);
        }

        return result;
    }

    //right side view
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        if(root==null){
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()){
            int levelSize = queue.size();

            for(int i=0; i<levelSize;i++){
                TreeNode currentNode = queue.poll();

                if(i==levelSize-1){
                    result.add(currentNode.val);
                }

                if(currentNode.left!=null) {
                    queue.offer(currentNode.left);
                }

                if(currentNode.right!=null){
                    queue.offer(currentNode.right);
                }
            }
        }

        return result;
    }

    // find the average of levels in BST (use BFS because it asekd fore levers)
    public List<Double> levelAvg(TreeNode root){
        List<Double> result = new ArrayList<>();

        if(root==null){
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()){
            int levelSize = queue.size();
            Double averageLevel = 0.0;
            for(int i=0; i<levelSize;i++){
                TreeNode currentNode = queue.poll();
                averageLevel += currentNode.val;
                if(currentNode.left!=null) {
                    queue.offer(currentNode.left);
                }

                if(currentNode.right!=null){
                    queue.offer(currentNode.right);
                }
            }
            result.add(averageLevel/levelSize);
        }

        return result;
    }

    //
    public TreeNode findSuccessor(TreeNode root, int key){

        if(root==null){
            return null;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()){
            int levelSize = queue.size();
            TreeNode keySuccessor = null;
                TreeNode currentNode = queue.poll();
                if(currentNode.left!=null) {
                    queue.offer(currentNode.left);
                }

                if(currentNode.right!=null){
                    queue.offer(currentNode.right);
                }

              if(currentNode.val == key){
                  break;
              }
        }
        // when the key is removed the successor will come on the front so used peek()
        return queue.peek();
    }

    // Binary Tree Zigzag Level Order Traversal (my method)
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        if(root==null){
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        boolean leftToRight = true;

        while(!queue.isEmpty()){
            int levelSize = queue.size();
            List<Integer> currentLevel = new ArrayList<>(levelSize);
            for(int i=0; i<levelSize;i++){
                TreeNode currentNode = queue.poll();
                currentLevel.add(currentNode.val);
                if(currentNode.left!=null) {
                    queue.offer(currentNode.left);
                }

                if(currentNode.right!=null){
                    queue.offer(currentNode.right);
                }

            }
            if (!leftToRight) {
                swap(currentLevel);
            }

            result.add(currentLevel);
            leftToRight = !leftToRight;
        }

        return result;
    }

    // kunal approach with using DEQUEUEQ
    public List<List<Integer>> zigzagLevelOrderUsingDequeue(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        if(root==null){
            return result;
        }

        Deque<TreeNode> deque = new LinkedList<>();
        deque.offer(root);

        boolean reverse = false;

        while(!deque.isEmpty()){
            int levelSize = deque.size();
            List<Integer> currentLevel = new ArrayList<>(levelSize);
            for(int i=0; i<levelSize;i++){

                if (!reverse) { // left to right
                    TreeNode currentNode = deque.pollFirst();
                    currentLevel.add(currentNode.val);
                    if (currentNode.left != null) {
                        deque.offerLast(currentNode.left);
                    }
                    if (currentNode.right != null) {
                        deque.offerLast(currentNode.right);
                    }
                } else { // right to left
                    TreeNode currentNode = deque.pollLast();
                    currentLevel.add(currentNode.val);
                    if (currentNode.right != null) {
                        deque.offerFirst(currentNode.right);
                    }
                    if (currentNode.left != null) {
                        deque.offerFirst(currentNode.left);
                    }
                }
            }
            result.add(currentLevel);
            reverse = !reverse;
        }

        return result;
    }


    private static void swap(List<Integer> list) {
        int start = 0;
        int end = list.size() - 1;
        while (start < end) {
            int temp = list.get(start);
            list.set(start, list.get(end));
            list.set(end, temp);
            start++;
            end--;
        }
    }


    // check cousins
    public boolean isCousins(TreeNode root, int x, int y) {
        TreeNode xx = findNode(root, x);
        TreeNode yy = findNode(root, y);

        return (
                (level(root, xx, 0) == level(root, yy, 0))
                        && (!isSibling(root, xx, yy))
        );
    }

    TreeNode findNode(TreeNode node, int x) {
        if (node == null) {
            return null;
        }

        if (node.val == x) {
            return node;
        }

        TreeNode n = findNode(node.left, x);
        if (n != null) {
            return n;
        }

        return findNode(node.right, x);
    }

    private static int level(TreeNode root, TreeNode node, int lvl) {
        if (root == null) {
            return -1;
        }

        if (root.val == node.val) {
            return lvl;
        }

        int n = level(root.left, node, lvl + 1);
        if (n != -1) {
            return n;
        }
        return level(root.right, node, lvl + 1);
    }

    private static boolean isSibling(TreeNode root, TreeNode xx, TreeNode yy) {
        if (root == null) {
            return false;
        }

        if (root.left != null && root.right != null) {
            if ((root.left.val == xx.val && root.right.val == yy.val) ||
                    (root.left.val == yy.val && root.right.val == xx.val)) {
                return true;
            }
        }

        return isSibling(root.left, xx, yy) || isSibling(root.right, xx, yy);
    }



    // symmetric tree check
    public boolean isSymmetric(TreeNode root) {
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root.left);
            queue.add(root.right);
            while(!queue.isEmpty()){
                TreeNode left = queue.poll();
                TreeNode right = queue.poll();

                if(left==null && right== null){
                    continue;
                }

                if(left==null || right==null){
                    return false;
                }

                if(left.val != right.val){
                    return false;
                }
                queue.add(left.left);
                queue.add(right.right);
                queue.add(left.right);
                queue.add(right.left);

            }
            return true;
    }

}
