package cn.bugstack.springframework.test.leetcode;

import org.junit.Test;

/**
 * @description: <p></p>
 * @author: DongxuHua
 * @create: at 2021-10-26 10:19 上午
 * @version: 1.0.0
 * @history: modify history             <desc>
 */
public class SoduKuTest {


    public void solveSudoku(char[][] board) {

        /**
         * 记录某行，某位数字是否已经被摆放
         */
        boolean[][] row = new boolean[9][9];
        /**
         * 记录某列，某位数字是否已经被摆放
         */
        boolean[][] col = new boolean[9][9];
        /**
         * 记录某 3x3 宫格内，某位数字是否已经被摆放
         */
        boolean[][] block = new boolean[9][9];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    int num = board[i][j] - '1';
                    row[i][num] = true;
                    col[j][num] = true;
                    // blockIndex = i / 3 * 3 + j / 3，取整
                    block[i / 3 * 3 + j / 3][num] = true;
                }
            }
        }
        System.out.println("----------  row  -----------");
        printBoolean(row);
        System.out.println("----------  col  -----------");
        printBoolean(col);
        System.out.println("----------  block  -----------");
        printBoolean(block);
        //dfs(board, row, col, block, 0, 0);
    }

    private void printBoolean(boolean[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
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

    private void printBoard(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    @Test
    public void test() {
        char[][] board = {
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}};

        solveSudoku(board);

        printBoard(board);


    }

}
