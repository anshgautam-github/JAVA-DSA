
public class Solution {
    public ListNode getIntersectionNode(ListNode head1, ListNode head2) {
        if (head1 == null || head2 == null) return null;

        ListNode t1 = head1;
        ListNode t2 = head2;

        // Loop until t1 and t2 meet
        while (t1 != t2) {
            // Move to the next node, or switch to the other list's head when null
            t1 = (t1 == null) ? head2 : t1.next;
            t2 = (t2 == null) ? head1 : t2.next;
        }

        // Return either t1 or t2 (both are the intersection point or null if no intersection)
        return t1;
    }
}
