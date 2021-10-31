package cn.bugstack.springframework.test.tx50;

import org.junit.Test;

/**
 * @description: <p></p>
 * @author: DongxuHua
 * @create: at 2021-10-31 8:55 下午
 * @version: 1.0.0
 * @history: modify history             <desc>
 */
public class CanWinNimTest {

    public boolean canWinNim(int n) {
        if (n <= 3){
            return true;
        }
        return !(n % 4 == 0);
    }

    @Test
    public void test() {
        System.out.println(canWinNim(8));
    }

}
