class Solution {
    public ListNode deleteMiddle(ListNode head) {
        
        if(head==null || head.next==null ) return null;
        ListNode s= head;
        ListNode f=head;
        f=head.next.next;
        while(f!=null && f.next!=null){
            s=s.next;
            f=f.next.next;
        }
        if(s.next!=null){  //if null ka -> next acess kiya -> we may get NPE -> so that's why we check first before acessing the next
            s.next=s.next.next;
        }
        return head;

    }
}
