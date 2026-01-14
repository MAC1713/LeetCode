package Array;

import java.util.HashMap;

/**
 * @author mac
 */
public class FiftyNine {
    static class Solution {
        public String getPermutation(int n, int k) {
            if (n == 1) {
                return "1";
            }
            StringBuilder ans = new StringBuilder();
            int[] factorial = new int[n];
            for (int i = 1; i <= n; i++){
                factorial[i - 1] = i;
            }
            while (k > 1){
                addArray(factorial, n);
                k--;
            }
            for (int i = 0; i < n; i++){
                ans.append(factorial[i]);
            }
            return ans.toString();
        }

        public static int[] addArray(int[] input, int n) {
            int carry = 0;
            HashMap <Integer, Integer> map = new HashMap<>(n);
            boolean flag = true;
            while (flag){
                int i = n - 1;
                int sum = input[i] + 1;
                carry = sum / (n + 1);
                if (carry == 1) {
                    input[i] = sum % (n);
                }else {
                    input[i] = sum;
                }
                while (carry == 1) {
                    i -= 1;
                    sum = input[i] + carry;
                    carry = sum / (n + 1);
                    if (carry == 1) {
                        input[i] = sum % (n);
                    }else {
                        input[i] = sum;
                    }
                }
                map = new HashMap<>(n);
                for (int j = 0; j < n; j++){
                    if (!map.containsKey(input[j])){
                        map.put(input[j], 1);
                    }else {
                        break;
                    }
                }
                if (map.size() == n && !map.containsKey(0)){
                    flag = false;
                }
            }
            return input;
        }

        public static void main(String[] args) {
            int n = 9;
            int k = 54494;
            Solution solution = new Solution();
            System.out.println(solution.getPermutation(n, k));
        }
    }
}
