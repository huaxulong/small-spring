package cn.bugstack.springframework.test.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: <p></p>
 * @author: DongxuHua
 * @create: at 2021-10-26 1:56 下午
 * @version: 1.0.0
 * @history: modify history             <desc>
 */
public class ZuheTest {

    private List<List<Integer>> ans = new ArrayList<>();

    /**
     * n 个数中， k个数的组合
     * @param n
     * @param k
     * @return
     */
    public List<List<Integer>> combine(int n, int k) {
        // 构建组合树
        getCombine(n, k, 1, new ArrayList<>());
        return ans;
    }

    public void getCombine(int n, int k, int start, List<Integer> list) {
        if(k == 0) {
            ans.add(new ArrayList<>(list));
            return;
        }
        for(int i = start;i <= n - k + 1;i++) {
            list.add(i);
            getCombine(n, k - 1, i+1, list);
            list.remove(list.size() - 1);
        }
    }

    @Test
    public void test() {
        List<List<Integer>> lists = combine(5, 3);

        lists.stream().forEach(list -> {
            list.stream().forEach(cnt -> {
                System.out.print(cnt + "    ");
            });
            System.out.println("   -----");
        });
    }

}
