package Algorithm;

import java.util.Arrays;

public class Sixteen {
    class Solution {
        public static int threeSumClosest(int[] nums, int target) {
            int ans = nums[0] + nums[1] + nums[2];
            Arrays.sort(nums);
            int temp_sum = ans;
            int temp_ans = ans;
            for (int i = 0; i < nums.length - 2; i++) {
                int l = i + 1, r = nums.length - 1;
                while (l < r) {
                    int sum = nums[i] + nums[l] + nums[r];
                    if (sum == target) {
                        return sum;
                    }
                    temp_sum = Math.abs(sum - target);
                    temp_ans = Math.abs(ans - target);
                    if (temp_sum < temp_ans) {
                        ans = sum;
                        if(sum > target){
                            if (l < r && nums[r] >= nums[r - 1]) {
                                while (l < r && nums[r] == nums[r - 1]) {
                                    r--;
                                }
                                r--;
                            }
                        } else {
                            if (l < r && nums[l] <= nums[l + 1]) {
                                while (l < r && nums[l] == nums[l + 1]) {
                                    l++;
                                }
                                l++;
                            }
                        }
                    } else if (temp_sum == temp_ans) {
                        ans = sum;
                        if(sum > target){
                            if (l < r && nums[r] >= nums[r - 1]) {
                                while (l < r && nums[r] == nums[r - 1]) {
                                    r--;
                                }
                                r--;
                            }
                        } else {
                            if (l < r && nums[l] <= nums[l + 1]) {
                                while (l < r && nums[l] == nums[l + 1]) {
                                    l++;
                                }
                                l++;
                            }
                        }
                    } else {
                        if(sum > target){
                            if (l < r && nums[r] >= nums[r - 1]) {
                                while (l < r && nums[r] == nums[r - 1]) {
                                    r--;
                                }
                                r--;
                            }
                        } else {
                            if (l < r && nums[l] <= nums[l + 1]) {
                                while (l < r && nums[l] == nums[l + 1]) {
                                    l++;
                                }
                                l++;
                            }
                        }
                    }
                }
                while (i < nums.length - 2 && nums[i] == nums[i + 1]) {
                    i++;
                }
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        int[] num = {0, 0, 0};
        int target = 1;
        int ans = Solution.threeSumClosest(num, target);
        System.out.println(ans);
    }
}
