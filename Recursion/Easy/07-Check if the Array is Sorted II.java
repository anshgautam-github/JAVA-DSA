class Solution {
    public boolean isSorted(ArrayList<Integer> nums) {
        //your code goes here
        int n = nums.size();
        int i =0;
        return check(n , i , nums);
    }
    private boolean check(int n, int i , ArrayList<Integer> nums){
        if (i>=n-1) return true;
        if(nums.get(i)>nums.get(i+1)) return false;
        return check(n,i+1,nums);
    }
}
