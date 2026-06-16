
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


// Interview Follow-ups

// 01- How would you modify this to remove a node from the middle of the list? (YET to update)
// 02- How would you modify this to return the deleted node instead of just updating the list?

    
// 02- Store the removed node in a temporary variable before modifying pointers.
    
    public ListNode deleteTailAndReturnDeletedNode(ListNode head) {
    if (head == null)
        return null;

    if (head.next == null)
        return head;

    ListNode temp = head;

    while (temp.next.next != null) {
        temp = temp.next;
    }

    ListNode deleted = temp.next;
    temp.next = null; // actually delete it

    return deleted;
}
