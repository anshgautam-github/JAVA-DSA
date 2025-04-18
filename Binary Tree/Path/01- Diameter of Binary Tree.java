//Leecode -> https://leetcode.com/problems/diameter-of-binary-tree/description/

class Solution {
    int result = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return result;
    }

    private int dfs(TreeNode node) {
        if (node == null) return 0;

        int left = dfs(node.left);
        int right = dfs(node.right);

        result = Math.max(result, left + right);
      
        return 1 + Math.max(left, right);  
    }
}
