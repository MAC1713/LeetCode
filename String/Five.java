package String;

public class Five {
    class Solution {
        public static String longestPalindrome(String s) {
            int length = s.length();
            if (length < 2) {
                return s;
            }
            int[] paLenBack = {0, 0};
            int paLen = 0;
            int start = 0, end = 0;
            for (int i = 0; i < length; i++) {
                int paLen_odd = isPalindrome(s, i, i);
                int paLen_even = isPalindrome(s, i, i + 1);
                paLen = Math.max(paLen_odd, paLen_even);
                if(paLen > end - start){
                    start = i - (paLen - 1) / 2;
                    end = i + paLen / 2;
                }
            }
            return s.substring(start, end + 1);

        }

        public static int isPalindrome(String s, int left, int right) {
            int paLen = 0;

            while (right < s.length() && left >= 0 && (s.charAt(left) == s.charAt(right))) {
                left--;
                right++;
            }

            paLen = right - left - 1;
            return paLen;

        }
    }

    public static void main(String[] args) {
        String str = "cbbd";
        String ans = Solution.longestPalindrome(str);
        System.out.println(ans);
    }
}
