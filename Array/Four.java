package Array;

public class Four {
    class Solution {

        public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
            double ans = 0;
            int aHead = 0, aEnd = nums1.length;
            int bHead = 0, bEnd = nums2.length;
            double left = 0, right = 0;
            for (int i = 0; i <= (aEnd + bEnd) / 2; i++) {
                left = right;
                if(aHead < aEnd && (bHead >= bEnd || nums1[aHead] <= nums2[bHead])){
                    right = (double) nums1[aHead++];
                }else{
                    right = (double) nums2[bHead++];
                }
            }

            if((aEnd + bEnd) % 2 == 0){
                return (left + right) / 2;
            }else{
                return right;
            }
        }
    }

    public static void main(String[] args) {
        int[] a = {9, 12, 13};
        int[] b = {1, 2, 11, 14, 15, 16};
        double ans = 0;
        ans = Solution.findMedianSortedArrays(a, b);
        System.out.println(ans);
    }
}
