package cn.bugstack.springframework.test.tx50;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class SpiralOrderTest {

    List<Integer> list = new ArrayList<>();

    public List<Integer> spiralOrder(int[][] matrix) {
        return null;
    }

    private void skipNums(int[][] matrix) {
        int abscissa = matrix.length;
        int ordinate = matrix[0].length;

        // 最上面读取一横
        for (int i = 0; i < abscissa; i++) {
            list.add(matrix[abscissa][ordinate - 1]);
        }
        // 往下读取一列
        for (int i = 1; i < ordinate; i++) {
            list.add(matrix[abscissa - 1][ordinate - i - 2]);
        }
        // 往左边读取
        for (int i = 1; i < abscissa; i++) {
            list.add(matrix[abscissa - i -2][0]);
        }
        // 从下往上读取
        for (int i = 2; i < ordinate; i++) {
            list.add(matrix[0][i+1]);
        }

    }

    @Test
    public void test() {

    }

}
