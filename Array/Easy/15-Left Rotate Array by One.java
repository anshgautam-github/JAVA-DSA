// Given an integer array nums, rotate the array to the left by one. Note: There is no need to return anything, just modify the given array


class Solution {
    public void rotateArrayByOne(int[] nums) {
         int temp = nums[0];
        for (int i = 1; i < nums.length; i++) {
            nums[i - 1] = nums[i];
        }
        nums[nums.length - 1] = temp;
    }
}

// Time Complexity: O(N), where N is the number of elements in the array. Each element is visited once during the iteration.
// Space Complexity: O(1). The space used does not depend on the size of the input array and remains constant.




// What is the difference between in-place rotation and using extra space?
// - In-Place Rotation: Rearranges elements directly in the original array without using additional memory. It is more space-efficient but
//   often requires more careful handling of indices. - Using Extra Space: Creates a temporary array to hold shifted elements, 
//   simplifying the process but increasing memory usage.
