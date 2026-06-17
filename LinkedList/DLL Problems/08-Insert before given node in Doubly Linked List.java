
class Solution {
    public void insertBeforeGivenNode(ListNode node, int X) {
        // Your code goes here
        ListNode nn = new ListNode(X);
        ListNode prev = node.prev;
        nn.next=node;
        node.prev=nn;
        prev.next=nn;
        nn.prev=prev;
    }
}





// Interview Follow-ups

// 01-How would this change if the list was a singly linked list (SLL)?
// 02-How can we modify this to insert X after given_node instead?
