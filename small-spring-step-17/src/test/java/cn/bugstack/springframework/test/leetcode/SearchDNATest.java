package cn.bugstack.springframework.test.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: <p></p>
 * @author: DongxuHua
 * @create: at 2021-10-30 2:24 下午
 * @version: 1.0.0
 * @history: modify history             <desc>
 */
public class SearchDNATest {

    public List<String> findRepeatedDnaSequences(String s) {
        int len = s.length();
        List<String> ans = new ArrayList<String>();
        if (len < 11) {
            return ans;
        }
        char[] cs = s.toCharArray();
        int cur = 0;
        for (int i = 0; i < 10; i++) {
            cur = (cur << 2) | map(cs[i]);
        }
        int cut = 0b11111111111111111111;
        Boolean[] table = new Boolean[cut + 1];
        table[cur] = false;
        for (int i = 10; i < len; i++) {
            cur = ((cur << 2) | map(cs[i])) & cut;
            Boolean has = table[cur];
            if (has == null) {
                table[cur] = false;
            } else if (!has) {
                ans.add(new String(cs, i - 9, 10));
                table[cur] = true;
            }
        }
        return ans;
    }

    private int map(char c) {
        if (c == 'A') {
            return 0b00;
        }
        if (c == 'C') {
            return 0b01;
        }
        if (c == 'G') {
            return 0b10;
        }
        if (c == 'T') {
            return 0b11;
        }
        return -1;
    }

    @Test
    public void test() {

        String str = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";

        List<String> list = findRepeatedDnaSequences(str);

        list.stream().forEach(strSub -> {
            System.out.println(strSub);
        });
    }

}
