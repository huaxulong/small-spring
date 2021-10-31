package cn.bugstack.springframework.test.tx50;

import org.junit.Test;

/**
 * @description: <p></p>
 * @author: DongxuHua
 * @create: at 2021-10-31 2:19 下午
 * @version: 1.0.0
 * @history: modify history             <desc>
 */
public class TakeFlowersTest {

    public int climbStairs(int n) {
        if (n <= 2){
            return n;
        }
        int n1 = 1;
        int n2 = 2;
        int temp = 0;
        for (int i = 3; i <= n ; i++) {
            temp = n1 + n2;
            n1 = n2;
            n2 = temp;
        }
        return temp;
    }

    @Test
    public void test() {
        System.out.println(climbStairs(5));
    }

}
