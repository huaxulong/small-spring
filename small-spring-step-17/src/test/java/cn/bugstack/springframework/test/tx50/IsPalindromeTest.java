package cn.bugstack.springframework.test.tx50;

import org.junit.Test;

/**
 * @description: isPalindromeTest
 * <p></p>
 * @author: DongxuHua
 * @create: at 2021-11-02 5:26 下午
 * @version: 1.0.0
 * @history: modify history             <desc>
 */
public class IsPalindromeTest {

    public boolean isPalindrome(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)){
            return false;
        }
        int revertedNumber = 0;
        while (x > revertedNumber){
            revertedNumber = revertedNumber * 10 + x % 10;
            x /= 10;
        }
        return x == revertedNumber || x == revertedNumber / 10;
    }

    @Test
    public void test() {
        System.out.println(isPalindrome(121));
    }


}

