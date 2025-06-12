/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;

        ListNode mid = middle(head);
        ListNode h2 = mid.next;
        mid.next = null;         // Cut the list
        h2 = reverse(h2);        // Reverse second half
        reorder(head, h2);       // Merge both halves
    }

    private ListNode middle(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private ListNode reverse(ListNode head) {
        ListNode prev = null, curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    private void reorder(ListNode h1, ListNode h2) {
        while (h1 != null && h2 != null) {
            ListNode temp1 = h1.next;
            ListNode temp2 = h2.next;

            h1.next = h2;
            h2.next = temp1;

            h1 = temp1;
            h2 = temp2;
        }
    }
}
