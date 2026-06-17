
class Solution {
    public ListNode insertBeforeHead(ListNode head, int data) {
        // Your code goes here
        if (head == null) return new ListNode(data);
        ListNode nn = new ListNode(data);
        nn.next = head;
        head.prev=nn;
        head = nn;
        return nn;
    }
}







// Interview Follow-ups

// 01-How would you modify this for a circular doubly linked list?
// 02-How can we make this thread-safe in concurrent environments?
