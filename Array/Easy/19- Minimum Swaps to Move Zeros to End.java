// You are given an integer array nums.In one operation, you can choose any two distinct indices i and j and swap nums[i] and nums[j].
// Return an integer denoting the minimum number of operations required to move all 0s to the end of the array.

// Example 1:
// Input: nums = [0,1,0,3,12]
// Output: 2
  
// Explanation:
// Swap nums[0] and nums[3], giving nums = [3, 1, 0, 0, 12].
// Swap nums[2] and nums[4], giving nums = [3, 1, 12, 0, 0].
// Thus, the answer is 2.

class Solution {
    public int minimumSwaps(int[] nums) {
        int zeroCount = 0;
        // Count total zeros
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                zeroCount++;
            }
        }
        // Number of positions that should contain non-zero elements
        int nonZeroPart = nums.length - zeroCount;
        int swaps = 0;
        // Count zeros that are incorrectly present
        // in the non-zero part
        for (int i = 0; i < nonZeroPart; i++) {
            if (nums[i] == 0) {
                swaps++;
            }
        }
        return swaps;
    }
}

// Time = O(N)
// Auxiliary Space = O(1).
