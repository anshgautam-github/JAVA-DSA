// Given an array nums, find the sum of elements of array using recursion.

// Input : nums = [1, 2, 3]
// Output : 6
// Explanation : The sum of elements of array is 1 + 2 + 3 => 6.


class Solution {
    public int arraySum(int[] nums) {
        //your code goes here
        int n = nums.length;
        int i=0;
        int ans = helper(n,nums,i);
        return ans;
    }
    public int helper(int n , int []nums, int i){
        if(i>=n) return 0;
        return nums[i] + helper(n,nums, i+1);
    }
}

// Time Complexity : O(N) The time complexity is O(N) because each element in the array is processed exactly once.
// Space Complexity : O(N)The space complexity is O(N) due to the recursion stack, which can grow up to the size of the array.
