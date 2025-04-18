class Solution {
    public int countLeafNodes(TreeNode root) {
        return dfs(root);
    }

    private int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }
        
       
        if (node.left == null && node.right == null) {
            return 1;
        }

        return dfs(node.left) + dfs(node.right);
    }
}
