package String;

public class Six {
    class Solution {
        public static String convert(String s, int numRows) {
            if (numRows == 1 || s.length() == 1) {
                return s;
            }
            String ans = "";
            int position = 0;
            for (int i = 0; i < numRows; i++) {
                int space = 2 * (numRows - i) - 3;//3
                int rev_space = 2 * i - 1;
                if (space < 0) {
                    space = 0;
                }
                while (position < s.length()) {
                    if (position <= i) {
                        position += i;
                        try {
                            ans = ans + s.charAt(position);
                        } finally {
                            if (ans.length() == s.length()) {
                                return ans;
                            }
                        }
                    }
                    if (space > 0) {
                        position += (space + 1);
                    }
                    if (position < s.length() && position > 0 && space != 0) {
                        ans = ans + s.charAt(position);
                    }
                    position += (rev_space + 1);
                    if (position < s.length() && rev_space > 0) {
                        ans = ans + s.charAt(position);
                    }
                }
                position = 0;
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        String str = "ab";
        int line = 3;
        String ans = Six.Solution.convert(str, line);
        System.out.println(ans);
    }
}
