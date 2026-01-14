package Array;

/**
 * @author mac
 */
public class FortyTwo {
    static class Solution {
        public int trap(int[] height) {
            int len = height.length;
            if (len <= 2){
                return 0;
            }
            int water = 0;
            int left = 0;
            int right = len - 1;
            water = pool(height, left, right);
            return water;
        }

        private int pool(int[] height, int left, int right){
            int water = 0;
            while (left < right){
                water += Math.max(0, Math.min(height[left], height[right]) - height[left]);
                left++;
                right--;
            }
            return water;
        }

        public static void main(String[] args) {
            Solution solution = new Solution();
            int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
            System.out.println(solution.trap(height));
        }
    }
}
