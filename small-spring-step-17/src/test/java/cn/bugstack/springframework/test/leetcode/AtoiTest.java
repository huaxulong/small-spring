package cn.bugstack.springframework.test.leetcode;

import org.junit.Test;

/**
 * @description: AtoiTest
 * <p></p>
 * @author: DongxuHua
 * @create: at 2021-10-25 11:18 上午
 * @version: 1.0.0
 * @history: modify history             <desc>
 */
public class AtoiTest {

    public int myAtoi(String s) {
        // 标识第一个有效数字 或者有效符号。
        boolean flag = false;
        String base = "";

        for (int i = 0; i < s.length(); i++) {
            // 无用字符的情况
            if (s.charAt(i) != 45 && (s.charAt(i) < 48 || s.charAt(i) > 58)){
                continue;
            }
            if (!flag && (45 == s.charAt(i) || (48 < s.charAt(i) && s.charAt(i) <= 57))){
                flag = true;
            }
            // 0 ~ 9 ,
            if (45 == s.charAt(i) || ((48 <= s.charAt(i)  && s.charAt(i) <= 57) && flag)){
                if (base.equals("") && s.charAt(i) == 45) {
                    base = "-";
                }else if(s.charAt(i) == 45){
                    continue;
                }else if(base.equals("-") && s.charAt(i) == 48) {
                    continue;
                }else if (base.equals("-")){
                    base = base + (s.charAt(i) - 48);
                }
                else{
                    String temp = base;
                    base = getBase(base, s.charAt(i));

                    if (testRange(base)){
                        return Integer.valueOf(temp);
                    }
                }
            }
        }
        return Integer.valueOf(base);
    }

    private String getBase(String base, char char1) {
        if (base.equals("")){
            return String.valueOf(char1 - 48);
        }
        if (Long.valueOf(base) < 0){
            base = String.valueOf(Long.valueOf(base) * 10 - char1 + 48);
        }else {
            base = String.valueOf(Long.valueOf(base) * 10 + char1 - 48);
        }
        return base;
    }

    private boolean testRange(String base) {
        Long count = Long.valueOf(base);
        if (count >= Integer.MAX_VALUE || count <= Integer.MIN_VALUE ){
            return true;
        }
        return false;
    }

    @Test
    public void test() {
        System.out.println(myAtoi("words and 987"));
    }

}
