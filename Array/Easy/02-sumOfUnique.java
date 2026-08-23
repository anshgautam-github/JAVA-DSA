class Solution {
    public int sumOfUnique(int[] nums) {
        int [] count = new int[101];
        for (int i = 0; i < nums.length; i++) {
            count[nums[i]]++;
        }
        int sum =0;
        for(int i=0;i<nums.length;i++){
            if(count[nums[i]]==1){
                sum+=nums[i];
            }
        }
        return sum;
    }
}

// TC - O(n) - first loop is O(N), second loop is O(N).
// SC - O(1) - count has only 101 positions because the values are limited to 1–100.


// If there were no constraint like 1 <= nums[i] <= 100, then we should not use int[101], because we don't know the range of the numbers.
// Instead, use a HashMap to store the frequency of each number.

import java.util.HashMap;
class Solution {
    public int sumOfUnique(int[] nums) {
        HashMap<Integer, Integer> count = new HashMap<>();
        // Count frequency of each element
        for (int i = 0; i < nums.length; i++) {

            if (count.containsKey(nums[i])) {
                count.put(nums[i], count.get(nums[i]) + 1);
            } else {
                count.put(nums[i], 1);
            }
        }
        int sum = 0;
        // Add elements that appeared exactly once
        for (int i = 0; i < nums.length; i++) {
            if (count.get(nums[i]) == 1) {
                sum += nums[i];
            }
        }
        return sum;
    }
}
 
// Time: O(N) First loop → O(N) Second loop → O(N) HashMap operations (get, put, containsKey) are O(1) average, So overall: O(N)
// Auxiliary Space: O(N) The HashMap could contain N different elements. In the worst case, every element is different:
