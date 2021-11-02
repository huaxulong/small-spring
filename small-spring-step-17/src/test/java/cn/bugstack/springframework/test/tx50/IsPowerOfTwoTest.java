package cn.bugstack.springframework.test.tx50;

import org.junit.Test;

/**
 * @description: <p></p>
 * @author: DongxuHua
 * @create: at 2021-11-02 3:54 下午
 * @version: 1.0.0
 * @history: modify history             <desc>
 */
public class IsPowerOfTwoTest {

    public boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n-1)) == 0;
    }

    @Test
    public void test() {
        int n = 17;
        System.out.println(isPowerOfTwo(n));
    }



}
