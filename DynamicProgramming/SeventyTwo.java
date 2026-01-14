package DynamicProgramming;

public class SeventyTwo {
    static class Solution {
        public int minDistance(String text1, String text2) {
            char[] s = text1.toCharArray(), t = text2.toCharArray();
            int n = s.length, m = t.length;
            int[][] f = new int[n + 1][m + 1];
            System.out.println("1");
            printArray(f);
            for (int j = 1; j <= m; ++j) {
                f[0][j] = j;
            }
            for (int i = 0; i < n; ++i) {
                f[i + 1][0] = i + 1;
                printArray(f);
                for (int j = 0; j < m; ++j) {
                    f[i + 1][j + 1] = s[i] == t[j] ? f[i][j] :
                            Math.min(Math.min(f[i][j + 1], f[i + 1][j]), f[i][j]) + 1;
                    System.out.println((i + 2) + "行" + (j + 2) + "列" + "=(" + s[i] + "=" + t[j] + ")? (" + (i + 1) + "行" + (j + 1) + "列):" + f[i][j] + " : min( min((" + (i + 1) + "行" + (j + 2) + "列):" + f[i][j + 1] + "，(" + (i + 2) + "行" + (j + 1) + "列):" + f[i + 1][j] + ") ,(" + (i + 1) + "行" + (j + 1) + "列):" + f[i][j] + ") + 1");
                    printArray(f);
                    System.out.println("################################");
                }
            }
            System.out.println("3");
            printArray(f);
            return f[n][m];
        }

        public void printArray(int[][] arr) {
            for (int[] a : arr) {
                for (int b : a) {
                    System.out.print(b + " ");
                }
                System.out.println();
            }
        }

        public static void main(String[] args) {
            Solution s = new Solution();
            System.out.println(s.minDistance("sea", "eat"));
            System.out.println(s.minDistance("abc", "abd"));
        }
    }
}
