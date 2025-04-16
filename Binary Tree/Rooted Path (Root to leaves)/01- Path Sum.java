// Given the root of a binary tree and an integer targetSum, return true if the tree has a root-to-leaf path such that adding up all the values along the path
// equals targetSum.
// A leaf is a node with no children.

//Leetcode -> https://leetcode.com/problems/path-sum/description/

class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        return dfs(root, targetSum, 0);
    }

    private boolean dfs(TreeNode node, int targetSum, int currentSum) {
        if (node == null) return false;

        currentSum += node.val;
        if (node.left == null && node.right == null) {
            return currentSum == targetSum;
        }

        return dfs(node.left, targetSum, currentSum) || dfs(node.right, targetSum, currentSum);
    }
}
