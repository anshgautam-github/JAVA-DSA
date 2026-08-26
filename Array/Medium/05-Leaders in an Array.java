// Given an integer array nums, return a list of all the leaders in the array.
// A leader in an array is an element whose value is strictly greater than all elements to its right in the given array. 
// The rightmost element is always a leader. The elements in the leader array must appear in the order they appear in the nums array.
// Example 1
// Input: nums = [1, 2, 5, 3, 1, 2]
// Output: [5, 3, 2]
// Explanation: 2 is the rightmost element, 3 is the largest element in the index range [3, 5], 5 is the largest element in the index range [2, 5]

// The last element is at: index = 5
// So: i = 5 Your inner loop becomes: for (int j = i + 1; j < nums.length; j++)
// Substitute: j = 5 + 1 =>j = 6 And: nums.length = 6 So the loop condition is: j < nums.length which becomes: 6 < 6 False!
// Therefore, the loop body never executes.
// if (nums[j] >= nums[i]) {   // NEVER REACHED
// So there is no attempt to access: nums[6] and therefore no error. ✅ and it will be considered as a leader

 
// BRUTEFORCE : 

public List<Integer> leaders(int[] nums) {
   
        List<Integer> ans = new ArrayList<>();
   
        for (int i = 0; i < nums.length; i++) {
            boolean leader = true;
            /* Check whether nums[i] is greaterthan all elements to its right */
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] >= nums[i]) {
                    /* If any element to the right is greater   or equal, nums[i] is not a leader */
                    leader = false;
                    break;
                }
            }
            // If nums[i] is a leader, add it to the ans list
            if (leader) {
                ans.add(nums[i]);
            }
        }
        // Return the leaders 
        return ans;
    }

// Time Complexity: O(N2), where N is the length of the array, as two nested loops are used to traverse the array.
// Space Complexity: O(N) to store the elements in the answer array and return it.
// Note: The auxiliary space (excluding the output array) is strictly O(1) since no additional intermediate data structures are utilized.





// OPTIMIZED : 
// Approach 
// 1-Set a variable max to the last element of the array (nums[sizeOfArray - 1]), as the last element is always a leader.
// 2-Create an empty list ans to store the leader elements and add the last element of the array to this list initially, as it is always a leader.
// 3-Start from the second last element (index = sizeOfArray - 2) and move towards the first element (index = 0)
// 4-For each element, compare it with the max variable. If the current element is greater than max, add this element to the ans list and update max to the current element.
// 5-Reverse the ans list. It now contains all the leader elements in the order they appear in the array.


class Solution {
    public List<Integer> leaders(int[] nums) {
    List<Integer> ans = new ArrayList<>();
    if (nums.length==0)return ans;

    int max = nums[nums.length-1];
    ans.add(nums[nums.length-1]);

    for(int i=nums.length-2; i>=0; i--){
        if(nums[i]>max){
            ans.add(nums[i]);
            max=nums[i];
        }
    }
    Collections.reverse(ans);
    return ans;
}
    }

// bACK traversl : [1,3,4,6,4,10]
// 10 is alwyas there so we added in the beginnign
// for 4, if it is bigger than 10(max) -> then it can be the leader otheriwse nope.

// Time Complexity: O(N), where N is the length of the array. A single traversal of the array is required.
// Space Complexity: O(N) to store the elements in the answer array and return it.
// Note: The auxiliary space (excluding the output array) is strictly O(1) 
