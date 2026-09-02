// Given an integer array nums of unique elements, return all possible subsets (the power set).
// The solution set must not contain duplicate subsets. Return the solution in any order.

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>(); 
        List<Integer> current = new ArrayList<>(); 
        helper(0, nums.length, nums , ans, current);
        return ans;
    }
    private void helper(int index, int n, int[]nums, List<List<Integer>> ans, List<Integer> current){
        //base case
        if(index==n){
            ans.add(new ArrayList<>(current));
            return;
        }
        //exclude
        helper(index+1, n, nums, ans, current);
        //include
        current.add(nums[index]);
        helper(index+1, n, nums, ans, current);
        current.remove(current.size()-1);
    }
}


// Time Complexity O(2^N): Each element in the array has two choices: either to be included in a subset or not, leading to 2^n possible subsets.
// Space Complexity O(N * 2^N): We generate 2^n subsets, and each subset can have up to n elements. Additionally, the recursion stack can go up to a depth of n.
