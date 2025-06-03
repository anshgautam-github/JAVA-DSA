
 class Solution {
     
     public int findLengthOfLoop(ListNode head) {
        ListNode s=head;
        ListNode f=head;
        while(f!=null && f.next!=null){
            s=s.next;
            f=f.next.next;
            if(s==f){
                return findLength(s,f);
            }
        }
        return 0;
     }

     public static int findLength(ListNode s, ListNode f){
        int cnt=1;
        f=f.next;
        while(s!=f){
            cnt++;
            f=f.next;
        }
        return cnt;
     }


 }
