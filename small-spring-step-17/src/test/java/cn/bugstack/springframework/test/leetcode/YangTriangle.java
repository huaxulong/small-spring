package cn.bugstack.springframework.test.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: <p></p>
 * @author: DongxuHua
 * @create: at 2021-10-27 6:31 下午
 * @version: 1.0.0
 * @history: modify history             <desc>
 */
public class YangTriangle {

    /**
     * 生成杨辉三角
     * @param numRows
     * @return
     */
    public List<List<Integer>> generate(int numRows) {
        if (numRows == 0){
            return null;
        }
        if (numRows < 0){
            throw new RuntimeException();
        }
        /**
         * 第一遍填充 1 的流程
         */
        for (int i = 0; i < numRows; i++) {
            List<Integer> list = new ArrayList<>();

        }
        /**
         * 第二遍填充其余数据
         */
        return null;
    }

}
