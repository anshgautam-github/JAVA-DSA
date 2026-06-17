
class Solution {
  public ListNode deleteKthElement(ListNode head, int k) {
       
        if (head == null) 
            return null;
    
        int count = 0;
        ListNode kNode = head;

        // Traverse the list
        while (kNode != null) {
            count++;
            if (count == k) break;
            kNode = kNode.next;
        }

        // If k is larger than the list size
        if (kNode == null) return head; 
        
        // Update the pointers
        ListNode prev = kNode.prev;
        ListNode front = kNode.next;

        // If node to be deleted is the only node in the list
        if (prev == null && front == null) {
            return null;
        }
        
        // If node to be deleted is head of the list
        else if (prev == null) {
            head = front;
            front.prev = null;
        }
        
        // If node to be deleted is tail of the list
        else if (front == null) {
            prev.next = null;
        }
        
        // If node to be deleted is in the middle of the list
        else {
            prev.next = front;
            front.prev = prev;
        }

        // Return modified list head
        return head;
    }
}

// Time Complexity: O(k) because it only involves identifying the Kth node and updating its references to delete it.
// Space Complexity: O(1) as no extra space is used.



// Interview Follow-ups

// 01- How would you efficiently find and delete the k-th node in a frequently accessed list?
// 02- How would you adapt this approach for deleting a node with a specific value instead of the k-th node?
