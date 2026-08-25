// You don't need to collect all missing numbers. nums = [10, 11, 13, 15]
// Range: 10, 11, 12, 13, 14, 15 : Missing: 12, 14
// Largest missing = 14

// HashSet Approach :

import java.util.*;
class Solution {
    public int largestMissing(int[] nums) {

        int small = Integer.MAX_VALUE;
        int large = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {

            if (nums[i] < small) {
                small = nums[i];
            }

            if (nums[i] > large) {
                large = nums[i];
            }
        }

        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        // Search from largest to smallest
        for (int i = large; i >= small; i--) {

            if (!set.contains(i)) {
                return i;
            }
        }
        return -1;
    }


// All missing numbers → scan small → large
// Smallest missing number → scan small → large
// Largest missing number → scan large → small
}


// HashSet : → O(N) average time → O(N) space




// If you want O(1) auxiliary space, you cannot use a HashSet or frequency array.
// The easiest O(1)-space approach is to sort the array first and then scan from the end.
import java.util.*;

class Solution {
    public int largestMissing(int[] nums) {

        // Sort the array
        Arrays.sort(nums);
      
        // Start from the largest element
        for (int i = nums.length - 1; i > 0; i--) {
            // If there is a gap between two consecutive elements, then nums[i] - 1 is missing.
            if (nums[i] - nums[i - 1] > 1) {
                return nums[i] - 1;
            }
        }
        // If no gap was found, there is no missing number
        return -1;
    }
}
// Sorting       → O(N log N)
// Scanning      → O(N)

// Total TC      → O(N log N)
// Auxiliary SC  → O(1)*
