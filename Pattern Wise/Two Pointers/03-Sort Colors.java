// You are given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color are adjacent, 
// with the colors in the order red, white, and blue.
// We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.
// You must solve this problem without using the library's sort function.

// Input: nums = [2,0,2,1,1,0]
// Output: [0,0,1,1,2,2]
// Explanation: The array has two 0s, two 1s, and two 2s. Sorting them in-place places all 0s first, then all 1s, then all 2s.



// Bruteforce :
// "I know there are only three types. I'll count how many 0s, 1s and 2s there are, then overwrite the array."
// For example: [2, 0, 2, 1, 1, 0]
// Count:
// 0 → 2
// 1 → 2
// 2 → 2
// Then rewrite: [0, 0, 1, 1, 2, 2]

class Solution {
    public void sortColors(int[] nums) {
        int red =0;
        int white = 0;
        int blue = 0;
        for(int i=0; i<nums.length; i++){
            if(nums[i]==0) red++;
            else if(nums[i]==1) white++;
            else blue++;
        }
        
        int index =0;
        while(red>0){
            nums[index++]=0;
            red--;
        }
        while(white>0){
            nums[index++]=1;
            white--;
        }
        while(blue>0){
            nums[index++]=2;
            blue--;
        }
    }
}

// This is actually O(2n)= O(n) time and O(1) extra space.
