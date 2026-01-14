package String;

import java.util.ArrayList;
import java.util.List;

/**
 * @author mac
 */
public class Thirty {
    static class Solution {
        public static List<Integer> findSubstring(String s, String[] words) {
            List<Integer> ans = new ArrayList<>();
            int len = words.length;
            System.out.println(len);
            for (int i = 1; i < words.length; i++) {
                len *= i;
            }
            List<String> list = new ArrayList<>();
            list.add(words[0]);
            for (int i = 1; i < words.length; i++) {
                list = combine(list, words[i]);
            }

            return ans;
        }

        public static List<String> combine(List list, String words) {
            List<String> temp = new ArrayList<>();
            for (int i = 0; i < list.size(); i++) {
                StringBuilder str = new StringBuilder((String) list.get(i));


                for (int j = 0; j < list.get(i).toString().length() + 1; j++) {
                    System.out.println(j);
                    str = new StringBuilder(list.get(i).toString());
                    if (!temp.contains(String.valueOf(str.insert(j, list.get(i))))) {
                        str = new StringBuilder(list.get(i).toString());
                        temp.add(String.valueOf(str.insert(j, list.get(i))));
                    }
                    System.out.println(str);
                }
            }
            return temp;
        }
    }

    public static void main(String[] args) {
        String s = "footooroorootoofoo";
        String[] words = {"foo", "roo", "too"};
        List<Integer> result = new ArrayList<>();
        result = Solution.findSubstring(s, words);
        System.out.println(result);
    }
}
