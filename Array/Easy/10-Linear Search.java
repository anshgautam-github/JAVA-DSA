// Given an array of integers nums and an integer target, find the smallest index (0 based indexing) where the target appears in the array. 
// If the target is not found in the array, return -1

class Solution {
    public int linearSearch(int nums[], int target) {
        int n = nums.length;
        for(int i=0;i<n;i++){
            if(nums[i]==target) return i;
        }
        return -1;
    }
}
// TC : O(n)
// SC:O(1)



// Interview Follow-ups
// How would you modify the function to return all indices of the target instead of just the smallest?

import java.util.ArrayList;
class Solution {
    public ArrayList<Integer> linearSearch(int nums[], int target) {
        ArrayList<Integer> indices = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                indices.add(i);
            }
        }
        return indices;
    }
}


// How can linear search be optimized for specific scenarios?

// If the array is sorted, I would use binary search to reduce the search from O(N) to O(log N). If I need to perform many searches on the same 
//   array, I can build a HashSet or HashMap, giving O(1) average lookup after O(N) preprocessing. If the data has a predictable target location,
//   I can also choose the search direction to improve average performance, although the worst case remains O(N)
