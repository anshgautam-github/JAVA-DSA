// You are given a string s. Return true if the string is palindrome, otherwise false. 
// A string is called palindrome if it reads the same forward and backward.

// Input : s = "hannah" , Output : true
// Explanation : The given string when read backward is -> "hannah", which is same as when read forward. Hence answer is true.

class Solution {   
    public boolean palindromeCheck(String s) {
        //your code goes here
        int left = 0;
        int right = s.length()-1;

        while(left < right){
            if (s.charAt(left) != s.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}



// Time Complexity: O(N), where n is the length of the string.
// Space Complexity: O(1), as no extra space is required.
