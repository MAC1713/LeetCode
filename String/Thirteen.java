package String;

public class Thirteen {
    class Solution {
        public static int romanToInt(String s) {
            int ans = 0;
            int[] sin_values = {1000, 500, 100,  50,  10,   5,  1};
            char[] sin_reps = {'M', 'D', 'C', 'L', 'X', 'V', 'I'};
            int[] dou_values = {  900,  400,   90,   40,    9,   4};
            String[] dou_reps = {"CM", "CD", "XC", "XL", "IX", "IV"};
            for (int i = 0; i < dou_reps.length; i++) {
                if(s.indexOf(dou_reps[i]) >= 0){
                    ans += dou_values[i];
                    s = s.replace(dou_reps[i], "");
                }
            }
            for (int i = 0; i < s.length(); i++) {
                for (int j = 0; j < sin_reps.length; j++) {
                    if(s.charAt(i) == sin_reps[j]){
                        ans += sin_values[j];
                        break;
                    }

                }
            }

            return ans;
        }
    }
    public static void main(String[] args) {
        String s = "LVIII";
        int ans = Solution.romanToInt(s);
        System.out.println(ans);
    }
}
