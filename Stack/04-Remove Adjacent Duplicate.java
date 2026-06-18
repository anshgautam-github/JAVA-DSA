
// Solution 1: Using Stack Indexing (get(i))
// This uses the fact that Java's Stack extends Vector.
import java.util.Stack;

class Solution {
    public String removeDuplicates(String s) {

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);

            if (!stack.isEmpty() && stack.peek() == ch) {
                stack.pop();
            } else {
                stack.push(ch);
            }
        }

        StringBuilder ans = new StringBuilder();

        for (int i = 0; i < stack.size(); i++) {
            ans.append(stack.get(i));
        }

        return ans.toString();
    }
}



// Solution 2: Pure Stack (No Indexing)
// Uses only:
// push()
// pop()
// peek()
// which is closer to the Stack ADT.
import java.util.Stack;

class Solution {

    public String removeDuplicates(String s) {

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);

            if (!stack.isEmpty() && stack.peek() == ch) {
                stack.pop();
            } else {
                stack.push(ch);
            }
        }

        StringBuilder ans = new StringBuilder();

        while (!stack.isEmpty()) {
            ans.append(stack.pop());
        }

        return ans.reverse().toString();
    }
}
