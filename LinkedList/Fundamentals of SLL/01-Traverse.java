class Solution {
    public List<Integer> LLTraversal(ListNode head) {
        //your code goes here
        ListNode temp = head;
        List<Integer> ans = new ArrayList<>();
        while(temp!=null){
            ans.add(temp.data);
            temp=temp.next;
        }
        return ans;
    }

    
// Time Complexity: O(N) since we are visiting each node once. Here N represents the length of the linked list 
// Space Complexity: O(1) (Auxiliary Space). The algorithm only uses a constant amount of extra space for the traversal pointer


// Interview Follow-ups

// 01 -  What if you need to reverse the traversal order?
// 02 - Can this algorithm be parallelized?

// 01 - Use a stack to store the values during traversal and pop elements from the stack to get them in reverse order. 
//     Alternatively, reverse the array after traversal.

// 02 - Traversing a singly linked list cannot be parallelized because each node depends on the next pointer of the previous node. 
//      However, parallelization is possible for tasks performed on the data after traversal.



    // Approach 01 :

    public List<Integer> reverseTraversalStack(ListNode head) {
    Stack<Integer> stack = new Stack<>();
    ListNode temp = head;

    // Push all elements into the stack
    while (temp != null) {
        stack.push(temp.data);
        temp = temp.next;
    }

    List<Integer> ans = new ArrayList<>();

    // Pop elements to get reverse order
    while (!stack.isEmpty()) {
        ans.add(stack.pop());
    }

    return ans;
}



    // Approach 02 :

    public List<Integer> reverseTraversalReverseList(ListNode head) {
    List<Integer> ans = new ArrayList<>();
    ListNode temp = head;

    // Store elements in normal order
    while (temp != null) {
        ans.add(temp.data);
        temp = temp.next;
    }

    // Reverse the list
    Collections.reverse(ans);

    return ans;
}
