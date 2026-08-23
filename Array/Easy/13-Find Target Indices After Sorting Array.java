// You are given a 0-indexed integer array nums and a target element target. A target index is an index i such that nums[i] == target.
// Return a list of the target indices of nums after sorting nums in non-decreasing order. If there are no target indices, return an empty list. 
// The returned list must be sorted in increasing order.

// Example 1: Input: nums = [1,2,5,2,3], target = 2 , Output: [1,2]
// Explanation: After sorting, nums is [1,2,2,3,5]. The indices where nums[i] == 2 are 1 and 2.


// Bruteforce :
class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        List<Integer> ans = new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0; i<nums.length; i++){
            if(nums[i]==target) ans.add(i);
        }
        return ans;
    }
}
// TC : Sorting + Scanning = Sorting: O(N log N) Scanning: O(N) Overall: Time = O(N log N)
// SC : O(1)




// OPtimized :

// The problem says: after sorting nums It does not necessarily mean you have to actually sort it.
// Because we're only interested in the positions of target after sorting, we can figure them out without sorting.


class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {

        int smaller = 0;
        int equal = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < target) {
                smaller++;
            }
            else if (nums[i] == target) {
                equal++;
            }
        }
        List<Integer> ans = new ArrayList<>();
        for (int i = smaller; i < smaller + equal; i++) {
            ans.add(i);
        }
        return ans;
    }
}

// TC : O(N) + O(N) = O(N)
// SC : O(1)


// We only need to know:
// How many are SMALLER?
//         ↓
//     tells us where TARGET starts

// How many are TARGET?
//         ↓
//     tells us how many positions TARGET occupies
  
// For our example: smaller = 1 ,equal   = 2 ,Therefore: TARGET starts at index 1 TARGET occupies 2 positions indices: 1, 2


// Suppose: nums = [7, 2, 4, 2, 1, 2] , target = 2
// Don't sort it. 

// Just count. Smaller than 2? Only: 1 So: smaller = 1 and Equal to 2? We have: 2, 2, 2 So: equal = 3
// Now imagine sorting: [1, 2, 2, 2, 4, 7]

// Target starts after the 1 smaller number:
// index:  0  1  2  3  4  5
//         1  2  2  2  4  7
//            ↑  ↑  ↑
//            1  2  3
// Answer: [1, 2, 3] We got that without sorting!
