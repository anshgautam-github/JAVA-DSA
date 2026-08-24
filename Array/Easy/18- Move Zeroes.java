// Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.
// Note that you must do this in-place without making a copy of the array.
// Example 1:
// Input: nums = [0,1,0,3,12]
// Output: [1,3,12,0,0]


// BRUTEFORCE 

// 1- Declare a temporary array to store all the non-zero elements. Traverse the original array and copy all non-zero elements to the temporary array.
// 2- Overwrite the original array's starting positions with the elements from the temporary array.
// 3- Fill the remaining positions in the original array with zeros.
class Solution {
  
    public void moveZeroes(int[] nums) {
        int n = nums.length;
        // Create a temporary array to store non-zero elements
        int[] temp = new int[n];
        int count = 0;
        // Copy non-zero elements to temp
        for (int i = 0; i < n; i++) {
            if (nums[i] != 0) {
                temp[count++] = nums[i];
            }
        }
        // Copy non-zero elements back to nums
        for (int i = 0; i < count; i++) {
            nums[i] = temp[i];
        }
        // Fill the rest with zeroes
        for (int i = count; i < n; i++) {
            nums[i] = 0;
        }
    }
}
// Time Complexity: O(2*N), O(N) for copying non-zero elements from the original to the temporary array. O(X) for again copying it back from temp
// to the original array. O(N-X) for filling zeros in the original array. Here N is the size of the array and X is the number of non-zero elements.
// Space Complexity: O(N), for using a temporary array to solve this problem and the maximum size of the array can be N in the worst case.



// Optimized :

// 1-Start by taking two pointers, i and j. Initialize j = 0. The pointer j will track the position where the next non-zero element should be placed.
// 2-Traverse the array using pointer i from index 0 to n − 1.
// 3-Whenever i encounters a non-zero element, swap the elements at positions i and j. This moves the non-zero element toward the front of the array.
// 4-After performing the swap, increment j by 1. This updates j to the next position where the following non-zero element should be placed.
// 5-If the current element at i is zero, simply move i forward without making any changes.
// 6-Repeat the process until i reaches the end of the array
class Solution {
    public void moveZeroes(int[] nums) {
        // j keeps track of where the next non-zero should be placed
        int j = 0;
        // Loop through all elements
        for (int i = 0; i < nums.length; i++) {
            // If current element is non-zero
            if (nums[i] != 0) {
                // Swap current element with the one at index j
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                // Move j forward
                j++;
            }
        }
    }
}
// Time Complexity: O(N), where N is size of the array, as we are traversing the array once. O(x) + O(n-x) = O(n)
// Space Complexity: O(1) , as no use of any extra space is done to solve this problem.




// Interview Follow-ups

// How would you modify the algorithm to move all zeros to the beginning instead?
class Solution {
    public void moveZeroesToBeginning(int[] nums) {
        // j keeps track of where the next zero should be placed
        int j = 0;
        // Loop through all elements
        for (int i = 0; i < nums.length; i++) {
            // If current element is zero
            if (nums[i] == 0) {
                // Swap current zero with element at j
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                // Move j forward
                j++;
            }
        }
    }
}
// To move zeros to the beginning: - Iterate through the array from right to left. - Shift non-zero elements to the rightmost available position, 
// and place zeros at the beginning. - This maintains the relative order of non-zero elements.

// Time Complexity: O(N)
// Space Complexity: O(1) 
