


class Solution {
    public void rotateArrayByOne(int[] nums) {

        int temp = nums[nums.length - 1];

        for (int i = nums.length - 1; i > 0; i--) {
            nums[i] = nums[i - 1];
        }

        nums[0] = temp;
    }
}

// Why do we loop backwards? 

// Suppose: nums = [1, 2, 3, 4, 5]
// First save the last element: temp = 5 Then:
// i = 4 → nums[4] = nums[3] → [1,2,3,4,4]
// i = 3 → nums[3] = nums[2] → [1,2,3,3,4]
// i = 2 → nums[2] = nums[1] → [1,2,2,3,4]
// i = 1 → nums[1] = nums[0] → [1,1,2,3,4]
// Finally: nums[0] = temp; gives: [5, 1, 2, 3, 4]
