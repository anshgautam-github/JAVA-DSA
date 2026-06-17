
   class Solution {
    public ListNode insertBeforeKthPosition(ListNode head, int X, int K) {

        if (K == 1) {
            ListNode nn = new ListNode(X);
            nn.next = head;

            if (head != null)
                head.prev = nn;

            return nn;
        }

        int count = 1;
        ListNode temp = head;

        while (temp != null) {
            if (count == K) break;
            count++;
            temp = temp.next;
        }

        if (temp == null) return head; // K exceeds length

        ListNode prev = temp.prev;
        ListNode nn = new ListNode(X);

        prev.next = nn;
        nn.prev = prev;

        nn.next = temp;
        temp.prev = nn;

        return head;
    }




// Interview Follow-ups

// 01-How would this approach change if the list were a singly linked list?
// 02-What if K was given as a negative index (e.g., -1 for inserting before the last node)?

      
}
