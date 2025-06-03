import java.util.*;
class ListNode {
    int val;
    ListNode next;

    ListNode() {
        val = 0;
        next = null;
    }

    ListNode(int data1) {
        val = data1;
        next = null;
    }

    ListNode(int data1, ListNode next1) {
        val = data1;
        next = next1;
    }
}
 
class Traverse {
  
    public List<Integer> LLTraversal(ListNode head) {
        
        ListNode temp=head;
        List<Integer>res=new ArrayList<>();
        while(temp!=null){
            res.add(temp.val); //add function -> accepts an integer -> so temp.val
            temp=temp.next;  ////first we add then move to the next element 
            
        }
        return res;
        
    }
}   
