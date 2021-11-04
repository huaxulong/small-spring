package cn.bugstack.springframework.test.tx50;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: <p></p>
 * @author: DongxuHua
 * @create: at 2021-11-03 5:24 下午
 * @version: 1.0.0
 * @history: modify history             <desc>
 */
public class GrayCodeTest {

    public List<Integer> grayCode(int n) {
        List<Integer> res = new ArrayList<Integer>(){{add(0);}};
        int head = 1;
        for (int i = 0; i < n; i++) {
            for (int j = res.size() - 1; j >= 0; j--)
                res.add(head + res.get(j));
            head <<= 1;
        }
        return res;
    }

    @Test
    public void test() {
        int n = 4;

        List<Integer> list = grayCode(n);

        list.stream().forEach(cnt -> {
            System.out.println(cnt);
        });

    }

    @Test
    public void test1() {
        System.out.println(2 >> 1);
    }

}
