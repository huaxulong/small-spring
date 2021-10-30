package cn.bugstack.springframework.test.leetcode;

import java.util.HashMap;

/**
 * @description: <p></p>
 * @author: DongxuHua
 * @create: at 2021-10-22 2:03 下午
 * @version: 1.0.0
 * @history: modify history             <desc>
 */
public class NoDuplication {

    public int lengthOfLongestSubstring(String s) {
        // 记录字符上一次出现的位置
        int[] last = new int[128];
        for(int i = 0; i < 128; i++) {
            last[i] = -1;
        }
        int n = s.length();

        int res = 0;
        int start = 0; // 窗口开始位置
        for(int i = 0; i < n; i++) {
            int index = s.charAt(i);
            start = Math.max(start, last[index] + 1);

            // 保存最长的长度
            res   = Math.max(res, i - start + 1);
            // 存放对应的下标
            last[index] = i;
        }

        return res;
    }


    public static void main(String[] args) {
        NoDuplication noDuplication = new NoDuplication();
        String str = "abcabcdbb";
        //System.out.println(noDuplication.lengthOfLongestSubstring(str));

        System.out.println(noDuplication.lengthOfLongestSubstring(str));
    }


}
