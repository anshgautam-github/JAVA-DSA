// Write a function to find the longest common prefix string amongst an array of strings.
// If there is no common prefix, return an empty string "".

// Input : str = ["flowers" , "flow" , "fly", "flight" ]       Output : "fl"
// Explanation : All strings given in array contains common prefix "fl".

// 1- Sort the array of strings.
// 2- Select the first and the last string from the sorted array. These two strings will have the maximum possible common prefix.
// 3- Initialize an index variable to zero. This index will track the length of the common prefix.
// 4- Compare characters at the current index of both selected strings. Continue moving the index forward as long as the characters at the current index are equal and the index is within the bounds of both strings.
// 5- Once characters differ or the end of one of the strings is reached, the index will indicate the length of the common prefix.
// 6- Return the substring of the first string from the start to the index, which represents the longest common prefix.


import java.util.Arrays;

class Solution {
    public String longestCommonPrefix(String[] v) {
        // Use StringBuilder to build the result
        StringBuilder ans = new StringBuilder();
        
        // Sort the array to get the lexicographically smallest and largest strings
        Arrays.sort(v);
        // First string (smallest in sorted order)
        String first = v[0]; 
         // Last string (largest in sorted order)
        String last = v[v.length - 1];
        
        // Compare characters of the first and last strings
        for (int i = 0; i < Math.min(first.length(), last.length()); i++) {
            // If characters don't match, return the current prefix
            if (first.charAt(i) != last.charAt(i)) {
                return ans.toString();
            }
            // Append the matching character to the result
            ans.append(first.charAt(i));
        }
        // Return the longest common prefix found
        return ans.toString();
    }
}


// Time Complexity: O(N * M * log N), where N is the number of strings and M is the maximum length of a string.

// The sorting operation takes O(N * M * log N) time because:
// Comparing two strings during sort costs up to O(M) (character-by-character comparison).

// Sorting does O(N*logN) comparisons  and the comparison of characters in the first and last strings takes O(M) time, which is dominated by the 
// sorting step making the overall time complexity as O(N * M * logN).

// Space Complexity: O(M), as the ans variable can store the length of the prefix which in the worst case will be O(M).
