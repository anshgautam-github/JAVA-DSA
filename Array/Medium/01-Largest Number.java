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

// TIME COMPLEXITY : 
    
// Convert numbers to strings
//         ↓
// O(N × L)

// Sort
//         ↓
// O(N log N × L)

// Build result
//         ↓
// O(N × L)

// Convert StringBuilder to String
//         ↓
// O(N × L)
    
// These happen one after another, so technically: O(N x L) + O(N log N) + O(N × L)
// Since O(N log N) dominates O(N): O(N + N log N) = O(N log N) . So we do add the two phases.

// Think about sorting: O(N log N) comparisons
// But each comparison does: (b + a).compareTo(a + b) and comparing strings of length L can take: O(L)
// So we have: Number of comparisons × work per comparison
// O(N log N) × O(L) = O(N log N × L) 
// That's multiplication because the O(L) work is being performed for every comparison.

// Why don't we write O(N + N log N + N)?

// We actually can when each operation is constant-time: O(N) + O(N log N) + O(N) = O(N log N)
// Here, because string operations depend on the number of characters, we use L:
// O(NL) + O(N log N L) + O(NL) = O(N log N L)




// SPACE COMPLEXITY :
// String[] arr We create: String[] arr = new String[nums.length]; There are N strings: N strings × up to L characters
// So technically: O(N × L) space. If we treat the number of digits L as a constant, this becomes:
// O(N).
