// Given an integer array of size n, find all elements that appear more than ⌊n / 3⌋ times.

// > n/3 → TWO elements are possible
// Now suppose: n = 9 .An element must appear: > 9/3 > 3 So it needs at least 4 occurrences.
// Can we have two such elements? Yes! A → 4 times , B → 4 times . Together: 4 + 4 = 8 We still have one element left.
// For example: [ A, A, A, A, B, B, B, B, C ]
// Here: A = 4 B = 4 Both satisfy: 4 > 9/3 So there can be TWO majority elements. 

// But can we have THREE?
// Suppose: A → 4 B → 4 C → 4 , Together: 4 + 4 + 4 = 12 But we only have 9 elements. Impossible.
// Therefore: There can be at most TWO elements appearing more than n/3 times.
// That's why we need: int ele1, ele2; int cnt1, cnt2;

import java.util.*;

class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n = nums.length;

        // We can have at most 2 elements appearing more than n/3 times.
        int ele1 = 0;
        int ele2 = 0;

        int cnt1 = 0;
        int cnt2 = 0;
      
        // PHASE 1: Find possible candidates
        for (int i = 0; i < n; i++) {

            // Case 1: Current number is already candidate 1.
            if (nums[i] == ele1) {
                cnt1++;
            }
            // Case 2: Current number is already candidate 2.
            else if (nums[i] == ele2) {
                cnt2++;
            }
            // Case 3: Candidate 1 has no votes.
            else if (cnt1 == 0) {
                ele1 = nums[i];
                cnt1 = 1;
            }
            // Case 4:Candidate 2 has no votes.
            else if (cnt2 == 0) {
                ele2 = nums[i];
                cnt2 = 1;
            }
            // Case 5:  Current number is different from both  candidates and both candidates have votes.Cancel one vote from each candidate.
            else {
                cnt1--;
                cnt2--;
            }
        }
      
        // PHASE 2: Verify the candidates
        int count1 = 0;
        int count2 = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == ele1) {
                count1++;
            }
            else if (nums[i] == ele2) {
                count2++;
            }
        }
        List<Integer> result = new ArrayList<>();
        if (count1 > n / 3) {
            result.add(ele1);
        }
        if (count2 > n / 3) {
            result.add(ele2);
        }
        return result;
    }
}

// TC - O(n)
// SC - O(1)
