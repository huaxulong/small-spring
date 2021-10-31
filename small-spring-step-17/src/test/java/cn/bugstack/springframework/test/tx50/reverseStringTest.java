package cn.bugstack.springframework.test.tx50;

import org.junit.Test;

/**
 * @description: reverseStringTest
 * <p></p>
 * @author: DongxuHua
 * @create: at 2021-10-31 7:52 下午
 * @version: 1.0.0
 * @history: modify history             <desc>
 */
public class reverseStringTest {

    public void reverseString(char[] s) {
        // 采用双指针法
        int count = s.length / 2;
        for (int i = 0; i < count ; i++) {
            char temp = s[s.length - i - 1];
            s[s.length - i - 1] = s[i];
            s[i] = temp;
        }
    }

    @Test
    public void test() {
        char[] chars = new char[]{'h','e','l','l','o'};

        reverseString(chars);

        print(chars);
    }

    private void print(char[] chars){
        for (int i = 0; i < chars.length; i++) {
            System.out.print(chars[i] + "\t");
        }
    }

}
