package cn.bugstack.springframework.test.tx50;

import org.junit.Test;

/**
 * @description: multiply
 * <p></p>
 * @author: DongxuHua
 * @create: at 2021-11-04 5:47 下午
 * @version: 1.0.0
 * @history: modify history             <desc>
 */
public class MultiplyTest {

    /**
     * 由此引发的问题， 就是很大的数值相乘， 导致INTEGER 类型或者LONG 类型存放不下， 导致越界的问题。
     * @param num1
     * @param num2
     * @return
     */
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")){
            return "0";
        }
        int m = num1.length();
        int n = num2.length();
        int[] ansArr = new int[m + n];

        for (int i = m - 1; i >= 0 ; i--) {
            int x = num1.charAt(i) - '0';
            for (int j = n - 1; j >= 0; j--) {
                int y = num2.charAt(j) - '0';
                ansArr[i + j + 1] += x * y;
            }
        }

        for (int i = m+n-1; i > 0 ; i--) {
            ansArr[i - 1] += ansArr[i] / 10;
            ansArr[i] %= 10;
        }
        int index = ansArr[0] == 0 ? 1 : 0;
        StringBuffer ans = new StringBuffer();
        while (index < m + n) {
            ans.append(ansArr[index]);
            index++;
        }
        return ans.toString();
    }

    @Test
    public void test() {
        String num1 = "";
        String num2 = "";

        System.out.println(multiply(num1, num2));
    }

    @Test
    public void test2() {
        String str = "123456";

        System.out.println(str.substring(str.length() - 1));
    }

    @Test
    public void test3() {
        char str = '3';
        char str1 = '2';

        System.out.println(Integer.valueOf(Character.valueOf(str).toString()));
    }


}
