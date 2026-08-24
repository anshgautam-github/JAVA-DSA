// For right rotation, do:
// 1. Reverse the entire array
// 2. Reverse the first k elements
// 3. Reverse the remaining elements


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

    public void rotate(int[] nums, int k) {

        int n = nums.length;
        k = k % n;

        // Reverse entire array
        reverseArray(nums, 0, n - 1);
        // Reverse first k elements
        reverseArray(nums, 0, k - 1);
        // Reverse remaining elements
        reverseArray(nums, k, n - 1);
    }
}


TC : O(n)
SC: O(1)
