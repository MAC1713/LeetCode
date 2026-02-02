package String;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FortyNine {
    class Solution {
        public static List<List<String>> groupAnagrams(String[] strs) {
            Map<Long, List<String>> param = new HashMap<Long, List<String>>();
            for (String str : strs) {
                long key = calTimes(str);
                List<String> tmp = new ArrayList<>();
                tmp = param.getOrDefault(key, new ArrayList<>());

                if (tmp.size() != 0){
                    if (tmp.get(0).length() != str.length()){
                        continue;
                    }
                }

                tmp.add(str);
                param.put(key, tmp);

            }

            return new ArrayList<>(param.values());
        }

        public static long calTimes(String x) {
            long res = 1;
            for (int i = 0; i < x.length(); i++) {
                int index = x.charAt(i);
                res *= index;
            }
            return res;
        }
    }

    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(Solution.groupAnagrams(strs));
    }
}
