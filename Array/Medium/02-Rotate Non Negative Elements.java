// You are given an integer array nums and an integer k.
// Rotate only the non-negative elements of the array to the left by k positions, in a cyclic manner.
// All negative elements must stay in their original positions and must not move.
// After rotation, place the non-negative elements back into the array in the new order, filling only the positions that originally contained 
// non-negative values and skipping all negative positions. Return the resulting array.

// Example 1:
// Input: nums = [1,-2,3,-4], k = 3
// Output: [3,-2,1,-4]

// Explanation:​​​​​​​
// The non-negative elements, in order, are [1, 3]. Left rotation with k = 3 results in: [1, 3] -> [3, 1] -> [1, 3] -> [3, 1]
// Placing them back into the non-negative indices results in [3, -2, 1, -4].


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

    public int[] rotateElements(int[] nums, int k) {
        // Step 1: Count non-negative elements
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= 0) {
                count++;
            }
        }

        // No non-negative elements
        if (count == 0) {
            return nums;
        }

        // Step 2: Put non-negative elements into a separate array
        int[] arr = new int[count];
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= 0) {
                arr[j] = nums[i];
                j++;
            }
        }

        // Step 3: Rotate the non-negative array
        int n = arr.length;
        k = k % n;
        reverseArray(arr, 0, k - 1);
        reverseArray(arr, k, n - 1);
        reverseArray(arr, 0, n - 1);

        // Step 4: Put rotated elements back
        j = 0;
        for (int i = 0; i < nums.length; i++) {

            if (nums[i] >= 0) {
                nums[i] = arr[j];
                j++;
            }
        }
        return nums;
    }
}




// Let's see why Step 4 is necessary
// Suppose: nums = [1, -2, 3, -4] ; After extraction: arr = [1, 3] ; After rotating arr: arr = [3, 1]
// But notice: the original nums hasn't changed yet! It is still: [1, -2, 3, -4]
// So we have to put the rotated values back:
// index 0 → take arr[0] = 3
// index 1 → negative → skip
// index 2 → take arr[1] = 1
// index 3 → negative → skip

// Result: [3, -2, 1, -4]
