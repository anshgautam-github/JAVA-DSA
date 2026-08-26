// You are given a 0-indexed integer array nums of even length consisting of an equal number of positive and negative integers.
// You should return the array of nums such that the array follows the given conditions:

// Every consecutive pair of integers have opposite signs.
// For all integers with the same sign, the order in which they were present in nums is preserved.
// The rearranged array begins with a positive integer.
// Return the modified array after rearranging the elements to satisfy the aforementioned conditions.
  
// Input: nums = [3,1,-2,-5,2,-4]
// Output: [3,-2,1,-5,2,-4]





// BRUTEFORCE :

// First, don't worry about optimization.
// Ask: "How do I get all positive numbers and all negative numbers while preserving their original order?"
// We can make two separate lists: positive = [3, 1, 2] , negative = [-2, -5, -4]
// Then combine them: positive[0], negative[0], positive[1], negative[1], positive[2], negative[2] giving: [3, -2, 1, -5, 2, -4]. equal no of pos neg given import java.util.*;

class Solution {

    public int[] rearrangeArray(int[] nums) {

        List<Integer> positive = new ArrayList<>();
        List<Integer> negative = new ArrayList<>();
        // Step 1: Separate positives and negatives
        for (int i = 0; i < nums.length; i++) {

            if (nums[i] > 0) {
                positive.add(nums[i]);
            } else {
                negative.add(nums[i]);
            }
        }

        // Step 2: Create result array
        int[] ans = new int[nums.length];
        int index = 0;
        // Step 3: Alternate positive and negative
        for (int i = 0; i < positive.size(); i++) {
            ans[index++] = positive.get(i);
            ans[index++] = negative.get(i);
        }
        return ans;
    }
}
// Time Complexity: O(N+N/2), where N is the size of the array. O(N) for traversing the array once for segregating positives and negatives and another O(N/2) for adding those elements alternatively to the array.
// Space Complexity: O(N/2 + N/2) = O(N), N/2 space required to store each of the positive and negative elements in separate arrays.



// OPTIMAL :


// What should your brain notice?
// There are three important clues in the question:

// Clue 1: "Begins with positive" So: index 0 → positive
  
// Clue 2: "Every consecutive pair has opposite signs"
// Therefore:
// index 0 → positive
// index 1 → negative
// index 2 → positive
// index 3 → negative
// index 4 → positive
// index 5 → negative
// So we immediately know the destination positions. Positive positions: 0, 2, 4, 6, ...
// Negative positions: 1, 3, 5, 7, ...
// ⭐ This is the big trick.
// Instead of asking:"Where should I put this number?"
// we can say: "If it's positive, the next available even index is its destination. If it's negative, the next available odd index is its destination."

// Clue 3: Now think about pointers
// We need two destination pointers: positiveIndex = 0 , negativeIndex = 1
// Why? Because: 0 → first positive position 2 → second positive position 4 → third positive position So whenever we find a positive:
// ans[positiveIndex] = num;
// positiveIndex += 2;


// Aha! 💡 We don't actually need to create the two lists. We already know where each type belongs.
// Index:      0    1    2    3    4    5
//             +    -    +    -    +    -
// Therefore: positive → even indexes , negative → odd indexes
// So instead of:
// nums
//  ↓
// positive list
// negative list
//  ↓
// combine
// we can directly do:
// nums
//  ↓
// look at each element
//  ↓
// positive → next even index
// negative → next odd index

class Solution {
    public int[] rearrangeArray(int[] nums) {

        int n = nums.length;
        int[] ans = new int[n];
        // Even indices are reserved for positive numbers
        int positiveIndex = 0;
        // Odd indices are reserved for negative numbers
        int negativeIndex = 1;
      
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                // Put positive number in next even position
                ans[positiveIndex] = nums[i];
                // Next positive position
                positiveIndex += 2;
            } else {
                // Put negative number in next odd position
                ans[negativeIndex] = nums[i];
                // Next negative position
                negativeIndex += 2;
            }
        }
        return ans;
    }
}

// Time Complexity: O(N), for traversing the array only once where N is the length of the array.
// Space Complexity: O(N) to store the resultant array.



// But how would I discover this in an interview?

// When you see a rearrangement problem, don't immediately think of sorting, swapping, or nested loops.

// Ask these questions in order:

// Question 1: What must the final positions look like?
// Here:
// + - + - + -
// That immediately gives: even indices → + , odd indices → -

// Question 2: Does relative order matter? Yes.
// The problem says the order among same-sign elements must be preserved.
// So: positives: 3 → 1 → 2 , must stay: 3 → 1 → 2 Therefore, don't sort them.
  
// Question 3: Do I need to search for a position? No!
// The sign itself tells us exactly where the element goes: positive → next even position , negative → next odd position
// That eliminates searching. And once you eliminate searching, you get: ONE PASS → O(n).
