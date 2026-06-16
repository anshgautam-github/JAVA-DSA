class Solution {
    public ListNode deleteNodeWithValueX(ListNode head, int X) {
        //YOUR CODE GOES HERE
        if(head==null) return null;
        if (head.data==X) return head = head.next;
        ListNode temp = head;

        while (temp.next!=null && temp.next.data!=X ){ // order matters otherwise you'll get an error.
            temp=temp.next;
        }
        if(temp.next!=null){
            temp.next = temp.next.next;
        }
        
        return head;

    }
}


// ALTERNATE solution -> 

class Solution {
    public ListNode deleteNodeWithValueX(ListNode head, int X) {
        if (head == null) return head;
        
        if (head.data == X) {
            head = head.next;
            return head;
        }

        ListNode temp = head;
        ListNode prev = null;

        while (temp != null) {
            if (temp.data == X) {
                prev.next = temp.next;
                return head;
            }
            prev = temp;
            temp = temp.next;
        }
        return head;
    }
}


// Time Complexity: O(N) worst case, when the value is found at the tail, and O(1) best case, 
//                   when the value is found at the head. Here N is the length of the linked list.
// Space Complexity: O(1) as no extra space used.


  
// Interview Follow-ups

// 01- What if you need to delete all occurrences of X? (NOT YET)
// 02- How would you handle circular linked lists?   (NOT YET)

// 01- For a circular linked list, ensure that the tail node’s next pointer is updated appropriately 
//     if the deleted node is the head or the node with value X.
// 02- For a circular linked list, ensure that the tail node’s next pointer is updated appropriately if the deleted node is the head 
//     or the node with value X.
