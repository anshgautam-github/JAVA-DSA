//Given an n-ary tree, return the level order traversal of its nodes' values.
//Nary-Tree input serialization is represented in their level order traversal, each group of children is separated by the null value (See examples)
Leetcode -> https://leetcode.com/problems/n-ary-tree-level-order-traversal/description/

class Solution {
    public List<List<Integer>> levelOrder(Node root) {
         List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
              return ans;
        }
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int n=q.size();
             List<Integer> level = new ArrayList<>();
             for(int i=0; i<n; i++){
                Node node = q.poll();
                level.add(node.val);
                if(node.children!=null){
                    for(Node child: node.children){
                        q.add(child);
                    }
                }
             }
             ans.add(level);           
        }
        return ans;

    }
}
