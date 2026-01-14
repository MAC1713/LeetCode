package String;

public class Twelve {
    class Solution {
        /*
        *   I             1
            V             5
            X             10
            L             50
            C             100
            D             500
            M             1000
            * IV = 4
            * IX = 9
            * XL = 40
            * XC = 90
            * CD = 400
            * CM = 900
*/
        public static String intToRoman(int num) {
            String s = "";
            int[] values={1000,900,500,400,100,90,50,40,10,9,5,4,1};
            String[] reps={"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
            for (int i = 0; i < values.length; i++) {
                while(num >= values[i]){
                    s = s + reps[i];
                    num -= values[i];
                }
            }

            return s;
        }
    }

    public static void main(String[] args) {
        int num = 3494;
        String ans = Solution.intToRoman(num);
        System.out.println(ans);
    }
}
