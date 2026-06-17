class Solution {
    public ListNode insertBeforeTail(ListNode head, int X) {

        if (head == null)
            return new ListNode(X);

        if (head.next == null) {
            ListNode newHead = new ListNode(X, null, head);
            head.prev = newHead;
            return newHead;
        }

        ListNode temp = head;

        while (temp.next.next != null) {
            temp = temp.next;
        }

        ListNode tail = temp.next;
        ListNode nn = new ListNode(X);

        temp.next = nn;
        nn.prev = temp;

        nn.next = tail;
        tail.prev = nn;

        return head;
    }
}

// Time Complexity: O(N) where N is the length of the array. We iterate through the input array exactly once and at each element perform constant
// time operations.
// Space Complexity: O(1) as no extra space is used.



// Interview Follow-ups

// How would you modify the solution if you were allowed to insert after the tail instead?
// How does this compare to inserting at arbitrary position?
