package Array;

public class Twenty_six {
    class Solution {
        //对返回有不符题意的修改，注意替换回题目
        public static int[] removeDuplicates(int[] nums) {
            if (nums.length <= 1) {
                return nums;
            }
            int l = 0;
            int r = 1;
            int len = nums.length;
            while (r < len && l < r) {
                if (nums[l] != nums[r]) {
                    l++;
                    r++;
                } else if (nums[l] == nums[len - 1]) {
                    return nums;
                } else {
                    while (nums[l] == nums[r]) {
                        if (r < len - 1) {
                            r++;
                        } else {
                            System.out.println(l + 1);
                            return nums;
                        }
                    }
                    l++;
                    nums[l] = nums[r];
                }
            }
            return nums;
        }
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 1, 2, 2, 2, 3, 4, 5, 6, 6, 6, 7, 8, 8};
        nums = Solution.removeDuplicates(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.printf(nums[i] + ", ");
        }
    }
}
