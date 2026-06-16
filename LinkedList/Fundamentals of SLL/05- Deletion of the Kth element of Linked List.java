class Solution {
   public ListNode deleteKthNode(ListNode head, int k) {
    if (head == null) return null;

    if (k == 1) return head.next;

    ListNode temp = head;
    ListNode prev = null;
     
    int count = 1;

    while (temp != null) {
        if (count == k) {
            prev.next = temp.next;
            break;
        }

        prev = temp;
        temp = temp.next;
        count++;
    }

    return head;
}

// Time Complexity: O(N) worst case, when deleting the tail and O(1) best case, when deleting the head.
// Space Complexity: O(1) no extra space used.
