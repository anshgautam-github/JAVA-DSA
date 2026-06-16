
class Solution {
    public ListNode insertBeforeX(ListNode head, int X, int val) {
        //YOUR CODE GOES HERE
        ListNode temp = head;
        ListNode nn = new ListNode(val);
        if(head==null) return null;
        if (head.data==X){
            nn.next=head;
            head=nn;
            return head;
        }
       

        while(temp!=null && temp.next!=null){ 
            if(temp.next.data==X){
                nn.next=temp.next;
                temp.next=nn;
                break;
            }
            temp=temp.next;
        }
        return head;
    }
}

// Time Complexity: O(N) worst case, when insertion happens at the tail and O(1) best case, when insertion happens at the head.
// Space Complexity: O(1) as we have not used any extra space.


// Interview Follow-ups

// 01- How would you handle a scenario where X is guaranteed to appear multiple times, and you want to insert 
// only before the last occurrence of X?
// 02- What optimizations can you apply if you frequently insert before a specific value like X?
