// Leetcode -> https://leetcode.com/problems/count-complete-tree-nodes/


class Solution {
    public int countNodes(TreeNode root) {
        if(root==null) return 0;
        int x=countNodes(root.left);
        int y=countNodes(root.right);
        return x+y+1;
    }
}
