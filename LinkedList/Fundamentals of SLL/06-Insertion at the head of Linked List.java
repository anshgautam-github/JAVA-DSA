class Solution {
    public ListNode insertAtHead(ListNode head, int X) {
        //YOUR CODE GOES HERE
        ListNode nn = new ListNode(X);
        nn.next = head;
        head = nn;
        return head;
    }
}

// Time Complexity: O(1) for inserting the new node at the head of the linked list
// Space Complexity: O(1) no extra space used.



// Interview Follow-ups

// 01- How would you handle a circular linked list?
