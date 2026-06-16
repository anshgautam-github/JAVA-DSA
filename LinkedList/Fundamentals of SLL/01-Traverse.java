class Solution {
    public List<Integer> LLTraversal(ListNode head) {
        //your code goes here
        ListNode temp = head;
        List<Integer> ans = new ArrayList<>();
        while(temp!=null){
            ans.add(temp.data);
            temp=temp.next;
        }
        return ans;
    }
}

// TC : O(n)
// SC : O(1)
