class Solution {
    public ListNode deleteHead(ListNode head) {
        //your code goes here
        if (head==null) return head;
        head=head.next;
        return
    }
}

// Time Complexity: O(1) for updating the head of the linked list.
// Space Complexity: O(1) as no extra space is used.


// Interview Follow-ups

// 01- What if the list is circular?
// 02- What is the difference between deleting the head and other nodes?

    
// 01- If the list is circular, check if the head is the only node. 
//     If true, set the head to None. Otherwise, update the tail’s next pointer to skip the deleted node and point to the new head.
// 02- Deleting the head does not require traversal or a previous pointer, making it simpler. 
//     Deleting other nodes requires maintaining a reference to the previous node.
