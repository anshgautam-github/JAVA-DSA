
class Solution {
    public ListNode deleteAllOccurrences(ListNode head, int target) {
          ListNode temp = head;

        while (temp != null) {
            if (temp.val == target) {
                // Update head if needed
                if (temp == head) {
                    head = temp.next;
                }

                ListNode nextNode = temp.next;
                ListNode prevNode = temp.prev;

                // Update previous node's next
                if (nextNode != null) {
                    nextNode.prev = prevNode;
                }

                // Update next node's previous
                if (prevNode != null) {
                    prevNode.next = nextNode;
                }

                // Delete the current node
                temp = nextNode;
            } else {
                temp = temp.next;
            }
        }

        return head;
    }
}

