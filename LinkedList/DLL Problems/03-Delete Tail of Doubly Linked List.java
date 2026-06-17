
class Solution {
    public ListNode deleteTail(ListNode head) {
        // Your code goes here
        if(head == null || head.next==null) return null;
        ListNode temp = head;
        ListNode prev = null;

        while(temp.next!=null){ // Not -> temp!=null, bcoz then temp becomes null
            prev=temp;
            temp=temp.next;
        }
        prev.next = null;
        temp.prev=null;

        return head;

    }
}

// Time Complexity: O(N), where N is the number of nodes in the DLL.
// Space Complexity: O(1) as no extra space used.


// ALTERNATE SINGLE POINTER -> go till the last node 
class Solution {
    public ListNode deleteTail(ListNode head) {
        // Your code goes here
        if(head == null || head.next==null) return null;
        ListNode temp = head;

        while(temp.next!=null){
            temp=temp.next;
        }
        temp.prev.next=null;
        temp.prev=null;


        return head;

    }
}

//Alternate -> Instead of reaching the tail, stop at the second-last node.
class Solution {
    public ListNode deleteTail(ListNode head) {

        if (head == null || head.next == null)
            return null;

        ListNode temp = head;

        while (temp.next.next != null) {
            temp = temp.next;
        }

        temp.next.prev = null;
        temp.next = null;

        return head;
    }
}





// Interview Follow-ups

// 01-  What if the list is circular?
// 02- How would you efficiently delete the tail in a frequently accessed list?
