package cn.bugstack.springframework.test.leetcode;

import cn.hutool.core.net.Ipv4Util;
import org.junit.Test;

/**
 * @description: <p></p>
 * @author: DongxuHua
 * @create: at 2021-10-21 3:45 下午
 * @version: 1.0.0
 * @history: modify history             <desc>
 */
public class JumpCode {

    public int climbStairs(int n) {
        if (n == 1){
            return 1;
        }
        if (n == 2){
            return 2;
        }
        return climbStairs(n - 1) + climbStairs(n - 2);
    }

    @Test
    public void test() {
        int n = 4;
        System.out.println(climbStairs(45));
    }

}
