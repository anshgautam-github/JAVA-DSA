//Leetcode -> https://leetcode.com/problems/leaf-similar-trees/

class Solution {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> leafs1 = new ArrayList<>();
        List<Integer> leafs2 = new ArrayList<>();

        getLeaves(root1, leafs1);
        getLeaves(root2, leafs2);

        return leafs1.equals(leafs2);
    }

    private void getLeaves(TreeNode node, List<Integer> list) {
        if (node == null) return;

        // Check if it's a leaf node
        if (node.left == null && node.right == null) {
            list.add(node.val);
        }

        // Recurse to left and right
        getLeaves(node.left, list);
        getLeaves(node.right, list);
    }
}
