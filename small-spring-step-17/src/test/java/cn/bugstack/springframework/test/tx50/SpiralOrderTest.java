package cn.bugstack.springframework.test.tx50;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class SpiralOrderTest {

    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return new ArrayList<>();
        }
        List<Integer> list = new ArrayList<>();
        int startAbscissa = 0;
        int abscissa = matrix.length - 1;
        int startOrdinate = 0;
        int ordinate = matrix[0].length - 1;

        int min = Math.min(abscissa + 1, ordinate + 1);
        if (min % 2 != 0) {
            min = min / 2 + 1;
        } else {
            min = min / 2;
        }
        for (int i = 0; i < min; i++) {
            skipNums(list, matrix, startAbscissa, abscissa, startOrdinate, ordinate);
            startAbscissa++;
            abscissa--;
            startOrdinate++;
            ordinate--;
        }

        return list;
    }

    private void skipNums(List<Integer> list, int[][] matrix, int startAbscissa, int abscissa, int startOrdinate, int ordinate) {

        // 下 -> 上 读取
        for (int i = startOrdinate; i <= ordinate; i++) {
            list.add(matrix[startAbscissa][i]);
        }
        // 左 -> 右 读取
        for (int i = startAbscissa + 1; i <= abscissa; i++) {
            list.add(matrix[i][ordinate]);
        }
        // 上 -> 下
        for (int i = ordinate - 1; i >= startOrdinate; i--) {
            if (startAbscissa != abscissa){
                list.add(matrix[abscissa][i]);
            }
        }
        // 右 —> 左 读取
        for (int i = abscissa - 1; i >= startAbscissa + 1; i--) {
            if (startOrdinate != ordinate){
                list.add(matrix[i][startOrdinate]);
            }
        }
    }

    @Test
    public void test() {
//        int[][] nums = {{1,2,3},{4,5,6},{7,8,9}};
//        int[][] nums = {};
//        int[][] nums = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
//        int[][] nums = {{1,2,3,4}};
        int[][] nums = {{1},{2},{3},{4}};
        List<Integer> list = spiralOrder(nums);

        if (list != null && list.size() != 0) {
            list.stream().forEach(n -> {
                System.out.println(n);
            });
        }
    }



}
