class Solution {
    public int sumOfLeafNodes(TreeNode root) {
        return dfs(root);
    }

    private int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }
      
        if (node.left == null && node.right == null) {
            return node.val;
        }

       
        return dfs(node.left) + dfs(node.right);
    }
}
