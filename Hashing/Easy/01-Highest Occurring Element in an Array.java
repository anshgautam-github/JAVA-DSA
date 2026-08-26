// Given an array nums of n integers, find the most frequent element in it i.e., the element that occurs the maximum number of times.
// If there are multiple elements that appear a maximum number of times, find the smallest of them.

// Example 1 : Input: nums = [1, 2, 2, 3, 3, 3]
// Output: 3 .Explanation: The number 3 appears the most (3 times). It is the most frequent element.

// Example 2 Input: nums = [4, 4, 5, 5, 6]
// Output: 4 Explanation: Both 4 and 5 appear twice, but 4 is smaller. So, 4 is the most frequent element.



// Bruteforce :

// We need: The element that occurs the maximum number of times. If there is a tie: Return the smallest element.
// Notice that there are actually two separate things we need to track:
// Frequency
// Smallest value when frequencies are equal

// most natural first thought is: "Take each element and count how many times it appears in the entire array."
// So: for every nums[i]
//           count how many times nums[i] occurs
// That means two loops

class Solution {
    public int highestOccurringElement(int[] nums) {

        int maxFreq = 0;
        int answer = Integer.MAX_VALUE;

        // Pick each element
        for (int i = 0; i < nums.length; i++) {
            int count = 0;
            // Count how many times nums[i] occurs
            for (int j = 0; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    count++;
                }
            }
            // Update answer
            if (count > maxFreq) {
                maxFreq = count;
                answer = nums[i];
            }
            // Same frequency → choose smaller element
            else if (count == maxFreq && nums[i] < answer) {
                answer = nums[i];
            }
        }
        return answer;
    }
}
// TC : O(N*2)
// SC : O(1)



// Optimized  :

// Now ask: "What work am I repeating?" This is the question you should train yourself to ask after writing brute force.
// Suppose: nums = [2, 3, 2, 4, 2]
// When i = 0, we count 2: 2 → 3 times
// Later when: i = 2 we count 2 again. That's wasted work. We already know: 2 → 3
// So instead of repeatedly counting the same number, we should remember the frequency.
// That leads naturally to: Frequency MaP

// Optimized approach: HashMap
// Ask: "What information do I need to remember?"
// Answer: number → frequency . That's exactly what a HashMap is good for.

import java.util.*;

class Solution {

    public int highestOccurringElement(int[] nums) {
        HashMap<Integer, Integer> freq = new HashMap<>();
        // Step 1: Count frequency of every element
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        int maxFreq = 0;
        int answer = Integer.MAX_VALUE;

        // Step 2: Find the element with maximum frequency
        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            int num = entry.getKey();
            int count = entry.getValue();

            // Higher frequency
            if (count > maxFreq) {
                maxFreq = count;
                answer = num;
            }
            // Same frequency → choose smaller number
            else if (count == maxFreq && num < answer) {
                answer = num;
            }
        }
        return answer;
    }
}

// TC → O(N) average
// SC → O(N)



// Can we use a frequency array instead?
// Ask: Can I use the value itself as an index? If the problem gives a small bounded range, yes.
// For example, suppose: 1 <= nums[i] <= 1000

class Solution {

    public int highestOccurringElement(int[] nums) {
      
        int[] freq = new int[1001];
      
        // Count frequencies
        for (int i = 0; i < nums.length; i++) {
            freq[nums[i]]++;
        }

        int maxFreq = 0;
        int answer = Integer.MAX_VALUE;

        // Check every possible value
        for (int num = 0; num <= 1000; num++) {
            if (freq[num] > maxFreq) {
                maxFreq = freq[num];
                answer = num;
            }
        }
        return answer;
    }
}
// TC : O(N + 1001) = O(N)
// SC : O(1001) = O(1)



// There is another small optimization 
  
// You don't necessarily need to do:
// 1. Build frequency map
// 2. Iterate over map
// You can update the answer while building the frequency map. This is a useful pattern.

import java.util.*;

class Solution {

    public int highestOccurringElement(int[] nums) {

        HashMap<Integer, Integer> freq = new HashMap<>();

        int maxFreq = 0;
        int answer = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int count = freq.getOrDefault(num, 0) + 1;
            freq.put(num, count);

            // New maximum frequency
            if (count > maxFreq) {
                maxFreq = count;
                answer = num;
            }

            // Same frequency → smaller number wins
            else if (count == maxFreq && num < answer) {
                answer = num;
            }
        }
        return answer;
    }
}

// Still:
// TC = O(N) average
// SC = O(N)
// But we now make only one logical pass over the input.
