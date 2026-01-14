package String;

public class Nine_2 {
    class Solution {
        public static boolean isPalindrome(int x) {
            if(x < 0){
                return false;
            }
            int ori = x;
            int rev = 0;
            while(ori != 0){
                rev =rev * 10 + ori % 10;
                ori /= 10;
            }
            return rev == x;
        }
    }

    public static void main(String[] args) {
        boolean ans = false;
        int x = 12344321;
        ans = Solution.isPalindrome(x);
        System.out.println(ans);
    }
}
