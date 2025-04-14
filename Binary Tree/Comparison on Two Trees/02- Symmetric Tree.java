//Leetcode -> https://leetcode.com/problems/symmetric-tree/


class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root ==null) return true;
        return helper(root.left,root.right);
    }

    private boolean helper(TreeNode l, TreeNode r){
        if(l==null || r==null) return l==r;
        if(l.val!=r.val) return false;
        boolean left=helper(l.left,r.right);
        boolean right=helper(l.right,r.left);
        return left && right;
    }

}
