//Leetcode -> https://leetcode.com/problems/subtree-of-another-tree/

class Solution {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null) return false;

        if (isIdentical(root, subRoot)) {
            return true;
        }

        // Recursively check left and right subtree
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    private boolean isIdentical(TreeNode s, TreeNode t) {
        if (s == null && t == null) return true;

        if (s == null || t == null) return false;

        if (s.val != t.val) return false;

        // Both left and right subtrees must also be identical
        return isIdentical(s.left, t.left) && isIdentical(s.right, t.right);
    }
}
