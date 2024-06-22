import java.util.Stack;

/**
 * Solution
 */
public class Solution {

    public static void main(String[] args) {

        String s = "}";
        System.out.println(isValid(s));
    }

    private static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        int n = s.length();
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '{' || s.charAt(i) == '[' || s.charAt(i) == '(')
                stack.push(s.charAt(i));
            else if (!stack.empty() && stack.peek() == '{' && s.charAt(i) == '}')
                stack.pop();
            else if (!stack.empty() && stack.peek() == '[' && s.charAt(i) == ']')
                stack.pop();
            else if (!stack.empty() && stack.peek() == '(' && s.charAt(i) == ')')
                stack.pop();
            else
                return false;
        }
        return stack.empty();
    }
}
