package DynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author mac
 */
public class NQueen {
    static class Solution {
        private int n;

        private int[] col;//保存皇后的位置，i是行，col[i]是列

        //onPath存储当前列是否使用过，diag1和diag2分别存储r+c和r-c是否使用过（r是行，c是列）
        private boolean[] onPath, diag1, diag2;

        private final List<List<String>> ans = new ArrayList<>();

        public List<List<String>> solveNQueens(int n) {
            this.n = n;

            col = new int[n];

            onPath = new boolean[n];

            diag1 = new boolean[n * 2 - 1];
            diag2 = new boolean[n * 2 - 1];

            dfs(0);
            return ans;

        }

        private void dfs(int r) {
            //遍历结束
            if (r == n) {
                List<String> board = new ArrayList<>(n);
                for (int c : col) {
                    char[] row = new char[n];
                    Arrays.fill(row, '.');
                    row[c] = 'Q';
                    board.add(new String(row));
                }
                ans.add(board);
                return;
            }
            for (int c = 0; c < n; ++c) {
                int rc = r - c + n - 1;//由于r-c可能存在负数，所以加上一个定值，保持相对位置不变

                if (!onPath[c] && !diag1[r + c] && !diag2[rc]) {
                    //放置皇后
                    col[r] = c;
                    onPath[c] = diag1[r + c] = diag2[rc] = true;
                    dfs(r + 1);
                    onPath[c] = diag1[r + c] = diag2[rc] = false; // 恢复现场
                }
            }
        }

        public void print(List<List<String>> ans){
            for (List<String> board : ans) {
                for (String row : board) {
                    System.out.println(row);
                }
                System.out.println();
            }
        }

        public static void main(String[] args) {
            Solution s = new Solution();
            List<List<String>> ans = s.solveNQueens(4);
            for (List<String> board : ans) {
                for (String row : board) {
                    System.out.println(row);
                }
                System.out.println();
            }
        }
    }
}
