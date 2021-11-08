package cn.bugstack.springframework.test.tx50;

import org.junit.Test;

/**
 * @description: uniquePathsTest
 * <p></p>
 * @author: DongxuHua
 * @create: at 2021-11-07 1:50 下午
 * @version: 1.0.0
 * @history: modify history             <desc>
 */
public class UniquePathsTest {

    public int uniquePaths(int m, int n) {
        // 通过寻找规律， 构成矩阵，
        /**
         *     满足以下要求， 便可以快读构建填充 m * n 的矩阵， 快速填充矩阵的内容。 最后取出最后一个的数据即可
         */
        int[][] nums = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0) {
                    nums[i][j] = 1;
                } else if (j == 0) {
                    nums[i][j] = 1;
                } else {
                    nums[i][j] = nums[i - 1][j] + nums[i][j - 1];
                }
            }
        }
        return nums[m - 1][n - 1];
    }

    @Test
    public void test() {
        int m = 3;
        int n = 7;

        System.out.println(uniquePaths(m, n));
    }

}
