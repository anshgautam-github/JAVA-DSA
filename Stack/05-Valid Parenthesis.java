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
