// Given an array nums of n integers where nums[i] is in the range [1, n], return an array of all the integers in the range [1, n] 
// that do not appear in nums.
// Example 1:
// Input: nums = [4,3,2,7,8,2,3,1]
// Output: [5,6]

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length;
        List<Integer>ans= new ArrayList<>();
        int [] hash = new int[n+1];

        for(int i=0; i<n; i++){
            int num = nums[i];
            hash[num]++;
        }
        for(int i=1; i<=n; i++){
            if(hash[i]==0) ans.add(i);
        }
        return ans;
    }
}



// Follow up: Could you do it without extra space and in O(n) runtime? You may assume the returned list does not count as extra space.
