// You are given an integer array nums consisting of unique integers.
// Originally, nums contained every integer within a certain range. However, some integers might have gone missing from the array.
// The smallest and largest integers of the original range are still present in nums.
// Return a sorted list of all the missing integers in this range. If no integers are missing, return an empty list.

// Example:
// Input: nums = [1,4,2,5]
// Output: [3]
// Explanation: The smallest integer is 1 and the largest is 5, so the full range should be [1,2,3,4,5]. Among these, only 3 is missing.

// Both the approaches works for both sorted and unsorted arrays. ✅

// FREQ Array : 
class Solution {
    public List<Integer> findMissingElements(int[] nums) {
      
        int n = nums.length;
        List<Integer>ans= new ArrayList<>();
      
        int small = Integer.MAX_VALUE;
        int large = Integer.MIN_VALUE;
        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < small) {
                small = nums[i];
            }
            if (nums[i] > large) {
                large = nums[i];
            }
        }

        int [] hash = new int[large+1];
        for(int i=0; i<n; i++){
            int num = nums[i];
            hash[num]++;
        }
        for(int i=small; i<=large; i++){
            if(hash[i]==0) ans.add(i);
        }
        return ans;
    }
}


// Suppose: nums = [100, 101, 105, 110] , Then: small = 100 ,large = 110
// The frequency-array approach needs: 110 - 100 + 1 = 11 positions. That's fine.
// But imagine: nums = [1, 1000000000] Then you'd need: 1,000,000,000 positions for the fequency array 😬.
// The HashSet only stores the values that actually exist: {1, 1000000000}
// So HashSet is much better when the range can be huge.


// Hash Set Version :
import java.util.*;

class Solution {
    public List<Integer> findMissingElements(int[] nums) {

        List<Integer> ans = new ArrayList<>();
        int small = Integer.MAX_VALUE;
        int large = Integer.MIN_VALUE;
        // Find smallest and largest values
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < small) {
                small = nums[i];
            }
            if (nums[i] > large) {
                large = nums[i];
            }
        }

        // Store all existing numbers
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }

        // Check every number in the original range
        for (int i = small; i <= large; i++) {
            if (!set.contains(i)) {
                ans.add(i);
            }
        }
        return ans;
    }
}

// Frequency array is good when the value range is small. HashSet is safer when the values can be very far apart.

// | Approach                 | Time                 | Auxiliary Space |
// | ------------------------ | -------------------- | --------------- |
// | Your frequency array     | **O(N + R)**         | **O(large)**    |
// | Improved frequency array | **O(N + R)**         | **O(R)**        |
// | HashSet                  | **O(N + R)** average | **O(N)**        |

// N = number of elements in nums
// R = large - small + 1


// Your HashSet code:

// Time
// Finding small and large: for (int i = 0; i < nums.length; i++) → O(N)
// Adding elements to the HashSet: for (int i = 0; i < nums.length; i++) → O(N) average
// Checking every number from small to large: for (int i = small; i <= large; i++) → O(R) .set.contains(i) is O(1) average.
// Therefore: TC = O(N + R) average
