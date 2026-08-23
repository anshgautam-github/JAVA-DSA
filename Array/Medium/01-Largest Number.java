// Given a list of non-negative integers nums, arrange them such that they form the largest number and return it.
// Since the result may be very large, so you need to return a string instead of an integer.
// Example 1: Input: nums = [10,2] , Output: "210"


import java.util.*;

class Solution {
    public String largestNumber(int[] nums) {
      
        String[] arr = new String[nums.length];
        // Convert integers to strings
        for (int i = 0; i < nums.length; i++) {
            arr[i] = String.valueOf(nums[i]);
        }
        // Custom sorting
        Arrays.sort(arr, (a, b) -> {
            return (b + a).compareTo(a + b);
        });
        // Handle case like [0, 0]
        if (arr[0].equals("0")) {
            return "0";
        }
      
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            result.append(arr[i]);
        }
        return result.toString();
    }
}
