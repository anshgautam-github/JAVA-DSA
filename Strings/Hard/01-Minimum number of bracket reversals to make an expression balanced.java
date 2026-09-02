// Given a string s consisting of only opening and closing brackets '(' and ')', find out the minimum number of reversals required to convert the string into a balanced expression.
// If it is not possible to make the brackets balanced, return -1. A reversal means changing '(' to ')' or vice-versa.

// A balanced expression is a string where:
// It is empty, or
// Every opening bracket '(' has exactly one corresponding closing bracket ')'
// Every closing bracket ')' has exactly one corresponding opening bracket '('
// Brackets are properly nested, meaning every opened bracket is closed before any outer bracket is closed

// Input: s = ")(())((("
// Output: 3
// Explanation: One way to balance is:
// "((())())". There is no balanced sequence
// that can be formed in lesser reversals.



// STRATEGY : 

// 1- Remove the balanced part.
// 2- Left overpart -> unbalanced like ))) ((( :
//                                 of same kind either )) or (( takes 1 reversal to make it balanced
//                                 of diff kind  )( reqiured 2 travlersal 
//                                 so in the above eg -> we requrie total 3 traversals 
// 3- If even length : possible, if odd length : NOT possible
// 4- eg: ))))) (((((((
//     here , close = 5, open = 7

//             close = 5 ; odd , traversals = (5/2) + 5%2(1 wil remain not form pair) = 2+1 = 3 
//             open = 3+1 = 4
//     Hence, the required minimum number of brackets will be:    (open / 2) + (open % 2) + (close / 2) + (close % 2)
//     where open and close represent the number of invalid open and close brackets respectively.
// 5- now comes how will we remove the balanced part ?
//             take 2 counter, open and close, while encountering , open keep doing increament, 
//                                             while clsoe done, check if we have open, if so , reduce from open , if no open then increase the closed numbers.
//                                             then at last we will have no of openings and no of closings. We can apply the formula then.



import java.util.*;

class Solution {
    public int countRev(String s) {
        int n = s.length();
        
        /* If string is of odd length, it is not possible to balance the paranthesis */
        if(n % 2 != 0) return -1;
        
        // To store the count of opening and closing brackets
        int open = 0, close = 0;
      
        for(int i=0; i < n; i++) {
            // Increment open count if opening bracket is found
            if(s.charAt(i) == '(') open++;
            // Else (closing bracket is found)
            else {   /* If a opening bracket is there, a pair of balanced paranthesis is formed */
                if(open > 0) open--;
                else close++; // Otherwise the closing bracket remain unbalanced
            }
        }
        // Computing the result
        int ans = (open / 2) + (open % 2) + (close / 2) + (close % 2);
        return ans; 
    }
}


// Time Complexity: O(n) (where n is the length of the input string) The input string is traversed once taking O(n) time.
// Space Complexity: O(1) Only a couple of variables are used taking constant space.
