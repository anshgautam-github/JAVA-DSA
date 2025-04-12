/*
Given the root of a binary tree and two integers val and depth, add a row of nodes with value val at the given depth depth.

Note that the root node is at depth 1.

The adding rule is:
1- Given the integer depth, for each not null tree node cur at the depth depth - 1, create two tree nodes with value val as cur's left subtree root and right subtree root.
2- cur's original left subtree should be the left subtree of the new left subtree root.
3- cur's original right subtree should be the right subtree of the new right subtree root.
4- If depth == 1 that means there is no depth depth - 1 at all, then create a tree node with value val as the new root of the whole original tree, and the original tree is the new root's left subtree.
*/

Leetcode -> https://leetcode.com/problems/add-one-row-to-tree/

class Solution {
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if(depth==1){
            TreeNode newRoot=new TreeNode(val);
            newRoot.left=root;
            return newRoot;
        }
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        int cdepth=1;
        while(!q.isEmpty()){
            int n=q.size();

            for(int i=0;i<n;i++){
                TreeNode node=q.poll();
                if(cdepth==depth-1){
                    TreeNode newLeft=new TreeNode(val);
                    newLeft.left=node.left;
                    node.left=newLeft;
                    TreeNode newRight=new TreeNode(val);
                    newRight.right=node.right;
                    node.right=newRight;
                    //here we have not inserted further left and right 
                }else{  //normal BFS
                    if(node.left!=null) q.add(node.left);
                    if(node.right!=null) q.add(node.right);
                }
            }

            cdepth++;
        }
        return root;
    }
}
