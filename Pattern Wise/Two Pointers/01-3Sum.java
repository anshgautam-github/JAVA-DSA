// Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
// Notice that the solution set must not contain duplicate triplets.

// Input: nums = [-1,0,1,2,-1,-4]
// Output: [[-1,-1,2],[-1,0,1]]

// Explanation: 
// nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
// nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
// nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
// The distinct triplets are [-1,0,1] and [-1,-1,2].
// Notice that the order of the output and the order of the triplets does not matter.




// Bruteforcw:
import java.util.*;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();
        int n = nums.length;

        // Try every possible combination of 3 numbers
        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                for (int k = j + 1; k < n; k++) {

                    // Check if their sum is 0
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        List<Integer> triplet = Arrays.asList( nums[i], nums[j], nums[k] );
                        
                      // Sort the triplet so duplicates can be identified consistently
                        Collections.sort(triplet);

                        // Add only if this triplet is not already present
                        if (!result.contains(triplet)) {
                            result.add(triplet);
                        }
                    }
                }
            }
        }
        return result;
    }
}


// TC : O(N*3)
// SC:O(1)




// Optimized :

// 3Sum
//   ↓
// Fix 1 number
//   ↓
// Find 2 numbers whose sum = -fixed number
//   ↓
// 2Sum
//   ↓
// Use two pointers
  
// The question explicitly says: solution set must not contain duplicate triplets That's why sorting is even more useful. It lets you easily skip duplicates.


class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        // Sort the array to enable two-pointer approach and skip duplicates
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        int n = nums.length;

        // Iterate through each element as the first element of the triplet
        for (int i = 0; i < n - 2; i++) {
            // Skip duplicate values for the first element
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            // Early termination: if smallest possible sum is positive, no valid triplet
            if (nums[i] > 0) break;
            // Initialize two pointers
            int left = i + 1;
            int right = n - 1;
            // Use two pointers to find pairs that sum to -nums[i]
            while (left < right) {
                int currentSum = nums[i] + nums[left] + nums[right];
                if (currentSum < 0) {
                    // Sum too small, move left pointer right to increase sum
                    left++;
                } else if (currentSum > 0) {
                    // Sum too large, move right pointer left to decrease sum
                    right--;
                } else {
                    // Found a valid triplet
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    // Skip duplicate values for the second element
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    // Skip duplicate values for the third element
                    while (left < right && nums[right] == nums[right - 1]) right--;
                    // Move both pointers inward
                    left++;
                    right--;
                }
            }
        }
        return result;
    }



// TC : O(n*2)
//   for (int i = 0; i < n; i++) {       // O(n)

//     int left = i + 1;
//     int right = n - 1;

//     while (left < right) {          // O(n)
//         ...
//     }
// }

// SC: O(1)
