package cn.bugstack.springframework.test.leetcode;

import org.junit.Test;

/**
 * @description: <p></p>
 * @author: DongxuHua
 * @create: at 2021-10-30 1:46 下午
 * @version: 1.0.0
 * @history: modify history             <desc>
 */
public class LeastDistance {

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        /**
         *  Bellman Ford 算法
         */
        return 0;
    }

    @Test
    private void test() {
        int n = 3;
        int[][] flights = {{0, 1, 100}, {1, 2, 100}, {0, 2, 500}};
        int src = 0;
        int dst = 2;
        int k = 1;
        System.out.println(findCheapestPrice(n, flights, src, dst, k));
    }

}
