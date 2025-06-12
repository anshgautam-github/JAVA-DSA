class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        
        ListNode s=head;
        ListNode f=head;
        
        for(int i=0;i<n;i++){
            f=f.next;
        }

        if (f == null) {
            return head.next;
        }

        while(f.next!=null){
            s=s.next;
            f=f.next;
        }
        s.next=s.next.next;
        return head;

    }
}


/*

 public ListNode removeNthFromEnd(ListNode head, int n) {
       if (head == null) {
            return null;
        }
        int cnt = 0;
        ListNode temp = head;

        while (temp != null) {
            cnt++;
            temp = temp.next;
        }
        if (cnt == n) {
            return head.next;
        }
        temp=head;
        int len=cnt-n;
        for(int i=0;i<len-1;i++){
            temp=temp.next;
        }

        
        // Delete the Nth node from the end
        temp.next = temp.next.next;
        return head;
    }   

*/
