/*
Given the root of a binary tree, the level of its root is 1, the level of its children is 2, and so on.
Return the smallest level x such that the sum of all the values of nodes at level x is maximal.
*/
Leetcode -> https://leetcode.com/problems/maximum-level-sum-of-a-binary-tree/description/


class Solution {
    public int maxLevelSum(TreeNode root) {
        Queue<TreeNode> q=new LinkedList<>();
        int level=1;
        int max=Integer.MIN_VALUE;
        int maxlevel=1;
        q.add(root);
        while(!q.isEmpty()){
            int n=q.size();
            int sum=0;
            for(int i=0;i<n;i++){
                TreeNode curr=q.poll();
                sum+=curr.val;
                if(curr.left!=null) q.add(curr.left);
                if(curr.right!=null) q.add(curr.right);
            }
            if(sum>max){
                max=sum;
                maxlevel=level;
            }
            level++;
        }
        return maxlevel;
    }
}
