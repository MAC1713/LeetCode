package Math;

public class ThreeFourThree {
    static class Solution {
        public int integerBreak(int n) {
            if (n <= 2){
                return 1;
            }
            int twoCount = 0;
            int threeCount = (n - n % 3) / 3;
            int fourCount = 0;
            if (n % 3 == 1) {
                threeCount -= 1;
                fourCount += 1;
            } else if (n % 3 == 2) {
                twoCount += 1;
            }
            return (int) (Math.pow(2, twoCount) * Math.pow(3, threeCount) * Math.pow(4, fourCount));
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int n = 4;
        int result = solution.integerBreak(n);
        System.out.println(result);
    }
}
