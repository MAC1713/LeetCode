package String;

import java.util.*;

/**
 * @author mac
 */
public class Thirty_2 {
    static class Solution {
        public static List<Integer> findSubstring(String s, String[] words) {
            Map<Integer, String> map = new HashMap<>(words.length);
            List<Integer> ans = new ArrayList<>();
            int step = words[0].length();
            if (words.length == 1) {
                for (int i = 0; i < words.length; i += step) {
                    ans.add(i);
                }
                return ans;
            }
            int flag = 0;
            for (int i = 0; i < s.length(); i += step){
                int pinLeft = i;
                int pinRight = pinLeft + step;
                String sString = s.substring(pinLeft, pinRight);
                if(!map.containsValue(sString) && hasWord(sString, words)){
                    map.put(pinLeft, sString);
                    flag += 1;
                    if(flag == words.length){
                        ans.add(pinLeft - words.length * step + step);
                    }
                }else if(hasWord(sString, words)){
                    if(map.containsValue(sString)){
                        for (int h = pinLeft - step; h >= 0; h -= step){
                            if(map.get(h).equals(sString)){
                                for (int j = 0; j <= h; j += step) {
                                    if(map.containsKey(j)){
                                        map.remove(j);
                                        flag -= 1;
                                    }
                                }
                                map.put(pinLeft, sString);
                                flag += 1;
                                if(flag == words.length){
                                    ans.add(pinLeft - words.length * step + step);
                                }
                                break;
                            }
                        }
                    }
                } else {
                    map.clear();
                    flag = 0;
                }
            }
            if(flag == words.length){
                ans.add(s.length() - step - words.length * step);
            }
            return ans;
        }

        public static boolean hasWord(String s, String[] words){
            for (String word : words){
                if (s.equals(word)){
                    return true;
                }
            }
            return false;
        }
    }

    public static void main(String[] args) {
        String s = "wordgoodgoodgoodbestwordwordgoodgoodgoodbestword";
        String[] words = {"word","good","best","word"};
        List<Integer> result = new ArrayList<>();
        result = Solution.findSubstring(s, words);
        System.out.println(result);
    }
}
