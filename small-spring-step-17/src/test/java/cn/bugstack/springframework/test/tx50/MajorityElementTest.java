package cn.bugstack.springframework.test.tx50;

import org.junit.Test;

import java.util.Arrays;

/**
 * @description: majorityElement
 * <p></p>
 * @author: DongxuHua
 * @create: at 2021-11-07 4:43 下午
 * @version: 1.0.0
 * @history: modify history             <desc>
 */
public class MajorityElementTest {

    /**
     * 尝试设计时间复杂度为 O(n)、空间复杂度为 O(1) 的算法解决此问题
     *
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        //取中间数
        return nums[nums.length / 2];

    }

    @Test
    public void test() {
        int[] nums = {3, 2, 3};
        System.out.println(majorityElement(nums));
    }


}
