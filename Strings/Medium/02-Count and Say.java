// The count-and-say sequence is a sequence of digit strings defined by the recursive formula:
// countAndSay(1) = "1"
// countAndSay(n) is the run-length encoding of countAndSay(n - 1).
  
// Run-length encoding (RLE) is a string compression method that works by replacing each maximal group of consecutive identical characters with the concatenation of the 
// length of the group followed by the character itself. For example, to compress the string "3322251" we replace "33" with "23", replace "222" with "32", replace "5" with "15", 
// and replace "1" with "11". Thus the compressed string becomes "23321511".

// Given a positive integer n, return the nth element of the count-and-say sequence.

// Input: n = 4
// Output: "1211"

// Explanation:
// countAndSay(1) = "1"
// countAndSay(2) = RLE of "1" = "11"
// countAndSay(3) = RLE of "11" = "21"
// countAndSay(4) = RLE of "21" = "1211"

 public String countAndSay(int n) {
        if (n == 1) return "1";
        
        // Recursive call
        String prev = countAndSay(n - 1);
        int len = prev.length();
        
        // To store the answer
        String ans = ""; 
        
        // To count the frequency of identicals
        int count = 1;  
        
        // Traverse the string 
        for (int i = 1; i < len; i++) {
            // If identicals are found, increment the counter
            if (prev.charAt(i) == prev.charAt(i - 1)) count++;
            
            // Otherwise
            else {
                ans += (char) ('0' + count); // Add frequency
                ans += prev.charAt(i - 1); // Add the digit 
                count = 1; // Reset counter to 1
            }
        }
        
        // Adding the frequency for the last digit and the last digit
        ans += (char) ('0' + count);
        ans += prev.charAt(len - 1); 
        
        return ans; // Return the result
    }


// Time Complexity: Can't be determined exactly
// Because it will depend on the length of the string in each step which is uncertain.

// Space Complexity: Can't be determined exactly
// The recursive stack space will take O(n) space and during each step, the string generated will take a variable space.
