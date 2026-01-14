package Array;

import java.util.Arrays;

/**
 *
 * @author MAC1713
 * @email 1172820376@qq.com
 * @date 2023-08-04 01:49:50
 */
public class TwentySevenSeventyOwn {
    private static class Solution {
        public static int maximumJumps(int[] nums, int target) {
            int answer = 0;
            if (nums.length == 1){
                return 0;
            }
            int before = nums.length - 2;
            int after = nums.length - 1;
            int temp = 0;
            for (int i = nums.length; i > 0; i--){
                int val = nums[after] - nums[before];
                System.out.println(nums[after] + "-" + nums[before] + ", " + answer);
                if(-target <= val && val <= target){
                    answer += 1;
                }else {
                    before -= 1;
                    if(before == -1) {
                        return -1;
                    }
                    continue;
                }
                temp = before;
                before -= 1;
                after = temp;
                if(before == -1) {
                    return answer;
                }
            }
            return answer;
        }
    }
    public static void main(String[] args) {
        int[] nums = {0,2,1};
        int target = 1;
        System.out.println(Solution.maximumJumps(nums, target));
    }
}
