//Given the root of a binary tree, return the average value of the nodes on each level in the form of an array. Answers within 10-5 of the actual answer will be accepted.
Leetcode -> https://leetcode.com/problems/average-of-levels-in-binary-tree/description/


class Solution {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double>ans=new ArrayList<>();
        Queue<TreeNode>q=new LinkedList<>();
        if(root==null) return ans;
        q.add(root);
        while(!q.isEmpty()){
            int n=q.size();
            double sum=0;
            for(int i=0;i<n;i++){
                TreeNode node=q.poll();
                sum+=node.val;
                if(node.left!=null) q.add(node.left);
                if(node.right!=null) q.add(node.right);
            }
            ans.add(sum/n);
        }
        return ans;
    }
}
