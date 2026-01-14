package String;

import java.lang.reflect.Array;

public class Three {
    public static void main(String[] args){
        String str = "qwkmkiopow";
        int ans = Three.lengthOfLongestSubstring(str);
        System.out.println(ans);
    }
    public static int lengthOfLongestSubstring(String s) {
        int[] last = new int[128];//建立一个128长度的数组last
        for(int i = 0; i < 128; i++) {//初始化数组为-1
            last[i] = -1;
        }
        int n = s.length();//获取字符串长度

        int res = 0;
        int start = 0; // 窗口开始位置
        for(int i = 0; i < n; i++) {//循环字符串长度"n"次
            int index = s.charAt(i);//让index等于字符串中第'i'位字母的ascii码值
            start = Math.max(start, last[index] + 1);//给start赋值为start自己与在last数组中第index位的数值加1相比中的最大值
            res   = Math.max(res, i - start + 1);//给res赋值为res自己与i-start+1相比中的最大值
            last[index] = i;//给last数组中第index位赋值为i
            for(int j = 0; j < last.length; j++){
                if(last[j] != -1){
                    System.out.print(last[j]);
                    System.out.print(' ');
                }
            }
        }

        return res;//输出结果res
    }
}
