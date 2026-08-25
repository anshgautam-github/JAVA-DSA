// You are given two integer arrays nums1 and nums2, sorted in non-decreasing order, and two integers m and n, representing the number of elements in nums1 and nums2 respectively.
// Merge nums1 and nums2 into a single array sorted in non-decreasing order.
// The final sorted array should not be returned by the function, but instead be stored inside the array nums1. 
// To accommodate this, nums1 has a length of m + n, where the first m elements denote the elements that should be merged, and the last n elements are set to 0 and should be ignored. nums2 has a length of n.

class Solution {

    public void merge(int[] nums1, int n, int[] nums2, int m) {
        // i points to the last actual element in nums1
        int i = n - 1;
        // j points to the last element in nums2
        int j = m - 1;
        // k points to the last position of nums1
        int k = n + m - 1;

        // Compare elements from the back and place the larger element at position k.
        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[k] = nums1[i];
                i--;
            } else {
                nums1[k] = nums2[j];
                j--;
            }
            k--;
        }
        // If nums2 still has elements, copy them into nums1. We don't need a similar loop for nums1  because its remaining elements are already in their correct positions.
        while (j >= 0) {
            nums1[k] = nums2[j];
            j--;
            k--;
        }
    }
}


// The really important interview takeaway is:
// When one sorted array has extra empty space at its end, merge from the BACK, not the front.
// That lets you modify nums1 in-place without needing another array.

// If we merge from the front, we would overwrite values in nums1 that we still need. Instead, start from the back.
// We have three pointers:
// i = n - 1 ,points to the last actual element in nums1.
// j = m - 1 ,points to the last element of nums2.
// k = n + m - 1 ,points to the last position of nums1.

// nums1 = [1,2,3,0,0,0]
// nums2 = [2,5,6]
// Initially:
// i = 2 → nums1[i] = 3
// j = 2 → nums2[j] = 6
// k = 5

// Compare:

// 3 vs 6 : 6 is bigger, so put it at the back: nums1 = [1,2,3,0,0,6]
// Then: j-- k--

// Now: 3 vs 5 Put 5: [1,2,3,0,5,6]
// Then: 3 vs 2 Put 3: [1,2,3,3,5,6]
// Then: 2 vs 2 Put 2: [1,2,2,3,5,6]
// Done.



// TC : 
// How many times can the main loop run?
// There are:
// n elements in nums1
// m elements in nums2
// At every iteration, we consume one element from either nums1 or nums2.
// Therefore, in the worst case, we process at most:n + m elements.
// So: Main loop = O(n + m)

// SC : O(1)
