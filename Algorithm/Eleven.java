package Algorithm;

public class Eleven {
    class Solution {
        public static int maxArea(int[] height) {
            int min = 0;
            int l = 0, r = height.length - 1;
            int max = 0;
            while(l < r){
                int minH = Math.min(height[l], height[r]);
                min = (r - l) * Math.min(height[l], height[r]);
                max = Math.max(max, min);
                while(l < r && height[l] <= minH){
                    l++;
                }
                while(r > l && height[r] <= minH){
                    r--;
                }
            }
            return max;
        }
    }

    public static void main(String[] args) {
        int[] arr = {1,8,6,2,5,4,8,3,7};
        int ans = Solution.maxArea(arr);
        System.out.println(ans);
    }
}
