//Leetode -> https://leetcode.com/problems/sum-of-left-leaves/

    public int sumOfLeftLeaves(TreeNode root) {
        return dfs(root, false); // root is not a left child
    }

    private int dfs(TreeNode node, boolean isLeft) {
        if (node == null) return 0;

        if (node.left == null && node.right == null) {
            return isLeft ? node.val : 0; // only sum if it's a left leaf
        }

        int left = dfs(node.left, true);     // go left → mark as left
        int right = dfs(node.right, false);  // go right → not a left

        return left + right;
    }
}
