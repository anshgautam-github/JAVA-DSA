class Solution {
    public ListNode insertAtTail(ListNode head, int X) {
        //YOUR CODE GOES HERE
        if(head==null) return new ListNode(X);  // EDGE CASE
        ListNode nn = new ListNode(X);
        ListNode temp = head;
        while(temp.next!=null){
            temp=temp.next;
        }
        temp.next = nn;
        return head;        
    }
}

// Time Complexity: O(N) for traversing the linked list and inserting the new node after the tail. Here N is the length of the Linked List.
// Space Complexity: O(1) as no extra space used.


// Interview Follow-ups

// 01- What if you frequently need to insert at the tail?
// 02- What if the list needs to remain sorted after insertion?

//02- Traverse the list to find the correct position based on X’s value, and insert the new node at that position.
