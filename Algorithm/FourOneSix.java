package Algorithm;

import java.lang.reflect.Array;
import java.util.Arrays;

public class FourOneSix {
    static class Solution {
        public boolean canPartition(int[] nums) {
            Arrays.sort(nums);
            int sum = 0;
            for (int num : nums) {
                sum += num;
            }

            if (sum % 2 != 0){
                return false;
            }

            int target = sum/2;
            int[] dp = new int[target+1];

            int n = nums.length;
            //遍历物品
            for (int num : nums) {
                //遍历背包
                for (int j = target; j >= num; j--) {
                    dp[j] = Math.max(dp[j], dp[j - num] + num);
                    if (dp[target] == target) {
                        return true;
                    }
                }
            }

            return dp[target] == target;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 5, 11, 5};
        Solution solution = new Solution();
        boolean result = solution.canPartition(nums);
        System.out.println(result);
    }
}