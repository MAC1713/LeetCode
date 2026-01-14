package Array;

import java.util.HashMap;
import java.util.Map;

/**
 * @author mac
 */
public class TwoFiveEightFour {
    static class Solution {
        private Map<String, Integer> gcdMap = new HashMap<>();
        public int findValidSplit(int[] nums) {

            int len = nums.length;
            if (len <= 1){
                return -1;
            }
            int pos = 0;
            if(nums[0] == 1){
                return 0;
            }
            for (int i = 0; i <= pos; i++) {
                if(nums[i] == 1){
                    continue;
                }
                for (int j = pos; j < len; j++) {
                    if (nums[j] == 1){
                        continue;
                    }
                    String key = nums[i] + "," + nums[j];
                    int gcd = gcdMap.getOrDefault(key, -1);
                    if (gcd == -1) {
                        gcd = gcd(nums[i], nums[j]);
                        gcdMap.put(key, gcd);
                    }
                    if (gcd >= 1) {
                        pos = j;
                    }
                }
            }
            return pos == len - 1 ? -1 : pos;
        }
        private int gcd(int x, int y) {
            if (y == 0) {
                return x != 1 ? x : -1;
            }
            String key = x + "," + y;
            int gcd = gcdMap.getOrDefault(key, -1);
            if (gcd == -1) {
                gcd = gcd(y, x % y);
                gcdMap.put(key, gcd);
            }
            return gcd;
        }
        public static void main (String[]args){
            Solution s = new Solution();
            System.out.println(s.findValidSplit(new int[]{
                    2,3,15,3,5,7,3
            }));
        }
    }

}

