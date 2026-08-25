// Given an integer array of size n containing distinct values in the range from 0 to n (inclusive), return the only number missing from the 
// array within this range.



// BruteForce : For each number between 0 to N, try to find it in the given array using linear search. And if any number is not found, return it.
class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        for(int i=0 ; i<=n ;i++){
            boolean flag = false;
            for(int j=0; j<n ;j++){
                if(nums[j]==i){
                    flag=true;
                    break;
                }
            }
            if(flag==false) return i;
        }
        return -1;
    }
}
// Time Complexity: O(N^2), where N is the size of the array. In the worst case i.e. if the missing number is N itself, the outer loop will run for N times, and for every single number the inner loop will also run for approximately N times. So, the total time complexity will be O(N^2).
// Space Complexity: O(1) , as no extra space is used.



// Better : rather than linear search is to use the hashing technique by storing the frequency of each element of the given array.
class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int [] hash = new int[n+1];

        for(int i=0; i<n; i++){
            int num = nums[i];
            hash[num]++;
        }
        for(int i=0; i<=n; i++){
            if(hash[i]==0) return i;
        }
        return -1;
    }
}
// Time Complexity: O(N) + O(N) ~ O(2N), where N is size of the array + 1.
// Space Complexity: O(N) where N is size of the array + 1, as extra hash space is used.

// Why N + 1?
// Suppose: nums = [3, 0, 1] , Then: N = nums.length = 3
// The problem says the numbers can be from: 0 to N . So the possible numbers are: 0, 1, 2, 3 That's 4 numbers. Therefore we need:

// What does hash/freq actually mean?
// Suppose: nums = [3, 0, 1]
// Initially: freq = [0, 0, 0, 0]
//                    0  1  2  3
// Now we loop through nums.
  
// First number: 3
// freq[3]++;
// Now: freq = [0, 0, 0, 1]
//              0  1  2  3
// Meaning: 3 appeared 1 time
  
// Next number: 0
// freq[0]++;
// Now: freq = [1, 0, 0, 1]
//              0  1  2  3
// Meaning: 0 appeared 1 time 

// First loop: i < N : This loop is going through the actual elements inside nums. you're asking: "What elements actually exist in my array?"
// Second loop: i <= N : This loop is not going through the original array. It is checking all possible numbers. 
// The problem says numbers can range from: 0 through N



// Optimal : based on simple mathematics, where addition and summation of series is involved.
// 1- Calculate the summation of first N natural numbers(i.e. 1 to N) using the formula (N*(N+1))/2 and store in variable sum1
// 2- Then add all the array elements by iterating in the array and store it in variable sum2
// 3- Finally, consider the difference between the sum1and sum2, return it.
class Solution {
    public int missingNumber(int[] nums) {
       int n = nums.length;
       int rsum = (n*(n+1))/2;
       int sum = 0;
       for(int i=0; i<nums.length;i++){
        sum+=nums[i];
       }
       return rsum-sum;

    }
}
// TC : O(n)
// SC : O(1)
