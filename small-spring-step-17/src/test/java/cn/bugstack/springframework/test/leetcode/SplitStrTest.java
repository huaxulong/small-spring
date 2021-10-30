package cn.bugstack.springframework.test.leetcode;

import net.sf.cglib.core.CollectionUtils;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: <p></p>
 * @author: DongxuHua
 * @create: at 2021-10-26 4:50 下午
 * @version: 1.0.0
 * @history: modify history             <desc>
 */
public class SplitStrTest {

    private List<List<String>> cus = new ArrayList<>();


    public List<List<String>> partition(String s) {
        List<String> list = new ArrayList<>();
        if (s == null || s.equals("")){
            return null;
        }
        int count = s.length();
        part(s, list, count);
        return cus;
    }

    private void part(String s, List<String> list, int count) {

        // 找到第一个回文字符串
        for (int i = 0; i < s.length(); i++) {

            String str = s.substring(0, i + 1);
            if (ifHuiWen(str)) {
                list.add(str);
                String subStr = s.substring(i + 1);
                if (!"".equals(subStr)){
                    part(subStr, list, count);
                    if (list != null && list.size() != 0){
                        cus.add(new ArrayList<>(list));
                        iteratorDelete(count  - subStr.length() - 1, list);
                    }
                }
            }else {
                iteratorDelete(str.length() - 1, list);
            }
        }
    }

    private boolean ifHuiWen(String str) {
        for (int i = 0; i < str.length() / 2; i++) {
            if (str.charAt(i) == str.charAt(str.length() - 1 - i)) {
                continue;
            } else {
                return false;
            }
        }
        return true;
    }

    private void iteratorDelete(int index, List<String> list) {
        if (index == list.size()){
            return;
        }
        int length = list.size();
        for (int i = index; i < length; i++) {
            list.remove(index);
        }
    }


    @Test
    public void test() {
        List<List<String>> lists = partition("aabb");

        lists.stream().forEach(list -> {
            list.stream().forEach(str -> {
                System.out.print(str + "     ");
            });
            System.out.println();
        });
    }

}
