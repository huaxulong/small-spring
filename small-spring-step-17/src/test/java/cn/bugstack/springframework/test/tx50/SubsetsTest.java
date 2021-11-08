package cn.bugstack.springframework.test.tx50;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: <p></p>
 * @author: DongxuHua
 * @create: at 2021-11-07 2:22 下午
 * @version: 1.0.0
 * @history: modify history             <desc>
 */
public class SubsetsTest {


    public List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());

        for (int num : nums) {
            List<List<Integer>> newSubsets = new ArrayList<>();
            for (List<Integer> subset : res) {
                List<Integer> newSubset = new ArrayList<>(subset);
                newSubset.add(num);
                newSubsets.add(newSubset);
            }
            res.addAll(newSubsets);
        }
        return res;
    }

    @Test
    public void test() {
        int[] nums = {1, 2, 3};

        List<List<Integer>> subsets = subsets(nums);

        print(subsets);
    }

    private void print(List<List<Integer>> res) {
        res.stream().forEach(list1 -> {
            list1.stream().forEach(cnt -> {
                System.out.print(cnt + "\t");
            });
            System.out.println();
        });
    }


}
