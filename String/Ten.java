package String;

public class Ten {
    class Solution {
        public static boolean isMatch(String s, String p) {
//            if (p.length() < s.length()) {
//                return false;
//            }
//
//            char[] p_arr = p.toCharArray();
//            for (int i = 0; i < p_arr.length; i++) {
//                if (i == 0) {
//                    continue;
//                }
//                if (p_arr[i] == '*') {
//                    p_arr[i] = p_arr[i - 1];
//                }
//            }
//            p_arr.toString();
//            System.out.println(p_arr);
//            int position = 0;
//            int same_position = 0;
//
//            while (p_arr.length - same_position > s.length()) {
//                position = 0;
//                for (int i = same_position; i < p_arr.length; i++) {
//                    if(s.charAt(0) == p_arr[i] || p_arr[i] == 0){
//                        same_position = i;
//                        break;
//                    }
//                }
//                System.out.println(same_position);
//
//                while (position < s.length()) {
//                    if (s.charAt(position) != p_arr[same_position] && p_arr[same_position] != '.') {
//                        if(position > (p_arr.length - same_position)){
//                            return false;
//                        }
//                        break;
//                    }
//                    same_position += 1;
//                    position += 1;
//                }
//
//            }
//
//            return true;
            return s.matches(p);
        }
    }

    public static void main(String[] args) {
        boolean ans = false;
        String s = "ab";
        String p = ".*c";
        ans = Solution.isMatch(s, p);
        System.out.println(ans);
    }
}
