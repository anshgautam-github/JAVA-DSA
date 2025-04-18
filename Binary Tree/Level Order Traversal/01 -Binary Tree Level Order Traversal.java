// Given the root of a binary tree, return the level order traversal of its nodes' values. (i.e., from left to right, level by level).
Leetcode -> https://leetcode.com/problems/binary-tree-level-order-traversal/

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
              return ans;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int n=q.size();
             List<Integer> level = new ArrayList<>();
             for(int i=0; i<n; i++){
                TreeNode node = q.poll();
                level.add(node.val);
                 if (node.left != null) {
                    q.add(node.left);
                }
                if (node.right != null) {
                    q.add(node.right);
                }
             }
             ans.add(level);           
        }
        return ans;

    }
}
