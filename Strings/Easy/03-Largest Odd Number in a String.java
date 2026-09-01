// Given a string s, representing a large integer, the task is to return the largest-valued odd integer (as a string) that is a substring of the
// given string s.
// The number returned should not have leading zero's. But the given input string may have leading zero. 
// (If no odd number is found, then return empty string.)


// Input : s = "5347"       Output : "5347"
// Explanation : The odd numbers formed by given strings are --> 5, 3, 53, 347, 5347.
// So the largest among all the possible odd numbers for given string is 5347.


// STEPS : 

// 1. Start by iterating through the string from the end towards the beginning to find the first odd digit. 
//    This digit marks the potential end of the largest odd number substring.
// 2. Once an odd digit is found, skip any leading zeroes from the beginning of the string up to this odd digit.
// 3. Extract and return the substring starting after the leading zeroes and ending at the identified odd digit. 
//    This substring represents the largest odd integer without leading zeroes.

import java.util.*;

class Solution {
   
    public String largeOddNum(String s) {
        int ind = -1;
        
        // Iterate through the string from the end to beginning
        int i;
        for (i = s.length() - 1; i >= 0; i--) {
            // Break if an odd digit is found
            if ((s.charAt(i) - '0') % 2 == 1) {
                ind = i;
                break;
            }
        }
        // If no odd number was found, return an empty string
        if (ind == -1) return "";
        // Skipping any leading zeroes
        i = 0;
        while(i <= ind && s.charAt(i) == '0') i++;
        
        // Return the largest odd number substring
        return s.substring(i, ind + 1);
    }
}


// Time Complexity: O(N), The loop runs once through the string of length N.
// Space Complexity: O(N), The auxiliary space used is O(1) but if the space for returned string is considered 
// (which will be O(N) in the worst case), the overall space complexity comes out to be O(N).
