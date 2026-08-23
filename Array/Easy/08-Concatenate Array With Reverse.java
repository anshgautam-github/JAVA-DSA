// Construct a new array ans of length 2 * n such that the first n elements are the same as nums, and the next n elements are the elements of
// nums in reverse order.
// Example 1:
// Input: nums = [1,2,3]
// Output: [1,2,3,3,2,1]
// Explanation: The first n elements of ans are the same as nums. For the next n = 3 elements, each element is taken from nums in reverse order

class Solution {
    public int[] concatWithReverse(int[] nums) {
        int n = nums.length;
        int []ans = new int[2*n];
        for (int i=0; i<n; i++){
            ans[i] = nums[i];
            ans[i + n] = nums[n - i - 1];
        }
        return ans;
    }
}

// ans[i] = nums[i] : First half of ans = original nums.
// ans[i + n] = nums[n - i - 1] : Second half of ans = reverse of nums.

// So for: nums = [1, 2, 3] , n = 3 ,the formula itself tells you:

// i = 0:
// ans[0] = nums[0]       → 1
// ans[3] = nums[2]       → 3

// i = 1:
// ans[1] = nums[1]       → 2
// ans[4] = nums[1]       → 2

// i = 2:
// ans[2] = nums[2]       → 3
// ans[5] = nums[0]       → 1

// Giving:ans = [1, 2, 3, 3, 2, 1]


// Time Complexity       → O(N)
// Auxiliary Space       → O(N)
