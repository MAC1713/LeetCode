package Stack;

import java.util.Stack;

public class Twenty {
    class Solution {
        public static boolean isValid(String s) {
            Stack<Character> stack = new Stack<Character>();
            boolean has = false;
            if(s.length() % 2 != 0 && s.length() <= 1){
                return false;
            }
            for (int i = 0; i < s.length(); i++) {
                if(!has && (s.charAt(i) == ')' || s.charAt(i) == ']' || s.charAt(i) == '}')){
                    return false;
                }
                if (s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{') {
                    stack.push(s.charAt(i));
                    has = true;
                } else if (!stack.empty() && s.charAt(i) == ')' && '(' == stack.peek()) {
                    stack.pop();
                    has = true;
                } else if (!stack.empty() &&s.charAt(i) == ']' && '[' == stack.peek()) {
                    stack.pop();
                    has = true;
                } else if (!stack.empty() &&s.charAt(i) == '}' && '{' == stack.peek()) {
                    stack.pop();
                    has = true;
                }else {
                    return false;
                }
            }
            if (stack.empty() && has) {
                return true;
            } else {
                return false;
            }
        }
    }

    public static void main(String[] args) {
        String s = "[]{}()][";
        boolean ans = Solution.isValid(s);
        System.out.println(ans);
    }
}
