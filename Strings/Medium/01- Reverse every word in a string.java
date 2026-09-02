// Given an input string s, reverse the order of the words.
// A word is defined as a sequence of non-space characters. The words in s will be separated by at least one space.
// Return a string of the words in reverse order concatenated by a single space.
// Note that s may contain leading or trailing spaces or multiple spaces between two words. The returned string should only have a single space separating the words. 
// Do not include any extra spaces.

// Input: s = "the sky is blue"
// Output: "blue is sky the"

// Input: s = "  hello world  "
// Output: "world hello"
// Explanation: Your reversed string should not contain leading or trailing spaces.


// Bruteforce :

// 1- Find first character in the sstring . (__hello__)
// 2- FInd the end char of it.
// 3- Then put that word in a list
// 4- in the first word no space, after it eveyr word must have sapcing .

import java.util.*;

class Solution {
    
    public String reverseWords(String s) {
        int n = s.length(); 
        List<String> words = new ArrayList<>();
        int start, end;
        int i = 0;
      
        while (i < n) {
            
            // Finding the first character of a word (if any)
            while (i < n && s.charAt(i) == ' ') i++;
            
            // If no word is found, break 
            if (i >= n) break;
            
            start = i; // Storing the index of first character of word
            
            // Finding the last character of the word
            while (i < n && s.charAt(i) != ' ') i++;
            
            end = i - 1; // Storing the index of last character of word
            
            // Add the found word to the list of words
            String wordFound = s.substring(start, end + 1);
            words.add(wordFound);
        }
        
        StringBuilder ans = new StringBuilder();
        
        // Adding all the words to result in the reverse order 
        for (int j = words.size() - 1; j >= 0; j--) {
            ans.append(words.get(j));
            
            // Adding spaces in between words
            if (j != 0) ans.append(' ');    // The loop is going backwards: so it will not add after the last word space.
        }
        
        return ans.toString(); // Return the stored result
    }
}
}


// Time Complexity: O(n) (where n is the length of the input string)
// The input string is scanned once to extract words, taking O(n) time, where n is the length of the input string.
// Each word is stored in a list and then concatenated in reverse order, which also takes O(n).

// Space Complexity: O(n)
// The words list stores each extracted word, requiring O(k) space, where k is the total number of characters in all words (essentially O(n)).
// The result string requires O(n) space as well.






// Optmized :

// 1- reverse the full string
// 2- find the word, move to the left. (__hello__ => hello__)
// 3- reverse that word now from it;s start to the end. End always point to the last char of the word.
// 4- add a space after the word.

class Solution {

    public String reverseWords(String s) {
        int n = s.length();

        // Reverse the entire string
        StringBuilder sb = new StringBuilder(s);
        reverseString(sb, 0, n - 1);

        int i = 0, j = 0, start = 0, end = 0;

        while (j < n) {

            // Skip spaces
            while (j < n && sb.charAt(j) == ' ') j++;
            if (j >= n) break;
            start = i;

            // Copy the word characters forward
            while (j < n && sb.charAt(j) != ' ') {
                if (i < sb.length()) {
                    sb.setCharAt(i++, sb.charAt(j++));
                } else {
                    sb.append(sb.charAt(j++));
                    i++;
                }
            }
            end = i - 1;

            // Reverse the current word using start and end
            reverseString(sb, start, end);

            // Add a space after the word if it's not the last word
            if (j < n) {
                if (i < sb.length()) {
                    sb.setCharAt(i++, ' ');
                } else {
                    sb.append(' ');
                    i++;
                }
            }
        }

        // Remove trailing space if present
        if (i > 0 && sb.charAt(i - 1) == ' ') i--;

        return sb.substring(0, i);
    }

    private void reverseString(StringBuilder s, int start, int end) {
        while (start < end) {
            char temp = s.charAt(start);
            s.setCharAt(start, s.charAt(end));
            s.setCharAt(end, temp);
            start++;
            end--;
        }
    }
}


// Time Complexity: O(n) (where n is the length of the input string)
// The input string is reversed firstly, taking O(n) time.
// The string is then traversed taking another O(n) time.
// Every word encountered in the string is again reversed taking overall O(n) time.

// Space Complexity: O(1)
// There is no additional space used. The reversal is done in-place taking O(1) or constant space.
// Note that the space complexity for the Java solution will be O(N) because of the conversion of the given String to a character array. 
// This is done because Strings are immutable in Java.
