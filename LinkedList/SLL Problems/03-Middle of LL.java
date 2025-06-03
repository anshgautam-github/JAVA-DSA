 public ListNode middleOfLinkedList(ListNode head) {
            ListNode s=head;
            ListNode f=head;
            while(f!=null && f.next!=null){
                f=f.next.next;
                s=s.next;
            }
            return s;

}
