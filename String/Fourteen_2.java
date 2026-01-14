package String;

public class Fourteen_2 {
    class Solution {
        public static String longestCommonPrefix(String[] strs) {
            if (strs.length == 0) return "";
            //公共前缀比所有字符串都短，随便选一个先
            String s = strs[0];
            for (String string : strs) {
                while (!string.startsWith(s)) {
                    if (s.length() == 0) return "";
                    //公共前缀不匹配就让它变短！
                    s = s.substring(0, s.length() - 1);
                }
            }
            return s;
        }
    }

    public static void main(String[] args) {
        String[] strs = {"ab", "a"};
        String ans = Solution.longestCommonPrefix(strs);
        System.out.println(ans);
    }
}
