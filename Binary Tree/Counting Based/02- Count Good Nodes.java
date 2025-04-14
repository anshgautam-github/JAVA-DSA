//Leetcode -> https://leetcode.com/problems/count-good-nodes-in-binary-tree/


class Solution {
    public int goodNodes(TreeNode root) {
        // Start the recursive call with the minimum possible value as initial max.
        return goodNodesHelper(root, Integer.MIN_VALUE);
    }

    private int goodNodesHelper(TreeNode node, int maxVal) {
        // Base case: If the node is null, return 0
        if (node == null) {
            return 0;
        }

        // Logic: If the current node's value is >= maxVal, it's a good node
        int count = 0;
        if (node.val >= maxVal) {
            count ++; // The node is a good node
        }

        // Update the max value encountered so far on the path
        maxVal = Math.max(maxVal, node.val);

        // Recurse on left and right children, passing the updated max value
        int x= goodNodesHelper(node.left, maxVal);
        int y= goodNodesHelper(node.right, maxVal);

        return x+y+count;
    }
}
