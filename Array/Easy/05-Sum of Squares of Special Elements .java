// You are given a 1-indexed integer array nums of length n.
// An element nums[i] of nums is called special if i divides n, i.e. n % i == 0.
// Return the sum of the squares of all special elements of nums.

// Very important rule for LeetCode Whenever a question says: "The array is 1-indexed" ,don't think:
// "Java array has become 1-indexed." Instead think: "The problem is referring to positions starting from 1." 
// Your Java array still starts at index 0.

class Solution {
    public int sumOfSquares(int[] nums) {
        int sum =0;
        int n=nums.length;
        for (int i =0; i<n; i++){
            int position= i+1;
            if(n%position==0) {
                sum+=nums[i]*nums[i];
        }}
        return sum;
    }
}

// TC : O(n)
// SC : O(1)


// WRONG :
// class Solution {
//     public int sumOfSquares(int[] nums) {
//         int sum =0;
//         int n=nums.length;
//         for (int i =0; i<n; i++){
//             if(n%i==0) {
//                 sum+=nums[i]*nums[i];
//         }}
//         return sum;
//     }
// }
