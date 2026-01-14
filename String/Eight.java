package String;

public class Eight {
    class Solution {
        public static int myAtoi(String s) {
            long ans = 0;
            int position = 0;
            int zf = 0;
            while(position < s.length()){
                if(s.charAt(position) == ' '){
                    position += 1;
                    continue;
                }
                if(!Character.isDigit(s.charAt(position)) && (s.charAt(position) != '-' && s.charAt(position) != '+')){
                    return 0;
                }
                if(position + 1 <= s.length()){
                    if(!Character.isDigit(s.charAt(position)) && !Character.isDigit(s.charAt(position + 1))){
                        return 0;
                    }
                }
                if(s.charAt(position) == '-' && position + 1 < s.length() && Character.isDigit(s.charAt(position + 1))){
                    zf = 1;
                }
                if(Character.isDigit(s.charAt(position))){
                    ans = ans * 10 + (s.charAt(position) - '0');
                    if(ans > (2147483647)){
                        if(zf == 1){
                            return -2147483648;
                        }
                        return 2147483647;
                    }
                    if(position + 1 >= s.length()){
                        if(zf == 1){
                            ans *= -1;
                        }
                        if(ans > (2147483647)){
                            return 2147483647;
                        }
                        if(ans < -2147483648){
                            return -2147483648;
                        }
                        return (int)ans;
                    }
                    if(!Character.isDigit(s.charAt(position + 1))){
                        if(zf == 1){
                            ans *= -1;
                        }
                        if(ans > (2147483647)){
                            return 2147483647;
                        }
                        if(ans < -2147483648){
                            return -2147483648;
                        }
                        return (int)ans;
                    }
                }
                position += 1;
            }
            if(zf == 1){
                ans *= -1;
            }
            if(ans > (2147483647)){
                return 2147483647;
            }
            if(ans < -2147483648){
                return -2147483648;
            }
            return (int)ans;
        }
    }

    public static void main(String[] args) {
        String s = "    +982234327phg";
        int ans = Solution.myAtoi(s);
        System.out.println(ans);
    }
}
