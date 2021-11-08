package cn.bugstack.springframework.test.tx50;

import org.junit.Test;

/**
 * @description: <p></p>
 * @author: DongxuHua
 * @create: at 2021-11-08 10:13 上午
 * @version: 1.0.0
 * @history: modify history             <desc>
 */
public class MaxProfitTest {

    public int maxProfit(int[] prices) {
        if(prices.length <= 1)
            return 0;
        int min = prices[0], max = 0;

        for (int i = 1; i < prices.length; i++) {
            max = Math.max(max, prices[i] - min);
            min = Math.min(min, prices[i]);
        }

        return max;
    }


    @Test
    public void test() {
        //int[] prices = {7, 1, 5, 3, 6, 4};
        int[] prices = {7, 6, 4, 3, 1};

        System.out.println(maxProfit(prices));
    }

}
