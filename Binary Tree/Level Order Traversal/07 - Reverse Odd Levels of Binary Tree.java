/*
Given the root of a perfect binary tree, reverse the node values at each odd level of the tree.

For example, suppose the node values at level 3 are [2,1,3,4,7,11,29,18], then it should become [18,29,11,7,4,3,1,2].
Return the root of the reversed tree.

A binary tree is perfect if all parent nodes have two children and all leaves are on the same level.

The level of a node is the number of edges along the path between it and the root node.
*/

Leetcode -> https://leetcode.com/problems/reverse-odd-levels-of-binary-tree/description/


class Solution {
    public TreeNode reverseOddLevels(TreeNode root) {
        Queue<TreeNode>q=new LinkedList<>();
        q.add(root);
        int level=0;
        while(!q.isEmpty()){
            int n=q.size();
            List<TreeNode> levelNodes = new ArrayList<>();
            for(int i=0;i<n;i++){
                TreeNode curr=q.poll();
                levelNodes.add(curr);
                if (curr.left != null) q.add(curr.left);
                if (curr.right != null) q.add(curr.right);
            }
            if(level%2==1){
                  for (int j = 0; j < n / 2; j++) {
                    int temp = levelNodes.get(j).val;
                    levelNodes.get(j).val = levelNodes.get(n - j - 1).val;
                    levelNodes.get(n - j - 1).val = temp;
                }
            }
        level++;
    }
    return root;
}}
