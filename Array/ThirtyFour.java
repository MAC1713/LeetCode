package Array;

import java.util.Arrays;

/**
 * @author mac
 */
public class ThirtyFour {
    static class Solution {
        public static int[] searchRange(int[] nums, int target) {
            int[] ans = {-1,-1};
            if (nums.length < 1){
                return ans;
            }
            int length = nums.length;
            int left = 0, right = length-1, middle = (left + right) / 2;
            int step = Math.max(5, length % 10);
            while(left < right){
                if(target < nums[middle]){
                    right = middle - 1;
                }else if(target > nums[middle]){
                    left = middle + 1;
                }else if(target == nums[middle]){
                    break;
                }
                middle = (left + right) / 2;
            }
            if (nums[middle] != target){
                return ans;
            }
            int leftTarget = middle, rightTarget = middle;
            boolean leftEnd = true, rightEnd = true;
            do {
                if (nums[leftTarget] == target && leftEnd) {
                    leftTarget -= step;
                    if (leftTarget < 0) {
                        leftTarget = 0;
                        leftEnd = false;
                    }
                    if (nums[leftTarget] != target) {
                        leftEnd = false;
                    }
                }
                if (nums[rightTarget] == target && rightEnd) {
                    rightTarget += step;
                    if (rightTarget > length - 1) {
                        rightTarget = length - 1;
                        rightEnd = false;
                    }
                    if (nums[rightTarget] != target) {
                        rightEnd = false;
                    }
                }
            } while (rightEnd || leftEnd);
            if (nums[leftTarget] == target){
                ans[0] = 0;
            }else {
                while (nums[leftTarget] != target){
                    leftTarget += 1;
                }
                ans[0] = leftTarget;
            }
            if (nums[rightTarget] == target){
                ans[1] = length - 1;
            }else {
                while (nums[rightTarget] != target){
                    rightTarget -= 1;
                }
                ans[1] = rightTarget;
            }
            return ans;
        }
    }
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,10,11,12,13,14,15,16,17,18,19,20};
        int target = 21;
        System.out.println(Arrays.toString(Solution.searchRange(nums, target)));
    }
}
