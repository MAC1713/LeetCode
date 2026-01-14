package Array;

import Algorithm.ThirtySeven;

import java.util.Arrays;

/**
 * @author mac
 */
public class OneEightNine {
    static class Solution {
        public static int[] rotate(int[] nums, int k) {
            int len = nums.length;
            if(k == 0 || len == 1 || k % len == 0) {
                return nums;
            }
            if (k > len){
                k = k % len;
            }
            int cache = nums[0];
            int current = k;
            int start = 0;
            for (int i = 0; i < len; i ++){
                current = current < len ? current : current % len;
                int tmp = nums[current];
                nums[current] = cache;
                cache = tmp;
                if (current == start){
                    start += 1;
                    cache = nums[start];
                    current = start;
                }
                current += k;
            }
            return nums;
        }

        public static void main(String[] args) {
            int[] nums = {
                    1,1,4,2,1,
                    0,6,6,2,5,
                    6,6,2,7,9,
                    4,1,3,9,6,
                    5,4,8,7,8
            };
            int k = 5;
            System.out.println(Arrays.toString(rotate(nums, k)));
        }
    }
}
