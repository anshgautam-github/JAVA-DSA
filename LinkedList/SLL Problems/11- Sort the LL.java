    public ListNode sortList(ListNode head) {
        List<Integer> ls=new ArrayList<>();
        ListNode temp=head;
        while(temp!=null){
            ls.add(temp.val);
            temp=temp.next;
        }
        Collections.sort(ls);
        temp=head;
        for(int i=0; i<ls.size(); i++){
            temp.val=ls.get(i);
            temp=temp.next;
        }
        return head;
    }
