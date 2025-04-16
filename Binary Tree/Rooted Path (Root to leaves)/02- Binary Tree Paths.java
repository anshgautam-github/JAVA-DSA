// Given the root of a binary tree, return all root-to-leaf paths in any order.
// A leaf is a node with no children.

//Leetcode -> https://leetcode.com/problems/binary-tree-paths/description/


class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        dfs(root, "", result);
        return result;
    }

  
    private void dfs(TreeNode root, String path, List<String> result) {
        if (root == null) return;

        if (path.isEmpty()) {
            path += root.val; // first node (root)
        } else {
            path += "->" + root.val;
        }

      if (root.left == null && root.right == null) {
            result.add(path);
            return;
        }

        dfs(root.left, path, result);
        dfs(root.right, path, result);
    }
}
