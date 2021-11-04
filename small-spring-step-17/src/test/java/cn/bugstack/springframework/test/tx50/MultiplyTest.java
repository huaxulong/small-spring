package cn.bugstack.springframework.test.tx50;

import org.junit.Test;

public class MultiplyTest {

    public String multiply(String num1, String num2) {
        String summy = "";
        for (int i = num1.length() - 1; i >= 0; i--) {
            int base = getInt(num1.charAt(i));
            int cheshu = 1;
            int jinwei = 0;

            for (int j = num2.length() - 1; j >= 0; j--) {
                int base2 = getInt(num2.charAt(j));
                int sum = base * base2 + jinwei;
                int remainder = sum % 10;
                jinwei = 0;
                jinwei = jinwei * 10;
            }
        }

        return "";
    }

    private String convertStr(int cnt) {
        return String.valueOf(Integer.valueOf(cnt));
    }

    private int getInt(char ch) {
        return Integer.valueOf(String.valueOf(ch));
    }


    @Test
    public void test() {
        String num1 = "123";

        String num2 = "123";

        System.out.println(multiply(num1, num2));
    }

    @Test
    public void test2() {
        System.out.println(Integer.valueOf('2'));
        System.out.println(getInt('2'));
    }

}
