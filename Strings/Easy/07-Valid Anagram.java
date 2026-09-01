// Given two strings s and t, return true if t is an anagram of s, and false otherwise.
// An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.
  
// Input : s = "anagram" , t = "nagaram"        Output : true
// Explanation : We can rearrange the characters of string s to get string t as frequency of all characters from both strings is same.



// BruteForce :

// Sort the characters of both strings using an inbuilt sort function, so that if they are anagrams, the sorted strings will be identical.
// Compare the sorted versions of both strings. If they match, the original strings are anagrams; otherwise, they are not.
// Return true if the sorted strings are identical, otherwise return false.

import java.util.Arrays;

class Solution {
    public boolean anagramStrings(String s, String t) {
        // If lengths are not equal, they cannot be anagrams
        if (s.length() != t.length()) return false;
        // Convert strings to char arrays and sort them
        char[] sArray = s.toCharArray();
        char[] tArray = t.toCharArray();
        Arrays.sort(sArray);
        Arrays.sort(tArray);
        // Compare sorted arrays
        return Arrays.equals(sArray, tArray);
    }
}
// Time Complexity: O(N log N) due to sorting each string.
// Space Complexity: O(1) as no additional data structures are used. Note that for Java, the space complexity will be O(N) due to the creation of additional character arrays. 
// And for Python, the space complexity will be O(N) due to the use of sorted() function, which creates a new string to hold the sorted string.




// Optimal :

// 1- Initialize a frequency array of size 26 to count the occurrences of each letter in the first string (Str1). Each index of the array represents a letter from 'a' to 'z'.
// 2- Iterate through the second string (Str2) and decrease the count in the frequency array for each letter found in Str2. This ensures we are balancing out the counts from Str1.
// 3- Check the frequency array. If all counts return to zero, both strings have identical character frequencies and are anagrams. If any count is not zero, the strings are not anagrams.

import java.util.*;

class Solution {
    public boolean anagramStrings(String s, String t) {
        // Edge Cases
        if (s.length() != t.length()) return false;

        // To store the count of each character
        int[] count = new int[26];

        // Count occurrence of each character in first string 
        for (char c : s.toCharArray()) count[c - 'a']++;

        // Decrement the count for each character in the second string
        for (char c : t.toCharArray()) count[c - 'a']--;

        // Check for count of every character
        for (int i : count) {
            // If the count is not zero
            if (i != 0) return false; // Return false
        }

        // Otherwise strings are anagram
        return true;
    }
}

// Time Complexity: O(N), where N is the length of the string
// Space Complexity: O(1), as there is always a constant-size array (of length 26) used to store the frequencies that does not depend on the length of the strings.
