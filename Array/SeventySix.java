package Array;

import java.lang.reflect.Array;

/**
 * @author mac
 */
public class SeventySix {
    static class Solution {
        public String minWindow(String s, String t) {
            int[] tMap = new int[128];
            int[] sMap = new int[128];
            for (char c : t.toCharArray()) {
                tMap[c]++;
            }
            sMap = tMap.clone();
            int left = 0, right = 0, count = t.length(), minLen = Integer.MAX_VALUE, start = 0;
            while (right < s.length()) {
                char c = s.charAt(right);
                if (tMap[c] > 0) {
                    count--;
                    sMap[c]--;
                }
                if (sMap[c] < 0){
                    count++;
                }
                while (count == 0) {
                    if (minLen > right - left + 1) {
                        minLen = right - left + 1;
                        start = left;
                    }
                    int leftCur = left;
                    while (tMap[s.charAt(leftCur)] == 0){
                        if (sMap[c] < 0) {
                            left++;
                        }
                        leftCur++;
                    }
                    char d = s.charAt(left);
                    if (tMap[d] > 0) {
                        count++;
                        sMap[d]++;
                    }
                    left++;
                }
                right++;
            }
            return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
        }

        public static void main(String[] args) {
            Solution solution = new Solution();
            System.out.println(solution.minWindow("aaabbcdd", "aabcd"));
        }
    }
}
