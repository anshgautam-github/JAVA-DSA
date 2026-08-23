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
 
