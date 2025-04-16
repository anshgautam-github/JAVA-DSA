// ou are given the root of a binary tree where each node has a value 0 or 1. Each root-to-leaf path represents a binary number starting with the most significant bit.

// For example, if the path is 0 -> 1 -> 1 -> 0 -> 1, then this could represent 01101 in binary, which is 13.
// For all leaves in the tree, consider the numbers represented by the path from the root to that leaf. Return the sum of these numbers.

// The test cases are generated so that the answer fits in a 32-bits integer.

//Leetcode -> https://leetcode.com/problems/sum-of-root-to-leaf-binary-numbers/description/



class Solution {
    
    public int sumRootToLeaf(TreeNode root) {
      return dfs(root,0);
    }

    public int dfs(TreeNode node, int curr){
        
        if(node == null) return 0;

        curr = (curr<<1) | node.val; 

        if (node.left == null && node.right == null) {
            return curr;
        }
        int left = dfs(node.left,curr); 
        int right= dfs(node.right,curr);

        return left+right;

    }
}
