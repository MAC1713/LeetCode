package Algorithm;

public class Fifty_three {
    class Solution {
        public static int maxSubArray(int[] nums) {
            int[] dp = new int[nums.length * nums.length];
            int maxValue = nums[0];
            dp[0] = nums[0];
            for (int i = 1; i < nums.length; i++) {
                dp[i] = Math.max(nums[i], dp[i - 1] + nums[i]);
                maxValue = Math.max(maxValue, dp[i]);
            }
            return maxValue;
        }
    }

    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        int ans = Solution.maxSubArray(nums);
        System.out.println(ans);
    }
}
