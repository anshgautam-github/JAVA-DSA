// Given an integer array nums that may contain duplicates, return all possible subsets (the power set).
// The solution set must not contain duplicate subsets. Return the solution in any order.

class Solution {
  public List<List<Integer>> subsetsWithDup(int[] nums) {
    Arrays.sort(nums);
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> curr = new ArrayList<>();
    backtrack(0, nums, curr, ans);
    return ans;
}

private void backtrack(int index, int[] nums,List<Integer> curr,List<List<Integer>> ans) {

    // LINE 1: Every current path is a valid subset
    ans.add(new ArrayList<>(curr));
  
    // LINE 2: Try choosing each element from index onward
    for (int i = index; i < nums.length; i++) {

        // LINE 3: Skip duplicate choices at the SAME level
        if (i > index && nums[i] == nums[i - 1]) {
            continue;
        }

        // LINE 4: Choose
        curr.add(nums[i]);

        // LINE 5: Go deeper
        backtrack(i + 1, nums, curr, ans);

        // LINE 6: Undo choice
        curr.remove(curr.size() - 1);
    }
}
}

