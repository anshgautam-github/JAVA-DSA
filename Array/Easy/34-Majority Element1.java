// Given an array nums of size n, return the majority element.
// The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.


// BruteForce:
class Solution {
    public int majorityElement(int[] nums) {
        int n = nums.length;
        for(int i=0; i<n; i++){
            int c =0;
            for(int j=0; j<n;j++){
                if(nums[i]==nums[j]) c++;
            } 
            if(c>n/2) return nums[i];
        }
        return -1;
    }
}
// Time Complexity: O(N2), for nested for loops used, where N is the size of the array
// Space Complexity: O(1) as no extra space is used



// Better :
class Solution {
    public int majorityElement(int[] nums) {
        int n = nums.length;
        // Hash map to store element counts
        HashMap<Integer, Integer> map = new HashMap<>();
        // Count occurrences of each eleent
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        /* Iterate through the map to find the majority element*/
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > n / 2) {
                return entry.getKey();
            }
        }
        return -1;
    }
// Time Complexity: O(N), where N is the size of the array.
// The code goes through the array once to count frequencies using a hash map (O(N)), then checks the map to find the majority element (O(N) in the 
// worst case). Since these are separate linear operations, the overall time complexity is O(N).
// Space Complexity: O(N), for using a map data structure.

// Small + known value range => Frequency Array
// Large / negative / unknown range => HashMap

  

// Optimal : 

// Approach  : Moore's Voting Algorithm
// 1- Initialize 2 variables: countfor tracking the count of elements and element for keeping a track of the element we are counting.
// 2- Traverse through the given array. If count is 0 then store the current value of the array as element .
// 3- If the current array value andelement are the same increase the count by 1. If they are different decrease the count by 1. 
//   The integer present in element should be the result expected.

class Solution {
    public int majorityElement(int[] nums) {
        int n = nums.length;
        int ele = 0;
        int cnt = 0;
        for(int i=0;i<n;i++){
            if(cnt==0){
                cnt=1;
                ele=nums[i];
            }else if(ele == nums[i]){
                cnt++;
            }else{
                cnt--;
            }
        }
        int vcount = 0;
        for(int i=0;i<n;i++){
            if(nums[i]==ele)vcount++;
        }
        if(vcount>n/2) return ele;
        return -1;
    }
}

// Time Complexity: O(N) + O(N) = O(N)
// Space Complexity: O(1) no extra space used.
