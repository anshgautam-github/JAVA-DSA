
class Solution {
    public static ArrayList<ArrayList<Integer>> findPairsWithGivenSum(int target,
                                                                      Node head) {
        // code here
        ArrayList<ArrayList<Integer>> res=new ArrayList<>();
        Node first=head;
        Node second=head;
        while(second.next!=null) second=second.next;
        
        while(first.data<second.data){
            if(first.data+second.data == target){
                ArrayList<Integer>pair=new ArrayList<>();
                pair.add(first.data);
                pair.add(second.data);
                res.add(pair);
                first=first.next;
                second=second.prev;
            }else if(first.data+second.data < target){
                first=first.next;
            }else{
                second=second.prev;
            }
        }
        return res;
    }
}
