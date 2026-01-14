package Algorithm;

import java.util.Arrays;
import java.util.List;

import java.util.ArrayList;


public class ThreeSixEight {
    static class Solution {
        public List<Integer> largestDivisibleSubset(int[] nums) {
            Arrays.sort(nums);
            List<Integer> ans = new ArrayList<>();
            if (nums.length == 1){
                ans.add(nums[0]);
                return ans;
            }
            int n = nums.length;
            int maxVul = -1;
            int maxPos = -1;
            int[] f = new int[n];
            int[] g = new int[n];
            for (int i = 0; i < n; i++) {
                int maxLen = 1;
                int prePos = i;
                for (int j = 0; j < i; j++) {
                    if (nums[i] % nums[j] == 0 && (f[j] + 1 > maxLen)){
                        maxLen = f[j] + 1;
                        prePos = j;
                    }
                }
                f[i] = maxLen;
                g[i] = prePos;
                if (maxLen > maxVul){
                    maxVul = maxLen;
                    maxPos = i;
                }
            }

            while (ans.size() != maxVul) {
                ans.add(nums[maxPos]);
                maxPos = g[maxPos];
            }

            return ans;
        }
    }

    public static void main(String[] args) {
        int[] nums = {9,18,54,90,108,180,360,540,720};
        int[] nums2 = {1,2,4,8};
        int[] nums3 = {2,3,4,9,8};
        int[] num4 = {2,3,5,7,11};
        Solution solution = new Solution();
        List<Integer> result = solution.largestDivisibleSubset(nums3);
        System.out.println(result);
    }
}
