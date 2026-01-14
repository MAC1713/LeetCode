package Algorithm;

import static java.util.Arrays.sort;

/**
 * @author mac
 */
public class TwoFiveNineFour {
    static class Solution {
        public long repairCars(int[] ranks, int cars) {
            sort(ranks);
            long maxTime = (long) ranks[0] * cars * cars;
            long minTime = 0;
            long midTime = minTime + (maxTime - minTime) / 2;
            while (minTime < maxTime) {
                if (check(ranks, cars, midTime)) {
                    maxTime = midTime;
                } else {
                    minTime = midTime + 1;
                }
                midTime = minTime + (maxTime - minTime) / 2;
            }
            return maxTime;
        }
        private static boolean check(int[] ranks, int cars, long time) {
            long sum = 0;
            for (int i : ranks) {
                sum += Math.sqrt(time/i);
            }
            return sum >= cars;
        }
        public static void main(String[] args) {
            Solution solution = new Solution();
            int[] ranks = {1, 3, 2, 4, 7};
            int cars = 2;
            System.out.println(solution.repairCars(ranks, cars));
        }
    }
}
