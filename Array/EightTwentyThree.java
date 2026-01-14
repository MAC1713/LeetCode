package Array;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author mac
 */
public class EightTwentyThree {
    private static class Solution {
        public static int numFactoredBinaryTrees(int[] arr) {
            if (arr.length == 1) {
                return 1;
            }
            long ans = 0L;
            int mod = (int)(1e9 + 7);
            Arrays.sort(arr);
            HashMap<Integer, Integer> tree = new HashMap<Integer, Integer>(arr.length);
            for (int j : arr) {
                tree.put(j,1);
                for (int k : arr) {
                    if (j <= k){
                        break;
                    }
                    if (j % k == 0 && tree.containsKey(j/k)) {
                        tree.put(j, (int) ((((long) tree.get(k) * (long) tree.get(j / k))%mod + tree.get(j))%mod));
                    }
                }
                ans += tree.get(j);
                ans %= mod;
            }
            return (int)ans;
        }
    }
    public static void main(String[] args) {
        int[] nums = {2,4,5,10,20,100,200,400};
        System.out.println(Solution.numFactoredBinaryTrees(nums));
    }
}
