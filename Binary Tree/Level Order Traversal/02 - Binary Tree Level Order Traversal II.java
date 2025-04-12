//Given the root of a binary tree, return the bottom-up level order traversal of its nodes' values. (i.e., from left to right, level by level from leaf to root).
Leetcode Link-> https://leetcode.com/problems/binary-tree-level-order-traversal-ii/

class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res=new ArrayList<>();
        if(root ==null) return res;
        Queue<TreeNode>q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int n=q.size();
            List<Integer> curr=new ArrayList<>();
            for(int i=0; i<n;i++){
                TreeNode node=q.poll();
                curr.add(node.val);
                if(node.left!=null) q.add(node.left);
                if(node.right!=null) q.add(node.right);
                
            }
            res.add(curr);
            // res.addFirst(curr);
        }
        Collections.reverse(res);
        return res;
    }
}
