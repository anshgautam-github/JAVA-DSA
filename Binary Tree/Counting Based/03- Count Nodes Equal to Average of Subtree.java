//Leetcode -> https://leetcode.com/problems/count-nodes-equal-to-average-of-subtree/



class Solution {
    int result = 0;

    public int averageOfSubtree(TreeNode root) {
        helper(root);
        return result;
    }

    // Returns [sum, count] of current subtree
    private int[] helper(TreeNode node) {
        if (node == null) return new int[]{0, 0}; // base case

        // go left
        int[] left = helper(node.left); // left[0] = sum, left[1] = count

        // go right
        int[] right = helper(node.right);

        // logic
        int totalSum = left[0] + right[0] + node.val;
        int totalCount = left[1] + right[1] + 1;

        int avg = totalSum / totalCount;

        if (node.val == avg) {
            result++;
        }

        return new int[]{totalSum, totalCount};
    }
}
