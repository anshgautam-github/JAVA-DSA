//Leetcode -> https://leetcode.com/problems/longest-univalue-path/


class Solution {
    private int maxLength = 0;

    public int longestUnivaluePath(TreeNode root) {
        dfs(root);
        return maxLength;
    }

    private int dfs(TreeNode node) {
       if (node==null) return 0;
       
       int left=dfs(node.left);
       int right=dfs(node.right);

       int leftpath=0;
       int rightpath=0;

       if(node.left!=null && node.val==node.left.val){
        leftpath=left+1;
       }

       if(node.right!=null && node.val==node.right.val){
        rightpath=right+1;
       }

       maxLength=Math.max(maxLength, leftpath+rightpath);
       return Math.max(leftpath, rightpath);

    }
}
