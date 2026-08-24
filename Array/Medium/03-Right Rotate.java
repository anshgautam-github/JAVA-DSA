// For right rotation, do:
// 1. Reverse the entire array
// 2. Reverse the first k elements
// 3. Reverse the remaining elements

//BRUTEFORCE: 
class Solution {

    private void rotateByOne(int[] nums) {
        int n = nums.length;
        // Save last element
        int temp = nums[n - 1];
        // Shift everything to the right
        for (int i = n - 1; i > 0; i--) {
            nums[i] = nums[i - 1];
        }
        // Put last element at the front
        nums[0] = temp;
    }

    public void rotate(int[] nums, int k) {

        int n = nums.length;
        k = k % n;
        // Rotate one position, k times
        for (int i = 0; i < k; i++) {
            rotateByOne(nums);
        }
    }
}


// Time Complexity: O(N × K)
// Look at rotateByOne(): for (int i = n - 1; i > 0; i--) This runs N - 1 times → O(N).
// Now we call rotateByOne() K times: for (int i = 0; i < k; i++) So: O(K) × O(N) = O(NK)
// Technically, because we do: k = k % n; k < n afterward, so the worst case is still O(N²).

// Space Complexity: O(1)



// OPTMIZED
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


// TC : O(n)
// SC: O(1)
