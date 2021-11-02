package cn.bugstack.springframework.test.tx50;

import org.junit.Test;

import java.util.Arrays;

/**
 * @description: SingleNumberTest
 * <p></p>
 * @author: DongxuHua
 * @create: at 2021-11-02 4:59 下午
 * @version: 1.0.0
 * @history: modify history             <desc>
 */
public class SingleNumberTest {

    public int singleNumber(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        Arrays.sort(nums);
        for (int i = 1; i < nums.length - 1; i += 2) {
            if (nums[i] == nums[i - 1]) {
                continue;
            } else {
                return nums[i - 1];
            }
        }
        return nums[nums.length - 1];
    }

    @Test
    public void test() {

    }

}
