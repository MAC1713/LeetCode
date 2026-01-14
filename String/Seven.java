package String;

public class Seven {
    class Solution {
        public static int reverse(int x) {
            long num = 0;
            while(x != 0){
                num = num * 10 + (x % 10);
                x = (x - x % 10) / 10;
            }
            return (int)num==num? (int)num:0;
        }
    }

    public static void main(String[] args) {
        int x = 1234;
        long ans = Solution.reverse(x);
        System.out.println(ans);
    }
}
