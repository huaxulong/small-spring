package cn.bugstack.springframework.test.tx50;

import org.junit.Test;

/**
 * @description: <p></p>
 * @author: DongxuHua
 * @create: at 2021-10-31 1:23 下午
 * @version: 1.0.0
 * @history: modify history             <desc>
 */
public class Tx14Test {

    /**
     * 纵向比较法  ->  横向比较法 -> 分治算法  -> 二分查找法。
     * @param strs
     * @return
     */
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            if (strs.length == 0){
                return "";
            }
            if (strs.length == 1){
                return strs[0];
            }
        }

        for (int i = 0; i < strs.length; i++) {
            if (null == strs[i] || strs[i].length() == 0){
                return "";
            }
        }

        int index = -1;
        char[] charArray = strs[0].toCharArray();
        boolean flag = true;

        retry:
        while (index + 1 < charArray.length){
            char source = charArray[index + 1];
            for (int i = 1; i < strs.length; i++) {
                if (index + 2 > strs[i].length()){
                    break retry;
                }
                if (source != strs[i].toCharArray()[index + 1]){
                    break retry;
                }
            }
            index ++;
        }
        if (index == -1){
            return "";
        }
        return strs[0].substring(0, index + 1);
    }

    @Test
    public void test() {
        String[] strs = {"ab","a"};
        String str = longestCommonPrefix(strs);

        System.out.println(str);

    }

    @Test
    public void test1() {
        System.out.println("".length());
    }

}
