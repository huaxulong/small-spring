package cn.bugstack.springframework.test.tx50;

import org.junit.Test;

/**
 * @description: maxPathSumTest
 * <p></p>
 * @author: DongxuHua
 * @create: at 2021-11-08 5:32 下午
 * @version: 1.0.0
 * @history: modify history             <desc>
 */
public class MaxPathSumTest {

    private int total = 0;

    public int maxPathSum(TreeNode root) {

        return 1;
    }

    private void getPath(TreeNode root) {
        if (root.left != null){
            getPath(root.left);
        }
    }

    @Test
    public void test() {

    }

}
