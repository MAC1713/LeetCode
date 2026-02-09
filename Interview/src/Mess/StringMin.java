package Mess;

import java.util.HashMap;
import java.util.Map;

public class StringMin {
        public int lengthOfLongestSubstring(String s) {
            Map<Character, Integer> charIndex = new HashMap<>();
            int left = 0;
            int maxLength = 0;

            for (int right = 0; right < s.length(); right++) {
                char currentChar = s.charAt(right);
                if (charIndex.containsKey(currentChar) && charIndex.get(currentChar) >= left) {
                    left = charIndex.get(currentChar) + 1;
                }

                charIndex.put(currentChar, right);
                maxLength = Math.max(maxLength, right - left + 1);
            }

            return maxLength;
        }

    public static void main(String[] args) {
        StringMin stringMin = new StringMin();
        int result = stringMin.lengthOfLongestSubstring("abcdabcda");
        System.out.println(result);
    }
    }
