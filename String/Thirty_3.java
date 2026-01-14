package String;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Thirty_3 {
    static class Solution {
        public static List<Integer> findSubstring(String s, String[] words) {
            List<Integer> ans = new ArrayList<>();
            int step = words[0].length();
            int sLength = step * words.length;
            int pinLeft = 0;
            int pinRight = pinLeft + step * words.length;
            int pinDelLeft = pinLeft + step;
            int pinDelRight = pinLeft + step + step;
            Map<String, Integer> map = new HashMap<>(words.length);
            for (String word : words){
                if (map.containsKey(word)){
                    map.replace(word, map.get(word), map.get(word) + 1);
                }else {
                    map.put(word, 1);
                }
            }
            for (int i = 0; i < s.length() - sLength + 1; i ++) {
                Map<String, Integer> mapTemp = new HashMap<>(words.length);
                mapTemp.putAll(map);
                pinLeft = i;
                pinRight = pinLeft + sLength;
                String sString = s.substring(pinLeft, pinLeft + step);
                if (!mapTemp.containsKey(sString)){
                    continue;
                }
                for (int j = 0; j < words.length; j ++) {
                    pinDelLeft = pinLeft + j * step;
                    pinDelRight = pinLeft + (j + 1) * step;
                    sString = s.substring(pinDelLeft, pinDelRight);
                    if (!mapTemp.containsKey(sString)){
                        break;
                    }
                    if(mapTemp.containsKey(sString) && !mapTemp.containsValue(-1)){
                        mapTemp.replace(sString, mapTemp.get(sString), mapTemp.get(sString) - 1);
                    }
                    if (mapTemp.containsValue(-1)) {
                        break;
                    }
                    if (j == words.length - 1) {
                        ans.add(i);
                    }
                }
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        String s = "lingmindraboofooowingdingbarrwingmonkeypoundcake";
        String[] words = {"fooo","barr","wing","ding","wing"};
        List<Integer> result = new ArrayList<>();
        result = Solution.findSubstring(s, words);
        System.out.println(result);
    }
}
