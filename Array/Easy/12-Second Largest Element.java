// Given an array of integers nums, return the second-largest element in the array. If the second-largest element does not exist, return -1.

// BRUTEFORCE :
class Solution {
    public int secondLargestElement(int[] nums) {
        int n = nums.length;
        if (n < 2) {
            return -1; 
        }
        Arrays.sort(nums);
        int largest = nums[n - 1];
        int secondLargest = -1;
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] != largest) {
                secondLargest = nums[i];
                break;
            }
        }
        return secondLargest;
    }
}
// Time Complexity: O(N * log N) for sorting the array, where N is the length of the array.
// Space Complexity: O(1) as no additional space is used.



// Better :
class Solution {
    public int secondLargestElement(int[] nums) {
        int n = nums.length;
        if (n < 2) {
            return -1;
        }
      
        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;

        // First traversal to find the largest element
        for (int i = 0; i < n; i++) {
            largest = Math.max(largest, nums[i]);
        }
        // Second traversal to find second largest element
        for (int i = 0; i < n; i++) {
            if (nums[i] > secondLargest  && nums[i] != largest) {
                secondLargest = nums[i];
            }
        }
        // Return the second largest element
        return secondLargest == Integer.MIN_VALUE ? -1 : secondLargest; 
    }
// TC : O(2N)
// SC: O(1)



// OPTIMAL :
class Solution {
    public int secondLargestElement(int[] nums) {
        if (nums.length < 2) {
            return -1;
        }
        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;
        /*Single traversal to find thelargest  and second largest elements*/
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > largest) {
                secondLargest = largest;
                largest = nums[i];
            } 
            else if (nums[i] > secondLargest && nums[i] != largest) {
                secondLargest = nums[i];
            }
        }
        return secondLargest == Integer.MIN_VALUE ?  -1 : secondLargest;
    }

// TC : O(n)
// SC: O(1)
