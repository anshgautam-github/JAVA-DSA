//Leetcode -> https://leetcode.com/problems/deepest-leaves-sum/


public class Solution {
    private int maxDepth = 0;
    private int sum = 0;

    public int deepestLeavesSum(TreeNode root) {
        dfs(root, 0);
        return sum;
    }

    private void dfs(TreeNode node, int depth) {
        if (node == null) return;

        // If it's a leaf
        if (node.left == null && node.right == null) {
            if (depth > maxDepth) {
                maxDepth = depth;
                sum = node.val; // new deepest level
            } else if (depth == maxDepth) {
                sum += node.val; // same deepest level
            }
        }

        // Recurse on left and right children
        dfs(node.left, depth + 1);
        dfs(node.right, depth + 1);
    }
}
