class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode curr= head;
        ListNode prev=null;
        while(curr!=null){
            ListNode currP1=curr.next;
            curr.next=prev;
            prev=curr;
            curr=currP1;  
        }
        head=prev;
        return head;
    }
}
