package Array;

public class TwentySeven {
    static class Solution {
        //对返回有不符题意的修改，注意替换回题目
        public static int[] removeElement(int[] nums, int val) {
            int len = nums.length;
            int useLen = len;
            int l = 0;
            for (l = 0; l < useLen; l++) {
                if (nums[l] == val) {
                    while (nums[useLen - 1] == val) {
                        if (useLen > l + 1) {
                            useLen--;
                        } else {
                            System.out.println(l);
                            return nums;
                        }
                    }
                    nums[l] = nums[useLen - 1];
                    useLen--;
                }
            }
            System.out.println(l);
            return nums;
        }
    }

    public static void main(String[] args) {
        int[] nums = {0,1,2,2,3,0,4,2};
        int val = 2;
        nums = Solution.removeElement(nums, val);
        for (int i = 0; i < nums.length; i++) {
            System.out.printf(nums[i] + ", ");
        }
    }
}
