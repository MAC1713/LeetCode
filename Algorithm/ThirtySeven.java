package Algorithm;

import java.util.HashSet;
import java.util.Set;

/**
 * @author mac
 */
public class ThirtySeven {
    static class Solution {
        public static void fillSudoku(char[][] board) {
            boolean changed = false;
            do {
                changed = false;
                for (int i = 0; i < 9; i++) {
                    for (int j = 0; j < 9; j++) {
                        if (board[i][j] == '.') {
                            Set<Character> candidates = computeCandidates(board, i, j);
                            if (candidates.size() == 1) {
                                char number = candidates.iterator().next();
                                board[i][j] = number;
                                changed = true;
                            }
                        }
                    }
                }
            } while (changed);
        }
        public static Set<Character> computeCandidates(char[][] board, int i, int j) {
            Set<Character> candidates = new HashSet<>();
            for (char c = '1'; c <= '9'; c++) {
                candidates.add(c);
            }
            for (int k = 0; k < 9; k++) {
                if (board[i][k] != '.') {
                    candidates.remove(board[i][k]);
                }
                if (board[k][j] != '.') {
                    candidates.remove(board[k][j]);
                }
                int blockRow = 3*(i/3) + k/3;
                int blockCol = 3*(j/3) + k%3;
                if (board[blockRow][blockCol] != '.') {
                    candidates.remove(board[blockRow][blockCol]);
                }
            }
            return candidates;
        }
        public void solveSudoku(char[][] board) {
            fillSudoku(board);
            boolean[][] row = new boolean[9][9];
            boolean[][] col = new boolean[9][9];
            boolean[][] block = new boolean[9][9];

            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    if (board[i][j] != '.') {
                        int num = board[i][j] - '1';
                        row[i][num] = true;
                        col[j][num] = true;
                        block[i / 3 * 3 + j / 3][num] = true;
                    }
                }
            }
            dfs(board, row, col, block, 0, 0);
        }

        private boolean dfs(char[][] board, boolean[][] row, boolean[][] col, boolean[][] block, int i, int j) {
            // 找寻空位置
            while (board[i][j] != '.') {
                if (++j >= 9) {
                    i++;
                    j = 0;
                }
                if (i >= 9) {
                    return true;
                }
            }
            for (int num = 0; num < 9; num++) {
                int blockIndex = i / 3 * 3 + j / 3;
                if (!row[i][num] && !col[j][num] && !block[blockIndex][num]) {
                    // 递归
                    board[i][j] = (char) ('1' + num);
                    row[i][num] = true;
                    col[j][num] = true;
                    block[blockIndex][num] = true;
                    printBoard(board);
                    if (dfs(board, row, col, block, i, j)) {
                        return true;
                    } else {
                        // 回溯
                        row[i][num] = false;
                        col[j][num] = false;
                        block[blockIndex][num] = false;
                        board[i][j] = '.';
                    }
                }
            }
            return false;
        }

        public static void printBoard(char[][] board) {
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    System.out.print(board[i][j] + " ");
                }
                System.out.println();
            }
            System.out.println("--------------------------------");
        }

        public static void main(String[] args) {
            char[][] board = new char[][]{
                    {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                    {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                    {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                    {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                    {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                    {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                    {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                    {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                    {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
            };
            Solution solution = new Solution();
            solution.solveSudoku(board);
            printBoard(board);
        }
    }
}
