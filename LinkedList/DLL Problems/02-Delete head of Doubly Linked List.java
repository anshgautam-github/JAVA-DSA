
class Solution {
    public ListNode deleteHead(ListNode head) {
        // Your code goes here
        if(head == null || head.next==null) return null;
        ListNode prev = head;
        head= head.next;
        head.prev=null;
        prev.next = null;

        return head;
    }
}



// Interview Follow-ups

// 01- How would you modify this to return the deleted node instead of just updating the list?
// 02- What if the list was circular instead of linear?


// 01- 
  
class Solution {
    public ListNode deleteHead(ListNode head) {
        // Your code goes here
        if(head == null || head.next==null) return null;
        ListNode prev = head;
        head= head.next;
        head.prev=null;
        prev.next = null;

        return prev;
    }
}

