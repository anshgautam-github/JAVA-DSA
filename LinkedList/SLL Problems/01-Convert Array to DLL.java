class Solution {
    public ListNode arrayToLinkedList(int [] nums) {
        
        if(nums.length==0) return null;
        ListNode head=new ListNode(nums[0]);
        ListNode prev=head;
        for(int i=1; i<nums.length;i++){
            ListNode temp= new ListNode(nums[i],null,prev);
            prev.next=temp;
            prev=temp;
        }
        return head;

    }
}
