package Stack;


import java.util.Stack;

/**
 * @author mac
 */
public class ThirtyTwo {
    static class Solution {
        public static int longestValidParentheses(String s) {
            Stack<Integer> stack = new Stack<>();
            stack.push(-1);
            int maxLen = 0;

            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c == '(') {
                    stack.push(i);
                } else {
                    stack.pop();
                    if (stack.isEmpty()) {
                        stack.push(i);
                    } else {
                        maxLen = Math.max(maxLen, i - stack.peek());
                    }
                }
            }

            return maxLen;
        }
    }
    public static void main(String[] args) {
        String s = "()()()(()))()(())))((()";
        System.out.println(Solution.longestValidParentheses(s));
    }
}
