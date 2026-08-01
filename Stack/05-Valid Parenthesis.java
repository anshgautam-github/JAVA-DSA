import java.util.Stack;

public class ValidParentheses {

    public static boolean validParentheses(String s) {

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);

            // Opening brackets
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            }

            // Closing brackets
            else {

                // No opening bracket available
                if (stack.isEmpty()) {
                    return false;
                }

                if (ch == ')') {

                    if (stack.peek() == '(') {
                        stack.pop();
                    } else {
                        return false;
                    }

                } else if (ch == '}') {

                    if (stack.peek() == '{') {
                        stack.pop();
                    } else {
                        return false;
                    }

                } else if (ch == ']') {

                    if (stack.peek() == '[') {
                        stack.pop();
                    } else {
                        return false;
                    }

                }
            }
        }

        // Stack should be empty after processing
        return stack.isEmpty();
    }

    public static void main(String[] args) {

        System.out.println(validParentheses("()"));          // true
        System.out.println(validParentheses("()[]{}"));      // true
        System.out.println(validParentheses("(]"));          // false
        System.out.println(validParentheses("([)]"));        // false
        System.out.println(validParentheses("{[]}"));        // true
        System.out.println(validParentheses("((("));         // false
        System.out.println(validParentheses(""));            // true
        System.out.println(validParentheses("]"));           // false
    }
}




// Interview Follow-ups
// 01-How would you modify this for different types of brackets (e.g., < and >)?
// What if tomorrow I add more types of brackets? For example < >, A B, or any custom bracket pair? Will you keep adding more if-else blocks?"
// The expected answer is No. Instead of hardcoding every bracket type, we use a HashMap.

// We store the relationship between brackets in a map.
// Now, if a new bracket type comes, we simply add one more entry to the map. No code changes.

import java.util.*;

public class ValidParentheses {

    public static boolean isValid(String s) {

        Stack<Character> stack = new Stack<>();

        // Closing bracket -> Opening bracket
        HashMap<Character, Character> map = new HashMap<>();

        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');
        map.put('>', '<');     // New bracket type added

        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);

            // Opening bracket
            if (map.containsValue(ch)) {
                stack.push(ch);
            }

            // Closing bracket
            else if (map.containsKey(ch)) {

                if (stack.isEmpty()) {
                    return false;
                }

                if (stack.peek() == map.get(ch)) {
                    stack.pop();
                } else {
                    return false;
                }
            }

            // Invalid character
            else {
                return false;
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {

        System.out.println(isValid("()"));          // true
        System.out.println(isValid("{[]}"));        // true
        System.out.println(isValid("<{[()]}>"));    // true
        System.out.println(isValid("([)]"));        // false
        System.out.println(isValid("((("));         // false
    }
}




// | Aspect               | Solution 1 (Hardcoded `if-else`) | Solution 2 (Using `HashMap`) | Why?                                                                                                                             |
// | -------------------- | -------------------------------- | ---------------------------- | -------------------------------------------------------------------------------------------------------------------------------- |
// | **Time Complexity**  | **O(n)**                         | **O(n)**                     | We traverse the string once. Each character is processed exactly once.                                                           |
// | **Space Complexity** | **O(n)**                         | **O(n)**                     | In the worst case (e.g., `"((({{{[[["`), all opening brackets are stored in the stack.                                           |
// | **Push Operation**   | O(1)                             | O(1)                         | Stack push takes constant time.                                                                                                  |
// | **Pop Operation**    | O(1)                             | O(1)                         | Stack pop removes only the top element.                                                                                          |
// | **Peek Operation**   | O(1)                             | O(1)                         | Accessing the top of the stack is constant time.                                                                                 |
// | **Bracket Matching** | O(1)                             | O(1)                         | `if-else` comparisons are constant time. `HashMap.get()` is also O(1) on average.                                                |
// | **Maintainability**  | Low                              | High                         | Every new bracket type requires adding another `else if` in Solution 1, whereas in Solution 2 you just add one entry to the map. |
// | **Scalability**      | Poor                             | Excellent                    | The `HashMap` solution easily supports any number of bracket pairs.                                                              |



// Interview Tip
// If an interviewer asks: "Why does using a HashMap not change the time complexity?"
// A good answer is: "The algorithm still scans the string only once. The only change is replacing multiple if-else comparisons with a HashMap lookup. 
// Since HashMap.get() and HashMap.containsKey() are O(1) on average, the overall time complexity remains O(n). 
// The improvement is in code maintainability and scalability, not in asymptotic complexity."
