// Given an array of integers nums, return the value of the largest element in the array

class Solution {
    public int largestElement(int[] nums) {
        int largest = Integer.MIN_VALUE;
        for(int i=0; i<nums.length; i++){
            if(nums[i]>largest) largest = nums[i];
        }
        return largest;
    }
}

// Time Complexity: O(N) , since there is linear traversal of the array, where N is the length of the array.
// Space Complexity: O(1), as only a couple of variables are used



// Interview Follow-ups
  
// How would you handle an empty array or invalid input?

class Solution {

    public int largestElement(int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException("Array cannot be null or empty");
        }
        int largest = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > largest) {
                largest = nums[i];
            }
        }
        return largest;
    }
}
// Option 2: Return a special value You could return something like -1:
// if (nums == null || nums.length == 0) {
//     return -1;
// }
// But this is not always safe. Why? Your array might legitimately contain: [-5, -10, -3] The largest element is -3.
// So -1 could be confused with a legitimate result in some problem settings.
