package Algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Eighteen {
    static class Solution {
        public static List<List<Integer>> fourSum(int[] nums, int target) {
            List<List<Integer>> ans = new ArrayList<>(nums.length > 256 ? nums.length : 256);
            Arrays.sort(nums);
            if (nums.length < 4 || (nums[0] > 0 && nums[0] > target) || (nums[nums.length - 1] < 0 && nums[nums.length - 1] < target) || nums[0] == 1000000000 || nums[0] == -1000000000) {
                return ans;
            }
            int sum4 = nums[0] + nums[1] + nums[2] + nums[3];
            long max3 = nums[nums.length - 1] + nums[nums.length - 2] + nums[nums.length - 3];
            int i = 0;
            for (i = 0; i < nums.length - 3; i++) {
                if (sum4 > target) {
                    break;
                }
                if (i + 4 < nums.length) {
                    sum4 = sum4 - nums[i] + nums[i + 4];
                }
                if (nums[i] + max3 < target && nums[nums.length - 1] != 1000000000) {
                    continue;
                }
                if (i > 0 && nums[i] == nums[i - 1]) {
                    continue;
                }
                int j = i + 1;
                for (j = i + 1; j < nums.length - 2; j++) {
                    if(j > i + 1 && nums[j] == nums[j - 1]){
                        continue;
                    }
                    int sumij = nums[i] + nums[j];
                    int l = j + 1, r = nums.length - 1;
                    while (l < r) {
                        int sumijlr = sumij + nums[l] + nums[r];
                        if (sumijlr > target) {
                            while (l < r && nums[r] == nums[r - 1]) {
                                r--;
                            }
                            r--;
                        } else if (sumijlr == target) {
                            ans.add(Arrays.asList(nums[i], nums[j], nums[l], nums[r]));
                            while (l < r && nums[r] == nums[r - 1]) {
                                r--;
                            }
                            r--;
                        } else {
                            while (l < r && nums[l] == nums[l + 1]) {
                                l++;
                            }
                            l++;
                        }
                    }
                }
            }

            return ans;
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {0,0,0,1000000000,1000000000,1000000000,1000000000};
        int target1 = 1000000000;
        List<List<Integer>> ans1 = Solution.fourSum(nums1, target1);
        System.out.println(ans1);
//
//        int[] nums2 = {2,2,2,2,2};
//        int target2 = 8;
//        List<List<Integer>> ans2 = Solution.fourSum(nums2, target2);
//        System.out.println(ans2);

//        int[] nums3 = {-3, -2, -1, 0, 0, 1, 2, 3};
//        int target3 = 0;
//        List<List<Integer>> ans3 = Solution.fourSum(nums3, target3);
//        System.out.println(ans3);

    }
}
