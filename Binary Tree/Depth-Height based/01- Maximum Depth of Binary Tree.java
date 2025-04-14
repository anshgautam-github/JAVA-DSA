//Leetcode -> https://leetcode.com/problems/maximum-depth-of-binary-tree/description/


class Solution {
    public int maxDepth(TreeNode root) {
        if(root==null) return 0;
        int l=maxDepth(root.left);
        int r=maxDepth(root.right);
        return 1+(Math.max(l,r));
    }
}
