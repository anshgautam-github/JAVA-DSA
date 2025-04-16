// You are given the root of a binary tree containing digits from 0 to 9 only.

// Each root-to-leaf path in the tree represents a number.

// For example, the root-to-leaf path 1 -> 2 -> 3 represents the number 123.
// Return the total sum of all root-to-leaf numbers. Test cases are generated so that the answer will fit in a 32-bit integer.

// A leaf node is a node with no children.

//Leetcode -> https://leetcode.com/problems/sum-root-to-leaf-numbers/description/

class Solution {
    public int sumNumbers(TreeNode root) {
         return helper(root, 0);
    }
     private int helper(TreeNode node, int currNum) {
        if (node == null) return 0;

        currNum = currNum * 10 + node.val;

        if (node.left == null && node.right == null) {
            return currNum;
        }

        // recurse on left and right subtrees
        int leftSum = helper(node.left, currNum);
        int rightSum = helper(node.right, currNum);

        return leftSum + rightSum;
    }
}
