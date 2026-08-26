// Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].
// The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
// You must write an algorithm that runs in O(n) time and without using the division operation.
  
// Input: nums = [1,2,3,4]
// Output: [24,12,8,6]

// Bruteforce :
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int [] ans = new int [n];
        for(int i =0; i<n ; i++){
            int prod =1;
            for(int j=0; j<n; j++){
                if(i!=j){
                    prod*=nums[j];
                }
            }
            ans[i] = prod;
        }
        return ans;
    }
}
// TC ; O(N*2)
// SC : O(n)




// Better : 

// Approach 1: Prefix Array + Suffix Array
// First, understand the idea:
// answer[i] = product of everything LEFT of i × product of everything RIGHT of i
// So let's explicitly create both arrays.

// nums = [1, 2, 3, 4]
// prefix: 1  1  2  6
// suffix: 24 12 4  1
// ans :   24 12 8  6
  
class Solution {

    public int[] productExceptSelf(int[] nums) {

        int n = nums.length;

        int[] prefix = new int[n];
        int[] suffix = new int[n];
        int[] ans = new int[n];

        // STEP 1: Build prefix products
        int product = 1;
        for (int i = 0; i < n; i++) {
            // Product of everything before i
            prefix[i] = product;
            // Include nums[i] for the next index
            product *= nums[i];
        }

        // STEP 2: Build suffix products
        product = 1;
        for (int i = n - 1; i >= 0; i--) {
            // Product of everything after i
            suffix[i] = product;
            // Include nums[i] for the next index
            product *= nums[i];
        }
      
        // STEP 3: Prefix × Suffix
        for (int i = 0; i < n; i++) {
            ans[i] = prefix[i] * suffix[i];
        }
        return ans;
    }
}

// Time Complexity :We have three loops, but they are sequential, not nested: O(N) + O(N) + O(N) which is: TC = O(N)
// Space :  prefix → O(N) , suffix → O(N) , ans    → O(N) So: SC = O(N)
