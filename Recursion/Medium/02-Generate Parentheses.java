// Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.



class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        backtrack(ans, "", 0, 0, n);
        return ans;
    }

    void backtrack(List<String> ans, String s, int open, int close, int n) {
        if (s.length() == 2 * n) {
            ans.add(s);
            return;
        }

        if (open < n)
            backtrack(ans, s + "(", open + 1, close, n);

        if (close < open)
            backtrack(ans, s + ")", open, close + 1, n);
    }
}


// Time Complexity: O(2**2n),The recursion tree has a maximum depth of 2n, as each valid combination consists of exactly 2n parentheses. 
// At every recursive call, there are at most two choices: either add an opening parenthesis '(' or a closing parenthesis ')'. 
// Assuming both choices are explored at every level, the recursion tree can have up to 22n nodes. Therefore, the overall time complexity is O(22n). 
// This is a loose upper bound since many invalid branches are pruned by the conditions open < n and close < open.

// Space Complexity: O(n × 22n), The overall space complexity consists of two parts: the auxiliary space used during recursion and the space required to store the generated output.
// The recursion depth can reach a maximum of 2n, since one parenthesis is added at each recursive call, resulting in an auxiliary space of O(2n) = O(n) due to the recursion stack.
// Additionally, assuming the loose upper bound where the algorithm generates up to 22n strings, each string has a maximum length of 2n.

Therefore, the space required to store all generated strings is O(2n × 22n), which simplifies to O(n × 22n). Since the output storage dominates the recursion stack, the overall space complexity, including the output, is O(n × 22n). This is also a loose upper bound, as the actual number of valid balanced parenthesis strings is much smaller due to the pruning performed during recursion.
