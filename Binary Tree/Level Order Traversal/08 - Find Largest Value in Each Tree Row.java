//Given the root of a binary tree, return an array of the largest value in each row of the tree (0-indexed).

 Leetcode -> https://leetcode.com/problems/find-largest-value-in-each-tree-row/description/

class Solution {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res=new ArrayList<>();
        Queue<TreeNode>q= new LinkedList<>();
        if(root==null) return res;
        q.add(root);
        while(!q.isEmpty()){
            int n=q.size();
            int large=Integer.MIN_VALUE;
            for(int i=0; i<n; i++){
                TreeNode curr=q.poll();
                large=Math.max(large,curr.val);
                if(curr.left!=null) q.add(curr.left);
                if(curr.right!=null) q.add(curr.right);
            }
            res.add(large);
        }
        return res;
    }
}
