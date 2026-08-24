// Approach 1: HashSet + Two Pointers
// This is generally the faster approach if you need to preserve the original order.

import java.util.*;

class Solution {
  
    public int removeDuplicates(int[] nums) {
        // Stores elements that we have already seen
        HashSet<Integer> seen = new HashSet<>();
        // i = position where the next unique element should be written
        int i = 0;
        // j = scans through the entire array
        for (int j = 0; j < nums.length; j++) {
            // If we have not seen this element before,
            // it is a new unique element
            if (!seen.contains(nums[j])) {
                // Remember that we have seen this value
                seen.add(nums[j]);
                // Put the unique element in the next
                // available position
                nums[i] = nums[j];
                // Move the write pointer forward
                i++;
            }
        }
        // i represents the number of unique elements
        return i;
    }
}
// Time  → O(N) average
// Space → O(N)



// Approach 2: Sort + Two Pointers
// If the original order doesn't matter, we can first sort the array.

import java.util.*;

class Solution {
    public int removeDuplicates(int[] nums) {
        // Step 1: Sort the array
        // After sorting, duplicates will be next to each other
        Arrays.sort(nums);
        // i = position of the last unique element
        int i = 0;
        // j = scans through the array looking for
        // the next different element
        for (int j = 1; j < nums.length; j++) {
            // If nums[j] is different from the
            // last unique element
            if (nums[i] != nums[j]) {
                // Move to the next position where
                // the new unique element should go
                i++;
                // Copy the new unique element there
                nums[i] = nums[j];
            }
        }
        // Number of unique elements
        return i + 1;
    }
}
// Time  → O(N log N)
// Space → depends on Java's sorting implementation




// The important difference

// HashSet approach 
//   Original:
//   [3, 1, 2, 3, 1]

//   Result: [3, 1, 2]
//   Original order is preserved.

// Sorting approach
//   Original : [3, 1, 2, 3, 1]
//   Sort: [1, 1, 2, 3, 3]
//   Result:[1, 2, 3]
//   Original order is lost.
