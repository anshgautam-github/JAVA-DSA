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
        if(s.next!=null){
            s.next=s.next.next;
        }
        return head;

    }
}
