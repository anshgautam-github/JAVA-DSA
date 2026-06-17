
// class Solution {
//     public void deleteGivenNode(ListNode node) {
//         // Your code goes here
//         ListNode prevv = node.prev;
//         ListNode nxt = node.next;
//         prevv.next = node.next;
//         node.prev = null;
//         nxt.prev = prevv;
//         node.next=null;
        
//     }
// }

// This above code fails for the edge cases like for head and tail -> if it is given that given deleted node is not any of them then it is 
// right 



// CORRECT CODE :
  
  class Solution {
    public void deleteGivenNode(ListNode node) {

        if (node == null) return;

        if (node.prev != null) {
            node.prev.next = node.next;
        }

        if (node.next != null) {
            node.next.prev = node.prev;
        }

        node.prev = null;
        node.next = null;
    }
}

// Time Complexity: O(1) as it only involves updating references and is independent of the list’s length.
// Space Complexity: O(1) as no extra space is use



// Interview Follow-ups

// 01- How would you modify this for a circular doubly linked list?
// 02- What if the given node was part of a sorted doubly linked list?
