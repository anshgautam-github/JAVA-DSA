
class Solution {
    public ListNode deleteTail(ListNode head) {
        //your code goes here
        if(head==null || head.next == null ) return null;
        ListNode temp = head;
        while(temp.next.next!=null){
            temp=temp.next;
        }
        temp.next=null;
        return head;
    }
}

// Time Complexity: O(N) for traversing the linked list and updating the tail.
// Space Complexity: O(1) as no extra space has been used.
