// Given an integer array nums and a non-negative integer k, rotate the array to the left by k steps.

// Example 1
// Input: nums = [1, 2, 3, 4, 5, 6], k = 2
// Output: nums = [3, 4, 5, 6, 1, 2]
// Explanation:
// rotate 1 step to the left: [2, 3, 4, 5, 6, 1]
// rotate 2 steps to the left: [3, 4, 5, 6, 1, 2]


//BRUTEFORCE : 
class Solution {
    public void rotateArray(int[] nums, int k) {
        int n = nums.length; // Size of array
        k = k % n; // To avoid unnecessary rotations
      
        int[] temp = new int[k];
        // Store first k elements in a temporary array
        for (int i = 0; i < k; i++) {
            temp[i] = nums[i];
        }
        // Shift n-k elements of given array to the front
        for (int i = k; i < n; i++) {
            nums[i - k] = nums[i];
        }
        // Copy back the k elements at the end
        for (int i = 0; i < k; i++) {
            nums[n - k + i] = temp[i];
        }
    }
}
// Time Complexity: O(N), where N is the length of the array. 
// Three loops are used taking K, N-K, and K iterations respectively contributing to O(N+K). 
// However, K can be N-1 in the worst case boiling down the time complexity as O(N).
// Space Complexity: O(K), due to the temporary list created to copy the K elements.


// // OPTIMAL :

// Reverse the first k elements of the array.
// Reversing the remaining elements (from position k to the end of the array) 
// Finally, on reversal of the entire array


class Solution {
  
    private void reverseArray(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    public void rotateArray(int[] nums, int k) {
        int n = nums.length;
        k = k % n; 
        // Reverse the first k elements
        reverseArray(nums, 0, k - 1);
        // Reverse the last n-k elements
        reverseArray(nums, k, n - 1);
        // Reverse the entire array
        reverseArray(nums, 0, n - 1);
    }
}

// Time Complexity: O(N), where N is the size of the array
// As three reversals are performed taking O(k), O(N-k) and O(N) time respectively.

// Space Complexity: O(1), as no extra space is used .
