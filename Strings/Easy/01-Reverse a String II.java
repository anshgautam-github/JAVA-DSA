// Given a string, the task is to reverse it. The string is represented by an array of characters s.
// Perform the reversal in place with O(1) extra memory. Note: no need to return anything, modify the given list.

// Input : s = ["h", "e" ,"l" ,"l" ,"o"] , Output : ["o", "l", "l", "e", "h"]
// Explanation : The given string is s = "hello" and after reversing it becomes s = "olleh".




// Bruteforce :

// Create a temporary array/list to store characters. Iterate over the given string from the first character to the last.
// During each iteration, copy the current character to the temporary array in reverse order (i.e., from the end of the original string to the 
// beginning of the temporary array).
// After completing the iteration, iterate again over the temporary array and copy each character back to the original string to reverse its content.

class Solution {
     public void reverseString(List<Character> s) {
        int n = s.size();
        
        // Create a temporary list to store reversed elements
        List<Character> temp = new ArrayList<>(n);
        // Initialize temp with dummy values
        for (int i = 0; i < n; i++) {
            temp.add(' ');
        }
        // Copy elements from original list to temp in reverse order
        for (int i = 0; i < n; i++) {
            temp.set(i, s.get(n - i - 1));
        }
        // Copy back the reversed string to original list
        for (int i = 0; i < n; i++) {
            s.set(i, temp.get(i));
        }
    }
}

// Time Complexity: O(N) , where N is the length of the string.
// The algorithm iterates once over the string to copy characters into the temporary array and then iterates again to copy them back to the
// original string.

// Space Complexity: O(N)
// This is due to the usage of the extra data structure (temporary array), which grows linearly with the size of the input string.





// Optimal : 
class Solution {
    // Function to reverse the string 
    public void reverseString(List<Character> s) {
        int start = 0, end = s.size() - 1;
        // Until the string is reversed
        while (start < end) {
            // Swap the characters at start and end
            char ch = s.get(start);
            s.set(start, s.get(end));
            s.set(end, ch);
            start++;
            end--;
        }
    }
}

// Time Complexity O(N) - Linear time complexity, where n is the length of the string. The algorithm iterates through half of the string.
// SpaceComplexity O(1) - Constant space complexity. The algorithm only uses a few extra variables regardless of the input size.


// Note: This same approach can also be implemented using recursion. Recursively, the function can swap the characters at the two ends of the str 
// and then call itself for the substring excluding these ends until the string is reversed.
