package cn.bugstack.springframework.test.tx50;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * @description: containsDuplicateTest
 * <p></p>
 * @author: DongxuHua
 * @create: at 2021-11-05 10:44 上午
 * @version: 1.0.0
 * @history: modify history             <desc>
 */
public class ContainsDuplicateTest {

    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
            if (set.size() != i + 1) {
                return true;
            }
        }
        return false;
    }

    @Test
    public void test() {
        int[] nums = {1, 2, 4, 5, 6, 7, 1};

        System.out.println(containsDuplicate(nums));
    }

}
