package Draw;

public class Six {
    class Solution {
        public static String convert(String s, int numRows) {
            if(numRows == 1){
                return s;
            }
            int pos = 0;
            int space = 2 * numRows - 3;
            int testPos = 0;
            int mostSpace = space;
            String ans = "";
            for (int i = 0; i < numRows; i++) {
                int num = pos;
                for (int j = 0; j < s.length(); j++) {
                    if (num < s.length() && num >= 0) {
                        System.out.print(s.charAt(num));
                        ans = ans + s.charAt(num);
                        num = num + space + 1;
                        for (int k = 0; k < mostSpace - testPos; k++) {
                            System.out.print(" ");
                        }
                        if (testPos != 0 && i <= numRows - 1) {
                            if(num >= s.length()){
                                break;
                            }
                            if(i < numRows - 1) {
                                System.out.print(s.charAt(num));
                                ans = ans + s.charAt(num);
                            }
                            num = num + 2 * i;
                        }
                        for (int k = 0; k < mostSpace - (mostSpace - testPos) - 1; k++) {
                            System.out.print(" ");
                        }
                    }
                }
                testPos += 2;
                pos += 1;
                space -= 2;
                System.out.println("");
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        String str = "asdfghjklkjhgfdsdfghjb";
        int line = 6;
        String ans = Solution.convert(str, line);
        System.out.println(ans);
    }
}
