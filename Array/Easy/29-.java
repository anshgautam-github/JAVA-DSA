// Find Common Elements Between Two Arrays
// You are given two integer arrays nums1 and nums2 of sizes n and m, respectively. Calculate the following values:
// answer1 : the number of indices i such that nums1[i] exists in nums2.
// answer2 : the number of indices i such that nums2[i] exists in nums1.
// Return [answer1,answer2]


// Intersection problem: "How many occurrences can actually be matched?" → Two pointers / frequency counting.
// This problem: "Does this value exist anywhere in the other array?" → HashSet.
// That phrase "exists in" should make you think Set.


// WAY -1 

import java.util.*;

class Solution {

    public int[] findIntersectionValues(int[] nums1, int[] nums2) {

        // Store all unique values from nums2
        HashSet<Integer> set2 = new HashSet<>();
        for (int i = 0; i < nums2.length; i++) {
            set2.add(nums2[i]);
        }
        // Store all unique values from nums1
        HashSet<Integer> set1 = new HashSet<>();
        for (int i = 0; i < nums1.length; i++) {
            set1.add(nums1[i]);
        }

        int answer1 = 0;
        int answer2 = 0;

        // Count how many elements of nums1 have a value that exists in nums2
        for (int i = 0; i < nums1.length; i++) {
            if (set2.contains(nums1[i])) {
                answer1++;
            }
        }

        // Count how many elements of nums2 have a value that exists in nums1
        for (int i = 0; i < nums2.length; i++) {
            if (set1.contains(nums2[i])) {
                answer2++;
            }
        }
        return new int[]{answer1, answer2};
    }
 }

// n = nums1.length
// m = nums2.length
// Building the sets: O(n + m) , Checking both arrays: O(n + m)
// Therefore: Time: O(n + m) average
  
// Space:
// set1 → O(n) , set2 → O(m)
// Therefore: Auxiliary Space: O(n + m)

// Why does this handle duplicates correctly?
// Consider: nums1 = [2, 3, 2] , nums2 = [1, 2]
// set2 is: {1, 2}
// Then we check every index of nums1:
// nums1[0] = 2 → set2 contains 2 → answer1 = 1
// nums1[1] = 3 → no                  → answer1 = 1
// nums1[2] = 2 → set2 contains 2 → answer1 = 2
// We don't remove 2 after finding it.





// OPTIMIZED :

// we can optimize the space if we use the constraints of this LeetCode problem.
// The values are bounded (1 <= nums[i] <= 1000), so instead of HashSet, we can use a simple boolean array.

// n = nums1.length
// m = nums2.length
// We scan the arrays a constant number of times: Time: O(n + m)
// The boolean arrays always have only 1001 positions:
// Auxiliary Space: O(1) in terms of the input size, because 1001 is a fixed constant.

  
class Solution {
    public int[] findIntersectionValues(int[] nums1, int[] nums2) {

        // Since values are at most 1000,  we can use the value itself as an index.
        boolean[] present1 = new boolean[1001];
        boolean[] present2 = new boolean[1001];

        // Mark values that exist in nums1
        for (int i = 0; i < nums1.length; i++) {
            present1[nums1[i]] = true;
        }
        // Mark values that exist in nums2
        for (int i = 0; i < nums2.length; i++) {
            present2[nums2[i]] = true;
        }

        int answer1 = 0;
        int answer2 = 0;

        // Count every index in nums1 whose value  exists somewhere in nums2.
        for (int i = 0; i < nums1.length; i++) {
            if (present2[nums1[i]]) {
                answer1++;
            }
        }

        // Count every index in nums2 whose value exists somewhere in nums1.
        for (int i = 0; i < nums2.length; i++) {
            if (present1[nums2[i]]) {
                answer2++;
            }
        }
        return new int[]{answer1, answer2};
    }
}


// The key pattern is:
// If the values have a small, known range, you can often replace a HashSet/HashMap with an array and use the value as the index.
