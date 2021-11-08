package cn.bugstack.springframework.test.tx50;

import org.junit.Test;

/**
 * @description: <p></p>
 * @author: DongxuHua
 * @create: at 2021-11-08 11:30 上午
 * @version: 1.0.0
 * @history: modify history             <desc>
 */
public class NmaxProfitTest {

    public int maxProfit(int[] prices) {
        if (prices.length < 2) {
            return 0;
        }
        int max = 0;
        for (int i = 0; i < prices.length; i++) {
            int minIndex = i;
            while (true) {
                if (i + 2 <= prices.length && prices[i + 1] >= prices[i]) {
                    i++;
                } else {
                    break;
                }
            }
            max = max + prices[i] - prices[minIndex];
        }
        return max;
    }

    @Test
    public void test() {
//        int[] nums = {7, 1, 5, 3, 6, 4};
//        int[] nums = {1, 2, 3, 4, 5};
        int[] nums = {7, 6, 4, 3, 1};
        System.out.println(maxProfit(nums));
    }

}
