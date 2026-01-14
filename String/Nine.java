package String;

public class Nine {
    class Solution {
        public static boolean isPalindrome(int x) {
            if(x < 0){
                return false;
            }
            int[] ans = new int[10];
            int pos = 0;
            while(x != 0){
                ans[pos] = x % 10;
                x /= 10;
                pos += 1;
            }
            pos -= 1;
            for (int i = 0; i < (pos + 1) / 2; i++) {
                if(ans[i] != ans[pos - i]){
                    return false;
                }
            }
            return true;
        }
    }

    public static void main(String[] args) {
        boolean ans = false;
        int x = -1244321;
        ans = Solution.isPalindrome(x);
        System.out.println(ans);
    }
}
