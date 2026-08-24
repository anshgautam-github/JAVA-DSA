// Given a binary array nums, return the maximum number of consecutive 1's in the array.

// Approach :
// Initialize two variables, count and max_count to 0. Traverse the array and if the current element is 1, increment the count by 1.
// Update max_count if count is greater than max_count.
// If the current element is 0, reset the count variable to 0 and at last return max_count.

class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int cnt = 0;
        int max = 0;
        for(int i = 0 ; i<nums.length; i++){
            if(nums[i]==1) {
                cnt++;
                max=Math.max(cnt,max);
            }else{
                cnt=0;
            }
        }
        return max;
    }
}

// Time Complexity: O(N), as there is single traversal of the array .Here N is the number of elements in the array.
// Space Complexity: O(1), as no additional space is used 





// Interview Follow-ups
// How would you modify the algorithm to return the indices of the maximum segment of consecutive 1s?

class Solution {
    public int[] findMaxConsecutiveOnes(int[] nums) {
        int cnt = 0;
        int start = 0;       // start of current segment
        int max = 0;
        int maxStart = -1;   // start of best segment
        int maxEnd = -1;     // end of best segment

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                // If this is the first 1 of a new segment
                if (cnt == 0) {
                    start = i;
                }
                cnt++;
                // Found a new maximum
                if (cnt > max) {
                    max = cnt;
                    maxStart = start;
                    maxEnd = i;
                }
            } else {
                cnt = 0;
            }
        }
        return new int[]{maxStart, maxEnd};
    }
}

// Time = O(N)
// Auxiliary Space = O(1)
