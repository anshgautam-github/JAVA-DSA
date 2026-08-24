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



// Exactly — that's the important case. If a 0 is already in the part where zeros are supposed to be, we don't count it.
// Let's make the idea very clear.
// What is nonZeroPart? Suppose: nums = [1, 0, 3, 0, 5] There are 2 zeros. So in the final answer, we need: [non-zero, non-zero, non-zero, 0, 0]
// Therefore: nonZeroPart = nums.length - zeroCount  = 5 - 2 = 3
// So: indices:    0   1   2 | 3   4
//             -----------|------
//             non-zero   | zeros
//              region    | region
// The first 3 positions must contain non-zero values.
// The last 2 positions must contain zeros.

// Now your question - What if a zero is not in the non-zero part? That's actually the correct situation, so we don't count it.
// For example: nums = [1, 3, 5, 0, 0]
// There are 2 zeros: zeroCount = 2 Therefore: nonZeroPart = 5 - 2 = 3
// We inspect only: [1, 3, 5] There are no zeros there.
// So: swaps = 0
// And that's correct because the array is already arranged properly: [1, 3, 5, 0, 0] No swaps needed.
