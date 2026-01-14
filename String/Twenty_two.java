package String;

import java.util.ArrayList;
import java.util.List;

public class Twenty_two {
    class Solution {
        public static List<String> generateParenthesis(int n) {
            List<String> result = new ArrayList<>(0);
            if (n == 0) {
                return result;
            }
            result.add("()");
            if (n == 1) {
                return result;
            }
            for (int i = 2; i <= n; i++) {
                result = fuc(result);
            }
            return result;
        }

        public static List<String> fuc(List list) {
            List<String> temp = new ArrayList<>();
            for (int i = 0; i < list.size(); i++) {
                StringBuilder str = new StringBuilder((String) list.get(i));
                for (int j = 0; j < list.get(i).toString().length() + 1; j++) {
                    System.out.println(j);
                    str = new StringBuilder(list.get(i).toString());
                    if (!temp.contains(String.valueOf(str.insert(j, "()")))) {
                        str = new StringBuilder(list.get(i).toString());
                        temp.add(String.valueOf(str.insert(j, "()")));
                    }
                    System.out.println(str);
                }
            }
            return temp;
        }
    }

    public static void main(String[] args) {
        int n = 3;
        List<String> ans = new ArrayList<>();
        ans = Solution.generateParenthesis(n);
        System.out.println(ans);
    }
}
