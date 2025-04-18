//Leetcode -> https://leetcode.com/problems/binary-tree-maximum-path-sum/description/

class Solution {
    int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        dfs(root);
        return maxSum;
    }

    private int dfs(TreeNode node) {
        if (node == null) return 0;

        // Step 1: Recurse on left and right children
        int left = dfs(node.left);
        int right = dfs(node.right);

        // Step 2: Ignore paths that reduce sum (i.e., < 0)
        left = Math.max(0, left);
        right = Math.max(0, right);

        // Step 3: Update global max if current node forms a better path
        maxSum = Math.max(maxSum, node.val + left + right);

        // Step 4: Return the best one-sided path sum (for recursion)
        return node.val + Math.max(left, right);
    }
}
