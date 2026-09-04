// left traversal without leaf
// add leaf nodes
// right traversal without leaf in reverse order




class Solution {
    // Function to check if a node is a leaf
    public boolean isLeaf(TreeNode root) {
        return root.left == null && root.right == null;
    }

    // Function to add the left boundary of the tree
    public void addLeftBoundary(TreeNode root, List<Integer> res) {
        TreeNode curr = root.left;
        while (curr != null) {
            if (!isLeaf(curr)) {
                res.add(curr.data);
            }
            if (curr.left != null) {
                curr = curr.left;
            } else {
                curr = curr.right;
            }
        }
    }

    // Function to add the right boundary of the tree
    public void addRightBoundary(TreeNode root, List<Integer> res) {
        TreeNode curr = root.right;
        List<Integer> temp = new ArrayList<>();
        while (curr != null) {
            if (!isLeaf(curr)) {
                temp.add(curr.data);
            }
            if (curr.right != null) {
                curr = curr.right;
            } else {
                curr = curr.left;
            }
        }
        for (int i = temp.size() - 1; i >= 0; --i) {
            res.add(temp.get(i));
        }
    }

    // Function to add the leaves of the tree
    public void addLeaves(TreeNode root, List<Integer> res) {
        if (isLeaf(root)) {
            res.add(root.data);
            return;
        }
        if (root.left != null) {
            addLeaves(root.left, res);
        }
        if (root.right != null) {
            addLeaves(root.right, res);
        }
    }

    // Main function to perform the boundary traversal of the binary tree
    public List<Integer> boundary(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        if (!isLeaf(root)) {
            res.add(root.data);
        }

        addLeftBoundary(root, res);
        addLeaves(root, res);
        addRightBoundary(root, res);

        return res;
    }

}


// Time Complexity: O(N) where N is the number of nodes in the Binary Tree. This is due to traversing the left boundary, bottom nodes, and right boundary sequentially, each operation being at most O(N).
// Space Complexity: O(N) for storing boundary nodes and auxiliary recursion stack space in the worst-case scenario of a skewed tree.
