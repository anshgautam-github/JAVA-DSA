/*
Given a binary tree, find its minimum depth.

The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.

Note: A leaf is a node with no children.
*/
Leetcode -> https://leetcode.com/problems/minimum-depth-of-binary-tree/description/


class Solution {
    public int minDepth(TreeNode root) {
    if (root == null)
      return 0;

    int depth = 1;
    Queue<TreeNode> q = new LinkedList<TreeNode>();
    q.offer(root);

    // Level order traversal
    while (!q.isEmpty()) {
      int size = q.size();
      for (int i = 0; i < size; i++) {
        TreeNode node = q.poll();

        // If a leaf node is found just return depth
        if (node.left == null && node.right == null) {
          return depth;
        }
        if (node.left != null) {
          q.offer(node.left);
        }
        if (node.right != null) {
          q.offer(node.right);
        }
      }
      depth++;
    }
    return depth;
}
}
