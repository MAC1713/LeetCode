package String;

public class Fourteen {
    class Solution {
        public static String longestCommonPrefix(String[] strs) {
            String ans = "";
            if (strs.length == 1 || strs[0].length() == 0) {
                return strs[0];
            }
            char head = strs[0].charAt(0);
            int pos = 0;
            while (pos >= 0) {
                if (pos >= strs[0].length()) {
                    return ans;
                }
                char temp = strs[0].charAt(pos);
                for (int j = 0; j < strs.length; j++) {
                    if (pos >= strs[j].length()) {
                        return ans;
                    }
                    head = strs[j].charAt(pos);
                    if (temp != head) {
                        return ans;
                    }
                }
                ans += head;
                pos += 1;
            }

            return ans;
        }
    }

    public static void main(String[] args) {
        String[] strs = {"ab", "a"};
        String ans = Solution.longestCommonPrefix(strs);
        System.out.println(ans);
    }
}
