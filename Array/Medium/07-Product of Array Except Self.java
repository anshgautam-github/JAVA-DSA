// Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].
// The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
// You must write an algorithm that runs in O(n) time and without using the division operation.
  
// Input: nums = [1,2,3,4]
// Output: [24,12,8,6]




// Bruteforce :

// Don't think: "Always write the if condition for what I am supposed to do."
// Instead think: "First identify which elements should participate in my operation, and make the condition select exactly those elements."
// In your problem: "Multiply every element except the current element."

// int prod = 1

// Ask: "Am I building something?"
// In your code:
// for (int j = 0; j < n; j++) {
//     if (i != j) {
//         prod *= nums[j];
//     }
// }
// We're doing: multiply multiply multiply multiply ... We need to remember the result of all those multiplications.
// Therefore, we need a variable: int prod = 1; This variable is called an accumulator. It accumulates the result as we go.

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int [] ans = new int [n];
        for(int i =0; i<n ; i++){
            int prod =1;
            for(int j=0; j<n; j++){
                if(i!=j){ // if condition
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

// The general lesson is not:
// "Whenever something excludes the current element, use prefix/suffix."
// Rather, think:
// When the answer for each index depends on the elements around it, and repeatedly calculating those elements would be expensive, look for prefix/suffix information.

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




// Optimized :
// Now ask: Do I really need the prefix and suffix arrays? No.
// Look at what happens in the first approach: prefix = [1, 1, 2, 6] We eventually multiply every prefix value by its corresponding suffix value.
// So instead of: prefix[i] , we can put the prefix product directly into ans[i]. That's our first optimization.

// Step 1: Use ans as the prefix array
// After this: ans = [1, 1, 2, 6] . Exactly what our prefix array contained before. So we have eliminated: int[] prefix.

// Step 2: What about the suffix array? We still need the suffix products. But do we need to store them? No! We can maintain just one variable:
// int rightProduct = 1; .and traverse from right to left.

class Solution {

    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
      
        // STEP 1: Store prefix products  directly inside ans
        int leftProduct = 1;
        for (int i = 0; i < n; i++) {
            // Product of everything to the left
            ans[i] = leftProduct;
            // Update product for next index
            leftProduct *= nums[i];
        }
      
        // STEP 2: Calculate suffix productson the fly
        int rightProduct = 1;
        for (int i = n - 1; i >= 0; i--) {
            // ans[i] already contains the left product. Multiply it by the right product.
            ans[i] *= rightProduct;
            // Update right product for next index
            rightProduct *= nums[i];
        }
        return ans;
    }
}
// TC : O(n)
// SC:O(1)
