package cn.bugstack.springframework.test.tx50;

import org.junit.Test;

import java.util.List;
import java.util.Scanner;

/**
 * @description: GenerateMatrixTest
 * <p></p>
 * @author: DongxuHua
 * @create: at 2021-11-03 3:20 下午
 * @version: 1.0.0
 * @history: modify history             <desc>
 */
public class GenerateMatrixTest {

    public int[][] generateMatrix(int n) {
        int[][] nums = new int[n][n];
        int min = n + 1;
        if (min % 2 != 0) {
            min = min / 2 + 1;
        } else {
            min = min / 2;
        }
        int summy = 1;
        for (int i = 0; i < min; i++) {
            summy = skipNums(nums, i, n - 1 - i, i, n - 1 - i , summy);
        }
        return nums;
    }

    private int skipNums(int[][] nums, int startAbscissa, int abscissa, int startOrdinate, int ordinate, int count) {

        // 下 -> 上 读取
        for (int i = startOrdinate; i <= ordinate; i++) {
            nums[startAbscissa][i] = count;
            count ++;
        }
        // 左 -> 右 读取
        for (int i = startAbscissa + 1; i <= abscissa; i++) {
            nums[i][ordinate] = count;
            count ++;
        }
        // 上 -> 下
        for (int i = ordinate - 1; i >= startOrdinate; i--) {
            if (startAbscissa != abscissa){
                nums[abscissa][i] = count;
                count ++;
            }
        }
        // 右 —> 左 读取
        for (int i = abscissa - 1; i >= startAbscissa + 1; i--) {
            if (startOrdinate != ordinate){
                nums[i][startOrdinate] = count;
                count ++;
            }
        }
        return count;
    }

    @Test
    public void test() {
        /*Scanner scanner = new Scanner(System.in);
        System.out.println("请输入数值:");
        int count = scanner.nextInt();*/
        int count = 3;
        int[][] matrix = generateMatrix(count);

        print(matrix);

    }

    private void print(int[][] nums) {
        if (nums == null || nums.length == 0){
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[0].length; j++) {
                System.out.print(nums[i] + "\t");
            }
            System.out.println();
        }
    }

}
