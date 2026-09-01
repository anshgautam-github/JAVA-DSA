// Given two strings s and goal, return true if and only if s can become goal after some number of shifts on s.
// A shift on s consists of moving the leftmost character of s to the rightmost position.
// For example, if s = "abcde", then it will be "bcdea" after one shift.

// Input : s = "abcde" , goal = "cdeab"             Output : true
// Explanation :
// After performing 2 shifts we can achieve the goal string from string s.
// After first shift the string s is => bcdea
// After second shift the string s is => cdeab.


// BruteForce :

// First generate all possible rotations of the string by rearranging its character using the substring method.
// For each rotation created, check if it is the same as the goal string.
// If any rotation matches the goal, return true; otherwise, after testing all rotations, return false.

public class Solution {
    public boolean rotateString(String s, String goal) {
    // Strings must be same length to be rotations of each other
        if (s.length() != goal.length()) {
            return false; 
        }
        // Try all possible rotations of s
        for (int i = 0; i < s.length(); i++) {
            String rotated = s.substring(i) + s.substring(0, i); 
            if (rotated.equals(goal)) {
                return true;  // Return true if a match is found
            }
        }
        return false;  
    }
}
// Time Complexity O(N^2) Generate N rotations and each comparison takes O(N) time.
// Space Complexity O(N) for the space needed to store each rotated string.



// Optimal :

// Create a new string by concatenating s with itself, resulting in s + s.
// Check if goal is a substring of s + s.
// If goal is found within s + s, return true; otherwise, return false


class Solution {
    // Strings must be of the same length to be rotations of each other
    public boolean rotateString(String s, String goal) {
        if (s.length() != goal.length()) {
            return false;  
        }
        String doubledS = s + s;  // Concatenate s with itself
        return doubledS.contains(goal);  // Check if goal is a substring of s + s
    }

}

// Time Complexity O(N) , because checking for a substring in s + s is linear in time.
// Space Complexity O(N) for the space needed to store the concatenated string s + s.
