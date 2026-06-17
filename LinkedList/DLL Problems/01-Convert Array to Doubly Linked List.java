
class Solution {
    public ListNode arrayToDoublyLinkedList(List<Integer> arr) {
        // Your code goes here
        if (arr == null || arr.size() == 0) return null;
        ListNode head = new ListNode (arr.get(0));
        ListNode prev = head;

        for(int i =1; i<arr.size(); i++){
            ListNode temp = new ListNode(arr.get(i),prev,null);
            prev.next = temp;
            prev = temp;
        }
        return head;
    }

// Time Complexity: O(N) where N is the length of the array. The code iterates over the array once creating a new node for each element.
// Space Complexity: O(N) The space complexity depends on the memory used to store doubly linked list nodes. Each node, storing data and 
// two pointers ('next' and 'back'), requires constant space. Thus, space complexity is O(N) as it scales linearly with the array's size.


  
  
// Interview Follow-ups

// 01- How would you modify this to construct a sorted DLL instead of inserting in array order?
// 02- How would you modify the function to create a circular DLL?

// 01- Insert each element in sorted order using insertion sort logic (O(n²)) or build and sort (O(n log n)).
