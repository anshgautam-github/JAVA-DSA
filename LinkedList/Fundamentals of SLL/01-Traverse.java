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

    
// Time Complexity: O(N) since we are visiting each node once. Here N represents the length of the linked list or the number of nodes present in the linked list.

// Space Complexity: O(1) (Auxiliary Space). The algorithm only uses a constant amount of extra space for the traversal pointer. (
