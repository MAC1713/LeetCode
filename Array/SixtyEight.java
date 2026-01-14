package Array;

import java.util.ArrayList;
import java.util.List;

/**
 * @author mac
 */
public class SixtyEight {
    static class Solution {
        public List<String> fullJustify(String[] words, int maxWidth) {
            List<String> res = new ArrayList<>();
            int len = words.length;
            int start = 0, end = 0;
            boolean isLast = false;
            while (end < len) {
                // 找到当前行的最后一个单词
                int line = 0;
                int numSpace = 0;
                while (end < len && line <= maxWidth){
                    end++;
                    numSpace ++;
                    line += words[end - 1].length();
                    if (line + (numSpace - 1)> maxWidth){
                        end --;
                        line -= words[end].length();
                        break;
                    }
                }
                if (end == len && line <= maxWidth){
                    isLast = true;
                }
                StringBuilder sb = new StringBuilder();
                int numWords = end - start;
                if (numWords == 1) {
                    sb.append(words[start]);
                    sb.append(" ".repeat(Math.max(0, maxWidth - words[start].length())));
                } else if (numWords > 1){
                    int spaces = (maxWidth - line) / (numWords - 1);
                    int extra = (maxWidth - line) % (numWords - 1);
                    if (isLast){
                        spaces = 1;
                        extra = 0;
                    }
                    for (int i = start; i < end - 1; i++) {
                        sb.append(words[i]);
                        sb.append(" ".repeat(Math.max(0, spaces)));
                        if (extra > 0) {
                            sb.append(' ');
                            extra--;
                        }
                    }
                    sb.append(words[end - 1]);
                    if (isLast){
                        sb.append(" ".repeat(Math.max(0, maxWidth - sb.length())));
                    }
                }
                res.add(sb.toString());
                start = end;
            }
            return res;
        }

        public static void main(String[] args) {
            Solution solution = new Solution();
            System.out.println(solution.fullJustify(new String[]{"What","must","be","acknowledgment","shall","be"}, 16));
        }
    }
}
