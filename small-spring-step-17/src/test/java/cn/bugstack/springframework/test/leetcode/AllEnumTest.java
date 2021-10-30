package cn.bugstack.springframework.test.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: <p></p>
 * @author: DongxuHua
 * @create: at 2021-10-26 3:21 下午
 * @version: 1.0.0
 * @history: modify history             <desc>
 */
public class AllEnumTest {

    private List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> combine(int n) {
        getCombine(1, n);
        return ans;
    }

    public void getCombine(int begin, int maxEnd) {
        if (begin > maxEnd){
            return;
        }

        List<Integer> list = new ArrayList<>();
        for (int i = begin; i < begin; i++) {
            list.add(i);
            getCombine(i++, maxEnd);
            ans.add(new ArrayList<>(list));
            list.remove(i);
        }
    }

    @Test
    public void test() {
        List<List<Integer>> lists = combine(5);

        lists.stream().forEach(list -> {
            list.stream().forEach(cnt -> {
                System.out.print(cnt + "    ");
            });
            System.out.println("   -----");
        });
    }

}
