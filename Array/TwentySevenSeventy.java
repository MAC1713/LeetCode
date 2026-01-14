package Array;

import java.util.Arrays;

import static java.util.Arrays.sort;

/**
 *
 * @author MAC1713
 * @email 1172820376@qq.com
 * @date 2023-08-04 01:49:50
 */
public class TwentySevenSeventy {
    private static class Solution {
        // jump[i] 表示从下标 0 开始跳到 nums[i] 所需的最大跳跃次数
        private static int[] jump;

        public static int maximumJumps(int[] nums, int target) {
            jump = new int[nums.length];
            Arrays.fill(jump, Integer.MIN_VALUE);
            jump[0] = 0;
            int maximumJumps = dfs(nums, nums.length - 1, target);
            return maximumJumps >= 0 ? maximumJumps : -1;
        }

        // 返回从下标 i 跳到下标 0 所需最大的跳跃次数
        private static int dfs(int[] nums, int i, int target) {
            if (jump[i] != Integer.MIN_VALUE) {
                return jump[i];
            }

            int max = Integer.MIN_VALUE;
            for (int j = i - 1; j >= 0; j--) {
                int val = nums[j] - nums[i];
                if (-target <= val && val <= target) {
                    System.out.println("turn:" + Arrays.toString(jump));
                    System.out.println("1-> j:" + j + " i:" + i + " nums[" + j + "]:" + nums[j] + " - nums[" + i + "]:" + nums[i] + " val:" + val);
                    int jump = dfs(nums, j, target) + 1;
                    max = Math.max(max, jump);
                }
                System.out.println("2-> j:" + j + " i:" + i + " nums[" + j + "]:" + nums[j] + " - nums[" + i + "]:" + nums[i] + " val:" + val + " jump:"+ Arrays.toString(jump));
            }

            return jump[i] = max;
        }
    }
// 1,-1,4,2,6,4,8
    public static void main(String[] args) {
        int[] nums = {1,-1,2,1,5,8,10,13,16,14,19,11,20};
        int target = 3;
        System.out.println(Solution.maximumJumps(nums, target));
    }
}
