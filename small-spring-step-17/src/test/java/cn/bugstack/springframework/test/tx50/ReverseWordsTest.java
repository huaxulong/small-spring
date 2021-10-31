package cn.bugstack.springframework.test.tx50;

import org.junit.Test;

import java.util.Arrays;

/**
 * @description: <p></p>
 * @author: DongxuHua
 * @create: at 2021-10-31 8:03 下午
 * @version: 1.0.0
 * @history: modify history             <desc>
 */
public class ReverseWordsTest {

    public String reverseWords(String s) {
        char[] chars = s.toCharArray();
        int begin = 0;
        int end = -2;
        for (int i = 0; i < chars.length; i++) {
            if ((int)chars[i] == 32){
                begin = end + 2;
                end = i - 1;
                reverseSmall(chars, begin, end);
            }
        }
        // 最后一个char 是不是 ' '?
        if (chars[chars.length - 1] != 32){
            begin = end + 2;
            end = chars.length - 1;
            reverseSmall(chars, begin, end);
        }
        return new String(Arrays.copyOf(chars, chars.length));
    }

    private void reverseSmall(char[] chars, int start , int end){
        int count = (end - start) / 2;
        for (int i = 0; i <= count; i++) {
            char temp = chars[start];
            chars[start] = chars[end];
            chars[end] = temp;

            start ++;
            end --;
        }
    }

    @Test
    public void test() {
        String str = "Let's take LeetCode contest";

        System.out.println(reverseWords(str));

    }

}
