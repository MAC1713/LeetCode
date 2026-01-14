package Array;

import static java.util.Arrays.sort;

/**
 *
 * @author MAC1713
 * @email 1172820376@qq.com
 * @date 2023-08-03 03:31:08
 */
public class ThirtyOne {
    private static class Solution {
        //对返回有不符题意的修改，注意替换回题目
        public static int[] nextPermutation(int[] nums) {
            boolean biggest = true;
            int end = nums.length - 1;
            int tmp = 0;
            if (nums.length == 1){
                return nums;
            }
            if (nums[end - 1] < nums[end]){
                tmp = nums[end];
                nums[end] = nums[end - 1];
                nums[end - 1] = tmp;
                return nums;
            }
            int maxPosition = end;
            int midPosition = end;
            int minPosition = end;
            while (midPosition > 1){
                if (nums[midPosition - 1] >= nums[maxPosition]){
                    midPosition -= 1;
                    maxPosition -= 1;
                    minPosition -= 1;
                }

                if (nums[midPosition - 1] < nums[minPosition + 1]){
                    midPosition -= 1;
                    minPosition += 1;
                    while (nums[midPosition] < nums[minPosition] && minPosition < nums.length - 1){
                        minPosition += 1;
                        if (nums[minPosition] <= nums[midPosition]){
                            minPosition -= 1;
                            break;
                        }
                    }
                    swap(nums, minPosition, midPosition);
                    sort(nums, maxPosition, end + 1);
                    biggest = false;
                    break;
                }

                if (nums[midPosition - 1] < nums[maxPosition]){
                    midPosition -= 1;
                    swap(nums, midPosition, maxPosition);
                    sort(nums, maxPosition, end + 1);
                    biggest = false;
                    break;
                }
            }
            if (biggest){
                sort(nums);
            }
            return nums;
        }
        public static void swap(int[] nums, int i, int j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }
//1 2 3 1 2 2 5 3
    public static void main(String[] args) {
        int[] nums = {2,2,7,5,4,3,2,2,1};
        Solution.nextPermutation(nums);
        for (int j : nums) {
            System.out.printf(j + ", ");
        }
    }
}
