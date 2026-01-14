package String;

import java.util.ArrayList;
import java.util.List;

public class Seventeen {
    static class Solution {
        public static List<String> letterCombinations(String digits) {
            List<String> result = new ArrayList<>();
            if (digits.length() <= 0) {
                return result;
            }

            int[] value = {      0,     1,     2,     3,     4,      5,     6,     7};
            String[] word = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

            int size = 0;
            for (int i = 0; i < digits.length(); i++) {
                int digit_num = word[digits.charAt(i) - '0'].length();
                size =  size < 3 ? digit_num : size * digit_num;
            }

            for (int i = 0; i < digits.length(); i++) {
                result = List.of(Solution.combine(digits.charAt(i) - '0', result));
            }

            return result;
        }

        public static String[] combine(int num, List<String> ans){
            num = num - 2;
            int[] value = {      0,     1,     2,     3,     4,      5,     6,     7};
            String[] word = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
            int i1 = ans.size() < 3 ? word[num].length() : ans.size() * word[num].length();
            String[] temp = new String[i1];
            for (int i = 0; i < word[num].length(); i++) {
                if(temp.length > 4) {
                    for (int j = 0; j < ans.size(); j++) {
                        temp[i * ans.size() + j] = String.valueOf(ans.get(j) + word[num].charAt(i));
                    }
                }else{
                    temp[i] = String.valueOf(word[num].charAt(i));
                }
            }
            return temp;
        }
    }

    public static void main(String[] args) {
        String s = "3647";
        List<String> ans = Solution.letterCombinations(s);
        System.out.println(ans.size());
        System.out.println(ans);
    }
}
