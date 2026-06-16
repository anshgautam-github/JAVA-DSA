
class Solution {
   
    public ListNode insertAtKthPosition(ListNode head, int X, int K) {
        if (head == null) {
            if (K == 1)
                return new ListNode(X);
            else
                return head;
        }
        if (K == 1)
            return new ListNode(X, head);

        int cnt = 0;
        ListNode temp = head;

        while (temp != null) {
            cnt++;
            if (cnt == K - 1) {
                ListNode newNode = new ListNode(X, temp.next);
                temp.next = newNode;
                break;
            }
            temp = temp.next;
        }

        return head;
    }
}


// Time Complexity: O(N) worst case, when insertion happens at the tail and O(1) best case, when insertion happens at the head.
// Space Complexity: O(1) no extra space used.



// Interview Follow-ups

// 01- How would you handle circular linked lists?
// 02- What if the list is sorted?

// 01- For circular linked lists: Traverse the list to the (K−1)-th node. 
//     Insert the new node and update pointers to maintain the circular structure.
// 02- If the list is sorted, traverse the list to find the correct position based on X’s value and insert the new node there.
